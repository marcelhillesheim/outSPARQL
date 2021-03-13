package execution;

import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.ex.ComboBoxAction;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;
import com.intellij.openapi.ui.ComboBox;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SparqlExecutionEndpointAction extends AnAction implements CustomComponentAction
{
    public void actionPerformed( AnActionEvent e ) {

    }

    public JComponent createCustomComponent(Presentation presentation )
    {
        ComboBox<SparqlEndpointSettings> comboBox = new ComboBox<SparqlEndpointSettings>();
        SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();
        comboBox.addItem(settings.endpointSettingsForExecution);
        comboBox.setSelectedItem(settings.endpointSettingsForExecution);



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
        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();
                settings.endpointSettingsForExecution = (SparqlEndpointSettings) e.getItem();
            }
        }
        );
        return comboBox;
    }



}