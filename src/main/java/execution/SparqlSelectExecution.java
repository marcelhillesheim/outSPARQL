package execution;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.ui.table.JBTable;
import org.apache.jena.query.*;
import org.jetbrains.annotations.NotNull;
import settings.SparqlSettingsUtil;
import ui.QueryExecutionToolWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class SparqlSelectExecution extends Task.Backgroundable {
    private final String queryString;
    private final String endpointUrl;
    private final String limit;
    private final QueryExecutionToolWindow queryExecutionToolWindow;
    private ResultSet results;
    private Query jenaQuery;
    private String[][] data;

    public SparqlSelectExecution(Project project, @NotNull String title, String queryString, String endpointUrl, String limit, QueryExecutionToolWindow queryExecutionToolWindow) {
        super(project, title);
        this.queryString = queryString;
        this.endpointUrl = endpointUrl;
        this.limit =limit;
        this.queryExecutionToolWindow = queryExecutionToolWindow;
    }

    @Override
    public void run(@NotNull ProgressIndicator indicator) {
        indicator.setIndeterminate(true);
        updateTextArea("Sending query to " + endpointUrl + " endpoint:", false);
        ParameterizedSparqlString queryStringParameterized = new ParameterizedSparqlString();
        queryStringParameterized.setCommandText(queryString);
        // adding common prefixes
        // as jena doesnt accepts query with undefined prefixes even if the endpoint should know the prefix
        queryStringParameterized.withDefaultMappings(SparqlSettingsUtil.getStandardPrefixes());
        try {
            this.jenaQuery = queryStringParameterized.asQuery();
        } catch (QueryParseException e) {
            updateTextArea("The query execution is handled by jena. The query couldn't be parsed by jena.\n" +
                    e.getMessage(), true);
            return;
        }

        if (limit.equals("removed")) {
            jenaQuery.setLimit(Query.NOLIMIT);
        } else if (limit.matches("[0-9]+")) {
            jenaQuery.setLimit(Integer.parseInt(limit));
        }
        updateTextArea(jenaQuery.toString(), false);

        QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointUrl, jenaQuery);
        //TODO use config values
        qexec.setTimeout(25, TimeUnit.SECONDS);

        Thread t = new Thread(() -> {
            try {
                results = qexec.execSelect();
            } catch (Exception e) {
                updateTextArea(e.getMessage(), true);
                if (qexec != null) {
                    qexec.close();
                }

            }
        });

        t.start();

        // checking if user canceled query
        while (t.isAlive()) {
            if (indicator.isCanceled()){
                System.out.println("canceled");
                synchronized (t) {
                    try {
                        t.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (t) { qexec.abort(); }
                synchronized (t) { t.notify(); }
                updateTextArea("Query got canceled.", true);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        if (results == null) {
            qexec.close();
            return;
        }
        JBTable resultTable = new JBTable(generateTable());
        ApplicationManager.getApplication().invokeLater(() -> queryExecutionToolWindow.setContent(new JScrollPane(resultTable)), ModalityState.any());

        qexec.close();
    }

    public TableModel generateTable(){
        //Processing endpoint response
        String[] columnNames = Arrays.copyOf(results.getResultVars().toArray(), results.getResultVars().toArray().length, String[].class);

        //iterating through each row
        ArrayList<ArrayList<String>> dataList = new ArrayList<>();
        while (results.hasNext()) {
            QuerySolution solution = results.next();

            ArrayList<String> row = new ArrayList<>();

            for (Iterator<String> iterator = solution.varNames(); iterator.hasNext(); ) {
                String field = solution.get(iterator.next()).toString();
                field = jenaQuery.getPrefixMapping().shortForm(field);
                field = SparqlSettingsUtil.getStoredPrefixes().shortForm(field);
                row.add(field);

            }
            dataList.add(row);
        }

        this.data = dataList.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

        return new DefaultTableModel(data, columnNames);
    }

    private void updateTextArea(String information, Boolean isErrorMessage){
        ApplicationManager.getApplication().invokeLater(() -> queryExecutionToolWindow.updateTextArea(information, isErrorMessage), ModalityState.any());
    }

    public String[][] getData() {
        return data;
    }
}
