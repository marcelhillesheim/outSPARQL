package language;


import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.intellij.lang.annotations.Language;

import java.util.List;

public class SparqlCodeInsightTest extends BasePlatformTestCase {

    public void testPrefixDeclarationMissingAnnotator() {
        @Language("Sparql")
        String prefixDecl = "PREFIX existingPrefix: <testurl#> ";
        @Language("Sparql")
        String query =
                "SELECT ?a WHERE {\n" +
                "?a existingPrefix:test ?b." +
                "?a missingPrefix:test ?c}";
        myFixture.configureByText(SparqlFileType.INSTANCE,prefixDecl + query);
        List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
        assertEquals(1, highlightInfos.stream().filter(highlightInfo -> "missingPrefix:test".equals(highlightInfo.getText())).count());
        assertEquals(1, highlightInfos.size());

        // test quickfix
        List<IntentionAction> allQuickFixes = myFixture.getAllQuickFixes();
        allQuickFixes.stream().filter(quickFix -> "Create prefix declaration".equals(quickFix.getFamilyName())).forEach(quickFix -> myFixture.launchAction(quickFix));
        myFixture.checkResult("PREFIX existingPrefix: <testurl#>\n" +
                "PREFIX missingPrefix: <>SELECT ?a WHERE {\n" +
                "?a existingPrefix:test ?b.?a missingPrefix:test ?c}");


        // test without prefix declaration
        myFixture.configureByText(SparqlFileType.INSTANCE, query);
        highlightInfos = myFixture.doHighlighting();
        assertEquals(1, highlightInfos.stream().filter(highlightInfo -> "existingPrefix:test".equals(highlightInfo.getText())).count());
        assertEquals(1, highlightInfos.stream().filter(highlightInfo -> "missingPrefix:test".equals(highlightInfo.getText())).count());
        assertEquals(2, highlightInfos.size());
    }

    public void testIriCanBeShortenedAnnotator() {
        @Language("Sparql")
        String prefixDecl = "PREFIX existingPrefix: <testurl#> ";
        @Language("Sparql")
        String query =
                "SELECT ?a WHERE {\n" +
                        "?a <testurl#local> ?b." +
                        "?a <randomurl#local> ?c." +
                        "?a existingPrefix:local ?d.}";
        myFixture.configureByText(SparqlFileType.INSTANCE,prefixDecl + query);
        List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
        assertEquals(1, highlightInfos.stream().filter(highlightInfo -> "<testurl#local>".equals(highlightInfo.getText())).count());
        assertEquals(1, highlightInfos.size());


    }

}
