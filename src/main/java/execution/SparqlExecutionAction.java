package execution;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.content.Content;
import language.SparqlFileType;
import language.psi.SparqlQuery;
import org.jetbrains.annotations.NotNull;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;
import ui.QueryExecutionToolWindow;

import javax.swing.*;
import java.util.Objects;

public class SparqlExecutionAction extends AnAction {
    private BackgroundableProcessIndicator processIndicator;

    public SparqlExecutionAction(Icon icon) {
        super(icon);
    }

    // is called by Intellij every 0.5 seconds
    @Override
    public  void update(@NotNull AnActionEvent e) {
        if (processIndicator != null) {
            e.getPresentation().setEnabled(!processIndicator.isRunning());
        } else {
            e.getPresentation().setEnabled(true);
        }
        e.getPresentation().setVisible(true);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // getting toolWindow to display results
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(Objects.requireNonNull(e.getProject()));
        ToolWindow window = toolWindowManager.getToolWindow(QueryExecutionToolWindow.WINDOW_ID);
        Content content = Objects.requireNonNull(window).getContentManager().getSelectedContent();
        QueryExecutionToolWindow queryExecutionToolWindow = (QueryExecutionToolWindow) Objects.requireNonNull(content).getComponent();

        queryExecutionToolWindow.resetTextArea();

        SparqlEndpointSettings endpointSettings = SparqlAppSettingsManager.getInstance().endpointSettingsForExecution;

        //getting file where the cursor is located
        PsiFile currentFile  = e.getData(CommonDataKeys.PSI_FILE);

        // get all visible editors in case that cursor is null or not in sparql file
        for (FileEditor editor : FileEditorManager.getInstance(Objects.requireNonNull(e.getProject())).getSelectedEditors()){
            if (currentFile == null || currentFile.getFileType() != SparqlFileType.INSTANCE){
                currentFile = PsiManager.getInstance(e.getProject()).findFile(Objects.requireNonNull(editor.getFile()));
            } else {
                break;
            }
        }
        if (currentFile == null) {
            queryExecutionToolWindow.updateTextArea("Couldn't find any SPARQL file. " +
                    "Please make sure the editor with the SPARQL file is visible. " +
                    "Alternatively place your cursor inside of the SPARQL file. ", true);
        } else {
            queryExecutionToolWindow.updateTextArea("SPARQL query from file " + currentFile.getName() + " will be executed. ");
        }

        //TODO SPARQL UPDATE
        //TODO move to Util
        //checking type of SPARQL query
        SparqlQuery queryElement = PsiTreeUtil.findChildOfType(Objects.requireNonNull(currentFile).getNode().getPsi(), SparqlQuery.class);
        if (queryElement == null) {
            queryExecutionToolWindow.updateTextArea("Couldn't find PSI element SPARQL Query. ", true);
        }else if (Objects.requireNonNull(queryElement).getSelectQuery() != null){
            SparqlSelectExecution exec = new SparqlSelectExecution(e.getProject(), "Query execution",currentFile.getOriginalFile().getNode().getPsi().getText(),
                    endpointSettings.getUrl(), SparqlAppSettingsManager.getInstance().limitForExecution, queryExecutionToolWindow);
            this.processIndicator = new BackgroundableProcessIndicator(exec);
            ProgressManager.getInstance().runProcessWithProgressAsynchronously(exec, processIndicator);
        } else {
            //TODO UPDATE text if more query types are supported
            queryExecutionToolWindow.updateTextArea("Plugin can't handle this type of SPARQL query. " +
                    "At the moment only SELECT queries are supported. ", true);
        }





    }


}

