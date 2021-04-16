package language.editor;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.IncorrectOperationException;
import language.SparqlElementFactory;
import language.psi.SparqlPrefixedName;
import org.jetbrains.annotations.NotNull;

public class SparqlShortenIriQuickFix extends BaseIntentionAction {
    private final String text = "Shorten IRI";
    private final String prefixedName;
    private final PsiElement element;

    SparqlShortenIriQuickFix(String prefixedName, PsiElement element) {
        this.prefixedName = prefixedName;
        this.element = element;
        setText(text + " with " + prefixedName + ".");
    }

    @Override
    public @NotNull @IntentionFamilyName String getFamilyName() {
        return text;
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, PsiFile file) {
        return true;
    }

    @Override
    public void invoke(@NotNull Project project, Editor editor, PsiFile file) throws IncorrectOperationException {
        WriteCommandAction.writeCommandAction(project).run(() -> {
            SparqlPrefixedName substituteElement = SparqlElementFactory.createPrefixedName(project, prefixedName);
            // element is of type iri. Therefore we need to replace the child iri	  ::=  	IRIREF | PrefixedName
            element.getFirstChild().replace(substituteElement);
        });
    }
}
