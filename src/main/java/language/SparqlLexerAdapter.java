package language;

import com.intellij.lexer.FlexAdapter;

public class SparqlLexerAdapter extends FlexAdapter {

    public SparqlLexerAdapter() {
        super(new _SparqlLexer(null));
    }

}