package execution;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.impl.BackgroundableProcessIndicator;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.util.PsiTreeUtil;
import language.SparqlFileType;
import language.psi.SparqlQuery;
import org.jetbrains.annotations.NotNull;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import java.util.Objects;

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
        SparqlEndpointSettings endpointSettings = SparqlAppSettingsManager.getInstance().endpointSettingsForExecution;

        //getting file where the cursor is located
        PsiFile currentFile  = e.getData(CommonDataKeys.PSI_FILE);

        // get all visible editors in case that cursor is null or not in sparql file
        for (FileEditor editor : FileEditorManager.getInstance(Objects.requireNonNull(e.getProject())).getSelectedEditors()){
            if (currentFile == null || currentFile.getFileType() != SparqlFileType.INSTANCE){
                System.out.println("no selected file or file not of type .sparql");
                currentFile = PsiManager.getInstance(e.getProject()).findFile(Objects.requireNonNull(editor.getFile()));
            } else {
                break;
            }
        }
        //TODO what if no sparql file is found
        //TODO Block button till while query is executed
        //TODO SPARQL UPDATE
        //TODO move to Util
        //checking type of SPARQL query
        SparqlQuery queryElement = PsiTreeUtil.findChildOfType(Objects.requireNonNull(currentFile).getNode().getPsi(), SparqlQuery.class);
        if (Objects.requireNonNull(queryElement).getSelectQuery() != null){
            SparqlSelectExecution exec = new SparqlSelectExecution(e.getProject(), "Query execution",currentFile.getOriginalFile().getNode().getPsi().getText(),
                    endpointSettings.getUrl(), e, SparqlAppSettingsManager.getInstance().limitForExecution);
            this.processIndicator = new BackgroundableProcessIndicator(exec);
            ProgressManager.getInstance().runProcessWithProgressAsynchronously(exec, processIndicator);
        } else {
            //TODO inform user
        }





    }


}

