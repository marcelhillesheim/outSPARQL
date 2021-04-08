// This is a generated file. Not intended for manual editing.
package language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import language.psi.impl.*;

public interface SparqlTypes {

  IElementType ADD = new SparqlElementType("ADD");
  IElementType ADDITIVE_EXPRESSION = new SparqlElementType("ADDITIVE_EXPRESSION");
  IElementType AGGREGATE = new SparqlElementType("AGGREGATE");
  IElementType ARG_LIST = new SparqlElementType("ARG_LIST");
  IElementType ASK_QUERY = new SparqlElementType("ASK_QUERY");
  IElementType BASE_DECL = new SparqlElementType("BASE_DECL");
  IElementType BIND = new SparqlElementType("BIND");
  IElementType BLANK_NODE = new SparqlElementType("BLANK_NODE");
  IElementType BLANK_NODE_PROPERTY_LIST = new SparqlElementType("BLANK_NODE_PROPERTY_LIST");
  IElementType BLANK_NODE_PROPERTY_LIST_PATH = new SparqlElementType("BLANK_NODE_PROPERTY_LIST_PATH");
  IElementType BOOLEAN_LITERAL = new SparqlElementType("BOOLEAN_LITERAL");
  IElementType BRACKETTED_EXPRESSION = new SparqlElementType("BRACKETTED_EXPRESSION");
  IElementType BUILT_IN_CALL = new SparqlElementType("BUILT_IN_CALL");
  IElementType CLEAR = new SparqlElementType("CLEAR");
  IElementType COLLECTION = new SparqlElementType("COLLECTION");
  IElementType COLLECTION_PATH = new SparqlElementType("COLLECTION_PATH");
  IElementType CONDITIONAL_AND_EXPRESSION = new SparqlElementType("CONDITIONAL_AND_EXPRESSION");
  IElementType CONDITIONAL_OR_EXPRESSION = new SparqlElementType("CONDITIONAL_OR_EXPRESSION");
  IElementType CONSTRAINT = new SparqlElementType("CONSTRAINT");
  IElementType CONSTRUCT_QUERY = new SparqlElementType("CONSTRUCT_QUERY");
  IElementType CONSTRUCT_TEMPLATE = new SparqlElementType("CONSTRUCT_TEMPLATE");
  IElementType CONSTRUCT_TRIPLES = new SparqlElementType("CONSTRUCT_TRIPLES");
  IElementType COPY = new SparqlElementType("COPY");
  IElementType CREATE = new SparqlElementType("CREATE");
  IElementType DATASET_CLAUSE = new SparqlElementType("DATASET_CLAUSE");
  IElementType DATA_BLOCK = new SparqlElementType("DATA_BLOCK");
  IElementType DATA_BLOCK_VALUE = new SparqlElementType("DATA_BLOCK_VALUE");
  IElementType DEFAULT_GRAPH_CLAUSE = new SparqlElementType("DEFAULT_GRAPH_CLAUSE");
  IElementType DELETE_CLAUSE = new SparqlElementType("DELETE_CLAUSE");
  IElementType DELETE_DATA = new SparqlElementType("DELETE_DATA");
  IElementType DELETE_WHERE = new SparqlElementType("DELETE_WHERE");
  IElementType DESCRIBE_QUERY = new SparqlElementType("DESCRIBE_QUERY");
  IElementType DROP = new SparqlElementType("DROP");
  IElementType EXISTS_FUNC = new SparqlElementType("EXISTS_FUNC");
  IElementType EXPRESSION = new SparqlElementType("EXPRESSION");
  IElementType EXPRESSION_LIST = new SparqlElementType("EXPRESSION_LIST");
  IElementType FILTER = new SparqlElementType("FILTER");
  IElementType FUNCTION_CALL = new SparqlElementType("FUNCTION_CALL");
  IElementType GRAPH_GRAPH_PATTERN = new SparqlElementType("GRAPH_GRAPH_PATTERN");
  IElementType GRAPH_NODE = new SparqlElementType("GRAPH_NODE");
  IElementType GRAPH_NODE_PATH = new SparqlElementType("GRAPH_NODE_PATH");
  IElementType GRAPH_OR_DEFAULT = new SparqlElementType("GRAPH_OR_DEFAULT");
  IElementType GRAPH_PATTERN_NOT_TRIPLES = new SparqlElementType("GRAPH_PATTERN_NOT_TRIPLES");
  IElementType GRAPH_REF = new SparqlElementType("GRAPH_REF");
  IElementType GRAPH_REF_ALL = new SparqlElementType("GRAPH_REF_ALL");
  IElementType GRAPH_TERM = new SparqlElementType("GRAPH_TERM");
  IElementType GROUP_CLAUSE = new SparqlElementType("GROUP_CLAUSE");
  IElementType GROUP_CONDITION = new SparqlElementType("GROUP_CONDITION");
  IElementType GROUP_GRAPH_PATTERN = new SparqlElementType("GROUP_GRAPH_PATTERN");
  IElementType GROUP_GRAPH_PATTERN_SUB = new SparqlElementType("GROUP_GRAPH_PATTERN_SUB");
  IElementType GROUP_OR_UNION_GRAPH_PATTERN = new SparqlElementType("GROUP_OR_UNION_GRAPH_PATTERN");
  IElementType HAVING_CLAUSE = new SparqlElementType("HAVING_CLAUSE");
  IElementType HAVING_CONDITION = new SparqlElementType("HAVING_CONDITION");
  IElementType INLINE_DATA = new SparqlElementType("INLINE_DATA");
  IElementType INLINE_DATA_FULL = new SparqlElementType("INLINE_DATA_FULL");
  IElementType INLINE_DATA_ONE_VAR = new SparqlElementType("INLINE_DATA_ONE_VAR");
  IElementType INSERT_CLAUSE = new SparqlElementType("INSERT_CLAUSE");
  IElementType INSERT_DATA = new SparqlElementType("INSERT_DATA");
  IElementType IRI = new SparqlElementType("IRI");
  IElementType IRI_OR_FUNCTION = new SparqlElementType("IRI_OR_FUNCTION");
  IElementType LIMIT_CLAUSE = new SparqlElementType("LIMIT_CLAUSE");
  IElementType LIMIT_OFFSET_CLAUSES = new SparqlElementType("LIMIT_OFFSET_CLAUSES");
  IElementType LIT_INTEGER = new SparqlElementType("LIT_INTEGER");
  IElementType LOAD = new SparqlElementType("LOAD");
  IElementType MINUS_GRAPH_PATTERN = new SparqlElementType("MINUS_GRAPH_PATTERN");
  IElementType MODIFY = new SparqlElementType("MODIFY");
  IElementType MOVE = new SparqlElementType("MOVE");
  IElementType MULTIPLICATIVE_EXPRESSION = new SparqlElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType NAMED_GRAPH_CLAUSE = new SparqlElementType("NAMED_GRAPH_CLAUSE");
  IElementType NOT_EXISTS_FUNC = new SparqlElementType("NOT_EXISTS_FUNC");
  IElementType NUMERIC_EXPRESSION = new SparqlElementType("NUMERIC_EXPRESSION");
  IElementType NUMERIC_LITERAL = new SparqlElementType("NUMERIC_LITERAL");
  IElementType NUMERIC_LITERAL_NEGATIVE = new SparqlElementType("NUMERIC_LITERAL_NEGATIVE");
  IElementType NUMERIC_LITERAL_POSITIVE = new SparqlElementType("NUMERIC_LITERAL_POSITIVE");
  IElementType NUMERIC_LITERAL_UNSIGNED = new SparqlElementType("NUMERIC_LITERAL_UNSIGNED");
  IElementType OBJECT = new SparqlElementType("OBJECT");
  IElementType OBJECT_LIST = new SparqlElementType("OBJECT_LIST");
  IElementType OBJECT_LIST_PATH = new SparqlElementType("OBJECT_LIST_PATH");
  IElementType OBJECT_PATH = new SparqlElementType("OBJECT_PATH");
  IElementType OFFSET_CLAUSE = new SparqlElementType("OFFSET_CLAUSE");
  IElementType OPTIONAL_GRAPH_PATTERN = new SparqlElementType("OPTIONAL_GRAPH_PATTERN");
  IElementType ORDER_CLAUSE = new SparqlElementType("ORDER_CLAUSE");
  IElementType ORDER_CONDITION = new SparqlElementType("ORDER_CONDITION");
  IElementType PATH = new SparqlElementType("PATH");
  IElementType PATH_ALTERNATIVE = new SparqlElementType("PATH_ALTERNATIVE");
  IElementType PATH_ELT = new SparqlElementType("PATH_ELT");
  IElementType PATH_ELT_OR_INVERSE = new SparqlElementType("PATH_ELT_OR_INVERSE");
  IElementType PATH_MOD = new SparqlElementType("PATH_MOD");
  IElementType PATH_NEGATED_PROPERTY_SET = new SparqlElementType("PATH_NEGATED_PROPERTY_SET");
  IElementType PATH_ONE_IN_PROPERTY_SET = new SparqlElementType("PATH_ONE_IN_PROPERTY_SET");
  IElementType PATH_PRIMARY = new SparqlElementType("PATH_PRIMARY");
  IElementType PATH_SEQUENCE = new SparqlElementType("PATH_SEQUENCE");
  IElementType PREFIXED_NAME = new SparqlElementType("PREFIXED_NAME");
  IElementType PREFIX_DECL = new SparqlElementType("PREFIX_DECL");
  IElementType PRIMARY_EXPRESSION = new SparqlElementType("PRIMARY_EXPRESSION");
  IElementType PROLOGUE = new SparqlElementType("PROLOGUE");
  IElementType PROPERTY_LIST = new SparqlElementType("PROPERTY_LIST");
  IElementType PROPERTY_LIST_NOT_EMPTY = new SparqlElementType("PROPERTY_LIST_NOT_EMPTY");
  IElementType PROPERTY_LIST_PATH = new SparqlElementType("PROPERTY_LIST_PATH");
  IElementType PROPERTY_LIST_PATH_NOT_EMPTY = new SparqlElementType("PROPERTY_LIST_PATH_NOT_EMPTY");
  IElementType QUADS = new SparqlElementType("QUADS");
  IElementType QUADS_NOT_TRIPLES = new SparqlElementType("QUADS_NOT_TRIPLES");
  IElementType QUAD_DATA = new SparqlElementType("QUAD_DATA");
  IElementType QUAD_PATTERN = new SparqlElementType("QUAD_PATTERN");
  IElementType QUERY = new SparqlElementType("QUERY");
  IElementType QUERY_UNIT = new SparqlElementType("QUERY_UNIT");
  IElementType RDF_LITERAL = new SparqlElementType("RDF_LITERAL");
  IElementType REGEX_EXPRESSION = new SparqlElementType("REGEX_EXPRESSION");
  IElementType RELATIONAL_EXPRESSION = new SparqlElementType("RELATIONAL_EXPRESSION");
  IElementType SELECT_CLAUSE = new SparqlElementType("SELECT_CLAUSE");
  IElementType SELECT_QUERY = new SparqlElementType("SELECT_QUERY");
  IElementType SERVICE_GRAPH_PATTERN = new SparqlElementType("SERVICE_GRAPH_PATTERN");
  IElementType SOLUTION_MODIFIER = new SparqlElementType("SOLUTION_MODIFIER");
  IElementType SOURCE_SELECTOR = new SparqlElementType("SOURCE_SELECTOR");
  IElementType STRING = new SparqlElementType("STRING");
  IElementType STR_REPLACE_EXPRESSION = new SparqlElementType("STR_REPLACE_EXPRESSION");
  IElementType SUBSTRING_EXPRESSION = new SparqlElementType("SUBSTRING_EXPRESSION");
  IElementType SUB_SELECT = new SparqlElementType("SUB_SELECT");
  IElementType TRIPLES_BLOCK = new SparqlElementType("TRIPLES_BLOCK");
  IElementType TRIPLES_NODE = new SparqlElementType("TRIPLES_NODE");
  IElementType TRIPLES_NODE_PATH = new SparqlElementType("TRIPLES_NODE_PATH");
  IElementType TRIPLES_SAME_SUBJECT = new SparqlElementType("TRIPLES_SAME_SUBJECT");
  IElementType TRIPLES_SAME_SUBJECT_PATH = new SparqlElementType("TRIPLES_SAME_SUBJECT_PATH");
  IElementType TRIPLES_TEMPLATE = new SparqlElementType("TRIPLES_TEMPLATE");
  IElementType UNARY_EXPRESSION = new SparqlElementType("UNARY_EXPRESSION");
  IElementType UPDATE = new SparqlElementType("UPDATE");
  IElementType UPDATE_1 = new SparqlElementType("UPDATE_1");
  IElementType UPDATE_UNIT = new SparqlElementType("UPDATE_UNIT");
  IElementType USING_CLAUSE = new SparqlElementType("USING_CLAUSE");
  IElementType VALUES_CLAUSE = new SparqlElementType("VALUES_CLAUSE");
  IElementType VALUE_LOGICAL = new SparqlElementType("VALUE_LOGICAL");
  IElementType VAR = new SparqlElementType("VAR");
  IElementType VAR_OR_IRI = new SparqlElementType("VAR_OR_IRI");
  IElementType VAR_OR_TERM = new SparqlElementType("VAR_OR_TERM");
  IElementType VERB = new SparqlElementType("VERB");
  IElementType VERB_PATH = new SparqlElementType("VERB_PATH");
  IElementType VERB_SIMPLE = new SparqlElementType("VERB_SIMPLE");
  IElementType WHERE_CLAUSE = new SparqlElementType("WHERE_CLAUSE");

