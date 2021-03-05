package language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static language.psi.SparqlTypes.*;

%%

%{
  public _SparqlLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SparqlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

WS=[\u0020\u0009\u000D\u000A]
LANGTAG=@[a-zA-Z]+(-[a-zA-Z0-9]+)*
INTEGER=[0-9]+
DECIMAL=[0-9]+\.[0-9]*|\.[0-9]+
EXPONENT=[eE][+-]?[0-9]+
PN_CHARS_BASE=[A-Z]|[a-z]

%%
<YYINITIAL> {
  {WHITE_SPACE}             { return WHITE_SPACE; }

  "IRI_REF"                 { return IRI_REF; }
  "STRING_LITERAL1"         { return STRING_LITERAL1; }
  "STRING_LITERAL2"         { return STRING_LITERAL2; }
  "STRING_LITERAL_LONG1"    { return STRING_LITERAL_LONG1; }
  "STRING_LITERAL_LONG2"    { return STRING_LITERAL_LONG2; }

  {WS}                      { return WS; }
  {LANGTAG}                 { return LANGTAG; }
  {INTEGER}                 { return INTEGER; }
  {DECIMAL}                 { return DECIMAL; }
  {EXPONENT}                { return EXPONENT; }
  {PN_CHARS_BASE}           { return PN_CHARS_BASE; }

}

[^] { return BAD_CHARACTER; }
