package execution;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.content.Content;
import com.intellij.ui.table.JBTable;
import org.apache.jena.query.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ui.QueryExecutionToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SparqlSelectExecution extends Task.@NotNull Backgroundable {
    private final String queryString;
    private final String endpointUrl;
    private final String limit;
    private final AnActionEvent event;
    private final QueryExecutionToolWindow queryExecutionToolWindow;
    private ResultSet results;
    private Query jenaQuery;
    private String output;

    public SparqlSelectExecution(@Nullable Project project, @NotNull String title, String queryString, String endpointUrl, AnActionEvent event, String limit) {
        super(project, title);
        this.queryString = queryString;
        this.endpointUrl = endpointUrl;
        this.limit =limit;
        this.event = event;
        this.output = "";
        // getting toolWindow to display results
        ToolWindowManager toolWindowManager = ToolWindowManager.getInstance(Objects.requireNonNull(event.getProject()));
        ToolWindow window = toolWindowManager.getToolWindow(QueryExecutionToolWindow.WINDOW_ID);
        Content content = Objects.requireNonNull(window).getContentManager().getSelectedContent();
        this.queryExecutionToolWindow= (QueryExecutionToolWindow) content.getComponent();
    }

    @Override
    public void run(@NotNull ProgressIndicator indicator) {
        updateTextArea("Sending query to " + endpointUrl + " endpoint:");
        this.jenaQuery = QueryFactory.create(queryString);

        if (limit.equals("removed")) {
            jenaQuery.setLimit(Query.NOLIMIT);
        } else if (limit.matches("[0-9]+")) {
            jenaQuery.setLimit(Integer.parseInt(limit));
        }
        updateTextArea(jenaQuery.toString());

        QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointUrl, jenaQuery);
        //TODO use config values
        qexec.setTimeout(15, TimeUnit.SECONDS);

        Thread t = new Thread(() -> {
            try {
                results = qexec.execSelect();
            } catch (Exception e) {
                updateTextArea(e.getMessage());
                if (qexec != null) {
                    qexec.close();
                }

            }
        });

        t.start();

        // checking if user canceled query
        while (t.isAlive()) {
            if (indicator.isCanceled()){
                updateTextArea("Query got canceled.");
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
        if (results == null) return;
        JBTable resultTable = new JBTable(generateTable());
        ApplicationManager.getApplication().invokeLaterOnWriteThread(() -> queryExecutionToolWindow.setContent(new JScrollPane(resultTable)), ModalityState.any());

        qexec.close();
        event.getPresentation().setEnabled(true);
    }

    public TableModel generateTable(){
        //Procssing endpoint response
        String[] columnNames = Arrays.copyOf(results.getResultVars().toArray(), results.getResultVars().toArray().length, String[].class);


        //iterating through each row
        ArrayList<ArrayList<String>> dataList = new ArrayList();
        while (results.hasNext()) {
            QuerySolution solution = results.next();

            ArrayList<String> row = new ArrayList();

            for (Iterator<String> iterator = solution.varNames(); iterator.hasNext(); ) {
                String field = solution.get(iterator.next()).toString();
                field = jenaQuery.getPrefixMapping().shortForm(field);
                row.add(field);

            }
            dataList.add(row);
        }

        String[][] data = dataList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        return new DefaultTableModel(data, columnNames);
    }

    private void updateTextArea(String information){
        output += "\n" + information;
        JTextPane textPane = new JTextPane();
        textPane.setText(output);
        JBScrollPane scrollPane = new JBScrollPane(textPane);
        // scrolling down automatically
        scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        ApplicationManager.getApplication().invokeLaterOnWriteThread(() -> queryExecutionToolWindow.setContent(scrollPane), ModalityState.any());
    }
}
