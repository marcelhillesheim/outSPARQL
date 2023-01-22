package execution;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.intellij.lang.annotations.Language;
import org.mockito.Mockito;
import ui.QueryExecutionToolWindow;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;

public class SparqlSelectExecutionTest extends BasePlatformTestCase {
    @Language("Sparql")
    private final String query_1 = "SELECT ?a WHERE {\n" +
            "?a ?b ?c.\n" +
            "} LIMIT 10";

    /*
        IMPORTANT: In case that the test fails, check if endpoint is available.
     */
    private final String endpointUrl = "https://dbpedia.org/sparql";

    public void testExecution() {
        execute(query_1, "20", 20);
    }

    public void testExecutionUnmodified() {
        execute(query_1, "unmodified", 10);
    }

    private void execute(String query, String limit, int expectedRows) {
        QueryExecutionToolWindow mockedWindow = Mockito.mock(QueryExecutionToolWindow.class);
        Mockito.doNothing().when(mockedWindow).updateTextArea(anyString(), anyBoolean());
        Mockito.doNothing().when(mockedWindow).setContent(any());

        ProgressIndicator mockedIndicator = Mockito.mock(ProgressIndicator.class);
        Mockito.doReturn(false).when(mockedIndicator).isCanceled();

        SparqlSelectExecution execution = new SparqlSelectExecution(myFixture.getProject(), "test", query, endpointUrl, limit, mockedWindow);
        SparqlSelectExecution executionSpy = Mockito.spy(execution);

        //intercept when query results are processed to check if results match expectations
        Mockito.doAnswer(invocation -> {
            Object result = invocation.callRealMethod();
            assertEquals(expectedRows, executionSpy.getData().length);
            return result;
        }).when(executionSpy).generateTable();

        executionSpy.run(mockedIndicator);
    }

    public void testColumnOrder() {
        @Language("Sparql")
        String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "SELECT * WHERE {\n" +
                "    { SELECT ?b1 WHERE { ?a rdfs:label ?b1. } LIMIT 1 }\n" +
                "    UNION\n" +
                "    { SELECT ?b2 WHERE { ?a rdfs:label ?b2 } LIMIT 1 }\n" +
                "}";

        QueryExecutionToolWindow mockedWindow = Mockito.mock(QueryExecutionToolWindow.class);
        Mockito.doNothing().when(mockedWindow).updateTextArea(anyString(), anyBoolean());
        Mockito.doNothing().when(mockedWindow).setContent(any());

        ProgressIndicator mockedIndicator = Mockito.mock(ProgressIndicator.class);
        Mockito.doReturn(false).when(mockedIndicator).isCanceled();

        SparqlSelectExecution execution = new SparqlSelectExecution(myFixture.getProject(), "test", query, endpointUrl, "2", mockedWindow);
        SparqlSelectExecution executionSpy = Mockito.spy(execution);

        //intercept when query results are processed to check if results match expectations
        Mockito.doAnswer(invocation -> {
            Object result = invocation.callRealMethod();

            // check table header
            assertEquals(2, executionSpy.getColumnNames().size());
            assertEquals("b1", executionSpy.getColumnNames().get(0));
            assertEquals("b2", executionSpy.getColumnNames().get(1));

            // check table data
            assertEquals(2, executionSpy.getData().length);

            String[] firstRow = executionSpy.getData()[0];
            assertTrue(firstRow[0].length()>0);
            assertNull(firstRow[1]);

            String[] secondRow = executionSpy.getData()[1];
            assertNull(secondRow[0]);
            assertTrue(secondRow[1].length()>0);

            return result;
        }).when(executionSpy).generateTable();

        executionSpy.run(mockedIndicator);

    }

    public void testColumnOrderSelect() {
        @Language("Sparql")
        String query = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "SELECT ?b2 ?b1 WHERE {\n" +
                "    { SELECT ?b1 WHERE { ?a rdfs:label ?b1. } LIMIT 1 }\n" +
                "    UNION\n" +
                "    { SELECT ?b2 WHERE { ?a rdfs:label ?b2 } LIMIT 1 }\n" +
                "}";

        QueryExecutionToolWindow mockedWindow = Mockito.mock(QueryExecutionToolWindow.class);
        Mockito.doNothing().when(mockedWindow).updateTextArea(anyString(), anyBoolean());
        Mockito.doNothing().when(mockedWindow).setContent(any());

        ProgressIndicator mockedIndicator = Mockito.mock(ProgressIndicator.class);
        Mockito.doReturn(false).when(mockedIndicator).isCanceled();

        SparqlSelectExecution execution = new SparqlSelectExecution(myFixture.getProject(), "test", query, endpointUrl, "2", mockedWindow);
        SparqlSelectExecution executionSpy = Mockito.spy(execution);

        //intercept when query results are processed to check if results match expectations
        Mockito.doAnswer(invocation -> {
            Object result = invocation.callRealMethod();

            // check table header
            assertEquals(2, executionSpy.getColumnNames().size());
            assertEquals("b2", executionSpy.getColumnNames().get(0));
            assertEquals("b1", executionSpy.getColumnNames().get(1));

            // check table data
            assertEquals(2, executionSpy.getData().length);

            String[] firstRow = executionSpy.getData()[0];
            assertNull(firstRow[0]);
            assertTrue(firstRow[1].length()>0);

            String[] secondRow = executionSpy.getData()[1];
            assertTrue(secondRow[0].length()>0);
            assertNull(secondRow[1]);

            return result;
        }).when(executionSpy).generateTable();

        executionSpy.run(mockedIndicator);

    }

}
