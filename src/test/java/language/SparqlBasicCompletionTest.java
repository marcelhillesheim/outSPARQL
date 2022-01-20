package language;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class SparqlBasicCompletionTest extends LightJavaCodeInsightFixtureTestCase {

    private static final String[] prologueKW = {"BASE", "PREFIX"};
    private static final String[] queryClauseKW = {"SELECT", "ASK", "CONSTRUCT", "DESCRIBE"};
    private static final String[] updateKW = {"LOAD", "CLEAR", "DROP", "ADD", "MOVE", "COPY", "CREATE", "WITH"};

    @Parameterized.Parameter()
    public String title;

    @Parameterized.Parameter(value = 1)
    public String query;

    @Parameterized.Parameter(value = 2)
    public List<String> expected;

    //TODO add expected results
    @Parameterized.Parameters(name = "{index}: test {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Prologue
                {"in front of Prologue",
                        "<caret>\n" +
                        "PREFIX pre: <prefixiri#>\n" +
                        "PREFIX pre: <prefixiri#>",
                        combine(prologueKW)
                },
                {"inside Prologue",
                        "PREFIX pre: <prefixiri#>\n" +
                        "<caret>\n" +
                        "PREFIX pre: <prefixiri#>",
                        combine(prologueKW)
                },
                {"after Prologue",
                        "PREFIX pre: <prefixiri#>\n" +
                                "PREFIX pre: <prefixiri#>\n" +
                                "<caret>",
                        combine(prologueKW, queryClauseKW, updateKW)
                },
                {"empty file",
                        "<caret>",
                        combine(prologueKW, queryClauseKW, updateKW)
                },
                {"empty file with whitespace",
                        " <caret>",
                        combine(prologueKW, queryClauseKW, updateKW)
                },
                {"in front of Select Query",
                        "<caret>\n" +
                                "SELECT ?v WHERE {?v ?v2 ?v3}",
                        combine(prologueKW)
                },

        });
    }

    @Test
    public void testBasicCompletion() {
        myFixture.configureByText(SparqlFileType.INSTANCE, query);
        myFixture.complete(CompletionType.BASIC);
        List<String> lookupElementStrings = myFixture.getLookupElementStrings();
        assert lookupElementStrings != null;

        Set<String> expectedSet = new HashSet<>(expected);
        Set<String> actualSet = new HashSet<>(lookupElementStrings);

        assertEquals(expectedSet, actualSet);

    }

    private static List<String> combine(String[]... arrays) {
        List<String> result = new ArrayList<>();
        for (String[] array : arrays){
            result.addAll(Arrays.asList(array));
        }
        return result;
    }
}