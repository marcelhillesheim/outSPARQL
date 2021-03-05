package language.psi;

import com.intellij.psi.tree.IElementType;
import language.SparqlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SparqlElementType extends IElementType {

    public SparqlElementType(@NotNull @NonNls String debugName) {
        super(debugName, SparqlLanguage.INSTANCE);
    }

}
