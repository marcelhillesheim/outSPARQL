package language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import language.SparqlFileType;
import language.SparqlLanguage;
import org.jetbrains.annotations.NotNull;

public class SparqlFile extends PsiFileBase {

    public SparqlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SparqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SparqlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Sparql File";
    }

}
