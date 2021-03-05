package language;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class SparqlLexerAdapter extends FlexAdapter {

    public SparqlLexerAdapter() {
        super(new _SparqlLexer(null));
    }

}