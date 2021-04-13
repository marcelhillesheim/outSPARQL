package language;


import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.intellij.lang.annotations.Language;

import java.util.List;

public class SparqlCodeInsightTest extends BasePlatformTestCase {

    public void testPrefixAnnotator() {
        @Language("Sparql")
        String prefixdecl = "PREFIX existingPrefix: <testurl#> ";
        @Language("Sparql")
        String query =
                "SELECT ?a WHERE {\n" +
                "?a existingPrefix:test ?b." +
                "?a missingPrefix:test ?c}";
        myFixture.configureByText(SparqlFileType.INSTANCE,prefixdecl + query);
        List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
        assertEquals("missingPrefix:test", highlightInfos.get(0).getText());
        assertEquals(1, highlightInfos.size());

        // test without prefix declaration
        myFixture.configureByText(SparqlFileType.INSTANCE, query);
        highlightInfos = myFixture.doHighlighting();
        assertEquals("existingPrefix:test", highlightInfos.get(0).getText());
        assertEquals(2, highlightInfos.size());
    }

}
