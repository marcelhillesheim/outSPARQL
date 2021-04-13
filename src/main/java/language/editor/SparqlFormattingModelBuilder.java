package language.editor;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import language.SparqlLanguage;
import org.jetbrains.annotations.NotNull;


public class SparqlFormattingModelBuilder implements FormattingModelBuilder {

    private SpacingBuilder createSpacingBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, SparqlLanguage.INSTANCE);

    }

    @NotNull
    @Override
    public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new SparqlBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false),
                                Alignment.createAlignment(),
                                createSpacingBuilder(formattingContext.getCodeStyleSettings())),
                        formattingContext.getCodeStyleSettings());
    }

}
