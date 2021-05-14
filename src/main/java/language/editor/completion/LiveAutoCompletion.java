package language.editor.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;
import language.SparqlElementFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LiveAutoCompletion {
    private final String pofVariableName = "?OutSparqlPof";
    private final String fillerVariableName = "?OutSparqlFiller";
    private final String originalQueryString;
    private final int offset;
    private final Project project;

    private String repairedQuery;

    public LiveAutoCompletion(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet resultSet) {
        this.originalQueryString = parameters.getOriginalFile().getText();
        this.offset = parameters.getOffset();
        this.project = parameters.getEditor().getProject();

        generate();
    }

    // for testing purposes
    public LiveAutoCompletion(String query, int offset, Project project){
        this.originalQueryString = query;
        this.offset = offset;
        this.project = project;
    }

    private void generate() {
        repairQuery();

        if (repairedQuery != null) {
            //TODO modify query even further
            //TODO add comment to generated query
            //TODO what if there is another, error which cant be resolved at caret position
        } else {
            //TODO inform user
        }
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
                assert elementBeforeError != null;
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
        if (errorElement == null) {
            this.repairedQuery = modifiedQuery.getText();
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
        return repairedQuery;
    }
}
