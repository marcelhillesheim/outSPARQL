package ui;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.actionSystem.ex.ComboBoxAction;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.components.JBScrollPane;


import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.table.JBTable;
import execution.SparqlExecutionAction;
import execution.SparqlExecutionEndpointAction;
import org.jetbrains.annotations.NotNull;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableModel;


public class QueryExecutionToolWindow extends SimpleToolWindowPanel {
    // NOTE: should be consistent with plugin.xml defined
    public static final String WINDOW_ID = "SPARQL Execution";
    private final SparqlAppSettingsManager settings;
    private JPanel content;
    private JScrollPane resultPanel;
    private JTable table1;
    private JComboBox endpointSelectionDropDown;

    public QueryExecutionToolWindow(ToolWindow toolWindow) {
        super(true, true);

        this.settings = SparqlAppSettingsManager.getInstance();

        // Intellij style toolbar with actions attached
        DefaultActionGroup actionGroup = new DefaultActionGroup(
                //new Separator(),
                new SparqlExecutionAction(),
                new SparqlExecutionEndpointAction()
                );
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("", actionGroup, false);
        setToolbar((JComponent) actionToolbar);

        setContent(content);
    }


    public void setResultContent(TableModel tableModel) {
        table1.setModel(tableModel);
        table1.revalidate();
    }
}
