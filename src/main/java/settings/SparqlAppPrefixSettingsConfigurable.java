package settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import ui.SparqlPrefixSettingsDialog;

import javax.swing.*;

public class SparqlAppPrefixSettingsConfigurable implements Configurable {
    private SparqlPrefixSettingsDialog dialog;
    private static final String TEXT_DISPLAY_NAME = "SPARQL Prefix Settings";

    @Nls
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
    public void apply() throws ConfigurationException {

    }
}
