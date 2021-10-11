package execution;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.intellij.lang.annotations.Language;
import org.mockito.Mockito;
import ui.QueryExecutionToolWindow;

import static org.mockito.ArgumentMatchers.*;

public class SparqlSelectExecutionCancelationTest extends BasePlatformTestCase {

    public void testCancelation() {
        @Language("Sparql")
        String query = "select distinct ?Concept where {?s ?Concept ?a. ?a ?b ?c. ?c ?d ?e. ?c ?g ?l. ?c ?o ?p} ";
        execute(query, "unmodified");
    }

    private void execute(String query, String limit){

        QueryExecutionToolWindow mockedWindow = Mockito.mock(QueryExecutionToolWindow.class);
        Mockito.doNothing().when(mockedWindow).updateTextArea(anyString(), anyBoolean());
        Mockito.doNothing().when(mockedWindow).setContent(any());

        ProgressIndicator mockedIndicator = Mockito.mock(ProgressIndicator.class);
        Mockito.doReturn(true).when(mockedIndicator).isCanceled();

        String endpointUrl = "https://dbpedia.org/sparql";
        SparqlSelectExecution execution = new SparqlSelectExecution(myFixture.getProject(), "test", query, endpointUrl, limit, mockedWindow);
        SparqlSelectExecution executionSpy = Mockito.spy(execution);

        long start = System.currentTimeMillis();
        executionSpy.run(mockedIndicator);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(timeElapsed);
        //TODO add assert
        //known bug currently will fail
    }
}
