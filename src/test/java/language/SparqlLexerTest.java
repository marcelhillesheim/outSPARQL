package language;

import com.intellij.lexer.Lexer;
import com.intellij.testFramework.LexerTestCase;


public class SparqlLexerTest extends LexerTestCase {

    @Override
    protected Lexer createLexer() {
        return new SparqlLexerAdapter();
    }

    //TODO doesn't work yet (wrong dir)
    @Override
    protected String getDirPath() {
        return "src/test/resources/lexerTestCases";
    }

    public void testKeywords() {
        doTokenTest("STR", "KW_STR");
        doTokenTest("STRSTARTS", "KW_STRSTARTS");
        doTest("STRSTA", "BAD_CHARACTER ('STRSTA')");
    }

    public void testNumbers(){
        doTokenTest("0", "INTEGER");
        doTokenTest("0.1", "DECIMAL");
        doTokenTest("1e2", "DOUBLE");

        doTokenTest("+1", "INTEGER_POSITIVE");
    }

    public void testStrings(){
        doTokenTest("\"\"\" test: \"\" hello world \"\"  \"\"\"", "STRING_LITERAL_LONG2");
        doTokenTest("\" \\\" \"", "STRING_LITERAL2");
    }
    public void testComment(){
        // # can be part of an url. A lexer shouldn't detect a comment in this case.
        doTest("<#> 12345","SparqlTokenType.IRIREF ('<#>')\n" +
                "WHITE_SPACE (' ')\n" +
                "SparqlTokenType.INTEGER ('12345')");
    }



    private void doTokenTest(String input, String expectedToken){
        doTest(input, "SparqlTokenType." + expectedToken + " ('" + input + "')");
    }
}
