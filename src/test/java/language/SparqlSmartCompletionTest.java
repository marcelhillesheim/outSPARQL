package language;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import settings.SparqlAppSettingsManager;

import java.util.List;

public class SparqlSmartCompletionTest extends LightJavaCodeInsightFixtureTestCase {
    //TODO add asserts
    public void testCompletionTriple() {

        String querySelect1 = "SELECT ?a {" +
                "?a <caret>}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect1);
        SparqlAppSettingsManager.getInstance().endpointSettingsForExecution.setUrl("http://dbpedia.org/sparql");

        myFixture.complete(CompletionType.SMART);
        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

    }
}