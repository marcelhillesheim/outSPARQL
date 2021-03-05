package language.psi;

import com.intellij.psi.tree.IElementType;
import language.SparqlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SparqlTokenType extends IElementType {

    public SparqlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SparqlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "SparqlTokenType." + super.toString();
    }
}