package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SparqlAppSettingsConfigurable implements Configurable {
    private static final String TEXT_DISPLAY_NAME = "SPARQL Settings";

    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Override
    public @Nullable JComponent createComponent() {
        return null;
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() {

    }
}
