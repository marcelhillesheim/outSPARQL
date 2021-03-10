package execution;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;
import org.apache.jena.query.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import static org.apache.jena.sparql.vocabulary.VocabTestQuery.query;

public class SparqlSelectExecution implements SparqlExecution{
    private final String queryString;
    private ResultSet results;

    public SparqlSelectExecution (String query){
        this.queryString = query;
    }

    @Override
    public void run() {
        //TODO use config values --> abstract instead of interface
        Query jenaQuery = QueryFactory.create(queryString);
        //TODO endpoint
        QueryExecution qexec = QueryExecutionFactory.sparqlService("https://dbpedia.org/sparql", jenaQuery);
        //TODO use config values
        qexec.setTimeout(30, TimeUnit.SECONDS);
        ResultSet results = qexec.execSelect();
        this.results = results;
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
