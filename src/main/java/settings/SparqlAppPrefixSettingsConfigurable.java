package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import ui.SparqlPrefixSettingsDialog;

import javax.swing.*;

public class SparqlAppPrefixSettingsConfigurable implements Configurable {
    private static final String TEXT_DISPLAY_NAME = "Prefix Settings";

    @Nls
    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Override
    public @Nullable JComponent createComponent() {
        SparqlPrefixSettingsDialog dialog = new SparqlPrefixSettingsDialog();
        return (dialog.getRootPanel());
    }

    @Override
    public boolean isModified() {
        //TODO check if tablemodel changed
        return false;
    }

    @Override
    public void apply() {

    }
}
