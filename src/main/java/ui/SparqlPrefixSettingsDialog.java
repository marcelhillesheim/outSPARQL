package ui;

import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.table.JBTable;
import com.intellij.util.ui.FontInfo;
import settings.SparqlAppSettingsManager;

import javax.swing.*;
import java.awt.*;

public class SparqlPrefixSettingsDialog {
    private final SparqlAppSettingsManager settings;
    private final JPanel rootPanel;

    public SparqlPrefixSettingsDialog() {
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();

        this.rootPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        rootPanel.add(generateTable(), BorderLayout.CENTER);

        String informationText = "Here you can set Prefixes, which are being used for annotations and quickfixes. " +
                "If a prefix is set to standard, you won't get a warning, if the prefix is used but not declared within the query. " +
                "\n \n Disclaimer: For the query execution tool the standard prefixes are always added automatically. " +
                "So if the library, you are using for query execution, requires all Prefixes to be defined within the query, " +
                "the query might fail when running via your program. In this case you should set all prefixes to non standard. " +
                "So you get warnings, if prefix declarations are missing.";
        JTextArea informationTextArea = new JTextArea(informationText);
        informationTextArea.setEditable(false);
        informationTextArea.setLineWrap(true);
        informationTextArea.setWrapStyleWord(true);
        informationTextArea.setOpaque(false);
        informationTextArea.setFont(FontInfo.get(Font.DIALOG).getFont());
        rootPanel.add(informationTextArea, BorderLayout.NORTH);
    }

    private JComponent generateTable() {
        JBTable table = new JBTable();
        PrefixTableModel tableModel = new PrefixTableModel(settings.prefixSettingsList);
        table.setModel(tableModel);
        table.getEmptyText().setText("No prefixes set yet");

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
