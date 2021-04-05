package language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ui.SparqlIcons;

import javax.swing.*;

public class SparqlFileType extends LanguageFileType {

    public static final SparqlFileType INSTANCE = new SparqlFileType();

    private SparqlFileType() {
        super(SparqlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Sparql File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Sparql language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "sparql";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SparqlIcons.FILE;
    }

}