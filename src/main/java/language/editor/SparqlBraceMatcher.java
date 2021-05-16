package language.editor;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import language.psi.SparqlTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SparqlBraceMatcher implements PairedBraceMatcher {

    private static final BracePair[] PAIRS = {
            new BracePair(SparqlTypes.OP_LCURLY, SparqlTypes.OP_RCURLY, true),
            new BracePair(SparqlTypes.OP_LROUND, SparqlTypes.OP_RROUND, true),
            new BracePair(SparqlTypes.OP_LSQUARE, SparqlTypes.OP_RSQUARE, false),
            //TODO add brace matching for iri (-> separate lexer tokens for braces) OR automatically close iri after typing '<'
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}