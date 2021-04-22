package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import ui.SparqlPrefixSettingsDialog;

import javax.swing.*;

public class SparqlAppPrefixSettingsConfigurable implements Configurable {
    private static final String TEXT_DISPLAY_NAME = "SPARQL Prefix Settings";
    private SparqlPrefixSettingsDialog dialog;

    @Nls
    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Override
    public @Nullable JComponent createComponent() {
        this.dialog = new SparqlPrefixSettingsDialog();
        return (dialog.getRootPanel());
    }

    @Override
    public boolean isModified() {
        return false;
    }

    @Override
    public void apply() {

    }
}
