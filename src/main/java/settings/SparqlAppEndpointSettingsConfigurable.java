package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import ui.SparqlEndpointSettingsDialog;

import javax.swing.*;

public class SparqlAppEndpointSettingsConfigurable implements Configurable {
    private SparqlEndpointSettingsDialog dialog;
    private static final String TEXT_DISPLAY_NAME = "Endpoint Settings";

    @Nls
    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Override
    public @Nullable JComponent createComponent() {
        dialog = new SparqlEndpointSettingsDialog();
        return dialog.getRootPanel();
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
