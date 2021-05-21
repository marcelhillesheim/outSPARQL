package language.editor.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.PrioritizedLookupElement;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.ide.plugins.PluginManagerCore;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationListener;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;
import language.SparqlElementFactory;
import language.psi.impl.SparqlPrologueImpl;
import language.psi.impl.SparqlTriplesBlockImpl;
import language.psi.impl.SparqlWhereClauseImpl;
import org.apache.jena.graph.Node;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.shared.PrefixMapping;
import org.apache.jena.sparql.core.Var;
import org.apache.jena.sparql.engine.binding.Binding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import settings.SparqlSettingsUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TODO add link to live auto-completion white paper

public class LiveAutoCompletion {
    private final String pofVariableName = "?OutSparqlPof";
    private final String originalQueryString;
    private final int offset;
    private final Project project;
    private final CompletionResultSet completionResults;

    private PsiFile repairedQuery;

    public LiveAutoCompletion(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet completionResults) {
        this.completionResults = completionResults;
        this.originalQueryString = parameters.getOriginalFile().getText();
        this.offset = parameters.getOffset();
        this.project = parameters.getEditor().getProject();

        generateSuggestions();
    }


    // for testing purposes
    public LiveAutoCompletion(String query, int offset, Project project){
        this.originalQueryString = query;
        this.offset = offset;
        this.project = project;
        completionResults = null;
    }

    private void generateSuggestions() {
        repairQuery();

        if (repairedQuery != null) {
            // only keep prologue and where class as we want to define our own query and solution modifiers
            String whereClause = Objects.requireNonNull(PsiTreeUtil.findChildOfType(repairedQuery, SparqlWhereClauseImpl.class)).getText();
            // add filter for type IRI as it is a common IRI -> displaces other IRIs due to it's high occurrence
            whereClause = whereClause.substring(0, whereClause.lastIndexOf('}')) +
                    " FILTER (" + pofVariableName + "!= <http://www.w3.org/1999/02/22-rdf-syntax-ns#type>) }";

            PsiElement prologueElement = PsiTreeUtil.findChildOfType(repairedQuery, SparqlPrologueImpl.class);
            String prologue = "";
            if (prologueElement != null) {
                prologue = prologueElement.getText();
            }
            //TODO FROM
            String countVariableName = "?OutSparqlCount";
            String finalQuery = "#" + "generated query, but manually triggered by the user for auto-completion" + "\n"
                    + "#" + "outSPARQL " + Objects.requireNonNull(PluginManagerCore.getPlugin(PluginId.getId("org.outsparql.outSPARQL"))).getVersion() + "\n"
                    + prologue
                    + " SELECT " + pofVariableName + " (count(" + pofVariableName + ") as " + countVariableName + ") WHERE {"

                    //subselect otherwise limit has no effect on performance
                    + "SELECT " + pofVariableName + " "
                    + whereClause
                    + " LIMIT 1000"

                    + "} GROUP BY " + pofVariableName
                    + " ORDER BY DESC(" + countVariableName + ")";

            Query jenaQuery = QueryFactory.create(finalQuery);

            SparqlSelectExecution execution = new SparqlSelectExecution(project, jenaQuery);
            execution.send();

            displaySuggestions(execution.getResults(), completionResults,
                    jenaQuery.getPrefixMapping().withDefaultMappings(SparqlSettingsUtil.getStoredPrefixes()));
        } else {
            String message = "<html> This feature is in an early stage. Find more information about possible causes/problems " +
                    "<a href=\"https://plugins.jetbrains.com/plugin/16503-outsparql/tutorial/auto-completion\">here.</a></html>";
            new Notification("outSPARQL notifications", "OutSPARQL completion failed", message,
                    NotificationType.INFORMATION, new NotificationListener.UrlOpeningListener(true)).notify(project);
        }
    }

