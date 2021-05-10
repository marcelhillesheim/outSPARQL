package language;

import com.intellij.testFramework.ParsingTestCase;

/**
 * Tests the Parser generated with the .bnf file
 * The queries are example queries from the w3c SPARQL 1.1 recommendation
 * The queries are stored in a text file with '###' as separator between queries
 *
 * W3_query_list contains example queries from https://www.w3.org/TR/2013/REC-sparql11-query-20130321/
 * W3_queryUpdate_list contains example queries from https://www.w3.org/TR/2013/REC-sparql11-update-20130321/
 *
 * The SPARQL files are generated from these text files with ParserTestQueryGenerator.py
 */

public class SparqlParsingTest extends ParsingTestCase {

    public SparqlParsingTest() {
        super("", "sparql", new SparqlParserDefinition());
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testManualParserTestSelect() { doTest(true, true); }
    public void testManualParserTestConstruct() { doTest(true, true); }
    public void testManualParserTestUpdate() { doTest(true, true); }

    public void testParsingTest000() { doTest(true, true); }
    public void testParsingTest001() { doTest(true, true); }
    public void testParsingTest002() { doTest(true, true); }
    public void testParsingTest003() { doTest(true, true); }
    public void testParsingTest004() { doTest(true, true); }
    public void testParsingTest005() { doTest(true, true); }
    public void testParsingTest006() { doTest(true, true); }
    public void testParsingTest007() { doTest(true, true); }
    public void testParsingTest008() { doTest(true, true); }
    public void testParsingTest009() { doTest(true, true); }
    public void testParsingTest010() { doTest(true, true); }
    public void testParsingTest011() { doTest(true, true); }
    public void testParsingTest012() { doTest(true, true); }
    public void testParsingTest013() { doTest(true, true); }
    public void testParsingTest014() { doTest(true, true); }
    public void testParsingTest015() { doTest(true, true); }
    public void testParsingTest016() { doTest(true, true); }
    public void testParsingTest017() { doTest(true, true); }
    public void testParsingTest018() { doTest(true, true); }
    public void testParsingTest019() { doTest(true, true); }
    public void testParsingTest020() { doTest(true, true); }
    public void testParsingTest021() { doTest(true, true); }
    public void testParsingTest022() { doTest(true, true); }
    public void testParsingTest023() { doTest(true, true); }
    public void testParsingTest024() { doTest(true, true); }
    public void testParsingTest025() { doTest(true, true); }
    public void testParsingTest026() { doTest(true, true); }
    public void testParsingTest027() { doTest(true, true); }
    public void testParsingTest028() { doTest(true, true); }
    public void testParsingTest029() { doTest(true, true); }
    public void testParsingTest030() { doTest(true, true); }
    public void testParsingTest031() { doTest(true, true); }
    public void testParsingTest032() { doTest(true, true); }
    public void testParsingTest033() { doTest(true, true); }
    public void testParsingTest034() { doTest(true, true); }
    public void testParsingTest035() { doTest(true, true); }
    public void testParsingTest036() { doTest(true, true); }
    public void testParsingTest037() { doTest(true, true); }
    public void testParsingTest038() { doTest(true, true); }
    public void testParsingTest039() { doTest(true, true); }
    public void testParsingTest040() { doTest(true, true); }
    public void testParsingTest041() { doTest(true, true); }
    public void testParsingTest042() { doTest(true, true); }
    public void testParsingTest043() { doTest(true, true); }
    public void testParsingTest044() { doTest(true, true); }
    public void testParsingTest045() { doTest(true, true); }
    public void testParsingTest046() { doTest(true, true); }
    public void testParsingTest047() { doTest(true, true); }
    public void testParsingTest048() { doTest(true, true); }
    public void testParsingTest049() { doTest(true, true); }
    public void testParsingTest050() { doTest(true, true); }
    public void testParsingTest051() { doTest(true, true); }
    public void testParsingTest052() { doTest(true, true); }
    public void testParsingTest053() { doTest(true, true); }
    public void testParsingTest054() { doTest(true, true); }
    public void testParsingTest055() { doTest(true, true); }
    public void testParsingTest056() { doTest(true, true); }
    public void testParsingTest057() { doTest(true, true); }
    public void testParsingTest058() { doTest(true, true); }
    public void testParsingTest059() { doTest(true, true); }
    public void testParsingTest060() { doTest(true, true); }
    public void testParsingTest061() { doTest(true, true); }
    public void testParsingTest062() { doTest(true, true); }
    public void testParsingTest063() { doTest(true, true); }
    public void testParsingTest064() { doTest(true, true); }
    public void testParsingTest065() { doTest(true, true); }
    public void testParsingTest066() { doTest(true, true); }
    public void testParsingTest067() { doTest(true, true); }
    public void testParsingTest068() { doTest(true, true); }
    public void testParsingTest069() { doTest(true, true); }
    public void testParsingTest070() { doTest(true, true); }
    public void testParsingTest071() { doTest(true, true); }
    public void testParsingTest072() { doTest(true, true); }
    public void testParsingTest073() { doTest(true, true); }
    public void testParsingTest074() { doTest(true, true); }
    public void testParsingTest075() { doTest(true, true); }
    public void testParsingTest076() { doTest(true, true); }
    public void testParsingTest077() { doTest(true, true); }
    public void testParsingTest078() { doTest(true, true); }
    public void testParsingTest079() { doTest(true, true); }
    public void testParsingTest080() { doTest(true, true); }
    public void testParsingTest081() { doTest(true, true); }
    public void testParsingTest082() { doTest(true, true); }
    public void testParsingTest083() { doTest(true, true); }
    public void testParsingTest084() { doTest(true, true); }
    public void testParsingTest085() { doTest(true, true); }
    public void testParsingTest086() { doTest(true, true); }
    public void testParsingTest087() { doTest(true, true); }
    public void testParsingTest088() { doTest(true, true); }
    public void testParsingTest089() { doTest(true, true); }
    public void testParsingTest090() { doTest(true, true); }
    public void testParsingTest091() { doTest(true, true); }
    public void testParsingTest092() { doTest(true, true); }
    public void testParsingTest093() { doTest(true, true); }
    public void testParsingTest094() { doTest(true, true); }
    public void testParsingTest095() { doTest(true, true); }
    public void testParsingTest096() { doTest(true, true); }
    public void testParsingTest097() { doTest(true, true); }
    public void testParsingTest098() { doTest(true, true); }
    public void testParsingTest099() { doTest(true, true); }
    public void testParsingTest100() { doTest(true, true); }
    public void testParsingTest101() { doTest(true, true); }

    // tests for SPARQL update queries
    public void testParsingUpdateTest000() { doTest(true, true); }
    public void testParsingUpdateTest001() { doTest(true, true); }
    public void testParsingUpdateTest002() { doTest(true, true); }
    public void testParsingUpdateTest003() { doTest(true, true); }
    public void testParsingUpdateTest004() { doTest(true, true); }
    public void testParsingUpdateTest005() { doTest(true, true); }
    public void testParsingUpdateTest006() { doTest(true, true); }
    public void testParsingUpdateTest007() { doTest(true, true); }
    public void testParsingUpdateTest008() { doTest(true, true); }
    public void testParsingUpdateTest009() { doTest(true, true); }
    public void testParsingUpdateTest010() { doTest(true, true); }
    public void testParsingUpdateTest011() { doTest(true, true); }
    public void testParsingUpdateTest012() { doTest(true, true); }
    public void testParsingUpdateTest013() { doTest(true, true); }
    public void testParsingUpdateTest014() { doTest(true, true); }
    public void testParsingUpdateTest015() { doTest(true, true); }
    public void testParsingUpdateTest016() { doTest(true, true); }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/resources/queries";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

}
