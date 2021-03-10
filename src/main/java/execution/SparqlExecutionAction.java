package execution;


import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import org.jetbrains.annotations.NotNull;
import ui.QueryExecutionToolWindow;

public class SparqlExecutionAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // getting toolWindow
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(e.getProject());
        ToolWindow window = toolWindowManager.getToolWindow(QueryExecutionToolWindow.WINDOW_ID);
        Content content = window.getContentManager().getSelectedContent();
        QueryExecutionToolWindow queryExecutionToolWindow = (QueryExecutionToolWindow) content.getComponent();

        queryExecutionToolWindow.setButtonText("test");
    }


    //JFrame frame = new JFrame();

}

