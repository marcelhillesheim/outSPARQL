package language;

import com.intellij.psi.tree.TokenSet;


import static language.psi.SparqlTypes.*;
import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
/**
 * Sets of token types for easy use.
 *
 * @author Matt Nathan
 *
 * source:SPARQL4IDEA
 * modified by
 *
 * @author Marcel Hillesheim
 */
public interface SparqlTokenTypeSets {

    TokenSet COMMENTS = TokenSet.create(LINE_COMMENT);
    TokenSet WHITESPACE = TokenSet.create(WHITE_SPACE);
    TokenSet VARIABLES = TokenSet.create(VAR1, VAR2);
    TokenSet STRING_LITERALS = TokenSet.create(STRING_LITERAL1, STRING_LITERAL2, STRING_LITERAL_LONG1, STRING_LITERAL_LONG2);
    TokenSet NUMBER_LITERALS = TokenSet.create(INTEGER, DECIMAL, DOUBLE, INTEGER_NEGATIVE, INTEGER_POSITIVE,
            DECIMAL_NEGATIVE, DECIMAL_POSITIVE, DOUBLE_NEGATIVE, DOUBLE_POSITIVE);
    TokenSet KEYWORDS = TokenSet.create(
            KW_BASE,
            KW_PREFIX,
            KW_SELECT,
            KW_CONSTRUCT,
            KW_DESCRIBE,
            KW_ASK,
            KW_ORDER,
            KW_BY,
            KW_AS,
            KW_DESC,
            KW_LIMIT,
            KW_OFFSET,
            KW_DISTINCT,
            KW_REDUCED,
            KW_FROM,
            KW_NAMED,
            KW_WHERE,
            KW_GRAPH,
            KW_OPTIONAL,
            KW_UNION,
            KW_FILTER,
            KW_A,
            KW_STR,
            KW_LANG,
            KW_LANGMATCHES,
            KW_DATATYPE,
            KW_BOUND,
            KW_SAME_TERM,
            KW_IS_URI,
            KW_IS_IRI,
            KW_IS_BLANK,
            KW_IS_LITERAL,
            KW_IS_NUMERIC,
            KW_REGEX,
            KW_GROUP,
            KW_HAVING,
            KW_ASC,
            KW_VALUES,
            KW_LOAD,
            KW_SILENT,
            KW_INTO,
            KW_CLEAR,
            KW_DROP,
            KW_CREATE,
            KW_ADD,
            KW_TO,
            KW_MOVE,
            KW_COPY,
            KW_WITH,
            KW_DELETE,
            KW_INSERT,
            KW_USING,
            KW_NAMED,
            KW_DEFAULT,
            KW_ALL,
            KW_SERVICE,
            KW_BIND,
            KW_UNDEF,
            KW_MINUS,
            KW_IN,
            KW_NOT,
            KW_IRI,
            KW_URI,
            KW_BNODE,
            KW_RAND,
            KW_ABS,
            KW_CEIL,
            KW_FLOOR,
            KW_ROUND,
            KW_CONCAT,
            KW_STRLEN,
            KW_UCASE,
            KW_LCASE,
            KW_CONTAINS,
            KW_STRSTARTS,
            KW_STRENDS,
            KW_STRBEFORE,
            KW_STRAFTER,
            KW_YEAR,
            KW_MONTH,
            KW_DAY,
            KW_HOURS,
            KW_MINUTES,
            KW_SECONDS,
            KW_TIMEZONE,
            KW_TZ,
            KW_NOW,
            KW_UUID,
            KW_STRUUID,
            KW_COALESCE,
            KW_IF,
            KW_STRLANG,
            KW_STRDT,
            KW_SUBSTR,
            KW_REPLACE,
            KW_EXISTS,
            KW_COUNT,
            KW_SUM,
            KW_MIN,
            KW_MAX,
            KW_AVG,
            KW_SAMPLE,
            KW_SEPARATOR,
            LIT_TRUE,
            LIT_FALSE
    );
}