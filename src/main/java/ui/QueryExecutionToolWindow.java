package ui;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import execution.SparqlExecutionAction;
import execution.SparqlExecutionEndpointAction;
import execution.SparqlExecutionLimitSliderAction;
import settings.SparqlAppSettingsManager;

import javax.swing.*;


public class QueryExecutionToolWindow extends SimpleToolWindowPanel {
    // NOTE: should be consistent with plugin.xml defined
    public static final String WINDOW_ID = "SPARQL Execution";

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
        setContent(new JScrollPane());
    }
}
