package language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;import language.psi.SparqlTypes;

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

IRIREF = "<"([^\<\>\"\{\}\|\^\`\\\x00-\x20])*">"
PNAME_NS = {PN_PREFIX}? ":"
PNAME_LN = {PNAME_NS} {PN_LOCAL}
BLANK_NODE_LABEL = "_:" ( {PN_CHARS_U} | [0-9] ) (({PN_CHARS}|'.')* {PN_CHARS})?


VAR1 = "?" {VARNAME}
VAR2 = "$" {VARNAME}
LANGTAG = "@" [a-zA-Z]+ ("-" [a-zA-Z0-9]+)*


// numbers
INTEGER = [0-9]+
DECIMAL = [0-9]* '.' [0-9]+
DOUBLE = ([0-9]+ "." [0-9]* {EXPONENT}) | ("." ([0-9])+ {EXPONENT}) | (([0-9])+ {EXPONENT})

INTEGER_POSITIVE = "+"{INTEGER}
DECIMAL_POSITIVE = "+"{DECIMAL}
DOUBLE_POSITIVE = "+"{DOUBLE}
INTEGER_NEGATIVE = "-"{INTEGER}
DECIMAL_NEGATIVE = "-"{DECIMAL}
DOUBLE_NEGATIVE = "-"{DOUBLE}

EXPONENT = [eE] [+-]? [0-9]+

// strings
STRING_LITERAL1 = "'" ( ([^\x27\x5C\x0A\x0D]) | {ECHAR} )* "'"
STRING_LITERAL2 = "\"" ( ([^\x22\x5C\x0A\x0D]) | {ECHAR} )* "\""
STRING_LITERAL_LONG1 = "'''" ( ( "'" | "''" )? ( [^'\\] | {ECHAR} ) )* "'''"
STRING_LITERAL_LONG2 = "\"\"\"" ( ( "\"" | "\"\"" )? ( [^\"\\] | {ECHAR} ) )* "\"\"\""
ECHAR = [\\][tbnrf\\\"\']


// character sets etc
NIL = "("{WS}*")"
WS = [\x20\x09\x0D\x0A]
ANON = "["{WS}*"]"
LINE_COMMENT= "#" .*

//TODO [#x10000-#xEFFFF]
PN_CHARS_BASE = [A-Za-z\u00C0-\u00D6\u00DB-\u00F6\u00F8-\u02FF\u0370-\u037D\u037F-\u1FFF\u200C-\u200D\u2070-\u218F\u2C00-\u2FEF\u3001-\uD7FF\uF900-\uFDCF\uFDF0-\uFFFD]
PN_CHARS_U = {PN_CHARS_BASE}|"_"
VARNAME = ( {PN_CHARS_U} | [0-9] ) ( {PN_CHARS_U} | [0-9\u00B7\u0300-\u036F\u203F-\u2040] )*
PN_CHARS = {PN_CHARS_U} | [\-0-9\u00B7\u0300-\u036F\u203F-\u2040]
PN_PREFIX = {PN_CHARS_BASE} (({PN_CHARS}|".")* {PN_CHARS})?
PN_LOCAL = ({PN_CHARS_U} | ':' | [0-9] | {PLX} ) (({PN_CHARS} | '.' | ':' | {PLX})* ({PN_CHARS} | ':' | {PLX}) )?
//TODO test new grammar
PLX	= {PERCENT} | {PN_LOCAL_ESC}
PERCENT = '%' {HEX} {HEX}
HEX	= [0-9] | [A-F] | [a-f]
PN_LOCAL_ESC = "\\" ( "_" | "~" | "." | "-" | "!" | "$" | "&" | "'" | "(" | ")" | "*" | "+" | "," | ";" | "=" | "/" | "?" | "#" | "@" | "%" )





%x PNAME_NS
%x PNAME_LN
%x PNAME_LN2



%%

<YYINITIAL> {
//TODO
    BASE { return KW_BASE; }
    PREFIX { return KW_PREFIX; }
    SELECT { return KW_SELECT; }
    CONSTRUCT { return KW_CONSTRUCT; }
    DESCRIBE { return KW_DESCRIBE; }
    ASK { return KW_ASK; }
    ORDER { return KW_ORDER; }
    BY { return KW_BY; }
    AS { return KW_AS; }
    DESC { return KW_DESC; }
    LIMIT { return KW_LIMIT; }
    OFFSET { return KW_OFFSET; }
    DISTINCT { return KW_DISTINCT; }
    REDUCED { return KW_REDUCED; }
    FROM { return KW_FROM; }
    NAMED { return KW_NAMED; }
    WHERE { return KW_WHERE; }
    GRAPH { return KW_GRAPH; }
    OPTIONAL { return KW_OPTIONAL; }
    UNION { return KW_UNION; }
    FILTER { return KW_FILTER; }
    "a" { return KW_A; }
    STR { return KW_STR; }
    LANG { return KW_LANG; }
    LANGMATCHES { return KW_LANGMATCHES; }
    DATATYPE { return KW_DATATYPE; }
    BOUND { return KW_BOUND; }
    sameTerm { return KW_SAME_TERM; }
    isURI { return KW_IS_URI; }
    isIRI { return KW_IS_IRI; }
    isBLANK { return KW_IS_BLANK; }
    isLITERAL { return KW_IS_LITERAL; }
    isNUMERIC { return KW_IS_NUMERIC; }
    REGEX { return KW_REGEX; }
    GROUP { return KW_GROUP; }
    HAVING { return KW_HAVING; }
    ASC { return KW_ASC; }
    VALUES { return KW_VALUES; }
    LOAD { return KW_LOAD; }
    SILENT { return KW_SILENT; }
    INTO { return KW_INTO; }
    CLEAR { return KW_CLEAR; }
    DROP { return KW_DROP; }
    CREATE { return KW_CREATE; }
    ADD { return KW_ADD; }
    TO { return KW_TO; }
    MOVE { return KW_MOVE; }
    COPY { return KW_COPY; }
    WITH { return KW_WITH; }
    DELETE { return KW_DELETE; }
    INSERT { return KW_INSERT; }
    USING { return KW_USING; }
    NAMED { return KW_NAMED; }
    DEFAULT { return KW_DEFAULT; }
    ALL { return KW_ALL; }
    SERVICE { return KW_SERVICE; }
    BIND { return KW_BIND; }
    UNDEF { return KW_UNDEF; }
    MINUS { return KW_MINUS; }
    IN { return KW_IN; }
    NOT { return KW_NOT; }
    IRI { return KW_IRI; }
    URI { return KW_URI; }
    BNODE { return KW_BNODE; }
    RAND { return KW_RAND; }
    ABS { return KW_ABS; }
    CEIL { return KW_CEIL; }
    FLOOR { return KW_FLOOR; }
    ROUND { return KW_ROUND; }
    CONCAT { return KW_CONCAT; }
    STRLEN { return KW_STRLEN; }
    UCASE { return KW_UCASE; }
    LCASE { return KW_LCASE; }
    CONTAINS { return KW_CONTAINS; }
    STRSTARTS { return KW_STRSTARTS; }
    STRENDS { return KW_STRENDS; }
    STRBEFORE { return KW_STRBEFORE; }
    STRAFTER { return KW_STRAFTER; }
    YEAR { return KW_YEAR; }
    MONTH { return KW_MONTH; }
    DAY { return KW_DAY; }
    HOURS { return KW_HOURS; }
    MINUTES { return KW_MINUTES; }
    SECONDS { return KW_SECONDS; }
    TIMEZONE { return KW_TIMEZONE; }
    TZ { return KW_TZ; }
    NOW { return KW_NOW; }
    UUID { return KW_UUID; }
    STRUUID { return KW_STRUUID; }
    COALESCE { return KW_COALESCE; }
    IF { return KW_IF; }
    STRLANG { return KW_STRLANG; }
    STRDT { return KW_STRDT; }
    SUBSTR { return KW_SUBSTR; }
    REPLACE { return KW_REPLACE; }
    EXISTS { return KW_EXISTS; }
    COUNT { return KW_COUNT; }
    SUM { return KW_SUM; }
    MIN { return KW_MIN; }
    MAX { return KW_MAX; }
    AVG { return KW_AVG; }
    SAMPLE { return KW_SAMPLE; }
    SEPARATOR { return KW_SEPARATOR; }

    true { return LIT_TRUE; }
    false { return LIT_FALSE; }

    {INTEGER} { return INTEGER; }
    {DECIMAL} { return DECIMAL; }
    {DOUBLE} { return DOUBLE; }
    {INTEGER_POSITIVE} { return INTEGER_POSITIVE; }
    {INTEGER_NEGATIVE} { return INTEGER_NEGATIVE; }
    {DECIMAL_POSITIVE} { return DECIMAL_POSITIVE; }
    {DECIMAL_NEGATIVE} { return DECIMAL_NEGATIVE; }
    {DOUBLE_POSITIVE} { return DOUBLE_POSITIVE; }
    {DOUBLE_NEGATIVE} { return DOUBLE_NEGATIVE; }

    "(" { return OP_LROUND; }
    ")" { return OP_RROUND; }
    "{" { return OP_LCURLY; }
    "}" { return OP_RCURLY; }
    "[" { return OP_LSQUARE; }
    "]" { return OP_RSQUARE; }

    "." { return OP_DOT; }
    ";" { return OP_SEMI; }
    "," { return OP_COMMA; }
    "||" { return OP_PIPEPIPE; }
    "&&" { return OP_ANDAND; }
    "=" { return OP_EQ; }
    "!=" { return OP_NE; }
    "<" { return OP_LT; }
    ">" { return OP_GT; }
    "<=" { return OP_LE; }
    ">=" { return OP_GE; }
    "+" { return OP_PLUS; }
    "-" { return OP_MINUS; }
    "*" { return OP_MULT; }
    "/" { return OP_DIV; }
    "!" { return OP_NOT; }
// TODO OP_hat
//    "^^" { return OP_HATHAT; }

    {IRIREF} { return IRIREF;}
    {PNAME_LN} { return SparqlTypes.PNAME_LN; }
    {PNAME_NS} { return SparqlTypes.PNAME_NS; }
    {BLANK_NODE_LABEL} { return BLANK_NODE; }

    {ANON} { return ANON; }
    {NIL} { return NIL; }

    {LANGTAG} { return LANGTAG; }
    {VAR1} { return VAR1; }
    {VAR2} { return VAR2; }

    {STRING_LITERAL1} { return STRING_LITERAL1; }
    {STRING_LITERAL2} { return STRING_LITERAL2; }
    {STRING_LITERAL_LONG1} { return STRING_LITERAL_LONG1; }
    {STRING_LITERAL_LONG2} { return STRING_LITERAL_LONG2; }

    //  '#', outside an IRI or string, and continue to the end of line (marked by characters 0x0D or 0x0A)
    {LINE_COMMENT} {return LINE_COMMENT; }
}

{WS} { return WHITE_SPACE; }
//[:letter:]+ { return UNKNOWN; }
[^] { return BAD_CHARACTER; }
