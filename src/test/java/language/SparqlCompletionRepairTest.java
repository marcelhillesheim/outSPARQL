package language;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;
import language.editor.completion.LiveAutoCompletion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SparqlCompletionRepairTest extends LightJavaCodeInsightFixtureTestCase {

    @Parameterized.Parameter()
    public Integer offset;

    @Parameterized.Parameter(value = 1)
    public String query;

    @Parameterized.Parameters(name = "{index}: testRepair({0}, {1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {12, "SELECT ?a {  }"},
                {16, "SELECT ?a { ?v1  }"},
                {20, "SELECT ?a { ?v1 ?v1  }"},
                {12, "SELECT ?a {  ?v2 }"},
                {16, "SELECT ?a { ?v1  ?v2 }"},
                // {20, "SELECT ?a { ?v1 ?v1  ?v2 }"}, is not possible to repair
                {12, "SELECT ?a {  ?v2 ?v2 }"},
                {16, "SELECT ?a { ?v1  ?v2 ?v2 }"},
                {20, "SELECT ?a { ?v1 ?v1  ?v2 ?v2 }"},
                {12, "SELECT ?a {  ?v2 ?v2 ?v2 }"},
                {16, "SELECT ?a { ?v1  ?v2 ?v2 ?v2 }"},
                {20, "SELECT ?a { ?v1 ?v1  ?v2 ?v2 ?v2 }"},

                {25, "SELECT ?a { ?v1 ?v1 ?v1;  }"}
        });
    }

    @Test
    public void testRepair(){
        LiveAutoCompletion completion = new LiveAutoCompletion(query, offset, myFixture.getProject());
        completion.repairQuery();
        String repairedQuery = completion.getRepairedQuery();
        assert repairedQuery != null;
        PsiFile repairedQueryFile = myFixture.configureByText(SparqlFileType.INSTANCE, repairedQuery);
        System.out.println(repairedQuery);
        assertFalse(PsiTreeUtil.hasErrorElements(repairedQueryFile));
    }
}
