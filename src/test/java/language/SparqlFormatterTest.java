package language;

import com.intellij.psi.formatter.FormatterTestCase;

public class SparqlFormatterTest extends FormatterTestCase {
    @Override
    protected String getFileExtension() {
        return SparqlFileType.INSTANCE.getDefaultExtension();
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/resources/";
    }

    @Override
    protected String getBasePath() {
        return "formatting";
    }

    @Override
    protected void doTest(String resultNumber) throws Exception {
        String testName = getTestName(false);
        doTest(testName + "." + getFileExtension(), testName + "_after." + getFileExtension(), resultNumber);
    }

    public void testIndentWhereClause1() throws Exception {
        doTest();
    }

    public void testIndentWhereClause2() throws Exception {
        doTest();
    }
}
