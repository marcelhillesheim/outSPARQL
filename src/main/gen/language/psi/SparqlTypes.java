// This is a generated file. Not intended for manual editing.
package language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import language.psi.impl.*;

public interface SparqlTypes {

  IElementType ADDITIVE_EXPRESSION = new SparqlElementType("ADDITIVE_EXPRESSION");
  IElementType ANON = new SparqlElementType("ANON");
  IElementType ARG_LIST = new SparqlElementType("ARG_LIST");
  IElementType ASK_QUERY = new SparqlElementType("ASK_QUERY");
  IElementType BASE_DECL = new SparqlElementType("BASE_DECL");
  IElementType BLANK_NODE = new SparqlElementType("BLANK_NODE");
  IElementType BLANK_NODE_LABEL = new SparqlElementType("BLANK_NODE_LABEL");
  IElementType BLANK_NODE_PROPERTY_LIST = new SparqlElementType("BLANK_NODE_PROPERTY_LIST");
  IElementType BOOLEAN_LITERAL = new SparqlElementType("BOOLEAN_LITERAL");
  IElementType BRACKETTED_EXPRESSION = new SparqlElementType("BRACKETTED_EXPRESSION");
  IElementType BUILT_IN_CALL = new SparqlElementType("BUILT_IN_CALL");
  IElementType COLLECTION = new SparqlElementType("COLLECTION");
  IElementType CONDITIONAL_AND_EXPRESSION = new SparqlElementType("CONDITIONAL_AND_EXPRESSION");
  IElementType CONDITIONAL_OR_EXPRESSION = new SparqlElementType("CONDITIONAL_OR_EXPRESSION");
  IElementType CONSTRAINT = new SparqlElementType("CONSTRAINT");
  IElementType CONSTRUCT_QUERY = new SparqlElementType("CONSTRUCT_QUERY");
  IElementType CONSTRUCT_TEMPLATE = new SparqlElementType("CONSTRUCT_TEMPLATE");
  IElementType CONSTRUCT_TRIPLES = new SparqlElementType("CONSTRUCT_TRIPLES");
  IElementType DATASET_CLAUSE = new SparqlElementType("DATASET_CLAUSE");
  IElementType DECIMAL_NEGATIVE = new SparqlElementType("DECIMAL_NEGATIVE");
  IElementType DECIMAL_POSITIVE = new SparqlElementType("DECIMAL_POSITIVE");
  IElementType DEFAULT_GRAPH_CLAUSE = new SparqlElementType("DEFAULT_GRAPH_CLAUSE");
  IElementType DESCRIBE_QUERY = new SparqlElementType("DESCRIBE_QUERY");
  IElementType DOUBLE = new SparqlElementType("DOUBLE");
  IElementType DOUBLE_NEGATIVE = new SparqlElementType("DOUBLE_NEGATIVE");
  IElementType DOUBLE_POSITIVE = new SparqlElementType("DOUBLE_POSITIVE");
  IElementType ECHAR = new SparqlElementType("ECHAR");
  IElementType EXPRESSION = new SparqlElementType("EXPRESSION");
  IElementType FILTER = new SparqlElementType("FILTER");
  IElementType FUNCTION_CALL = new SparqlElementType("FUNCTION_CALL");
  IElementType GRAPH_GRAPH_PATTERN = new SparqlElementType("GRAPH_GRAPH_PATTERN");
  IElementType GRAPH_NODE = new SparqlElementType("GRAPH_NODE");
  IElementType GRAPH_PATTERN_NOT_TRIPLES = new SparqlElementType("GRAPH_PATTERN_NOT_TRIPLES");
  IElementType GRAPH_TERM = new SparqlElementType("GRAPH_TERM");
  IElementType GROUP_GRAPH_PATTERN = new SparqlElementType("GROUP_GRAPH_PATTERN");
  IElementType GROUP_OR_UNION_GRAPH_PATTERN = new SparqlElementType("GROUP_OR_UNION_GRAPH_PATTERN");
  IElementType INTEGER_NEGATIVE = new SparqlElementType("INTEGER_NEGATIVE");
  IElementType INTEGER_POSITIVE = new SparqlElementType("INTEGER_POSITIVE");
  IElementType IR_IREF = new SparqlElementType("IR_IREF");
  IElementType IR_IREF_OR_FUNCTION = new SparqlElementType("IR_IREF_OR_FUNCTION");
  IElementType LIMIT_CLAUSE = new SparqlElementType("LIMIT_CLAUSE");
  IElementType LIMIT_OFFSET_CLAUSES = new SparqlElementType("LIMIT_OFFSET_CLAUSES");
  IElementType MULTIPLICATIVE_EXPRESSION = new SparqlElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType NAMED_GRAPH_CLAUSE = new SparqlElementType("NAMED_GRAPH_CLAUSE");
  IElementType NIL = new SparqlElementType("NIL");
  IElementType NUMERIC_EXPRESSION = new SparqlElementType("NUMERIC_EXPRESSION");
  IElementType NUMERIC_LITERAL = new SparqlElementType("NUMERIC_LITERAL");
  IElementType NUMERIC_LITERAL_NEGATIVE = new SparqlElementType("NUMERIC_LITERAL_NEGATIVE");
  IElementType NUMERIC_LITERAL_POSITIVE = new SparqlElementType("NUMERIC_LITERAL_POSITIVE");
  IElementType NUMERIC_LITERAL_UNSIGNED = new SparqlElementType("NUMERIC_LITERAL_UNSIGNED");
  IElementType OBJECT = new SparqlElementType("OBJECT");
  IElementType OBJECT_LIST = new SparqlElementType("OBJECT_LIST");
  IElementType OFFSET_CLAUSE = new SparqlElementType("OFFSET_CLAUSE");
  IElementType OPTIONAL_GRAPH_PATTERN = new SparqlElementType("OPTIONAL_GRAPH_PATTERN");
  IElementType ORDER_CLAUSE = new SparqlElementType("ORDER_CLAUSE");
  IElementType ORDER_CONDITION = new SparqlElementType("ORDER_CONDITION");
  IElementType PNAME_LN = new SparqlElementType("PNAME_LN");
  IElementType PNAME_NS = new SparqlElementType("PNAME_NS");
  IElementType PN_CHARS = new SparqlElementType("PN_CHARS");
  IElementType PN_CHARS_U = new SparqlElementType("PN_CHARS_U");
  IElementType PN_LOCAL = new SparqlElementType("PN_LOCAL");
  IElementType PN_PREFIX = new SparqlElementType("PN_PREFIX");
  IElementType PREFIXED_NAME = new SparqlElementType("PREFIXED_NAME");
  IElementType PREFIX_DECL = new SparqlElementType("PREFIX_DECL");
  IElementType PRIMARY_EXPRESSION = new SparqlElementType("PRIMARY_EXPRESSION");
  IElementType PROLOGUE = new SparqlElementType("PROLOGUE");
  IElementType PROPERTY_LIST = new SparqlElementType("PROPERTY_LIST");
  IElementType PROPERTY_LIST_NOT_EMPTY = new SparqlElementType("PROPERTY_LIST_NOT_EMPTY");
  IElementType RDF_LITERAL = new SparqlElementType("RDF_LITERAL");
  IElementType REGEX_EXPRESSION = new SparqlElementType("REGEX_EXPRESSION");
  IElementType RELATIONAL_EXPRESSION = new SparqlElementType("RELATIONAL_EXPRESSION");
  IElementType SELECT_QUERY = new SparqlElementType("SELECT_QUERY");
  IElementType SOLUTION_MODIFIER = new SparqlElementType("SOLUTION_MODIFIER");
  IElementType SOURCE_SELECTOR = new SparqlElementType("SOURCE_SELECTOR");
  IElementType STRING = new SparqlElementType("STRING");
  IElementType TRIPLES_BLOCK = new SparqlElementType("TRIPLES_BLOCK");
  IElementType TRIPLES_NODE = new SparqlElementType("TRIPLES_NODE");
  IElementType TRIPLES_SAME_SUBJECT = new SparqlElementType("TRIPLES_SAME_SUBJECT");
  IElementType UNARY_EXPRESSION = new SparqlElementType("UNARY_EXPRESSION");
  IElementType VALUE_LOGICAL = new SparqlElementType("VALUE_LOGICAL");
  IElementType VAR = new SparqlElementType("VAR");
  IElementType VARNAME = new SparqlElementType("VARNAME");
  IElementType VAR_1 = new SparqlElementType("VAR_1");
  IElementType VAR_2 = new SparqlElementType("VAR_2");
  IElementType VAR_OR_IR_IREF = new SparqlElementType("VAR_OR_IR_IREF");
  IElementType VAR_OR_TERM = new SparqlElementType("VAR_OR_TERM");
  IElementType VERB = new SparqlElementType("VERB");
  IElementType WHERE_CLAUSE = new SparqlElementType("WHERE_CLAUSE");

