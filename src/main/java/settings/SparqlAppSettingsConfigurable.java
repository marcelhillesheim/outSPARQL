package settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import ui.SparqlSettingsDialog;

import javax.swing.*;

public class SparqlAppSettingsConfigurable implements Configurable {
    private  SparqlSettingsDialog dialog;
    private static final String TEXT_DISPLAY_NAME = "SPARQL settings";

    @Nls
    @Override
    public String getDisplayName() {
        return TEXT_DISPLAY_NAME;
    }

    @Override
    public @Nullable JComponent createComponent() {
        dialog = new SparqlSettingsDialog();
        return dialog.getRootPanel();
    }

    @Override
    public boolean isModified() {
        return dialog.isModified();
    }

    @Override
    public void apply() {
        dialog.apply();
    }

    @Override
    public void reset() { dialog.reset(); }
}
