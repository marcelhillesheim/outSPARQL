// This is a generated file. Not intended for manual editing.
package language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static language.psi.SparqlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SparqlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Query(b, l + 1);
  }

  /* ********************************************************** */
  // '[' WS* ']'
  public static boolean ANON(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ANON")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ANON, "<anon>");
    r = consumeToken(b, "[");
    r = r && ANON_1(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WS*
  private static boolean ANON_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ANON_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS)) break;
      if (!empty_element_parsed_guard_(b, "ANON_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // MultiplicativeExpression ( '+' MultiplicativeExpression | '-' MultiplicativeExpression | NumericLiteralPositive | NumericLiteralNegative )*
  public static boolean AdditiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = MultiplicativeExpression(b, l + 1);
    r = r && AdditiveExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '+' MultiplicativeExpression | '-' MultiplicativeExpression | NumericLiteralPositive | NumericLiteralNegative )*
  private static boolean AdditiveExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AdditiveExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AdditiveExpression_1", c)) break;
    }
    return true;
  }

  // '+' MultiplicativeExpression | '-' MultiplicativeExpression | NumericLiteralPositive | NumericLiteralNegative
  private static boolean AdditiveExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AdditiveExpression_1_0_0(b, l + 1);
    if (!r) r = AdditiveExpression_1_0_1(b, l + 1);
    if (!r) r = NumericLiteralPositive(b, l + 1);
    if (!r) r = NumericLiteralNegative(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' MultiplicativeExpression
  private static boolean AdditiveExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "+");
    r = r && MultiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-' MultiplicativeExpression
  private static boolean AdditiveExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && MultiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NIL | '(' Expression ( ',' Expression )* ')'
  public static boolean ArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = NIL(b, l + 1);
    if (!r) r = ArgList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' Expression ( ',' Expression )* ')'
  private static boolean ArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && ArgList_1_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ',' Expression )*
  private static boolean ArgList_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgList_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgList_1_2", c)) break;
    }
    return true;
  }

  // ',' Expression
  private static boolean ArgList_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'ASK' DatasetClause* WhereClause
  public static boolean AskQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AskQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASK_QUERY, "<ask query>");
    r = consumeToken(b, "ASK");
    r = r && AskQuery_1(b, l + 1);
    r = r && WhereClause(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DatasetClause*
  private static boolean AskQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AskQuery_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AskQuery_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '_:' PN_LOCAL
  public static boolean BLANK_NODE_LABEL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BLANK_NODE_LABEL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLANK_NODE_LABEL, "<blank node label>");
    r = consumeToken(b, "_:");
    r = r && PN_LOCAL(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'BASE' IRI_REF
  public static boolean BaseDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_DECL, "<base decl>");
    r = consumeToken(b, "BASE");
    r = r && consumeToken(b, IRI_REF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BLANK_NODE_LABEL | ANON
  public static boolean BlankNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlankNode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLANK_NODE, "<blank node>");
    r = BLANK_NODE_LABEL(b, l + 1);
    if (!r) r = ANON(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' PropertyListNotEmpty ']'
  public static boolean BlankNodePropertyList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlankNodePropertyList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLANK_NODE_PROPERTY_LIST, "<blank node property list>");
    r = consumeToken(b, "[");
    r = r && PropertyListNotEmpty(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean BooleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' Expression ')'
  public static boolean BrackettedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BrackettedExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BRACKETTED_EXPRESSION, "<bracketted expression>");
    r = consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'STR' '(' Expression ')'
  // | 'LANG' '(' Expression ')'
  // | 'LANGMATCHES' '(' Expression ',' Expression ')'
  // | 'DATATYPE' '(' Expression ')'
  // | 'BOUND' '(' Var ')'
  // | 'sameTerm' '(' Expression ',' Expression ')'
  // | 'isIRI' '(' Expression ')'
  // | 'isURI' '(' Expression ')'
  // | 'isBLANK' '(' Expression ')'
  // | 'isLITERAL' '(' Expression ')'
  // | RegexExpression
  public static boolean BuiltInCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILT_IN_CALL, "<built in call>");
    r = BuiltInCall_0(b, l + 1);
    if (!r) r = BuiltInCall_1(b, l + 1);
    if (!r) r = BuiltInCall_2(b, l + 1);
    if (!r) r = BuiltInCall_3(b, l + 1);
    if (!r) r = BuiltInCall_4(b, l + 1);
    if (!r) r = BuiltInCall_5(b, l + 1);
    if (!r) r = BuiltInCall_6(b, l + 1);
    if (!r) r = BuiltInCall_7(b, l + 1);
    if (!r) r = BuiltInCall_8(b, l + 1);
    if (!r) r = BuiltInCall_9(b, l + 1);
    if (!r) r = RegexExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'STR' '(' Expression ')'
  private static boolean BuiltInCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "STR");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'LANG' '(' Expression ')'
  private static boolean BuiltInCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "LANG");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'LANGMATCHES' '(' Expression ',' Expression ')'
  private static boolean BuiltInCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "LANGMATCHES");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'DATATYPE' '(' Expression ')'
  private static boolean BuiltInCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "DATATYPE");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'BOUND' '(' Var ')'
  private static boolean BuiltInCall_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "BOUND");
    r = r && consumeToken(b, "(");
    r = r && Var(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'sameTerm' '(' Expression ',' Expression ')'
  private static boolean BuiltInCall_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "sameTerm");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'isIRI' '(' Expression ')'
  private static boolean BuiltInCall_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "isIRI");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'isURI' '(' Expression ')'
  private static boolean BuiltInCall_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "isURI");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'isBLANK' '(' Expression ')'
  private static boolean BuiltInCall_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "isBLANK");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // 'isLITERAL' '(' Expression ')'
  private static boolean BuiltInCall_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "isLITERAL");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' GraphNode+ ')'
  public static boolean Collection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Collection")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COLLECTION, "<collection>");
    r = consumeToken(b, "(");
    r = r && Collection_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // GraphNode+
  private static boolean Collection_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Collection_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GraphNode(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!GraphNode(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Collection_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ValueLogical ( '&&' ValueLogical )*
  public static boolean ConditionalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_AND_EXPRESSION, "<conditional and expression>");
    r = ValueLogical(b, l + 1);
    r = r && ConditionalAndExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '&&' ValueLogical )*
  private static boolean ConditionalAndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConditionalAndExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalAndExpression_1", c)) break;
    }
    return true;
  }

  // '&&' ValueLogical
  private static boolean ConditionalAndExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "&&");
    r = r && ValueLogical(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ConditionalAndExpression ( '||' ConditionalAndExpression )*
  public static boolean ConditionalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_OR_EXPRESSION, "<conditional or expression>");
    r = ConditionalAndExpression(b, l + 1);
    r = r && ConditionalOrExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '||' ConditionalAndExpression )*
  private static boolean ConditionalOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConditionalOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalOrExpression_1", c)) break;
    }
    return true;
  }

  // '||' ConditionalAndExpression
  private static boolean ConditionalOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "||");
    r = r && ConditionalAndExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BrackettedExpression | BuiltInCall | FunctionCall
  public static boolean Constraint(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Constraint")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRAINT, "<constraint>");
    r = BrackettedExpression(b, l + 1);
    if (!r) r = BuiltInCall(b, l + 1);
    if (!r) r = FunctionCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'CONSTRUCT' ConstructTemplate DatasetClause* WhereClause SolutionModifier
  public static boolean ConstructQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCT_QUERY, "<construct query>");
    r = consumeToken(b, "CONSTRUCT");
    r = r && ConstructTemplate(b, l + 1);
    r = r && ConstructQuery_2(b, l + 1);
    r = r && WhereClause(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DatasetClause*
  private static boolean ConstructQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstructQuery_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '{' ConstructTriples? '}'
  public static boolean ConstructTemplate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTemplate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCT_TEMPLATE, "<construct template>");
    r = consumeToken(b, "{");
    r = r && ConstructTemplate_1(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ConstructTriples?
  private static boolean ConstructTemplate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTemplate_1")) return false;
    ConstructTriples(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TriplesSameSubject ( '.' ConstructTriples? )?
  public static boolean ConstructTriples(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCT_TRIPLES, "<construct triples>");
    r = TriplesSameSubject(b, l + 1);
    r = r && ConstructTriples_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '.' ConstructTriples? )?
  private static boolean ConstructTriples_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples_1")) return false;
    ConstructTriples_1_0(b, l + 1);
    return true;
  }

  // '.' ConstructTriples?
  private static boolean ConstructTriples_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && ConstructTriples_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ConstructTriples?
  private static boolean ConstructTriples_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples_1_0_1")) return false;
    ConstructTriples(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '-' DECIMAL
  public static boolean DECIMAL_NEGATIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DECIMAL_NEGATIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECIMAL_NEGATIVE, "<decimal negative>");
    r = consumeToken(b, "-");
    r = r && consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+' DECIMAL
  public static boolean DECIMAL_POSITIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DECIMAL_POSITIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECIMAL_POSITIVE, "<decimal positive>");
    r = consumeToken(b, "+");
    r = r && consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DECIMAL EXPONENT | INTEGER EXPONENT
  public static boolean DOUBLE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE")) return false;
    if (!nextTokenIs(b, "<double>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE, "<double>");
    r = parseTokens(b, 0, DECIMAL, EXPONENT);
    if (!r) r = parseTokens(b, 0, INTEGER, EXPONENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '-' DOUBLE
  public static boolean DOUBLE_NEGATIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_NEGATIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE_NEGATIVE, "<double negative>");
    r = consumeToken(b, "-");
    r = r && DOUBLE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+' DOUBLE
  public static boolean DOUBLE_POSITIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DOUBLE_POSITIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DOUBLE_POSITIVE, "<double positive>");
    r = consumeToken(b, "+");
    r = r && DOUBLE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'FROM' ( DefaultGraphClause | NamedGraphClause )
  public static boolean DatasetClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DatasetClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATASET_CLAUSE, "<dataset clause>");
    r = consumeToken(b, "FROM");
    r = r && DatasetClause_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DefaultGraphClause | NamedGraphClause
  private static boolean DatasetClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DatasetClause_1")) return false;
    boolean r;
    r = DefaultGraphClause(b, l + 1);
    if (!r) r = NamedGraphClause(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // SourceSelector
  public static boolean DefaultGraphClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DefaultGraphClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFAULT_GRAPH_CLAUSE, "<default graph clause>");
    r = SourceSelector(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'DESCRIBE' ( VarOrIRIref+ | '*' ) DatasetClause* WhereClause? SolutionModifier
  public static boolean DescribeQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DESCRIBE_QUERY, "<describe query>");
    r = consumeToken(b, "DESCRIBE");
    r = r && DescribeQuery_1(b, l + 1);
    r = r && DescribeQuery_2(b, l + 1);
    r = r && DescribeQuery_3(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarOrIRIref+ | '*'
  private static boolean DescribeQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DescribeQuery_1_0(b, l + 1);
    if (!r) r = consumeToken(b, "*");
    exit_section_(b, m, null, r);
    return r;
  }

  // VarOrIRIref+
  private static boolean DescribeQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarOrIRIref(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!VarOrIRIref(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DescribeQuery_1_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DatasetClause*
  private static boolean DescribeQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "DescribeQuery_2", c)) break;
    }
    return true;
  }

  // WhereClause?
  private static boolean DescribeQuery_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_3")) return false;
    WhereClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '\' "regexp:[tbnrf\"']"
  public static boolean ECHAR(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ECHAR")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ECHAR, "<echar>");
    r = consumeToken(b, "\\");
    r = r && consumeToken(b, "regexp:[tbnrf\"']");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ConditionalOrExpression
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = ConditionalOrExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'FILTER' Constraint
  public static boolean Filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER, "<filter>");
    r = consumeToken(b, "FILTER");
    r = r && Constraint(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IRIref ArgList
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = IRIref(b, l + 1);
    r = r && ArgList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'GRAPH' VarOrIRIref GroupGraphPattern
  public static boolean GraphGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphGraphPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_GRAPH_PATTERN, "<graph graph pattern>");
    r = consumeToken(b, "GRAPH");
    r = r && VarOrIRIref(b, l + 1);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VarOrTerm | TriplesNode
  public static boolean GraphNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphNode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_NODE, "<graph node>");
    r = VarOrTerm(b, l + 1);
    if (!r) r = TriplesNode(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OptionalGraphPattern | GroupOrUnionGraphPattern | GraphGraphPattern
  public static boolean GraphPatternNotTriples(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphPatternNotTriples")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_PATTERN_NOT_TRIPLES, "<graph pattern not triples>");
    r = OptionalGraphPattern(b, l + 1);
    if (!r) r = GroupOrUnionGraphPattern(b, l + 1);
    if (!r) r = GraphGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IRIref | RDFLiteral | NumericLiteral | BooleanLiteral | BlankNode | NIL
  public static boolean GraphTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_TERM, "<graph term>");
    r = IRIref(b, l + 1);
    if (!r) r = RDFLiteral(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = BooleanLiteral(b, l + 1);
    if (!r) r = BlankNode(b, l + 1);
    if (!r) r = NIL(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' TriplesBlock? ( ( GraphPatternNotTriples | Filter ) '.'? TriplesBlock? )* '}'
  public static boolean GroupGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP_GRAPH_PATTERN, "<group graph pattern>");
    r = consumeToken(b, "{");
    r = r && GroupGraphPattern_1(b, l + 1);
    r = r && GroupGraphPattern_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TriplesBlock?
  private static boolean GroupGraphPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_1")) return false;
    TriplesBlock(b, l + 1);
    return true;
  }

  // ( ( GraphPatternNotTriples | Filter ) '.'? TriplesBlock? )*
  private static boolean GroupGraphPattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GroupGraphPattern_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupGraphPattern_2", c)) break;
    }
    return true;
  }

  // ( GraphPatternNotTriples | Filter ) '.'? TriplesBlock?
  private static boolean GroupGraphPattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupGraphPattern_2_0_0(b, l + 1);
    r = r && GroupGraphPattern_2_0_1(b, l + 1);
    r = r && GroupGraphPattern_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // GraphPatternNotTriples | Filter
  private static boolean GroupGraphPattern_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_2_0_0")) return false;
    boolean r;
    r = GraphPatternNotTriples(b, l + 1);
    if (!r) r = Filter(b, l + 1);
    return r;
  }

  // '.'?
  private static boolean GroupGraphPattern_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_2_0_1")) return false;
    consumeToken(b, ".");
    return true;
  }

  // TriplesBlock?
  private static boolean GroupGraphPattern_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_2_0_2")) return false;
    TriplesBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GroupGraphPattern ( 'UNION' GroupGraphPattern )*
  public static boolean GroupOrUnionGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP_OR_UNION_GRAPH_PATTERN, "<group or union graph pattern>");
    r = GroupGraphPattern(b, l + 1);
    r = r && GroupOrUnionGraphPattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( 'UNION' GroupGraphPattern )*
  private static boolean GroupOrUnionGraphPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GroupOrUnionGraphPattern_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupOrUnionGraphPattern_1", c)) break;
    }
    return true;
  }

  // 'UNION' GroupGraphPattern
  private static boolean GroupOrUnionGraphPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "UNION");
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' INTEGER
  public static boolean INTEGER_NEGATIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER_NEGATIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_NEGATIVE, "<integer negative>");
    r = consumeToken(b, "-");
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '+' INTEGER
  public static boolean INTEGER_POSITIVE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "INTEGER_POSITIVE")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_POSITIVE, "<integer positive>");
    r = consumeToken(b, "+");
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IRI_REF | PrefixedName
  public static boolean IRIref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IRIref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IR_IREF, "<ir iref>");
    r = consumeToken(b, IRI_REF);
    if (!r) r = PrefixedName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IRIref ArgList?
  public static boolean IRIrefOrFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IRIrefOrFunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IR_IREF_OR_FUNCTION, "<ir iref or function>");
    r = IRIref(b, l + 1);
    r = r && IRIrefOrFunction_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ArgList?
  private static boolean IRIrefOrFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IRIrefOrFunction_1")) return false;
    ArgList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // 'LIMIT' INTEGER
  public static boolean LimitClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIMIT_CLAUSE, "<limit clause>");
    r = consumeToken(b, "LIMIT");
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LimitClause OffsetClause? | OffsetClause LimitClause?
  public static boolean LimitOffsetClauses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIMIT_OFFSET_CLAUSES, "<limit offset clauses>");
    r = LimitOffsetClauses_0(b, l + 1);
    if (!r) r = LimitOffsetClauses_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LimitClause OffsetClause?
  private static boolean LimitOffsetClauses_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = LimitClause(b, l + 1);
    r = r && LimitOffsetClauses_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OffsetClause?
  private static boolean LimitOffsetClauses_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses_0_1")) return false;
    OffsetClause(b, l + 1);
    return true;
  }

  // OffsetClause LimitClause?
  private static boolean LimitOffsetClauses_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = OffsetClause(b, l + 1);
    r = r && LimitOffsetClauses_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LimitClause?
  private static boolean LimitOffsetClauses_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses_1_1")) return false;
    LimitClause(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // UnaryExpression ( '*' UnaryExpression | '/' UnaryExpression )*
  public static boolean MultiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = UnaryExpression(b, l + 1);
    r = r && MultiplicativeExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '*' UnaryExpression | '/' UnaryExpression )*
  private static boolean MultiplicativeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MultiplicativeExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MultiplicativeExpression_1", c)) break;
    }
    return true;
  }

  // '*' UnaryExpression | '/' UnaryExpression
  private static boolean MultiplicativeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MultiplicativeExpression_1_0_0(b, l + 1);
    if (!r) r = MultiplicativeExpression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '*' UnaryExpression
  private static boolean MultiplicativeExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "*");
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '/' UnaryExpression
  private static boolean MultiplicativeExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' WS* ')'
  public static boolean NIL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NIL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NIL, "<nil>");
    r = consumeToken(b, "(");
    r = r && NIL_1(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // WS*
  private static boolean NIL_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NIL_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, WS)) break;
      if (!empty_element_parsed_guard_(b, "NIL_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'NAMED' SourceSelector
  public static boolean NamedGraphClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedGraphClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMED_GRAPH_CLAUSE, "<named graph clause>");
    r = consumeToken(b, "NAMED");
    r = r && SourceSelector(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AdditiveExpression
  public static boolean NumericExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_EXPRESSION, "<numeric expression>");
    r = AdditiveExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NumericLiteralUnsigned | NumericLiteralPositive | NumericLiteralNegative
  public static boolean NumericLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL, "<numeric literal>");
    r = NumericLiteralUnsigned(b, l + 1);
    if (!r) r = NumericLiteralPositive(b, l + 1);
    if (!r) r = NumericLiteralNegative(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_NEGATIVE | DECIMAL_NEGATIVE | DOUBLE_NEGATIVE
  public static boolean NumericLiteralNegative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteralNegative")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL_NEGATIVE, "<numeric literal negative>");
    r = INTEGER_NEGATIVE(b, l + 1);
    if (!r) r = DECIMAL_NEGATIVE(b, l + 1);
    if (!r) r = DOUBLE_NEGATIVE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_POSITIVE | DECIMAL_POSITIVE | DOUBLE_POSITIVE
  public static boolean NumericLiteralPositive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteralPositive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL_POSITIVE, "<numeric literal positive>");
    r = INTEGER_POSITIVE(b, l + 1);
    if (!r) r = DECIMAL_POSITIVE(b, l + 1);
    if (!r) r = DOUBLE_POSITIVE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTEGER | DECIMAL | DOUBLE
  public static boolean NumericLiteralUnsigned(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteralUnsigned")) return false;
    if (!nextTokenIs(b, "<numeric literal unsigned>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL_UNSIGNED, "<numeric literal unsigned>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = DOUBLE(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // GraphNode
  public static boolean Object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT, "<object>");
    r = GraphNode(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Object ( ',' Object )*
  public static boolean ObjectList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_LIST, "<object list>");
    r = Object(b, l + 1);
    r = r && ObjectList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( ',' Object )*
  private static boolean ObjectList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ObjectList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ObjectList_1", c)) break;
    }
    return true;
  }

  // ',' Object
  private static boolean ObjectList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && Object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'OFFSET' INTEGER
  public static boolean OffsetClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OffsetClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OFFSET_CLAUSE, "<offset clause>");
    r = consumeToken(b, "OFFSET");
    r = r && consumeToken(b, INTEGER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'OPTIONAL' GroupGraphPattern
  public static boolean OptionalGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalGraphPattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL_GRAPH_PATTERN, "<optional graph pattern>");
    r = consumeToken(b, "OPTIONAL");
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'ORDER' 'BY' OrderCondition+
  public static boolean OrderClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDER_CLAUSE, "<order clause>");
    r = consumeToken(b, "ORDER");
    r = r && consumeToken(b, "BY");
    r = r && OrderClause_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OrderCondition+
  private static boolean OrderClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderClause_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = OrderCondition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!OrderCondition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "OrderClause_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( ( 'ASC' | 'DESC' ) BrackettedExpression )
  // | ( Constraint | Var )
  public static boolean OrderCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDER_CONDITION, "<order condition>");
    r = OrderCondition_0(b, l + 1);
    if (!r) r = OrderCondition_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( 'ASC' | 'DESC' ) BrackettedExpression
  private static boolean OrderCondition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = OrderCondition_0_0(b, l + 1);
    r = r && BrackettedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'ASC' | 'DESC'
  private static boolean OrderCondition_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition_0_0")) return false;
    boolean r;
    r = consumeToken(b, "ASC");
    if (!r) r = consumeToken(b, "DESC");
    return r;
  }

  // Constraint | Var
  private static boolean OrderCondition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition_1")) return false;
    boolean r;
    r = Constraint(b, l + 1);
    if (!r) r = Var(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PNAME_NS PN_LOCAL
  public static boolean PNAME_LN(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PNAME_LN")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PNAME_LN, "<pname ln>");
    r = PNAME_NS(b, l + 1);
    r = r && PN_LOCAL(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PN_PREFIX? ':'
  public static boolean PNAME_NS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PNAME_NS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PNAME_NS, "<pname ns>");
    r = PNAME_NS_0(b, l + 1);
    r = r && consumeToken(b, ":");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PN_PREFIX?
  private static boolean PNAME_NS_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PNAME_NS_0")) return false;
    PN_PREFIX(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PN_CHARS_U | '-' | 'regexp:[0-9]|\u00B7|[\u0300-\u036F]|[\u203F-\u2040]'
  public static boolean PN_CHARS(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_CHARS")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PN_CHARS, "<pn chars>");
    r = PN_CHARS_U(b, l + 1);
    if (!r) r = consumeToken(b, "-");
    if (!r) r = consumeToken(b, "regexp:[0-9]|\\u00B7|[\\u0300-\\u036F]|[\\u203F-\\u2040]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PN_CHARS_BASE | '_'
  public static boolean PN_CHARS_U(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_CHARS_U")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PN_CHARS_U, "<pn chars u>");
    r = consumeToken(b, PN_CHARS_BASE);
    if (!r) r = consumeToken(b, "_");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( PN_CHARS_U | 'regexp:[0-9]' ) ((PN_CHARS|'.')* PN_CHARS)?
  public static boolean PN_LOCAL(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PN_LOCAL, "<pn local>");
    r = PN_LOCAL_0(b, l + 1);
    r = r && PN_LOCAL_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PN_CHARS_U | 'regexp:[0-9]'
  private static boolean PN_LOCAL_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL_0")) return false;
    boolean r;
    r = PN_CHARS_U(b, l + 1);
    if (!r) r = consumeToken(b, "regexp:[0-9]");
    return r;
  }

  // ((PN_CHARS|'.')* PN_CHARS)?
  private static boolean PN_LOCAL_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL_1")) return false;
    PN_LOCAL_1_0(b, l + 1);
    return true;
  }

  // (PN_CHARS|'.')* PN_CHARS
  private static boolean PN_LOCAL_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PN_LOCAL_1_0_0(b, l + 1);
    r = r && PN_CHARS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_CHARS|'.')*
  private static boolean PN_LOCAL_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PN_LOCAL_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PN_LOCAL_1_0_0", c)) break;
    }
    return true;
  }

  // PN_CHARS|'.'
  private static boolean PN_LOCAL_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_LOCAL_1_0_0_0")) return false;
    boolean r;
    r = PN_CHARS(b, l + 1);
    if (!r) r = consumeToken(b, ".");
    return r;
  }

  /* ********************************************************** */
  // PN_CHARS_BASE ((PN_CHARS|'.')* PN_CHARS)?
  public static boolean PN_PREFIX(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_PREFIX")) return false;
    if (!nextTokenIs(b, PN_CHARS_BASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PN_CHARS_BASE);
    r = r && PN_PREFIX_1(b, l + 1);
    exit_section_(b, m, PN_PREFIX, r);
    return r;
  }

  // ((PN_CHARS|'.')* PN_CHARS)?
  private static boolean PN_PREFIX_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_PREFIX_1")) return false;
    PN_PREFIX_1_0(b, l + 1);
    return true;
  }

  // (PN_CHARS|'.')* PN_CHARS
  private static boolean PN_PREFIX_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_PREFIX_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PN_PREFIX_1_0_0(b, l + 1);
    r = r && PN_CHARS(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (PN_CHARS|'.')*
  private static boolean PN_PREFIX_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_PREFIX_1_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PN_PREFIX_1_0_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PN_PREFIX_1_0_0", c)) break;
    }
    return true;
  }

  // PN_CHARS|'.'
  private static boolean PN_PREFIX_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PN_PREFIX_1_0_0_0")) return false;
    boolean r;
    r = PN_CHARS(b, l + 1);
    if (!r) r = consumeToken(b, ".");
    return r;
  }

  /* ********************************************************** */
  // 'PREFIX' PNAME_NS IRI_REF
  public static boolean PrefixDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixDecl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_DECL, "<prefix decl>");
    r = consumeToken(b, "PREFIX");
    r = r && PNAME_NS(b, l + 1);
    r = r && consumeToken(b, IRI_REF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PNAME_LN | PNAME_NS
  public static boolean PrefixedName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixedName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIXED_NAME, "<prefixed name>");
    r = PNAME_LN(b, l + 1);
    if (!r) r = PNAME_NS(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BrackettedExpression | BuiltInCall | IRIrefOrFunction | RDFLiteral | NumericLiteral | BooleanLiteral | Var
  public static boolean PrimaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = BrackettedExpression(b, l + 1);
    if (!r) r = BuiltInCall(b, l + 1);
    if (!r) r = IRIrefOrFunction(b, l + 1);
    if (!r) r = RDFLiteral(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = BooleanLiteral(b, l + 1);
    if (!r) r = Var(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BaseDecl? PrefixDecl*
  public static boolean Prologue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prologue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROLOGUE, "<prologue>");
    r = Prologue_0(b, l + 1);
    r = r && Prologue_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BaseDecl?
  private static boolean Prologue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prologue_0")) return false;
    BaseDecl(b, l + 1);
    return true;
  }

  // PrefixDecl*
  private static boolean Prologue_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prologue_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PrefixDecl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Prologue_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PropertyListNotEmpty?
  public static boolean PropertyList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyList")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_LIST, "<property list>");
    PropertyListNotEmpty(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // Verb ObjectList ( ';' ( Verb ObjectList )? )*
  public static boolean PropertyListNotEmpty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_LIST_NOT_EMPTY, "<property list not empty>");
    r = Verb(b, l + 1);
    r = r && ObjectList(b, l + 1);
    r = r && PropertyListNotEmpty_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( ';' ( Verb ObjectList )? )*
  private static boolean PropertyListNotEmpty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PropertyListNotEmpty_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PropertyListNotEmpty_2", c)) break;
    }
    return true;
  }

  // ';' ( Verb ObjectList )?
  private static boolean PropertyListNotEmpty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ";");
    r = r && PropertyListNotEmpty_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( Verb ObjectList )?
  private static boolean PropertyListNotEmpty_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2_0_1")) return false;
    PropertyListNotEmpty_2_0_1_0(b, l + 1);
    return true;
  }

  // Verb ObjectList
  private static boolean PropertyListNotEmpty_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Verb(b, l + 1);
    r = r && ObjectList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Prologue ( SelectQuery | ConstructQuery | DescribeQuery | AskQuery | DOUBLE)
  static boolean Query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Prologue(b, l + 1);
    r = r && Query_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // SelectQuery | ConstructQuery | DescribeQuery | AskQuery | DOUBLE
  private static boolean Query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Query_1")) return false;
    boolean r;
    r = SelectQuery(b, l + 1);
    if (!r) r = ConstructQuery(b, l + 1);
    if (!r) r = DescribeQuery(b, l + 1);
    if (!r) r = AskQuery(b, l + 1);
    if (!r) r = DOUBLE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // String ( LANGTAG | ( '^^' IRIref ) )?
  public static boolean RDFLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RDF_LITERAL, "<rdf literal>");
    r = String(b, l + 1);
    r = r && RDFLiteral_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( LANGTAG | ( '^^' IRIref ) )?
  private static boolean RDFLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1")) return false;
    RDFLiteral_1_0(b, l + 1);
    return true;
  }

  // LANGTAG | ( '^^' IRIref )
  private static boolean RDFLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANGTAG);
    if (!r) r = RDFLiteral_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '^^' IRIref
  private static boolean RDFLiteral_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "^^");
    r = r && IRIref(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'REGEX' '(' Expression ',' Expression ( ',' Expression )? ')'
  public static boolean RegexExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGEX_EXPRESSION, "<regex expression>");
    r = consumeToken(b, "REGEX");
    r = r && consumeToken(b, "(");
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    r = r && RegexExpression_5(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( ',' Expression )?
  private static boolean RegexExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression_5")) return false;
    RegexExpression_5_0(b, l + 1);
    return true;
  }

  // ',' Expression
  private static boolean RegexExpression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NumericExpression ( '=' NumericExpression | '!=' NumericExpression | '<' NumericExpression | '>' NumericExpression | '<=' NumericExpression | '>=' NumericExpression )?
  public static boolean RelationalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_EXPRESSION, "<relational expression>");
    r = NumericExpression(b, l + 1);
    r = r && RelationalExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '=' NumericExpression | '!=' NumericExpression | '<' NumericExpression | '>' NumericExpression | '<=' NumericExpression | '>=' NumericExpression )?
  private static boolean RelationalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1")) return false;
    RelationalExpression_1_0(b, l + 1);
    return true;
  }

  // '=' NumericExpression | '!=' NumericExpression | '<' NumericExpression | '>' NumericExpression | '<=' NumericExpression | '>=' NumericExpression
  private static boolean RelationalExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = RelationalExpression_1_0_0(b, l + 1);
    if (!r) r = RelationalExpression_1_0_1(b, l + 1);
    if (!r) r = RelationalExpression_1_0_2(b, l + 1);
    if (!r) r = RelationalExpression_1_0_3(b, l + 1);
    if (!r) r = RelationalExpression_1_0_4(b, l + 1);
    if (!r) r = RelationalExpression_1_0_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '=' NumericExpression
  private static boolean RelationalExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "=");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '!=' NumericExpression
  private static boolean RelationalExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!=");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<' NumericExpression
  private static boolean RelationalExpression_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>' NumericExpression
  private static boolean RelationalExpression_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ">");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '<=' NumericExpression
  private static boolean RelationalExpression_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<=");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '>=' NumericExpression
  private static boolean RelationalExpression_1_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ">=");
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'SELECT' ( 'DISTINCT' | 'REDUCED' )? ( Var+ | '*' ) DatasetClause* WhereClause SolutionModifier
  public static boolean SelectQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SELECT_QUERY, "<select query>");
    r = consumeToken(b, "SELECT");
    r = r && SelectQuery_1(b, l + 1);
    r = r && SelectQuery_2(b, l + 1);
    r = r && SelectQuery_3(b, l + 1);
    r = r && WhereClause(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( 'DISTINCT' | 'REDUCED' )?
  private static boolean SelectQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_1")) return false;
    SelectQuery_1_0(b, l + 1);
    return true;
  }

  // 'DISTINCT' | 'REDUCED'
  private static boolean SelectQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_1_0")) return false;
    boolean r;
    r = consumeToken(b, "DISTINCT");
    if (!r) r = consumeToken(b, "REDUCED");
    return r;
  }

  // Var+ | '*'
  private static boolean SelectQuery_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SelectQuery_2_0(b, l + 1);
    if (!r) r = consumeToken(b, "*");
    exit_section_(b, m, null, r);
    return r;
  }

  // Var+
  private static boolean SelectQuery_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!Var(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SelectQuery_2_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DatasetClause*
  private static boolean SelectQuery_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SelectQuery_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // OrderClause? LimitOffsetClauses?
  public static boolean SolutionModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SOLUTION_MODIFIER, "<solution modifier>");
    r = SolutionModifier_0(b, l + 1);
    r = r && SolutionModifier_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OrderClause?
  private static boolean SolutionModifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_0")) return false;
    OrderClause(b, l + 1);
    return true;
  }

  // LimitOffsetClauses?
  private static boolean SolutionModifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_1")) return false;
    LimitOffsetClauses(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IRIref
  public static boolean SourceSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SourceSelector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SOURCE_SELECTOR, "<source selector>");
    r = IRIref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL1 | STRING_LITERAL2 | STRING_LITERAL_LONG1 | STRING_LITERAL_LONG2
  public static boolean String(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "String")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING, "<string>");
    r = consumeToken(b, STRING_LITERAL1);
    if (!r) r = consumeToken(b, STRING_LITERAL2);
    if (!r) r = consumeToken(b, STRING_LITERAL_LONG1);
    if (!r) r = consumeToken(b, STRING_LITERAL_LONG2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // TriplesSameSubject ( '.' TriplesBlock? )?
  public static boolean TriplesBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_BLOCK, "<triples block>");
    r = TriplesSameSubject(b, l + 1);
    r = r && TriplesBlock_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( '.' TriplesBlock? )?
  private static boolean TriplesBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock_1")) return false;
    TriplesBlock_1_0(b, l + 1);
    return true;
  }

  // '.' TriplesBlock?
  private static boolean TriplesBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ".");
    r = r && TriplesBlock_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TriplesBlock?
  private static boolean TriplesBlock_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock_1_0_1")) return false;
    TriplesBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Collection | BlankNodePropertyList
  public static boolean TriplesNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesNode")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_NODE, "<triples node>");
    r = Collection(b, l + 1);
    if (!r) r = BlankNodePropertyList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VarOrTerm PropertyListNotEmpty | TriplesNode PropertyList
  public static boolean TriplesSameSubject(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubject")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_SAME_SUBJECT, "<triples same subject>");
    r = TriplesSameSubject_0(b, l + 1);
    if (!r) r = TriplesSameSubject_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarOrTerm PropertyListNotEmpty
  private static boolean TriplesSameSubject_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubject_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarOrTerm(b, l + 1);
    r = r && PropertyListNotEmpty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TriplesNode PropertyList
  private static boolean TriplesSameSubject_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubject_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TriplesNode(b, l + 1);
    r = r && PropertyList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '!' PrimaryExpression
  // | '+' PrimaryExpression
  // | '-' PrimaryExpression
  // | PrimaryExpression
  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = UnaryExpression_0(b, l + 1);
    if (!r) r = UnaryExpression_1(b, l + 1);
    if (!r) r = UnaryExpression_2(b, l + 1);
    if (!r) r = PrimaryExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '!' PrimaryExpression
  private static boolean UnaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "!");
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' PrimaryExpression
  private static boolean UnaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "+");
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-' PrimaryExpression
  private static boolean UnaryExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "-");
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '?' VARNAME
  public static boolean VAR1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VAR1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_1, "<var 1>");
    r = consumeToken(b, "?");
    r = r && VARNAME(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '$' VARNAME
  public static boolean VAR2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VAR2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_2, "<var 2>");
    r = consumeToken(b, "$");
    r = r && VARNAME(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( PN_CHARS_U | 'regexp:[0-9]' ) ( PN_CHARS_U | 'regexp:\u00B7|[0-9]|[\u0300-\u036F]|[\u203F-\u2040]' )*
  public static boolean VARNAME(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARNAME")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARNAME, "<varname>");
    r = VARNAME_0(b, l + 1);
    r = r && VARNAME_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PN_CHARS_U | 'regexp:[0-9]'
  private static boolean VARNAME_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARNAME_0")) return false;
    boolean r;
    r = PN_CHARS_U(b, l + 1);
    if (!r) r = consumeToken(b, "regexp:[0-9]");
    return r;
  }

  // ( PN_CHARS_U | 'regexp:\u00B7|[0-9]|[\u0300-\u036F]|[\u203F-\u2040]' )*
  private static boolean VARNAME_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARNAME_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!VARNAME_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "VARNAME_1", c)) break;
    }
    return true;
  }

  // PN_CHARS_U | 'regexp:\u00B7|[0-9]|[\u0300-\u036F]|[\u203F-\u2040]'
  private static boolean VARNAME_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VARNAME_1_0")) return false;
    boolean r;
    r = PN_CHARS_U(b, l + 1);
    if (!r) r = consumeToken(b, "regexp:\\u00B7|[0-9]|[\\u0300-\\u036F]|[\\u203F-\\u2040]");
    return r;
  }

  /* ********************************************************** */
  // RelationalExpression
  public static boolean ValueLogical(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValueLogical")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_LOGICAL, "<value logical>");
    r = RelationalExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR1 | VAR2
  public static boolean Var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR, "<var>");
    r = VAR1(b, l + 1);
    if (!r) r = VAR2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var | IRIref
  public static boolean VarOrIRIref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarOrIRIref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_OR_IR_IREF, "<var or ir iref>");
    r = Var(b, l + 1);
    if (!r) r = IRIref(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var | GraphTerm
  public static boolean VarOrTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarOrTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_OR_TERM, "<var or term>");
    r = Var(b, l + 1);
    if (!r) r = GraphTerm(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VarOrIRIref | 'a'
  public static boolean Verb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Verb")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERB, "<verb>");
    r = VarOrIRIref(b, l + 1);
    if (!r) r = consumeToken(b, "a");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'WHERE'? GroupGraphPattern
  public static boolean WhereClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhereClause")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHERE_CLAUSE, "<where clause>");
    r = WhereClause_0(b, l + 1);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'WHERE'?
  private static boolean WhereClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhereClause_0")) return false;
    consumeToken(b, "WHERE");
    return true;
  }

}
