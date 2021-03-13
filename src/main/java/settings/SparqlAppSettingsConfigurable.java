package settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;
import ui.SparqlSettingsDialog;

import javax.swing.*;

public class SparqlAppSettingsConfigurable implements Configurable {
    private  SparqlSettingsDialog dialog;
    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return null;
    }

    @Override
    public @Nullable JComponent createComponent() {
        dialog = new SparqlSettingsDialog();
        return (JComponent) dialog.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return dialog.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        dialog.apply();
    }
}
