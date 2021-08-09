package language;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import settings.SparqlAppSettingsManager;

import java.util.List;

public class SparqlSmartCompletionTest extends LightJavaCodeInsightFixtureTestCase {

    public void testCompletionTriple() {

        String querySelect = "SELECT ?a {" +
                "?a ?b <caret>}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect);
        SparqlAppSettingsManager.getInstance().endpointSettingsForExecution.setUrl("http://dbpedia.org/sparql");

        myFixture.complete(CompletionType.SMART);
        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);
        assert lookupElementStrings != null;
        assertFalse(lookupElementStrings.isEmpty());

    }
}