    private void displaySuggestions(ResultSet results, CompletionResultSet completionResults, PrefixMapping prefixMapping) {
        List<LookupElement> temporaryList = new ArrayList<>();

        assert results != null;
        Var resultVar = Var.alloc(results.getResultVars().get(0));
        Var countVar = Var.alloc(results.getResultVars().get(1));
        while (results.hasNext()) {
            Binding entry = results.nextBinding();
            Node value = entry.get(resultVar);
            long count = Long.parseLong(entry.get(countVar).getLiteralValue().toString());
            String label = "";
            if(value.isURI()){
                // if there is an abbreviated version of the IRI (prefix)
                if (prefixMapping.qnameFor(value.getURI())!=null){
                    label = prefixMapping.qnameFor(value.getURI());
                } else {
                    label = "<" + value.getURI() + ">";
                }
            } else if(value.isLiteral()){
                label = value.getLiteral().toString();
            } else if(value.isBlank()){
                label = value.getBlankNodeLabel();
            }
            double priority = (double) count;
            temporaryList.add(
                    PrioritizedLookupElement.withPriority(
                    LookupElementBuilder.create(label).withTypeText(Double.toString(priority)),
                    priority
                    )
            );
        }
        completionResults.addAllElements(temporaryList);
    }


    public void repairQuery() {
        String modification = " "+pofVariableName+" ";
        PsiFile modifiedQuery = insertStringAtCaret(modification);


        // adding filler variables to get a full triple depending on where the error is found
        for (int i=1; i<3; i++) {
            PsiErrorElement errorElement = PsiTreeUtil.findChildOfType(modifiedQuery, PsiErrorElement.class);
            if (errorElement != null) {
                //check where the error is located. If its not after the inserted string, insert a filler variable.
                PsiElement elementBeforeError = prevElement(errorElement);
                if (elementBeforeError == null) return;

                String fillerVariableName = "?OutSparqlFiller";
                if (
                        (!elementBeforeError.getText().contains(pofVariableName) &&
                        !elementBeforeError.getText().contains(fillerVariableName)) ||

                        //TODO more elegant solution
                        errorElement.getErrorDescription().contains("<property list path not empty>") ||
                        errorElement.getErrorDescription().contains("<graph node path>")
                ) {
                    modification = modification + " " + fillerVariableName + i;
                }
            }
            modifiedQuery = insertStringAtCaret(modification);
        }

        // trial and error, if a dot or semicolon is required by checking if there is still an error
        PsiErrorElement errorElement = PsiTreeUtil.findChildOfType(modifiedQuery, PsiErrorElement.class);
        if (errorElement != null) {
            modifiedQuery = insertStringAtCaret(modification + ".");
            errorElement = PsiTreeUtil.findChildOfType(modifiedQuery, PsiErrorElement.class);
            if (errorElement != null) {
                modifiedQuery = insertStringAtCaret(modification + ";");
            }
        }

        errorElement = PsiTreeUtil.findChildOfType(modifiedQuery, PsiErrorElement.class);
        if (errorElement == null &&
                PsiTreeUtil.getParentOfType(modifiedQuery.findElementAt(modifiedQuery.getText().indexOf(pofVariableName)),SparqlTriplesBlockImpl.class) != null ){
            this.repairedQuery = modifiedQuery;
        }
    }

    private PsiElement prevElement(PsiErrorElement errorElement) {
        int offset = errorElement.getTextOffset()-2;
        while (offset>0) {
            PsiElement element = errorElement.getContainingFile().findElementAt(offset);
            if (!(element instanceof PsiWhiteSpace)){
                return element;
            }

            offset--;
        }
        return null;
    }

    private PsiFile insertStringAtCaret(String modification) {
        StringBuilder stringBuilder = new StringBuilder(originalQueryString);
        stringBuilder.insert(offset, modification);

        return SparqlElementFactory.createFile(project, stringBuilder.toString());
    }

    @Nullable
    public String getRepairedQuery() {
        return repairedQuery.getText();
    }


}
