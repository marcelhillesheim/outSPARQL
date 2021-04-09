package execution;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;
import com.intellij.openapi.ui.ComboBox;
import org.jetbrains.annotations.NotNull;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;


public class SparqlExecutionEndpointAction extends AnAction implements CustomComponentAction
{
    public void actionPerformed(@NotNull AnActionEvent e ) {

    }
    public @NotNull JComponent createCustomComponent(@NotNull Presentation presentation, @NotNull String place)
    {
        ComboBox<SparqlEndpointSettings> comboBox = new ComboBox<>();
        SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();
        comboBox.addItem(settings.endpointSettingsForExecution);
        comboBox.setSelectedItem(settings.endpointSettingsForExecution);

        //TODO only reload list if list changed as the selected item is overwritten.

        // add listeners
        // reload list when popup menu is opened in case a new endpoint was added via settings
        comboBox.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();
                ComboBox<SparqlEndpointSettings> comboBox = (ComboBox<SparqlEndpointSettings>) e.getSource();
                comboBox.removeAllItems();
                for (SparqlEndpointSettings endpointSettings : settings.endpointSettingsList) {
                    comboBox.addItem(endpointSettings);
                }
                comboBox.setSelectedItem(settings.endpointSettingsForExecution);
            }
            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) { }
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) { }

        });
        comboBox.addItemListener(e -> {
            SparqlAppSettingsManager settings1 = SparqlAppSettingsManager.getInstance();
            settings1.endpointSettingsForExecution = (SparqlEndpointSettings) e.getItem();
        }
        );
        return comboBox;
    }



}