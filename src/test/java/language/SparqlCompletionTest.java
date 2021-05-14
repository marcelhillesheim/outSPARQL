package language;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

import java.util.List;

public class SparqlCompletionTest extends LightJavaCodeInsightFixtureTestCase {
    public void testCompletion() {
        String queryPrologue = "PREFIX pre: <prefixiri#>\n" +
                "<caret>\n" +
                "PREFIX pre: <prefixiri#>";

        myFixture.configureByText(SparqlFileType.INSTANCE, queryPrologue);
        myFixture.complete(CompletionType.BASIC);
        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

        String querySelect1 = "SELECT ?a {" +
                "?a <caret>}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect1);
        myFixture.complete(CompletionType.BASIC);
        lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

        String querySelect2 = "SELECT ?a {" +
                "?a ?b ?c. <caret> ?b ?d.}";
        myFixture.configureByText(SparqlFileType.INSTANCE, querySelect2);
        myFixture.complete(CompletionType.BASIC);
        lookupElementStrings = myFixture.getLookupElementStrings();
        System.out.println(lookupElementStrings);

    }
}