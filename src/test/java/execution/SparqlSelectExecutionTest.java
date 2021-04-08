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

    public void testExecution(){
        execute(query_1, "20", 20);
    }

    public void testExecutionUnmodified(){
        execute(query_1, "unmodified", 10);
    }

    private void execute(String query, String limit, int expectedRows){


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
            assertEquals(executionSpy.getData().length, expectedRows);
            return result;
        }).when(executionSpy).generateTable();

        executionSpy.run(mockedIndicator);
    }

}
