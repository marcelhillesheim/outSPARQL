package language.editor.completion;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.project.Project;
import org.apache.jena.query.*;
import org.jetbrains.annotations.Nullable;
import settings.SparqlAppSettingsManager;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;


//TODO use the same class for SPARQL execution (toolwindow execution) as for live auto-completion !!!

//TODO execute query within backgroudnable task so the user can cancel the completion
// and is not stuck till the query is timed out in the worst case

public class SparqlSelectExecution {
    private final QueryExecution qexec;
    private final Project project;
    private ResultSet results;

    public SparqlSelectExecution(@Nullable Project project, Query jenaQuery) {
        this.project = project;
        this.qexec = QueryExecutionFactory.sparqlService(
                SparqlAppSettingsManager.getInstance().endpointSettingsForExecution.getUrl(),
                jenaQuery
        );
        qexec.setTimeout(15, TimeUnit.SECONDS);
    }

    public void send() {
        Thread t = new Thread(() -> {
            try {
                results =  ResultSetFactory.copyResults(qexec.execSelect());
            } catch (Exception e) {
                ApplicationManager.getApplication().invokeLater(() -> {
                    String message = e.getMessage();
                    if (e.getCause() instanceof SocketTimeoutException) {
                        message = "Query execution took too long and timed out.";
                    }
                    Notification notification = new Notification("outSPARQL notifications", "OutSPARQL error", message, NotificationType.ERROR);
                    notification.notify(project);
                });
                if (qexec != null) {
                    qexec.close();
                }
            }
        });
        t.start();

        //TODO user should be able to cancel auto-completion
        //TODO user losing focus wont cancel auto-completion ProgressManager.getInstance().getProgressIndicator().isCanceled()

        // checking if user canceled query
        while (t.isAlive()) {
            if (ProgressManager.getInstance().getProgressIndicator().isCanceled()){
                qexec.abort();
                qexec.close();
                return;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        qexec.close();
    }

    public ResultSet getResults() {
        return results;
    }
}
