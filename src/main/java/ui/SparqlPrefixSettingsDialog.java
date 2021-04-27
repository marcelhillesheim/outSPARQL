package ui;

import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.UI;
import org.intellij.lang.annotations.Language;
import settings.SparqlAppSettingsManager;

import javax.swing.*;
import java.awt.*;

public class SparqlPrefixSettingsDialog {
    private final SparqlAppSettingsManager settings;
    private final JPanel rootPanel;

    public SparqlPrefixSettingsDialog() {
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();

        this.rootPanel = generateTable();
    }

    private JPanel generateTable() {
        JBTable table = new JBTable();
        PrefixTableModel tableModel = new PrefixTableModel(settings.prefixSettingsList);
        table.setModel(tableModel);
        table.getEmptyText().setText("No prefixes added");

        // setting max width as this column only shows checkBoxes for Boolean value
        table.getColumnModel().getColumn(2).setMaxWidth(130);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(
                ToolbarDecorator.createDecorator(table)
                        .setAddAction(button -> tableModel.addRow())
                        .setRemoveAction(button -> tableModel.removeRows(table.getSelectedRows()))
                        .disableUpDownActions()
                        .createPanel()
                );
        @Language("HTML")
        String helpText = "<p>Standard prefixes are common prefixes, which don't need a prefix declaration within the query.</p>\n" +
                "<p>Find out more about this feature <a href='https://plugins.jetbrains.com/plugin/16503-outsparql/custom-pages/672'>here.</a></p>";

        return UI.PanelFactory.panel(panel).withComment(
                helpText
        ).resizeY(true).createPanel();
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
