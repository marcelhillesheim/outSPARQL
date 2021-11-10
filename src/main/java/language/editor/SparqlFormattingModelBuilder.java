package language.editor;

import com.intellij.formatting.*;
import org.jetbrains.annotations.NotNull;


public class SparqlFormattingModelBuilder implements FormattingModelBuilder {

    @NotNull
    @Override
    public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                        new SparqlBlock(formattingContext.getNode(),
                                Wrap.createWrap(WrapType.NONE, false), null),
                        formattingContext.getCodeStyleSettings());
    }

}
