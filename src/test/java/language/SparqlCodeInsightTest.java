package language;


import com.intellij.codeInsight.daemon.impl.HighlightInfo;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import org.intellij.lang.annotations.Language;

import java.util.List;

public class SparqlCodeInsightTest extends BasePlatformTestCase {

    public void testPrefixAnnotator() {
        @Language("Sparql")
        String query_1 = "PREFIX existingprefix: <testurl#>\n" +
                "SELECT ?a WHERE {\n" +
                "?a existingprefix:test ?b." +
                "?a missingprefix:test ?c}";
        myFixture.configureByText(SparqlFileType.INSTANCE, query_1);
        List<HighlightInfo> highlightInfos = myFixture.doHighlighting();
        for (HighlightInfo info : highlightInfos){
            System.out.println(info.getDescription());
            System.out.println(info.getText());
            System.out.println(info.getSeverity().getName());
        }



    }

}
