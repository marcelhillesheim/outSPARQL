package ui;

import com.intellij.icons.AllIcons;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.JBColor;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.messages.MessageBus;
import com.intellij.util.messages.MessageBusConnection;
import execution.SparqlExecutionAction;
import execution.SparqlExecutionEndpointAction;
import execution.SparqlExecutionLimitSliderAction;
import execution.SparqlExecutionStateNotifier;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;


public class QueryExecutionToolWindow extends SimpleToolWindowPanel {
    // NOTE: should be consistent with plugin.xml defined
    public static final String WINDOW_ID = "SPARQL";
    private JTextPane textPane;

    public QueryExecutionToolWindow(ToolWindow toolWindow, Project project) {
        super(true, true);

        // Intellij style toolbar with actions attached
        DefaultActionGroup actionGroup = new DefaultActionGroup(
                new SparqlExecutionAction(AllIcons.Actions.Execute),
                new SparqlExecutionEndpointAction(),
                new Separator(),
                new SparqlExecutionLimitSliderAction()
                );
        ActionToolbar actionToolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.TOOLWINDOW_CONTENT, actionGroup, false);
        setToolbar((JComponent) actionToolbar);
        setContent(new JScrollPane());

        resetTextArea();


        MessageBus messageBus = project.getMessageBus();
        MessageBusConnection connection = messageBus.connect();
        connection.subscribe(
                SparqlExecutionStateNotifier.SPARQL_EXECUTION_STATE,
                (message, isErrorMessage) -> ApplicationManager.getApplication().invokeLater(
                        () -> updateTextArea(message, isErrorMessage),
                        ModalityState.any()
                )

        );
    }

    public void updateTextArea( String information, Boolean isErrorMessage) {
        Style style = null;
        if (isErrorMessage) {
            style = textPane.getStyle("red");
        }

        try {
            textPane.getStyledDocument().insertString(textPane.getStyledDocument().getLength(), "\n" + information, style);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        JBScrollPane scrollPane = new JBScrollPane(textPane);
        // scrolling down automatically
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());

        setContent(scrollPane);
    }

    public void resetTextArea() {
        this.textPane = new JTextPane();
        Style style = textPane.addStyle("red", null);
        StyleConstants.setForeground(style, JBColor.RED);
        JBScrollPane scrollPane = new JBScrollPane(textPane);
        setContent(scrollPane);
    }

}