  IElementType DECIMAL = new SparqlTokenType("DECIMAL");
  IElementType EXPONENT = new SparqlTokenType("EXPONENT");
  IElementType INTEGER = new SparqlTokenType("INTEGER");
  IElementType IRI_REF = new SparqlTokenType("IRI_REF");
  IElementType LANGTAG = new SparqlTokenType("LANGTAG");
  IElementType PN_CHARS_BASE = new SparqlTokenType("PN_CHARS_BASE");
  IElementType STRING_LITERAL1 = new SparqlTokenType("STRING_LITERAL1");
  IElementType STRING_LITERAL2 = new SparqlTokenType("STRING_LITERAL2");
  IElementType STRING_LITERAL_LONG1 = new SparqlTokenType("STRING_LITERAL_LONG1");
  IElementType STRING_LITERAL_LONG2 = new SparqlTokenType("STRING_LITERAL_LONG2");
  IElementType WS = new SparqlTokenType("WS");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_EXPRESSION) {
        return new SparqlAdditiveExpressionImpl(node);
      }
      else if (type == ANON) {
        return new SparqlAnonImpl(node);
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
      else if (type == BLANK_NODE) {
        return new SparqlBlankNodeImpl(node);
      }
      else if (type == BLANK_NODE_LABEL) {
        return new SparqlBlankNodeLabelImpl(node);
      }
      else if (type == BLANK_NODE_PROPERTY_LIST) {
        return new SparqlBlankNodePropertyListImpl(node);
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
      else if (type == COLLECTION) {
        return new SparqlCollectionImpl(node);
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
      else if (type == DATASET_CLAUSE) {
        return new SparqlDatasetClauseImpl(node);
      }
      else if (type == DECIMAL_NEGATIVE) {
        return new SparqlDecimalNegativeImpl(node);
      }
      else if (type == DECIMAL_POSITIVE) {
        return new SparqlDecimalPositiveImpl(node);
      }
      else if (type == DEFAULT_GRAPH_CLAUSE) {
        return new SparqlDefaultGraphClauseImpl(node);
      }
      else if (type == DESCRIBE_QUERY) {
        return new SparqlDescribeQueryImpl(node);
      }
      else if (type == DOUBLE) {
        return new SparqlDoubleImpl(node);
      }
      else if (type == DOUBLE_NEGATIVE) {
        return new SparqlDoubleNegativeImpl(node);
      }
      else if (type == DOUBLE_POSITIVE) {
        return new SparqlDoublePositiveImpl(node);
      }
      else if (type == ECHAR) {
        return new SparqlEcharImpl(node);
      }
      else if (type == EXPRESSION) {
        return new SparqlExpressionImpl(node);
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
      else if (type == GRAPH_PATTERN_NOT_TRIPLES) {
        return new SparqlGraphPatternNotTriplesImpl(node);
      }
      else if (type == GRAPH_TERM) {
        return new SparqlGraphTermImpl(node);
      }
      else if (type == GROUP_GRAPH_PATTERN) {
        return new SparqlGroupGraphPatternImpl(node);
      }
      else if (type == GROUP_OR_UNION_GRAPH_PATTERN) {
        return new SparqlGroupOrUnionGraphPatternImpl(node);
      }
      else if (type == INTEGER_NEGATIVE) {
        return new SparqlIntegerNegativeImpl(node);
      }
      else if (type == INTEGER_POSITIVE) {
        return new SparqlIntegerPositiveImpl(node);
      }
      else if (type == IR_IREF) {
        return new SparqlIRIrefImpl(node);
      }
      else if (type == IR_IREF_OR_FUNCTION) {
        return new SparqlIRIrefOrFunctionImpl(node);
      }
      else if (type == LIMIT_CLAUSE) {
        return new SparqlLimitClauseImpl(node);
      }
      else if (type == LIMIT_OFFSET_CLAUSES) {
        return new SparqlLimitOffsetClausesImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new SparqlMultiplicativeExpressionImpl(node);
      }
      else if (type == NAMED_GRAPH_CLAUSE) {
        return new SparqlNamedGraphClauseImpl(node);
      }
      else if (type == NIL) {
        return new SparqlNilImpl(node);
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
      else if (type == PNAME_LN) {
        return new SparqlPnameLnImpl(node);
      }
      else if (type == PNAME_NS) {
        return new SparqlPnameNsImpl(node);
      }
      else if (type == PN_CHARS) {
        return new SparqlPnCharsImpl(node);
      }
      else if (type == PN_CHARS_U) {
        return new SparqlPnCharsUImpl(node);
      }
      else if (type == PN_LOCAL) {
        return new SparqlPnLocalImpl(node);
      }
      else if (type == PN_PREFIX) {
        return new SparqlPnPrefixImpl(node);
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
      else if (type == RDF_LITERAL) {
        return new SparqlRDFLiteralImpl(node);
      }
      else if (type == REGEX_EXPRESSION) {
        return new SparqlRegexExpressionImpl(node);
      }
      else if (type == RELATIONAL_EXPRESSION) {
        return new SparqlRelationalExpressionImpl(node);
      }
      else if (type == SELECT_QUERY) {
        return new SparqlSelectQueryImpl(node);
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
      else if (type == TRIPLES_BLOCK) {
        return new SparqlTriplesBlockImpl(node);
      }
      else if (type == TRIPLES_NODE) {
        return new SparqlTriplesNodeImpl(node);
      }
      else if (type == TRIPLES_SAME_SUBJECT) {
        return new SparqlTriplesSameSubjectImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new SparqlUnaryExpressionImpl(node);
      }
      else if (type == VALUE_LOGICAL) {
        return new SparqlValueLogicalImpl(node);
      }
      else if (type == VAR) {
        return new SparqlVarImpl(node);
      }
      else if (type == VARNAME) {
        return new SparqlVarnameImpl(node);
      }
      else if (type == VAR_1) {
        return new SparqlVar1Impl(node);
      }
      else if (type == VAR_2) {
        return new SparqlVar2Impl(node);
      }
      else if (type == VAR_OR_IR_IREF) {
        return new SparqlVarOrIRIrefImpl(node);
      }
      else if (type == VAR_OR_TERM) {
        return new SparqlVarOrTermImpl(node);
      }
      else if (type == VERB) {
        return new SparqlVerbImpl(node);
      }
      else if (type == WHERE_CLAUSE) {
        return new SparqlWhereClauseImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
