package execution;


import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiLiteralValue;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.content.Content;
import language.psi.SparqlQuery;
import language.psi.SparqlVisitor;
import org.jetbrains.annotations.NotNull;
import ui.QueryExecutionToolWindow;

public class SparqlExecutionAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        //TODO currently only getting window with cursor in it
        //getting current opened file
        PsiFile currentFile  = e.getData(CommonDataKeys.PSI_FILE);

        if (!currentFile.getFileType().getDefaultExtension().equals("sparql")) {
            // TODO file isnt of type SPARQL -> inform user to switch window
            System.out.println("Cant execute on file which is not of type SPARQL");
            return;
        }


        // getting toolWindow to display results
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(e.getProject());
        ToolWindow window = toolWindowManager.getToolWindow(QueryExecutionToolWindow.WINDOW_ID);
        Content content = window.getContentManager().getSelectedContent();
        QueryExecutionToolWindow queryExecutionToolWindow = (QueryExecutionToolWindow) content.getComponent();

        //TODO SPARQL UPDATE
        //TODO move to Util
        //checking type of SPARQL query
        SparqlQuery queryElement = PsiTreeUtil.findChildOfType(currentFile.getNode().getPsi(), SparqlQuery.class);
        if (queryElement.getSelectQuery() != null){
            System.out.println(currentFile.getText());
            SparqlSelectExecution exec = new SparqlSelectExecution(currentFile.getOriginalFile().getNode().getPsi().getText());
            exec.run();
            queryExecutionToolWindow.setResultContent(exec.generateJBTable());
        } else {
            //TODO inform user
          return;
        }





    }


}

