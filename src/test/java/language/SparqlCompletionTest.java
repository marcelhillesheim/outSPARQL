package language;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

import java.util.List;

public class SparqlCompletionTest extends LightJavaCodeInsightFixtureTestCase {
    //TODO add asserts
    public void testCompletionTriple() {

        String querySelect1 = "SELECT ?a {" +
                "?a <caret>}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect1);
        myFixture.complete(CompletionType.SMART);
        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

        String querySelect2 = "SELECT ?a {" +
                "?a ?b ?c. <caret> ?b ?d.}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect2);
        myFixture.complete(CompletionType.SMART);
        lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

    }
}