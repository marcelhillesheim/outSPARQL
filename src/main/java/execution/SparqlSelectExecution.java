package execution;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.content.Content;
import org.apache.jena.query.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ui.QueryExecutionToolWindow;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class SparqlSelectExecution extends Task.@NotNull Backgroundable {
    private final String queryString;
    private final String endpointUrl;
    private final AnActionEvent event;
    private ResultSet results;

    public SparqlSelectExecution(@Nullable Project project, @NlsContexts.ProgressTitle @NotNull String title, String queryString, String endpointUrl, AnActionEvent event) {
        super(project, title);
        this.queryString = queryString;
        this.endpointUrl = endpointUrl;
        this.event = event;
    }

    @Override
    public void run(@NotNull ProgressIndicator indicator) {


        //TODO use config values --> abstract instead of interface
        Query jenaQuery = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointUrl, jenaQuery);
        //TODO use config values
        qexec.setTimeout(15, TimeUnit.SECONDS);
        ResultSet results = qexec.execSelect();
        this.results = results;


        System.out.println(results.getRowNumber());
        // getting toolWindow to display results
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(event.getProject());
        ToolWindow window = toolWindowManager.getToolWindow(QueryExecutionToolWindow.WINDOW_ID);
        Content content = window.getContentManager().getSelectedContent();
        QueryExecutionToolWindow queryExecutionToolWindow = (QueryExecutionToolWindow) content.getComponent();
        queryExecutionToolWindow.setResultContent(generateJBTable());
    }

    public TableModel generateJBTable(){
        //Procssing endpoint response
        String[] columnNames = Arrays.copyOf(results.getResultVars().toArray(), results.getResultVars().toArray().length, String[].class);


        //iterating through each row
        ArrayList<ArrayList<String>> dataList = new ArrayList();
        while (results.hasNext()) {
            QuerySolution solution = results.next();

            ArrayList<String> row = new ArrayList();

            for (Iterator<String> iterator = solution.varNames(); iterator.hasNext(); ) {
                row.add(solution.get(iterator.next()).toString());

            }
            dataList.add(row);
        }

        String[][] data = dataList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        return new DefaultTableModel(data, columnNames);
    }

}
