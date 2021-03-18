package execution;


import com.intellij.execution.process.ProcessHandler;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator;
import com.intellij.openapi.progress.util.ProgressIndicatorUtils;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiLiteralValue;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.content.Content;
import com.intellij.util.progress.ProgressVisibilityManager;
import language.SparqlFileType;
import language.psi.SparqlQuery;
import language.psi.SparqlVisitor;
import org.jetbrains.annotations.NotNull;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;
import ui.QueryExecutionToolWindow;

public class SparqlExecutionAction extends AnAction {
    private BackgroundableProcessIndicator processIndicator;

    // is called by Intellij every 0.5 seconds
    @Override
    public  void update(@NotNull AnActionEvent e) {
        if (processIndicator != null) {
            e.getPresentation().setEnabled(!processIndicator.isRunning());
        }
        e.getPresentation().setVisible(true);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        SparqlEndpointSettings settings = SparqlAppSettingsManager.getInstance().endpointSettingsForExecution;

        //getting file where the cursor is located
        PsiFile currentFile  = e.getData(CommonDataKeys.PSI_FILE);

        // get all visible editors in case that cursor is null or not in sparql file
        for (FileEditor editor : FileEditorManager.getInstance(e.getProject()).getSelectedEditors()){
            if (currentFile == null || currentFile.getFileType() != SparqlFileType.INSTANCE){
                System.out.println("no selectd file or file not of type .sparql");
                currentFile = PsiManager.getInstance(e.getProject()).findFile(editor.getFile());
            } else {
                break;
            }
        }
        //TODO what if no sparql file is found
        //TODO Block button till while query is executed
        //TODO SPARQL UPDATE
        //TODO move to Util
        //checking type of SPARQL query
        SparqlQuery queryElement = PsiTreeUtil.findChildOfType(currentFile.getNode().getPsi(), SparqlQuery.class);
        if (queryElement.getSelectQuery() != null){
            System.out.println(currentFile.getText());
            SparqlSelectExecution exec = new SparqlSelectExecution(e.getProject(),"Query Execution" ,currentFile.getOriginalFile().getNode().getPsi().getText(),
                    settings.getUrl(), e);
            this.processIndicator = new BackgroundableProcessIndicator(exec);
            ProgressManager.getInstance().runProcessWithProgressAsynchronously(exec, processIndicator);
        } else {
            //TODO inform user
        }





    }


}

