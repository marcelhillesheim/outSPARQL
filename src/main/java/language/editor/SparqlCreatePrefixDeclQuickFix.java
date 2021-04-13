package language.editor;

import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.util.IntentionFamilyName;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import language.SparqlElementFactory;
import language.psi.SparqlPrefixDecl;
import language.psi.SparqlPrologue;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SparqlCreatePrefixDeclQuickFix extends BaseIntentionAction  {
    private final String text = "Create prefix declaration";
    private final String prefix;

    SparqlCreatePrefixDeclQuickFix(String prefix){
        this.prefix = prefix;
        setText(text + " for " + prefix);
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
            SparqlPrefixDecl prefixDecl = SparqlElementFactory.createPrefixDecl(project, prefix);
            //TODO create Prologue in case no Prologue exists. remove require nonnull
            Objects.requireNonNull(PsiTreeUtil.findChildOfType(file, SparqlPrologue.class)).getNode().addChild(prefixDecl.getNode());
            //TODO move caret to "<>" see quickfix tutorial
        });
    }
}
