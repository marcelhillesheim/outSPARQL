package ui;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import execution.SparqlExecutionAction;
import execution.SparqlExecutionEndpointAction;
import execution.SparqlExecutionLimitSliderAction;
import settings.SparqlAppSettingsManager;

import javax.swing.*;
import javax.swing.table.TableModel;


public class QueryExecutionToolWindow extends SimpleToolWindowPanel {
    // NOTE: should be consistent with plugin.xml defined
    public static final String WINDOW_ID = "SPARQL Execution";
    private JPanel content;
    private JScrollPane resultPanel;
    private JTable table1;

    public QueryExecutionToolWindow(ToolWindow toolWindow) {
        super(true, true);

        SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();

        // Intellij style toolbar with actions attached
        DefaultActionGroup actionGroup = new DefaultActionGroup(
                //new Separator(),
                new SparqlExecutionAction(),
                new SparqlExecutionEndpointAction(),
                new Separator(),
                new SparqlExecutionLimitSliderAction()
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