  IElementType ANON = new SparqlTokenType("ANON");
  IElementType BLANK_NODE_LABEL = new SparqlTokenType("BLANK_NODE_LABEL");
  IElementType DECIMAL = new SparqlTokenType("DECIMAL");
  IElementType DECIMAL_NEGATIVE = new SparqlTokenType("DECIMAL_NEGATIVE");
  IElementType DECIMAL_POSITIVE = new SparqlTokenType("DECIMAL_POSITIVE");
  IElementType DOUBLE = new SparqlTokenType("DOUBLE");
  IElementType DOUBLE_NEGATIVE = new SparqlTokenType("DOUBLE_NEGATIVE");
  IElementType DOUBLE_POSITIVE = new SparqlTokenType("DOUBLE_POSITIVE");
  IElementType INTEGER = new SparqlTokenType("INTEGER");
  IElementType INTEGER_NEGATIVE = new SparqlTokenType("INTEGER_NEGATIVE");
  IElementType INTEGER_POSITIVE = new SparqlTokenType("INTEGER_POSITIVE");
  IElementType IRIREF = new SparqlTokenType("IRIREF");
  IElementType KW_A = new SparqlTokenType("KW_A");
  IElementType KW_ABS = new SparqlTokenType("KW_ABS");
  IElementType KW_ADD = new SparqlTokenType("KW_ADD");
  IElementType KW_ALL = new SparqlTokenType("KW_ALL");
  IElementType KW_AS = new SparqlTokenType("KW_AS");
  IElementType KW_ASC = new SparqlTokenType("KW_ASC");
  IElementType KW_ASK = new SparqlTokenType("KW_ASK");
  IElementType KW_AVG = new SparqlTokenType("KW_AVG");
  IElementType KW_BASE = new SparqlTokenType("KW_BASE");
  IElementType KW_BIND = new SparqlTokenType("KW_BIND");
  IElementType KW_BNODE = new SparqlTokenType("KW_BNODE");
  IElementType KW_BOUND = new SparqlTokenType("KW_BOUND");
  IElementType KW_BY = new SparqlTokenType("KW_BY");
  IElementType KW_CEIL = new SparqlTokenType("KW_CEIL");
  IElementType KW_CLEAR = new SparqlTokenType("KW_CLEAR");
  IElementType KW_COALESCE = new SparqlTokenType("KW_COALESCE");
  IElementType KW_CONCAT = new SparqlTokenType("KW_CONCAT");
  IElementType KW_CONSTRUCT = new SparqlTokenType("KW_CONSTRUCT");
  IElementType KW_CONTAINS = new SparqlTokenType("KW_CONTAINS");
  IElementType KW_COPY = new SparqlTokenType("KW_COPY");
  IElementType KW_COUNT = new SparqlTokenType("KW_COUNT");
  IElementType KW_CREATE = new SparqlTokenType("KW_CREATE");
  IElementType KW_DATA = new SparqlTokenType("KW_DATA");
  IElementType KW_DATATYPE = new SparqlTokenType("KW_DATATYPE");
  IElementType KW_DAY = new SparqlTokenType("KW_DAY");
  IElementType KW_DEFAULT = new SparqlTokenType("KW_DEFAULT");
  IElementType KW_DELETE = new SparqlTokenType("KW_DELETE");
  IElementType KW_DESC = new SparqlTokenType("KW_DESC");
  IElementType KW_DESCRIBE = new SparqlTokenType("KW_DESCRIBE");
  IElementType KW_DISTINCT = new SparqlTokenType("KW_DISTINCT");
  IElementType KW_DROP = new SparqlTokenType("KW_DROP");
  IElementType KW_ENCODE_FOR_URI = new SparqlTokenType("KW_ENCODE_FOR_URI");
  IElementType KW_EXISTS = new SparqlTokenType("KW_EXISTS");
  IElementType KW_FILTER = new SparqlTokenType("KW_FILTER");
  IElementType KW_FLOOR = new SparqlTokenType("KW_FLOOR");
  IElementType KW_FROM = new SparqlTokenType("KW_FROM");
  IElementType KW_GRAPH = new SparqlTokenType("KW_GRAPH");
  IElementType KW_GROUP = new SparqlTokenType("KW_GROUP");
  IElementType KW_GROUP_CONCAT = new SparqlTokenType("KW_GROUP_CONCAT");
  IElementType KW_HAVING = new SparqlTokenType("KW_HAVING");
  IElementType KW_HOURS = new SparqlTokenType("KW_HOURS");
  IElementType KW_IF = new SparqlTokenType("KW_IF");
  IElementType KW_IN = new SparqlTokenType("KW_IN");
  IElementType KW_INSERT = new SparqlTokenType("KW_INSERT");
  IElementType KW_INTO = new SparqlTokenType("KW_INTO");
  IElementType KW_IRI = new SparqlTokenType("KW_IRI");
  IElementType KW_IS_BLANK = new SparqlTokenType("KW_IS_BLANK");
  IElementType KW_IS_IRI = new SparqlTokenType("KW_IS_IRI");
  IElementType KW_IS_LITERAL = new SparqlTokenType("KW_IS_LITERAL");
  IElementType KW_IS_NUMERIC = new SparqlTokenType("KW_IS_NUMERIC");
  IElementType KW_IS_URI = new SparqlTokenType("KW_IS_URI");
  IElementType KW_LANG = new SparqlTokenType("KW_LANG");
  IElementType KW_LANGMATCHES = new SparqlTokenType("KW_LANGMATCHES");
  IElementType KW_LCASE = new SparqlTokenType("KW_LCASE");
  IElementType KW_LIMIT = new SparqlTokenType("KW_LIMIT");
  IElementType KW_LOAD = new SparqlTokenType("KW_LOAD");
  IElementType KW_MAX = new SparqlTokenType("KW_MAX");
  IElementType KW_MD5 = new SparqlTokenType("KW_MD5");
  IElementType KW_MIN = new SparqlTokenType("KW_MIN");
  IElementType KW_MINUS = new SparqlTokenType("KW_MINUS");
  IElementType KW_MINUTES = new SparqlTokenType("KW_MINUTES");
  IElementType KW_MONTH = new SparqlTokenType("KW_MONTH");
  IElementType KW_MOVE = new SparqlTokenType("KW_MOVE");
  IElementType KW_NAMED = new SparqlTokenType("KW_NAMED");
  IElementType KW_NOT = new SparqlTokenType("KW_NOT");
  IElementType KW_NOW = new SparqlTokenType("KW_NOW");
  IElementType KW_OFFSET = new SparqlTokenType("KW_OFFSET");
  IElementType KW_OPTIONAL = new SparqlTokenType("KW_OPTIONAL");
  IElementType KW_ORDER = new SparqlTokenType("KW_ORDER");
  IElementType KW_PREFIX = new SparqlTokenType("KW_PREFIX");
  IElementType KW_RAND = new SparqlTokenType("KW_RAND");
  IElementType KW_REDUCED = new SparqlTokenType("KW_REDUCED");
  IElementType KW_REGEX = new SparqlTokenType("KW_REGEX");
  IElementType KW_REPLACE = new SparqlTokenType("KW_REPLACE");
  IElementType KW_ROUND = new SparqlTokenType("KW_ROUND");
  IElementType KW_SAME_TERM = new SparqlTokenType("KW_SAME_TERM");
  IElementType KW_SAMPLE = new SparqlTokenType("KW_SAMPLE");
  IElementType KW_SECONDS = new SparqlTokenType("KW_SECONDS");
  IElementType KW_SELECT = new SparqlTokenType("KW_SELECT");
  IElementType KW_SEPARATOR = new SparqlTokenType("KW_SEPARATOR");
  IElementType KW_SERVICE = new SparqlTokenType("KW_SERVICE");
  IElementType KW_SHA1 = new SparqlTokenType("KW_SHA1");
  IElementType KW_SHA256 = new SparqlTokenType("KW_SHA256");
  IElementType KW_SHA384 = new SparqlTokenType("KW_SHA384");
  IElementType KW_SHA512 = new SparqlTokenType("KW_SHA512");
  IElementType KW_SILENT = new SparqlTokenType("KW_SILENT");
  IElementType KW_STR = new SparqlTokenType("KW_STR");
  IElementType KW_STRAFTER = new SparqlTokenType("KW_STRAFTER");
  IElementType KW_STRBEFORE = new SparqlTokenType("KW_STRBEFORE");
  IElementType KW_STRDT = new SparqlTokenType("KW_STRDT");
  IElementType KW_STRENDS = new SparqlTokenType("KW_STRENDS");
  IElementType KW_STRLANG = new SparqlTokenType("KW_STRLANG");
  IElementType KW_STRLEN = new SparqlTokenType("KW_STRLEN");
  IElementType KW_STRSTARTS = new SparqlTokenType("KW_STRSTARTS");
  IElementType KW_STRUUID = new SparqlTokenType("KW_STRUUID");
  IElementType KW_SUBSTR = new SparqlTokenType("KW_SUBSTR");
  IElementType KW_SUM = new SparqlTokenType("KW_SUM");
  IElementType KW_TIMEZONE = new SparqlTokenType("KW_TIMEZONE");
  IElementType KW_TO = new SparqlTokenType("KW_TO");
  IElementType KW_TZ = new SparqlTokenType("KW_TZ");
  IElementType KW_UCASE = new SparqlTokenType("KW_UCASE");
  IElementType KW_UNDEF = new SparqlTokenType("KW_UNDEF");
  IElementType KW_UNION = new SparqlTokenType("KW_UNION");
  IElementType KW_URI = new SparqlTokenType("KW_URI");
  IElementType KW_USING = new SparqlTokenType("KW_USING");
  IElementType KW_UUID = new SparqlTokenType("KW_UUID");
  IElementType KW_VALUES = new SparqlTokenType("KW_VALUES");
  IElementType KW_WHERE = new SparqlTokenType("KW_WHERE");
  IElementType KW_WITH = new SparqlTokenType("KW_WITH");
  IElementType KW_YEAR = new SparqlTokenType("KW_YEAR");
  IElementType LANGTAG = new SparqlTokenType("LANGTAG");
  IElementType LINE_COMMENT = new SparqlTokenType("LINE_COMMENT");
  IElementType LIT_FALSE = new SparqlTokenType("LIT_FALSE");
  IElementType LIT_TRUE = new SparqlTokenType("LIT_TRUE");
  IElementType NIL = new SparqlTokenType("NIL");
  IElementType OP_ANDAND = new SparqlTokenType("OP_ANDAND");
  IElementType OP_COMMA = new SparqlTokenType("OP_COMMA");
  IElementType OP_DIV = new SparqlTokenType("OP_DIV");
  IElementType OP_DOT = new SparqlTokenType("OP_DOT");
  IElementType OP_EQ = new SparqlTokenType("OP_EQ");
  IElementType OP_GE = new SparqlTokenType("OP_GE");
  IElementType OP_GT = new SparqlTokenType("OP_GT");
  IElementType OP_HAT = new SparqlTokenType("OP_HAT");
  IElementType OP_HATHAT = new SparqlTokenType("OP_HATHAT");
  IElementType OP_LCURLY = new SparqlTokenType("OP_LCURLY");
  IElementType OP_LE = new SparqlTokenType("OP_LE");
  IElementType OP_LROUND = new SparqlTokenType("OP_LROUND");
  IElementType OP_LSQUARE = new SparqlTokenType("OP_LSQUARE");
  IElementType OP_LT = new SparqlTokenType("OP_LT");
  IElementType OP_MINUS = new SparqlTokenType("OP_MINUS");
  IElementType OP_MULT = new SparqlTokenType("OP_MULT");
  IElementType OP_NE = new SparqlTokenType("OP_NE");
  IElementType OP_NOT = new SparqlTokenType("OP_NOT");
  IElementType OP_PIPE = new SparqlTokenType("OP_PIPE");
  IElementType OP_PIPEPIPE = new SparqlTokenType("OP_PIPEPIPE");
  IElementType OP_PLUS = new SparqlTokenType("OP_PLUS");
  IElementType OP_QUESTION_MARK = new SparqlTokenType("OP_QUESTION_MARK");
  IElementType OP_RCURLY = new SparqlTokenType("OP_RCURLY");
  IElementType OP_RROUND = new SparqlTokenType("OP_RROUND");
  IElementType OP_RSQUARE = new SparqlTokenType("OP_RSQUARE");
  IElementType OP_SEMI = new SparqlTokenType("OP_SEMI");
  IElementType PNAME_LN = new SparqlTokenType("PNAME_LN");
  IElementType PNAME_NS = new SparqlTokenType("PNAME_NS");
  IElementType STRING_LITERAL1 = new SparqlTokenType("STRING_LITERAL1");
  IElementType STRING_LITERAL2 = new SparqlTokenType("STRING_LITERAL2");
  IElementType STRING_LITERAL_LONG1 = new SparqlTokenType("STRING_LITERAL_LONG1");
  IElementType STRING_LITERAL_LONG2 = new SparqlTokenType("STRING_LITERAL_LONG2");
  IElementType VAR1 = new SparqlTokenType("VAR1");
  IElementType VAR2 = new SparqlTokenType("VAR2");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD) {
        return new SparqlAddImpl(node);
      }
      else if (type == ADDITIVE_EXPRESSION) {
        return new SparqlAdditiveExpressionImpl(node);
      }
      else if (type == AGGREGATE) {
        return new SparqlAggregateImpl(node);
      }
      else if (type == ARG_LIST) {
        return new SparqlArgListImpl(node);
      }
      else if (type == ASK_QUERY) {
        return new SparqlAskQueryImpl(node);
      }
      else if (type == BASE_DECL) {
        return new SparqlBaseDeclImpl(node);
      }
      else if (type == BIND) {
        return new SparqlBindImpl(node);
      }
      else if (type == BLANK_NODE) {
        return new SparqlBlankNodeImpl(node);
      }
      else if (type == BLANK_NODE_PROPERTY_LIST) {
        return new SparqlBlankNodePropertyListImpl(node);
      }
      else if (type == BLANK_NODE_PROPERTY_LIST_PATH) {
        return new SparqlBlankNodePropertyListPathImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new SparqlBooleanLiteralImpl(node);
      }
      else if (type == BRACKETTED_EXPRESSION) {
        return new SparqlBrackettedExpressionImpl(node);
      }
      else if (type == BUILT_IN_CALL) {
        return new SparqlBuiltInCallImpl(node);
      }
      else if (type == CLEAR) {
        return new SparqlClearImpl(node);
      }
      else if (type == COLLECTION) {
        return new SparqlCollectionImpl(node);
      }
      else if (type == COLLECTION_PATH) {
        return new SparqlCollectionPathImpl(node);
      }
      else if (type == CONDITIONAL_AND_EXPRESSION) {
        return new SparqlConditionalAndExpressionImpl(node);
      }
      else if (type == CONDITIONAL_OR_EXPRESSION) {
        return new SparqlConditionalOrExpressionImpl(node);
      }
      else if (type == CONSTRAINT) {
        return new SparqlConstraintImpl(node);
      }
      else if (type == CONSTRUCT_QUERY) {
        return new SparqlConstructQueryImpl(node);
      }
      else if (type == CONSTRUCT_TEMPLATE) {
        return new SparqlConstructTemplateImpl(node);
      }
      else if (type == CONSTRUCT_TRIPLES) {
        return new SparqlConstructTriplesImpl(node);
      }
      else if (type == COPY) {
        return new SparqlCopyImpl(node);
      }
      else if (type == CREATE) {
        return new SparqlCreateImpl(node);
      }
      else if (type == DATASET_CLAUSE) {
        return new SparqlDatasetClauseImpl(node);
      }
      else if (type == DATA_BLOCK) {
        return new SparqlDataBlockImpl(node);
      }
      else if (type == DATA_BLOCK_VALUE) {
        return new SparqlDataBlockValueImpl(node);
      }
      else if (type == DEFAULT_GRAPH_CLAUSE) {
        return new SparqlDefaultGraphClauseImpl(node);
      }
      else if (type == DELETE_CLAUSE) {
        return new SparqlDeleteClauseImpl(node);
      }
      else if (type == DELETE_DATA) {
        return new SparqlDeleteDataImpl(node);
      }
      else if (type == DELETE_WHERE) {
        return new SparqlDeleteWhereImpl(node);
      }
      else if (type == DESCRIBE_QUERY) {
        return new SparqlDescribeQueryImpl(node);
      }
      else if (type == DROP) {
        return new SparqlDropImpl(node);
      }
      else if (type == EXISTS_FUNC) {
        return new SparqlExistsFuncImpl(node);
      }
      else if (type == EXPRESSION) {
        return new SparqlExpressionImpl(node);
      }
      else if (type == EXPRESSION_LIST) {
        return new SparqlExpressionListImpl(node);
      }
      else if (type == FILTER) {
        return new SparqlFilterImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new SparqlFunctionCallImpl(node);
      }
      else if (type == GRAPH_GRAPH_PATTERN) {
        return new SparqlGraphGraphPatternImpl(node);
      }
      else if (type == GRAPH_NODE) {
        return new SparqlGraphNodeImpl(node);
      }
      else if (type == GRAPH_NODE_PATH) {
        return new SparqlGraphNodePathImpl(node);
      }
      else if (type == GRAPH_OR_DEFAULT) {
        return new SparqlGraphOrDefaultImpl(node);
      }
      else if (type == GRAPH_PATTERN_NOT_TRIPLES) {
        return new SparqlGraphPatternNotTriplesImpl(node);
      }
      else if (type == GRAPH_REF) {
        return new SparqlGraphRefImpl(node);
      }
      else if (type == GRAPH_REF_ALL) {
        return new SparqlGraphRefAllImpl(node);
      }
      else if (type == GRAPH_TERM) {
        return new SparqlGraphTermImpl(node);
      }
      else if (type == GROUP_CLAUSE) {
        return new SparqlGroupClauseImpl(node);
      }
      else if (type == GROUP_CONDITION) {
        return new SparqlGroupConditionImpl(node);
      }
      else if (type == GROUP_GRAPH_PATTERN) {
        return new SparqlGroupGraphPatternImpl(node);
      }
      else if (type == GROUP_GRAPH_PATTERN_SUB) {
        return new SparqlGroupGraphPatternSubImpl(node);
      }
      else if (type == GROUP_OR_UNION_GRAPH_PATTERN) {
        return new SparqlGroupOrUnionGraphPatternImpl(node);
      }
      else if (type == HAVING_CLAUSE) {
        return new SparqlHavingClauseImpl(node);
      }
      else if (type == HAVING_CONDITION) {
        return new SparqlHavingConditionImpl(node);
      }
      else if (type == INLINE_DATA) {
        return new SparqlInlineDataImpl(node);
      }
      else if (type == INLINE_DATA_FULL) {
        return new SparqlInlineDataFullImpl(node);
      }
      else if (type == INLINE_DATA_ONE_VAR) {
        return new SparqlInlineDataOneVarImpl(node);
      }
      else if (type == INSERT_CLAUSE) {
        return new SparqlInsertClauseImpl(node);
      }
      else if (type == INSERT_DATA) {
        return new SparqlInsertDataImpl(node);
      }
      else if (type == IRI) {
        return new SparqlIriImpl(node);
      }
      else if (type == IRI_OR_FUNCTION) {
        return new SparqlIriOrFunctionImpl(node);
      }
      else if (type == LIMIT_CLAUSE) {
        return new SparqlLimitClauseImpl(node);
      }
      else if (type == LIMIT_OFFSET_CLAUSES) {
        return new SparqlLimitOffsetClausesImpl(node);
      }
      else if (type == LIT_INTEGER) {
        return new SparqlLitIntegerImpl(node);
      }
      else if (type == LOAD) {
        return new SparqlLoadImpl(node);
      }
      else if (type == MINUS_GRAPH_PATTERN) {
        return new SparqlMinusGraphPatternImpl(node);
      }
      else if (type == MODIFY) {
        return new SparqlModifyImpl(node);
      }
      else if (type == MOVE) {
        return new SparqlMoveImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new SparqlMultiplicativeExpressionImpl(node);
      }
      else if (type == NAMED_GRAPH_CLAUSE) {
        return new SparqlNamedGraphClauseImpl(node);
      }
      else if (type == NOT_EXISTS_FUNC) {
        return new SparqlNotExistsFuncImpl(node);
      }
      else if (type == NUMERIC_EXPRESSION) {
        return new SparqlNumericExpressionImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new SparqlNumericLiteralImpl(node);
      }
      else if (type == NUMERIC_LITERAL_NEGATIVE) {
        return new SparqlNumericLiteralNegativeImpl(node);
      }
      else if (type == NUMERIC_LITERAL_POSITIVE) {
        return new SparqlNumericLiteralPositiveImpl(node);
      }
      else if (type == NUMERIC_LITERAL_UNSIGNED) {
        return new SparqlNumericLiteralUnsignedImpl(node);
      }
      else if (type == OBJECT) {
        return new SparqlObjectImpl(node);
      }
      else if (type == OBJECT_LIST) {
        return new SparqlObjectListImpl(node);
      }
      else if (type == OBJECT_LIST_PATH) {
        return new SparqlObjectListPathImpl(node);
      }
      else if (type == OBJECT_PATH) {
        return new SparqlObjectPathImpl(node);
      }
      else if (type == OFFSET_CLAUSE) {
        return new SparqlOffsetClauseImpl(node);
      }
      else if (type == OPTIONAL_GRAPH_PATTERN) {
        return new SparqlOptionalGraphPatternImpl(node);
      }
      else if (type == ORDER_CLAUSE) {
        return new SparqlOrderClauseImpl(node);
      }
      else if (type == ORDER_CONDITION) {
        return new SparqlOrderConditionImpl(node);
      }
      else if (type == PATH) {
        return new SparqlPathImpl(node);
      }
      else if (type == PATH_ALTERNATIVE) {
        return new SparqlPathAlternativeImpl(node);
      }
      else if (type == PATH_ELT) {
        return new SparqlPathEltImpl(node);
      }
      else if (type == PATH_ELT_OR_INVERSE) {
        return new SparqlPathEltOrInverseImpl(node);
      }
      else if (type == PATH_MOD) {
        return new SparqlPathModImpl(node);
      }
      else if (type == PATH_NEGATED_PROPERTY_SET) {
        return new SparqlPathNegatedPropertySetImpl(node);
      }
      else if (type == PATH_ONE_IN_PROPERTY_SET) {
        return new SparqlPathOneInPropertySetImpl(node);
      }
      else if (type == PATH_PRIMARY) {
        return new SparqlPathPrimaryImpl(node);
      }
      else if (type == PATH_SEQUENCE) {
        return new SparqlPathSequenceImpl(node);
      }
      else if (type == PREFIXED_NAME) {
        return new SparqlPrefixedNameImpl(node);
      }
      else if (type == PREFIX_DECL) {
        return new SparqlPrefixDeclImpl(node);
      }
      else if (type == PRIMARY_EXPRESSION) {
        return new SparqlPrimaryExpressionImpl(node);
      }
      else if (type == PROLOGUE) {
        return new SparqlPrologueImpl(node);
      }
      else if (type == PROPERTY_LIST) {
        return new SparqlPropertyListImpl(node);
      }
      else if (type == PROPERTY_LIST_NOT_EMPTY) {
        return new SparqlPropertyListNotEmptyImpl(node);
      }
      else if (type == PROPERTY_LIST_PATH) {
        return new SparqlPropertyListPathImpl(node);
      }
      else if (type == PROPERTY_LIST_PATH_NOT_EMPTY) {
        return new SparqlPropertyListPathNotEmptyImpl(node);
      }
      else if (type == QUADS) {
        return new SparqlQuadsImpl(node);
      }
      else if (type == QUADS_NOT_TRIPLES) {
        return new SparqlQuadsNotTriplesImpl(node);
      }
      else if (type == QUAD_DATA) {
        return new SparqlQuadDataImpl(node);
      }
      else if (type == QUAD_PATTERN) {
        return new SparqlQuadPatternImpl(node);
      }
      else if (type == QUERY) {
        return new SparqlQueryImpl(node);
      }
      else if (type == QUERY_UNIT) {
        return new SparqlQueryUnitImpl(node);
      }
      else if (type == RDF_LITERAL) {
        return new SparqlRDFLiteralImpl(node);
      }
      else if (type == REGEX_EXPRESSION) {
        return new SparqlRegexExpressionImpl(node);
      }
      else if (type == RELATIONAL_EXPRESSION) {
        return new SparqlRelationalExpressionImpl(node);
      }
      else if (type == SELECT_CLAUSE) {
        return new SparqlSelectClauseImpl(node);
      }
      else if (type == SELECT_QUERY) {
        return new SparqlSelectQueryImpl(node);
      }
      else if (type == SERVICE_GRAPH_PATTERN) {
        return new SparqlServiceGraphPatternImpl(node);
      }
      else if (type == SOLUTION_MODIFIER) {
        return new SparqlSolutionModifierImpl(node);
      }
      else if (type == SOURCE_SELECTOR) {
        return new SparqlSourceSelectorImpl(node);
      }
      else if (type == STRING) {
        return new SparqlStringImpl(node);
      }
      else if (type == STR_REPLACE_EXPRESSION) {
        return new SparqlStrReplaceExpressionImpl(node);
      }
      else if (type == SUBSTRING_EXPRESSION) {
        return new SparqlSubstringExpressionImpl(node);
      }
      else if (type == SUB_SELECT) {
        return new SparqlSubSelectImpl(node);
      }
      else if (type == TRIPLES_BLOCK) {
        return new SparqlTriplesBlockImpl(node);
      }
      else if (type == TRIPLES_NODE) {
        return new SparqlTriplesNodeImpl(node);
      }
      else if (type == TRIPLES_NODE_PATH) {
        return new SparqlTriplesNodePathImpl(node);
      }
      else if (type == TRIPLES_SAME_SUBJECT) {
        return new SparqlTriplesSameSubjectImpl(node);
      }
      else if (type == TRIPLES_SAME_SUBJECT_PATH) {
        return new SparqlTriplesSameSubjectPathImpl(node);
      }
      else if (type == TRIPLES_TEMPLATE) {
        return new SparqlTriplesTemplateImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new SparqlUnaryExpressionImpl(node);
      }
      else if (type == UPDATE) {
        return new SparqlUpdateImpl(node);
      }
      else if (type == UPDATE_1) {
        return new SparqlUpdate1Impl(node);
      }
      else if (type == UPDATE_UNIT) {
        return new SparqlUpdateUnitImpl(node);
      }
      else if (type == USING_CLAUSE) {
        return new SparqlUsingClauseImpl(node);
      }
      else if (type == VALUES_CLAUSE) {
        return new SparqlValuesClauseImpl(node);
      }
      else if (type == VALUE_LOGICAL) {
        return new SparqlValueLogicalImpl(node);
      }
      else if (type == VAR) {
        return new SparqlVarImpl(node);
      }
      else if (type == VAR_OR_IRI) {
        return new SparqlVarOrIriImpl(node);
      }
      else if (type == VAR_OR_TERM) {
        return new SparqlVarOrTermImpl(node);
      }
      else if (type == VERB) {
        return new SparqlVerbImpl(node);
      }
      else if (type == VERB_PATH) {
        return new SparqlVerbPathImpl(node);
      }
      else if (type == VERB_SIMPLE) {
        return new SparqlVerbSimpleImpl(node);
      }
      else if (type == WHERE_CLAUSE) {
        return new SparqlWhereClauseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
