package ui;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.ui.components.JBScrollPane;


import com.intellij.openapi.wm.ToolWindow;
import execution.SparqlExecutionAction;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;



public class QueryExecutionToolWindow extends SimpleToolWindowPanel {
    // NOTE: should be consistent with plugin.xml defined
    public static final String WINDOW_ID = "SPARQL Execution";
    private JPanel content;
    private JButton button1;

    public QueryExecutionToolWindow(ToolWindow toolWindow) {
        super(true, true);

        // Intellij style toolbar with actions attached
        DefaultActionGroup actionGroup = new DefaultActionGroup(
                //new Separator(),

                new AnAction("test") {
                    @Override
                    public void actionPerformed(@NotNull AnActionEvent e) {

                    }
                },
                new SparqlExecutionAction()
                );
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar("", actionGroup, false);
        setToolbar((JComponent) actionToolbar);
        setContent(content);

    }
    //TODO remove experimental method
    public void setButtonText(String text) {
        button1.setText(text);
        setContent(content);
    }
}
