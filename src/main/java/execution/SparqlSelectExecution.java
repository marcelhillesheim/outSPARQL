package execution;

import org.apache.jena.query.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class SparqlSelectExecution implements SparqlExecution{
    private final String queryString;
    private final String endpointUrl;
    private ResultSet results;

    public SparqlSelectExecution(String query, String endpointUrl){
        this.queryString = query;
        this.endpointUrl = endpointUrl;
    }

    @Override
    public void run() {
        //TODO use config values --> abstract instead of interface
        Query jenaQuery = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.sparqlService(endpointUrl, jenaQuery);
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
