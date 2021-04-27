package ui;

import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.JBTable;
import settings.SparqlAppSettingsManager;

import javax.swing.*;
import java.awt.*;

public class SparqlEndpointSettingsDialog {
    private final SparqlAppSettingsManager settings;
    private final JPanel rootPanel;

    public SparqlEndpointSettingsDialog() {
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();

        this.rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(generateTable(), BorderLayout.CENTER);
    }

    private JComponent generateTable() {
        JBTable table = new JBTable();
        EndpointTableModel tableModel = new EndpointTableModel(settings.endpointSettingsList);
        table.setModel(tableModel);
        table.getEmptyText().setText("No endpoints added.");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(
                ToolbarDecorator.createDecorator(table)
                        .setAddAction(button -> tableModel.addRow())
                        .setRemoveAction(button -> tableModel.removeRows(table.getSelectedRows()))
                        .disableUpDownActions()
                        .createPanel(),
                BorderLayout.CENTER
                );

        return panel;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
