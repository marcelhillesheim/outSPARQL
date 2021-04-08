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
    return Root(b, l + 1);
  }

  /* ********************************************************** */
  // KW_ADD KW_SILENT? GraphOrDefault KW_TO GraphOrDefault
  public static boolean Add(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Add")) return false;
    if (!nextTokenIs(b, KW_ADD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ADD, null);
    r = consumeToken(b, KW_ADD);
    p = r; // pin = 1
    r = r && report_error_(b, Add_1(b, l + 1));
    r = p && report_error_(b, GraphOrDefault(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, KW_TO)) && r;
    r = p && GraphOrDefault(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Add_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Add_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // MultiplicativeExpression ( OP_PLUS MultiplicativeExpression | OP_MINUS MultiplicativeExpression | ( NumericLiteralPositive | NumericLiteralNegative ) ( ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression ) )* )*
  public static boolean AdditiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = MultiplicativeExpression(b, l + 1);
    r = r && AdditiveExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_PLUS MultiplicativeExpression | OP_MINUS MultiplicativeExpression | ( NumericLiteralPositive | NumericLiteralNegative ) ( ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression ) )* )*
  private static boolean AdditiveExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AdditiveExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AdditiveExpression_1", c)) break;
    }
    return true;
  }

  // OP_PLUS MultiplicativeExpression | OP_MINUS MultiplicativeExpression | ( NumericLiteralPositive | NumericLiteralNegative ) ( ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression ) )*
  private static boolean AdditiveExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AdditiveExpression_1_0_0(b, l + 1);
    if (!r) r = AdditiveExpression_1_0_1(b, l + 1);
    if (!r) r = AdditiveExpression_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_PLUS MultiplicativeExpression
  private static boolean AdditiveExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PLUS);
    r = r && MultiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MINUS MultiplicativeExpression
  private static boolean AdditiveExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MINUS);
    r = r && MultiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( NumericLiteralPositive | NumericLiteralNegative ) ( ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression ) )*
  private static boolean AdditiveExpression_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AdditiveExpression_1_0_2_0(b, l + 1);
    r = r && AdditiveExpression_1_0_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // NumericLiteralPositive | NumericLiteralNegative
  private static boolean AdditiveExpression_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2_0")) return false;
    boolean r;
    r = NumericLiteralPositive(b, l + 1);
    if (!r) r = NumericLiteralNegative(b, l + 1);
    return r;
  }

  // ( ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression ) )*
  private static boolean AdditiveExpression_1_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!AdditiveExpression_1_0_2_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "AdditiveExpression_1_0_2_1", c)) break;
    }
    return true;
  }

  // ( OP_MULT UnaryExpression ) | ( OP_DIV UnaryExpression )
  private static boolean AdditiveExpression_1_0_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AdditiveExpression_1_0_2_1_0_0(b, l + 1);
    if (!r) r = AdditiveExpression_1_0_2_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT UnaryExpression
  private static boolean AdditiveExpression_1_0_2_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MULT);
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_DIV UnaryExpression
  private static boolean AdditiveExpression_1_0_2_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AdditiveExpression_1_0_2_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DIV);
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_COUNT OP_LROUND KW_DISTINCT? ( OP_MULT | Expression ) OP_RROUND
  // | KW_SUM OP_LROUND KW_DISTINCT? Expression OP_RROUND
  // | KW_MIN OP_LROUND KW_DISTINCT? Expression OP_RROUND
  // | KW_MAX OP_LROUND KW_DISTINCT? Expression OP_RROUND
  // | KW_AVG OP_LROUND KW_DISTINCT? Expression OP_RROUND
  // | KW_SAMPLE OP_LROUND KW_DISTINCT? Expression OP_RROUND
  // | KW_GROUP_CONCAT OP_LROUND KW_DISTINCT? Expression ( OP_SEMI KW_SEPARATOR OP_EQ String )? OP_RROUND
  public static boolean Aggregate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AGGREGATE, "<aggregate>");
    r = Aggregate_0(b, l + 1);
    if (!r) r = Aggregate_1(b, l + 1);
    if (!r) r = Aggregate_2(b, l + 1);
    if (!r) r = Aggregate_3(b, l + 1);
    if (!r) r = Aggregate_4(b, l + 1);
    if (!r) r = Aggregate_5(b, l + 1);
    if (!r) r = Aggregate_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_COUNT OP_LROUND KW_DISTINCT? ( OP_MULT | Expression ) OP_RROUND
  private static boolean Aggregate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_COUNT, OP_LROUND);
    r = r && Aggregate_0_2(b, l + 1);
    r = r && Aggregate_0_3(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_0_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // OP_MULT | Expression
  private static boolean Aggregate_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_0_3")) return false;
    boolean r;
    r = consumeToken(b, OP_MULT);
    if (!r) r = Expression(b, l + 1);
    return r;
  }

  // KW_SUM OP_LROUND KW_DISTINCT? Expression OP_RROUND
  private static boolean Aggregate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SUM, OP_LROUND);
    r = r && Aggregate_1_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_1_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // KW_MIN OP_LROUND KW_DISTINCT? Expression OP_RROUND
  private static boolean Aggregate_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_MIN, OP_LROUND);
    r = r && Aggregate_2_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_2_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // KW_MAX OP_LROUND KW_DISTINCT? Expression OP_RROUND
  private static boolean Aggregate_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_MAX, OP_LROUND);
    r = r && Aggregate_3_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_3_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_3_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // KW_AVG OP_LROUND KW_DISTINCT? Expression OP_RROUND
  private static boolean Aggregate_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_AVG, OP_LROUND);
    r = r && Aggregate_4_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_4_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_4_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // KW_SAMPLE OP_LROUND KW_DISTINCT? Expression OP_RROUND
  private static boolean Aggregate_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SAMPLE, OP_LROUND);
    r = r && Aggregate_5_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_5_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_5_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // KW_GROUP_CONCAT OP_LROUND KW_DISTINCT? Expression ( OP_SEMI KW_SEPARATOR OP_EQ String )? OP_RROUND
  private static boolean Aggregate_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_GROUP_CONCAT, OP_LROUND);
    r = r && Aggregate_6_2(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && Aggregate_6_4(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean Aggregate_6_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_6_2")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // ( OP_SEMI KW_SEPARATOR OP_EQ String )?
  private static boolean Aggregate_6_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_6_4")) return false;
    Aggregate_6_4_0(b, l + 1);
    return true;
  }

  // OP_SEMI KW_SEPARATOR OP_EQ String
  private static boolean Aggregate_6_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Aggregate_6_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, OP_SEMI, KW_SEPARATOR, OP_EQ);
    r = r && String(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NIL | OP_LROUND KW_DISTINCT? Expression ( OP_COMMA Expression )* OP_RROUND
  public static boolean ArgList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList")) return false;
    if (!nextTokenIs(b, "<arg list>", NIL, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LIST, "<arg list>");
    r = consumeToken(b, NIL);
    if (!r) r = ArgList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_LROUND KW_DISTINCT? Expression ( OP_COMMA Expression )* OP_RROUND
  private static boolean ArgList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && ArgList_1_1(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && ArgList_1_3(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DISTINCT?
  private static boolean ArgList_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1_1")) return false;
    consumeToken(b, KW_DISTINCT);
    return true;
  }

  // ( OP_COMMA Expression )*
  private static boolean ArgList_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgList_1_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgList_1_3", c)) break;
    }
    return true;
  }

  // OP_COMMA Expression
  private static boolean ArgList_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgList_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_ASK DatasetClause* WhereClause SolutionModifier
  public static boolean AskQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AskQuery")) return false;
    if (!nextTokenIs(b, KW_ASK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASK_QUERY, null);
    r = consumeToken(b, KW_ASK);
    p = r; // pin = 1
    r = r && report_error_(b, AskQuery_1(b, l + 1));
    r = p && report_error_(b, WhereClause(b, l + 1)) && r;
    r = p && SolutionModifier(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // KW_BASE IRIREF
  public static boolean BaseDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BaseDecl")) return false;
    if (!nextTokenIs(b, KW_BASE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BASE_DECL, null);
    r = consumeTokens(b, 1, KW_BASE, IRIREF);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_BIND OP_LROUND Expression KW_AS Var OP_RROUND
  public static boolean Bind(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Bind")) return false;
    if (!nextTokenIs(b, KW_BIND)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BIND, null);
    r = consumeTokens(b, 1, KW_BIND, OP_LROUND);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, KW_AS)) && r;
    r = p && report_error_(b, Var(b, l + 1)) && r;
    r = p && consumeToken(b, OP_RROUND) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // BLANK_NODE_LABEL | ANON
  public static boolean BlankNode(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlankNode")) return false;
    if (!nextTokenIs(b, "<blank node>", ANON, BLANK_NODE_LABEL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BLANK_NODE, "<blank node>");
    r = consumeToken(b, BLANK_NODE_LABEL);
    if (!r) r = consumeToken(b, ANON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_LSQUARE PropertyListNotEmpty OP_RSQUARE
  public static boolean BlankNodePropertyList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlankNodePropertyList")) return false;
    if (!nextTokenIs(b, OP_LSQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LSQUARE);
    r = r && PropertyListNotEmpty(b, l + 1);
    r = r && consumeToken(b, OP_RSQUARE);
    exit_section_(b, m, BLANK_NODE_PROPERTY_LIST, r);
    return r;
  }

  /* ********************************************************** */
  // OP_LSQUARE PropertyListPathNotEmpty OP_RSQUARE
  public static boolean BlankNodePropertyListPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BlankNodePropertyListPath")) return false;
    if (!nextTokenIs(b, OP_LSQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LSQUARE);
    r = r && PropertyListPathNotEmpty(b, l + 1);
    r = r && consumeToken(b, OP_RSQUARE);
    exit_section_(b, m, BLANK_NODE_PROPERTY_LIST_PATH, r);
    return r;
  }

  /* ********************************************************** */
  // LIT_TRUE | LIT_FALSE
  public static boolean BooleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BooleanLiteral")) return false;
    if (!nextTokenIs(b, "<boolean literal>", LIT_FALSE, LIT_TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, LIT_TRUE);
    if (!r) r = consumeToken(b, LIT_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OP_LROUND Expression OP_RROUND
  public static boolean BrackettedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BrackettedExpression")) return false;
    if (!nextTokenIs(b, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, BRACKETTED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // Aggregate
  // | KW_STR OP_LROUND Expression OP_RROUND
  // | KW_LANG OP_LROUND Expression OP_RROUND
  // | KW_LANGMATCHES OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_DATATYPE OP_LROUND Expression OP_RROUND
  // | KW_BOUND OP_LROUND Var OP_RROUND
  // | KW_IRI OP_LROUND Expression OP_RROUND
  // | KW_URI OP_LROUND Expression OP_RROUND
  // | KW_BNODE ( OP_LROUND Expression OP_RROUND | NIL )
  // | KW_RAND NIL
  // | KW_ABS OP_LROUND Expression OP_RROUND
  // | KW_CEIL OP_LROUND Expression OP_RROUND
  // | KW_FLOOR OP_LROUND Expression OP_RROUND
  // | KW_ROUND OP_LROUND Expression OP_RROUND
  // | KW_CONCAT ExpressionList
  // | SubstringExpression
  // | KW_STRLEN OP_LROUND Expression OP_RROUND
  // | StrReplaceExpression
  // | KW_UCASE OP_LROUND Expression OP_RROUND
  // | KW_LCASE OP_LROUND Expression OP_RROUND
  // | KW_ENCODE_FOR_URI OP_LROUND Expression OP_RROUND
  // | KW_CONTAINS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_STRSTARTS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_STRENDS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_STRBEFORE OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_STRAFTER OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_YEAR OP_LROUND Expression OP_RROUND
  // | KW_MONTH OP_LROUND Expression OP_RROUND
  // | KW_DAY OP_LROUND Expression OP_RROUND
  // | KW_HOURS OP_LROUND Expression OP_RROUND
  // | KW_MINUTES OP_LROUND Expression OP_RROUND
  // | KW_SECONDS OP_LROUND Expression OP_RROUND
  // | KW_TIMEZONE OP_LROUND Expression OP_RROUND
  // | KW_TZ OP_LROUND Expression OP_RROUND
  // | KW_NOW NIL
  // | KW_UUID NIL
  // | KW_STRUUID NIL
  // | KW_MD5 OP_LROUND Expression OP_RROUND
  // | KW_SHA1 OP_LROUND Expression OP_RROUND
  // | KW_SHA256 OP_LROUND Expression OP_RROUND
  // | KW_SHA384 OP_LROUND Expression OP_RROUND
  // | KW_SHA512 OP_LROUND Expression OP_RROUND
  // | KW_COALESCE ExpressionList
  // | KW_IF OP_LROUND Expression OP_COMMA Expression OP_COMMA Expression OP_RROUND
  // | KW_STRLANG OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_STRDT OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_SAME_TERM OP_LROUND Expression OP_COMMA Expression OP_RROUND
  // | KW_IS_IRI OP_LROUND Expression OP_RROUND
  // | KW_IS_URI OP_LROUND Expression OP_RROUND
  // | KW_IS_BLANK OP_LROUND Expression OP_RROUND
  // | KW_IS_LITERAL OP_LROUND Expression OP_RROUND
  // | KW_IS_NUMERIC OP_LROUND Expression OP_RROUND
  // | RegexExpression
  // | ExistsFunc
  // | NotExistsFunc
  public static boolean BuiltInCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILT_IN_CALL, "<built in call>");
    r = Aggregate(b, l + 1);
    if (!r) r = BuiltInCall_1(b, l + 1);
    if (!r) r = BuiltInCall_2(b, l + 1);
    if (!r) r = BuiltInCall_3(b, l + 1);
    if (!r) r = BuiltInCall_4(b, l + 1);
    if (!r) r = BuiltInCall_5(b, l + 1);
    if (!r) r = BuiltInCall_6(b, l + 1);
    if (!r) r = BuiltInCall_7(b, l + 1);
    if (!r) r = BuiltInCall_8(b, l + 1);
    if (!r) r = parseTokens(b, 0, KW_RAND, NIL);
    if (!r) r = BuiltInCall_10(b, l + 1);
    if (!r) r = BuiltInCall_11(b, l + 1);
    if (!r) r = BuiltInCall_12(b, l + 1);
    if (!r) r = BuiltInCall_13(b, l + 1);
    if (!r) r = BuiltInCall_14(b, l + 1);
    if (!r) r = SubstringExpression(b, l + 1);
    if (!r) r = BuiltInCall_16(b, l + 1);
    if (!r) r = StrReplaceExpression(b, l + 1);
    if (!r) r = BuiltInCall_18(b, l + 1);
    if (!r) r = BuiltInCall_19(b, l + 1);
    if (!r) r = BuiltInCall_20(b, l + 1);
    if (!r) r = BuiltInCall_21(b, l + 1);
    if (!r) r = BuiltInCall_22(b, l + 1);
    if (!r) r = BuiltInCall_23(b, l + 1);
    if (!r) r = BuiltInCall_24(b, l + 1);
    if (!r) r = BuiltInCall_25(b, l + 1);
    if (!r) r = BuiltInCall_26(b, l + 1);
    if (!r) r = BuiltInCall_27(b, l + 1);
    if (!r) r = BuiltInCall_28(b, l + 1);
    if (!r) r = BuiltInCall_29(b, l + 1);
    if (!r) r = BuiltInCall_30(b, l + 1);
    if (!r) r = BuiltInCall_31(b, l + 1);
    if (!r) r = BuiltInCall_32(b, l + 1);
    if (!r) r = BuiltInCall_33(b, l + 1);
    if (!r) r = parseTokens(b, 0, KW_NOW, NIL);
    if (!r) r = parseTokens(b, 0, KW_UUID, NIL);
    if (!r) r = parseTokens(b, 0, KW_STRUUID, NIL);
    if (!r) r = BuiltInCall_37(b, l + 1);
    if (!r) r = BuiltInCall_38(b, l + 1);
    if (!r) r = BuiltInCall_39(b, l + 1);
    if (!r) r = BuiltInCall_40(b, l + 1);
    if (!r) r = BuiltInCall_41(b, l + 1);
    if (!r) r = BuiltInCall_42(b, l + 1);
    if (!r) r = BuiltInCall_43(b, l + 1);
    if (!r) r = BuiltInCall_44(b, l + 1);
    if (!r) r = BuiltInCall_45(b, l + 1);
    if (!r) r = BuiltInCall_46(b, l + 1);
    if (!r) r = BuiltInCall_47(b, l + 1);
    if (!r) r = BuiltInCall_48(b, l + 1);
    if (!r) r = BuiltInCall_49(b, l + 1);
    if (!r) r = BuiltInCall_50(b, l + 1);
    if (!r) r = BuiltInCall_51(b, l + 1);
    if (!r) r = RegexExpression(b, l + 1);
    if (!r) r = ExistsFunc(b, l + 1);
    if (!r) r = NotExistsFunc(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_STR OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STR, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_LANG OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_LANG, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_LANGMATCHES OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_LANGMATCHES, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DATATYPE OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_DATATYPE, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_BOUND OP_LROUND Var OP_RROUND
  private static boolean BuiltInCall_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_BOUND, OP_LROUND);
    r = r && Var(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IRI OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IRI, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_URI OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_URI, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_BNODE ( OP_LROUND Expression OP_RROUND | NIL )
  private static boolean BuiltInCall_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_BNODE);
    r = r && BuiltInCall_8_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND Expression OP_RROUND | NIL
  private static boolean BuiltInCall_8_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_8_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BuiltInCall_8_1_0(b, l + 1);
    if (!r) r = consumeToken(b, NIL);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_8_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_8_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_ABS OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ABS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_CEIL OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CEIL, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_FLOOR OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_FLOOR, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_ROUND OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_13(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_13")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ROUND, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_CONCAT ExpressionList
  private static boolean BuiltInCall_14(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_14")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_CONCAT);
    r = r && ExpressionList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRLEN OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_16(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_16")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRLEN, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_UCASE OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_18(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_18")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_UCASE, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_LCASE OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_19(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_19")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_LCASE, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_ENCODE_FOR_URI OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_20(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_20")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_ENCODE_FOR_URI, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_CONTAINS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_21(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_21")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_CONTAINS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRSTARTS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_22(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_22")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRSTARTS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRENDS OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_23(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_23")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRENDS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRBEFORE OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_24(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_24")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRBEFORE, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRAFTER OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_25(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_25")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRAFTER, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_YEAR OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_26(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_26")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_YEAR, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_MONTH OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_27(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_27")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_MONTH, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_DAY OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_28(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_28")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_DAY, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_HOURS OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_29(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_29")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_HOURS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_MINUTES OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_30(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_30")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_MINUTES, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SECONDS OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_31(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_31")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SECONDS, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_TIMEZONE OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_32(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_32")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_TIMEZONE, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_TZ OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_33(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_33")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_TZ, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_MD5 OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_37(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_37")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_MD5, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SHA1 OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_38(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_38")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SHA1, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SHA256 OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_39(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_39")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SHA256, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SHA384 OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_40(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_40")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SHA384, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SHA512 OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_41(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_41")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SHA512, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_COALESCE ExpressionList
  private static boolean BuiltInCall_42(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_42")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_COALESCE);
    r = r && ExpressionList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IF OP_LROUND Expression OP_COMMA Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_43(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_43")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IF, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRLANG OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_44(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_44")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRLANG, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_STRDT OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_45(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_45")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_STRDT, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_SAME_TERM OP_LROUND Expression OP_COMMA Expression OP_RROUND
  private static boolean BuiltInCall_46(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_46")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_SAME_TERM, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IS_IRI OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_47(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_47")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS_IRI, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IS_URI OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_48(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_48")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS_URI, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IS_BLANK OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_49(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_49")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS_BLANK, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IS_LITERAL OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_50(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_50")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS_LITERAL, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IS_NUMERIC OP_LROUND Expression OP_RROUND
  private static boolean BuiltInCall_51(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInCall_51")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_IS_NUMERIC, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_CLEAR KW_SILENT? GraphRefAll
  public static boolean Clear(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Clear")) return false;
    if (!nextTokenIs(b, KW_CLEAR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CLEAR, null);
    r = consumeToken(b, KW_CLEAR);
    p = r; // pin = 1
    r = r && report_error_(b, Clear_1(b, l + 1));
    r = p && GraphRefAll(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Clear_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Clear_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // OP_LROUND GraphNode+ OP_RROUND
  public static boolean Collection(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Collection")) return false;
    if (!nextTokenIs(b, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Collection_1(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, COLLECTION, r);
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
  // OP_LROUND GraphNodePath+ OP_RROUND
  public static boolean CollectionPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CollectionPath")) return false;
    if (!nextTokenIs(b, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && CollectionPath_1(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, COLLECTION_PATH, r);
    return r;
  }

  // GraphNodePath+
  private static boolean CollectionPath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CollectionPath_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GraphNodePath(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!GraphNodePath(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CollectionPath_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ValueLogical ( OP_ANDAND ValueLogical )*
  public static boolean ConditionalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_AND_EXPRESSION, "<conditional and expression>");
    r = ValueLogical(b, l + 1);
    r = r && ConditionalAndExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_ANDAND ValueLogical )*
  private static boolean ConditionalAndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConditionalAndExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalAndExpression_1", c)) break;
    }
    return true;
  }

  // OP_ANDAND ValueLogical
  private static boolean ConditionalAndExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalAndExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_ANDAND);
    r = r && ValueLogical(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ConditionalAndExpression ( OP_PIPEPIPE ConditionalAndExpression )*
  public static boolean ConditionalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_OR_EXPRESSION, "<conditional or expression>");
    r = ConditionalAndExpression(b, l + 1);
    r = r && ConditionalOrExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_PIPEPIPE ConditionalAndExpression )*
  private static boolean ConditionalOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ConditionalOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConditionalOrExpression_1", c)) break;
    }
    return true;
  }

  // OP_PIPEPIPE ConditionalAndExpression
  private static boolean ConditionalOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConditionalOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PIPEPIPE);
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
  // KW_CONSTRUCT ( ConstructTemplate DatasetClause* WhereClause SolutionModifier | DatasetClause* KW_WHERE OP_LCURLY TriplesTemplate? OP_RCURLY SolutionModifier )
  public static boolean ConstructQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery")) return false;
    if (!nextTokenIs(b, KW_CONSTRUCT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCT_QUERY, null);
    r = consumeToken(b, KW_CONSTRUCT);
    p = r; // pin = 1
    r = r && ConstructQuery_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ConstructTemplate DatasetClause* WhereClause SolutionModifier | DatasetClause* KW_WHERE OP_LCURLY TriplesTemplate? OP_RCURLY SolutionModifier
  private static boolean ConstructQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstructQuery_1_0(b, l + 1);
    if (!r) r = ConstructQuery_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ConstructTemplate DatasetClause* WhereClause SolutionModifier
  private static boolean ConstructQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstructTemplate(b, l + 1);
    r = r && ConstructQuery_1_0_1(b, l + 1);
    r = r && WhereClause(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DatasetClause*
  private static boolean ConstructQuery_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstructQuery_1_0_1", c)) break;
    }
    return true;
  }

  // DatasetClause* KW_WHERE OP_LCURLY TriplesTemplate? OP_RCURLY SolutionModifier
  private static boolean ConstructQuery_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ConstructQuery_1_1_0(b, l + 1);
    r = r && consumeTokens(b, 0, KW_WHERE, OP_LCURLY);
    r = r && ConstructQuery_1_1_3(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DatasetClause*
  private static boolean ConstructQuery_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ConstructQuery_1_1_0", c)) break;
    }
    return true;
  }

  // TriplesTemplate?
  private static boolean ConstructQuery_1_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructQuery_1_1_3")) return false;
    TriplesTemplate(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OP_LCURLY ConstructTriples? OP_RCURLY
  public static boolean ConstructTemplate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTemplate")) return false;
    if (!nextTokenIs(b, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LCURLY);
    r = r && ConstructTemplate_1(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, m, CONSTRUCT_TEMPLATE, r);
    return r;
  }

  // ConstructTriples?
  private static boolean ConstructTemplate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTemplate_1")) return false;
    ConstructTriples(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TriplesSameSubject ( OP_DOT ConstructTriples? )?
  public static boolean ConstructTriples(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTRUCT_TRIPLES, "<construct triples>");
    r = TriplesSameSubject(b, l + 1);
    r = r && ConstructTriples_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_DOT ConstructTriples? )?
  private static boolean ConstructTriples_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples_1")) return false;
    ConstructTriples_1_0(b, l + 1);
    return true;
  }

  // OP_DOT ConstructTriples?
  private static boolean ConstructTriples_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ConstructTriples_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DOT);
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
  // KW_COPY KW_SILENT? GraphOrDefault KW_TO GraphOrDefault
  public static boolean Copy(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Copy")) return false;
    if (!nextTokenIs(b, KW_COPY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COPY, null);
    r = consumeToken(b, KW_COPY);
    p = r; // pin = 1
    r = r && report_error_(b, Copy_1(b, l + 1));
    r = p && report_error_(b, GraphOrDefault(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, KW_TO)) && r;
    r = p && GraphOrDefault(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Copy_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Copy_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // KW_CREATE KW_SILENT? GraphRef
  public static boolean Create(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Create")) return false;
    if (!nextTokenIs(b, KW_CREATE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CREATE, null);
    r = consumeToken(b, KW_CREATE);
    p = r; // pin = 1
    r = r && report_error_(b, Create_1(b, l + 1));
    r = p && GraphRef(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Create_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Create_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // InlineDataOneVar | InlineDataFull
  public static boolean DataBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_BLOCK, "<data block>");
    r = InlineDataOneVar(b, l + 1);
    if (!r) r = InlineDataFull(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // iri | RDFLiteral | NumericLiteral | BooleanLiteral | KW_UNDEF
  public static boolean DataBlockValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DataBlockValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_BLOCK_VALUE, "<data block value>");
    r = iri(b, l + 1);
    if (!r) r = RDFLiteral(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = BooleanLiteral(b, l + 1);
    if (!r) r = consumeToken(b, KW_UNDEF);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_FROM ( DefaultGraphClause | NamedGraphClause )
  public static boolean DatasetClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DatasetClause")) return false;
    if (!nextTokenIs(b, KW_FROM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_FROM);
    r = r && DatasetClause_1(b, l + 1);
    exit_section_(b, m, DATASET_CLAUSE, r);
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
  // KW_DELETE QuadPattern
  public static boolean DeleteClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteClause")) return false;
    if (!nextTokenIs(b, KW_DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_DELETE);
    r = r && QuadPattern(b, l + 1);
    exit_section_(b, m, DELETE_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DELETE KW_DATA QuadData
  public static boolean DeleteData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteData")) return false;
    if (!nextTokenIs(b, KW_DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_DELETE, KW_DATA);
    r = r && QuadData(b, l + 1);
    exit_section_(b, m, DELETE_DATA, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DELETE KW_WHERE QuadPattern
  public static boolean DeleteWhere(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeleteWhere")) return false;
    if (!nextTokenIs(b, KW_DELETE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_DELETE, KW_WHERE);
    r = r && QuadPattern(b, l + 1);
    exit_section_(b, m, DELETE_WHERE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_DESCRIBE ( VarOrIri+ | OP_MULT ) DatasetClause* WhereClause? SolutionModifier
  public static boolean DescribeQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery")) return false;
    if (!nextTokenIs(b, KW_DESCRIBE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DESCRIBE_QUERY, null);
    r = consumeToken(b, KW_DESCRIBE);
    p = r; // pin = 1
    r = r && report_error_(b, DescribeQuery_1(b, l + 1));
    r = p && report_error_(b, DescribeQuery_2(b, l + 1)) && r;
    r = p && report_error_(b, DescribeQuery_3(b, l + 1)) && r;
    r = p && SolutionModifier(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // VarOrIri+ | OP_MULT
  private static boolean DescribeQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DescribeQuery_1_0(b, l + 1);
    if (!r) r = consumeToken(b, OP_MULT);
    exit_section_(b, m, null, r);
    return r;
  }

  // VarOrIri+
  private static boolean DescribeQuery_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DescribeQuery_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarOrIri(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!VarOrIri(b, l + 1)) break;
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
  // KW_DROP KW_SILENT? GraphRefAll
  public static boolean Drop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Drop")) return false;
    if (!nextTokenIs(b, KW_DROP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DROP, null);
    r = consumeToken(b, KW_DROP);
    p = r; // pin = 1
    r = r && report_error_(b, Drop_1(b, l + 1));
    r = p && GraphRefAll(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Drop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Drop_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // KW_EXISTS GroupGraphPattern
  public static boolean ExistsFunc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExistsFunc")) return false;
    if (!nextTokenIs(b, KW_EXISTS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_EXISTS);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, m, EXISTS_FUNC, r);
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
  // NIL | OP_LROUND Expression ( OP_COMMA Expression )* OP_RROUND
  public static boolean ExpressionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList")) return false;
    if (!nextTokenIs(b, "<expression list>", NIL, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_LIST, "<expression list>");
    r = consumeToken(b, NIL);
    if (!r) r = ExpressionList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_LROUND Expression ( OP_COMMA Expression )* OP_RROUND
  private static boolean ExpressionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && ExpressionList_1_2(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( OP_COMMA Expression )*
  private static boolean ExpressionList_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ExpressionList_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ExpressionList_1_2", c)) break;
    }
    return true;
  }

  // OP_COMMA Expression
  private static boolean ExpressionList_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionList_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_FILTER Constraint
  public static boolean Filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Filter")) return false;
    if (!nextTokenIs(b, KW_FILTER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FILTER, null);
    r = consumeToken(b, KW_FILTER);
    p = r; // pin = 1
    r = r && Constraint(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // iri ArgList
  public static boolean FunctionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = iri(b, l + 1);
    r = r && ArgList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_GRAPH VarOrIri GroupGraphPattern
  public static boolean GraphGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphGraphPattern")) return false;
    if (!nextTokenIs(b, KW_GRAPH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_GRAPH);
    r = r && VarOrIri(b, l + 1);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, m, GRAPH_GRAPH_PATTERN, r);
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
  // VarOrTerm | TriplesNodePath
  public static boolean GraphNodePath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphNodePath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_NODE_PATH, "<graph node path>");
    r = VarOrTerm(b, l + 1);
    if (!r) r = TriplesNodePath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_DEFAULT | KW_GRAPH? iri
  public static boolean GraphOrDefault(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphOrDefault")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_OR_DEFAULT, "<graph or default>");
    r = consumeToken(b, KW_DEFAULT);
    if (!r) r = GraphOrDefault_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_GRAPH? iri
  private static boolean GraphOrDefault_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphOrDefault_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GraphOrDefault_1_0(b, l + 1);
    r = r && iri(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_GRAPH?
  private static boolean GraphOrDefault_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphOrDefault_1_0")) return false;
    consumeToken(b, KW_GRAPH);
    return true;
  }

  /* ********************************************************** */
  // GroupOrUnionGraphPattern | OptionalGraphPattern | MinusGraphPattern | GraphGraphPattern | ServiceGraphPattern | Filter | Bind | InlineData
  public static boolean GraphPatternNotTriples(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphPatternNotTriples")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_PATTERN_NOT_TRIPLES, "<graph pattern not triples>");
    r = GroupOrUnionGraphPattern(b, l + 1);
    if (!r) r = OptionalGraphPattern(b, l + 1);
    if (!r) r = MinusGraphPattern(b, l + 1);
    if (!r) r = GraphGraphPattern(b, l + 1);
    if (!r) r = ServiceGraphPattern(b, l + 1);
    if (!r) r = Filter(b, l + 1);
    if (!r) r = Bind(b, l + 1);
    if (!r) r = InlineData(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_GRAPH iri
  public static boolean GraphRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphRef")) return false;
    if (!nextTokenIs(b, KW_GRAPH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_GRAPH);
    r = r && iri(b, l + 1);
    exit_section_(b, m, GRAPH_REF, r);
    return r;
  }

  /* ********************************************************** */
  // GraphRef | KW_DEFAULT | KW_NAMED | KW_ALL
  public static boolean GraphRefAll(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphRefAll")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_REF_ALL, "<graph ref all>");
    r = GraphRef(b, l + 1);
    if (!r) r = consumeToken(b, KW_DEFAULT);
    if (!r) r = consumeToken(b, KW_NAMED);
    if (!r) r = consumeToken(b, KW_ALL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // iri | RDFLiteral | NumericLiteral | BooleanLiteral | BlankNode | NIL
  public static boolean GraphTerm(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GraphTerm")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GRAPH_TERM, "<graph term>");
    r = iri(b, l + 1);
    if (!r) r = RDFLiteral(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = BooleanLiteral(b, l + 1);
    if (!r) r = BlankNode(b, l + 1);
    if (!r) r = consumeToken(b, NIL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_GROUP KW_BY GroupCondition+
  public static boolean GroupClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupClause")) return false;
    if (!nextTokenIs(b, KW_GROUP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, GROUP_CLAUSE, null);
    r = consumeTokens(b, 1, KW_GROUP, KW_BY);
    p = r; // pin = 1
    r = r && GroupClause_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // GroupCondition+
  private static boolean GroupClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupClause_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupCondition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!GroupCondition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupClause_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BuiltInCall | FunctionCall | OP_LROUND Expression ( KW_AS Var )? OP_RROUND | Var
  public static boolean GroupCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupCondition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP_CONDITION, "<group condition>");
    r = BuiltInCall(b, l + 1);
    if (!r) r = FunctionCall(b, l + 1);
    if (!r) r = GroupCondition_2(b, l + 1);
    if (!r) r = Var(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_LROUND Expression ( KW_AS Var )? OP_RROUND
  private static boolean GroupCondition_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupCondition_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && GroupCondition_2_2(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( KW_AS Var )?
  private static boolean GroupCondition_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupCondition_2_2")) return false;
    GroupCondition_2_2_0(b, l + 1);
    return true;
  }

  // KW_AS Var
  private static boolean GroupCondition_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupCondition_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_AS);
    r = r && Var(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_LCURLY ( SubSelect | GroupGraphPatternSub ) OP_RCURLY
  public static boolean GroupGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern")) return false;
    if (!nextTokenIs(b, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LCURLY);
    r = r && GroupGraphPattern_1(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, m, GROUP_GRAPH_PATTERN, r);
    return r;
  }

  // SubSelect | GroupGraphPatternSub
  private static boolean GroupGraphPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPattern_1")) return false;
    boolean r;
    r = SubSelect(b, l + 1);
    if (!r) r = GroupGraphPatternSub(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // TriplesBlock? ( GraphPatternNotTriples OP_DOT? TriplesBlock? )*
  public static boolean GroupGraphPatternSub(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUP_GRAPH_PATTERN_SUB, "<group graph pattern sub>");
    r = GroupGraphPatternSub_0(b, l + 1);
    r = r && GroupGraphPatternSub_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TriplesBlock?
  private static boolean GroupGraphPatternSub_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub_0")) return false;
    TriplesBlock(b, l + 1);
    return true;
  }

  // ( GraphPatternNotTriples OP_DOT? TriplesBlock? )*
  private static boolean GroupGraphPatternSub_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GroupGraphPatternSub_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupGraphPatternSub_1", c)) break;
    }
    return true;
  }

  // GraphPatternNotTriples OP_DOT? TriplesBlock?
  private static boolean GroupGraphPatternSub_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GraphPatternNotTriples(b, l + 1);
    r = r && GroupGraphPatternSub_1_0_1(b, l + 1);
    r = r && GroupGraphPatternSub_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_DOT?
  private static boolean GroupGraphPatternSub_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub_1_0_1")) return false;
    consumeToken(b, OP_DOT);
    return true;
  }

  // TriplesBlock?
  private static boolean GroupGraphPatternSub_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupGraphPatternSub_1_0_2")) return false;
    TriplesBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // GroupGraphPattern ( KW_UNION GroupGraphPattern )*
  public static boolean GroupOrUnionGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern")) return false;
    if (!nextTokenIs(b, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GroupGraphPattern(b, l + 1);
    r = r && GroupOrUnionGraphPattern_1(b, l + 1);
    exit_section_(b, m, GROUP_OR_UNION_GRAPH_PATTERN, r);
    return r;
  }

  // ( KW_UNION GroupGraphPattern )*
  private static boolean GroupOrUnionGraphPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!GroupOrUnionGraphPattern_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "GroupOrUnionGraphPattern_1", c)) break;
    }
    return true;
  }

  // KW_UNION GroupGraphPattern
  private static boolean GroupOrUnionGraphPattern_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "GroupOrUnionGraphPattern_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_UNION);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_HAVING HavingCondition+
  public static boolean HavingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HavingClause")) return false;
    if (!nextTokenIs(b, KW_HAVING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, HAVING_CLAUSE, null);
    r = consumeToken(b, KW_HAVING);
    p = r; // pin = 1
    r = r && HavingClause_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // HavingCondition+
  private static boolean HavingClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HavingClause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = HavingCondition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!HavingCondition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "HavingClause_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Constraint
  public static boolean HavingCondition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "HavingCondition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HAVING_CONDITION, "<having condition>");
    r = Constraint(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_VALUES DataBlock
  public static boolean InlineData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineData")) return false;
    if (!nextTokenIs(b, KW_VALUES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_VALUES);
    r = r && DataBlock(b, l + 1);
    exit_section_(b, m, INLINE_DATA, r);
    return r;
  }

  /* ********************************************************** */
  // ( NIL | OP_LROUND Var* OP_RROUND ) OP_LCURLY ( OP_LROUND DataBlockValue* OP_RROUND | NIL )* OP_RCURLY
  public static boolean InlineDataFull(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull")) return false;
    if (!nextTokenIs(b, "<inline data full>", NIL, OP_LROUND)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_DATA_FULL, "<inline data full>");
    r = InlineDataFull_0(b, l + 1);
    r = r && consumeToken(b, OP_LCURLY);
    r = r && InlineDataFull_2(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NIL | OP_LROUND Var* OP_RROUND
  private static boolean InlineDataFull_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NIL);
    if (!r) r = InlineDataFull_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND Var* OP_RROUND
  private static boolean InlineDataFull_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && InlineDataFull_0_1_1(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // Var*
  private static boolean InlineDataFull_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_0_1_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Var(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InlineDataFull_0_1_1", c)) break;
    }
    return true;
  }

  // ( OP_LROUND DataBlockValue* OP_RROUND | NIL )*
  private static boolean InlineDataFull_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InlineDataFull_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InlineDataFull_2", c)) break;
    }
    return true;
  }

  // OP_LROUND DataBlockValue* OP_RROUND | NIL
  private static boolean InlineDataFull_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = InlineDataFull_2_0_0(b, l + 1);
    if (!r) r = consumeToken(b, NIL);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND DataBlockValue* OP_RROUND
  private static boolean InlineDataFull_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && InlineDataFull_2_0_0_1(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // DataBlockValue*
  private static boolean InlineDataFull_2_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataFull_2_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DataBlockValue(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InlineDataFull_2_0_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // Var OP_LCURLY DataBlockValue* OP_RCURLY
  public static boolean InlineDataOneVar(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataOneVar")) return false;
    if (!nextTokenIs(b, "<inline data one var>", VAR1, VAR2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INLINE_DATA_ONE_VAR, "<inline data one var>");
    r = Var(b, l + 1);
    r = r && consumeToken(b, OP_LCURLY);
    r = r && InlineDataOneVar_2(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DataBlockValue*
  private static boolean InlineDataOneVar_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InlineDataOneVar_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DataBlockValue(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InlineDataOneVar_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_INSERT QuadPattern
  public static boolean InsertClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InsertClause")) return false;
    if (!nextTokenIs(b, KW_INSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_INSERT);
    r = r && QuadPattern(b, l + 1);
    exit_section_(b, m, INSERT_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_INSERT KW_DATA QuadData
  public static boolean InsertData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InsertData")) return false;
    if (!nextTokenIs(b, KW_INSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_INSERT, KW_DATA);
    r = r && QuadData(b, l + 1);
    exit_section_(b, m, INSERT_DATA, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LIMIT INTEGER
  public static boolean LimitClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitClause")) return false;
    if (!nextTokenIs(b, KW_LIMIT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIMIT_CLAUSE, null);
    r = consumeTokens(b, 1, KW_LIMIT, INTEGER);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LimitClause OffsetClause? | OffsetClause LimitClause?
  public static boolean LimitOffsetClauses(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LimitOffsetClauses")) return false;
    if (!nextTokenIs(b, "<limit offset clauses>", KW_LIMIT, KW_OFFSET)) return false;
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
  // INTEGER
  public static boolean Lit_Integer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Lit_Integer")) return false;
    if (!nextTokenIs(b, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTEGER);
    exit_section_(b, m, LIT_INTEGER, r);
    return r;
  }

  /* ********************************************************** */
  // KW_LOAD KW_SILENT? iri ( KW_INTO GraphRef )?
  public static boolean Load(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Load")) return false;
    if (!nextTokenIs(b, KW_LOAD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LOAD, null);
    r = consumeToken(b, KW_LOAD);
    p = r; // pin = 1
    r = r && report_error_(b, Load_1(b, l + 1));
    r = p && report_error_(b, iri(b, l + 1)) && r;
    r = p && Load_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Load_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Load_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  // ( KW_INTO GraphRef )?
  private static boolean Load_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Load_3")) return false;
    Load_3_0(b, l + 1);
    return true;
  }

  // KW_INTO GraphRef
  private static boolean Load_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Load_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_INTO);
    r = r && GraphRef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_MINUS GroupGraphPattern
  public static boolean MinusGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MinusGraphPattern")) return false;
    if (!nextTokenIs(b, KW_MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MINUS_GRAPH_PATTERN, null);
    r = consumeToken(b, KW_MINUS);
    p = r; // pin = 1
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ( KW_WITH iri )? ( DeleteClause InsertClause? | InsertClause ) UsingClause* KW_WHERE GroupGraphPattern
  public static boolean Modify(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFY, "<modify>");
    r = Modify_0(b, l + 1);
    r = r && Modify_1(b, l + 1);
    r = r && Modify_2(b, l + 1);
    r = r && consumeToken(b, KW_WHERE);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( KW_WITH iri )?
  private static boolean Modify_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_0")) return false;
    Modify_0_0(b, l + 1);
    return true;
  }

  // KW_WITH iri
  private static boolean Modify_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_WITH);
    r = r && iri(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DeleteClause InsertClause? | InsertClause
  private static boolean Modify_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Modify_1_0(b, l + 1);
    if (!r) r = InsertClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DeleteClause InsertClause?
  private static boolean Modify_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = DeleteClause(b, l + 1);
    r = r && Modify_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // InsertClause?
  private static boolean Modify_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_1_0_1")) return false;
    InsertClause(b, l + 1);
    return true;
  }

  // UsingClause*
  private static boolean Modify_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Modify_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!UsingClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Modify_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_MOVE KW_SILENT? GraphOrDefault KW_TO GraphOrDefault
  public static boolean Move(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Move")) return false;
    if (!nextTokenIs(b, KW_MOVE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MOVE, null);
    r = consumeToken(b, KW_MOVE);
    p = r; // pin = 1
    r = r && report_error_(b, Move_1(b, l + 1));
    r = p && report_error_(b, GraphOrDefault(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, KW_TO)) && r;
    r = p && GraphOrDefault(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean Move_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Move_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // UnaryExpression ( OP_MULT UnaryExpression | OP_DIV UnaryExpression )*
  public static boolean MultiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = UnaryExpression(b, l + 1);
    r = r && MultiplicativeExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_MULT UnaryExpression | OP_DIV UnaryExpression )*
  private static boolean MultiplicativeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MultiplicativeExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MultiplicativeExpression_1", c)) break;
    }
    return true;
  }

  // OP_MULT UnaryExpression | OP_DIV UnaryExpression
  private static boolean MultiplicativeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MultiplicativeExpression_1_0_0(b, l + 1);
    if (!r) r = MultiplicativeExpression_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MULT UnaryExpression
  private static boolean MultiplicativeExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MULT);
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_DIV UnaryExpression
  private static boolean MultiplicativeExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MultiplicativeExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DIV);
    r = r && UnaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_NAMED SourceSelector
  public static boolean NamedGraphClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NamedGraphClause")) return false;
    if (!nextTokenIs(b, KW_NAMED)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NAMED);
    r = r && SourceSelector(b, l + 1);
    exit_section_(b, m, NAMED_GRAPH_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // KW_NOT KW_EXISTS GroupGraphPattern
  public static boolean NotExistsFunc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NotExistsFunc")) return false;
    if (!nextTokenIs(b, KW_NOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_NOT, KW_EXISTS);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, m, NOT_EXISTS_FUNC, r);
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
    r = consumeToken(b, INTEGER_NEGATIVE);
    if (!r) r = consumeToken(b, DECIMAL_NEGATIVE);
    if (!r) r = consumeToken(b, DOUBLE_NEGATIVE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_POSITIVE | DECIMAL_POSITIVE | DOUBLE_POSITIVE
  public static boolean NumericLiteralPositive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteralPositive")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL_POSITIVE, "<numeric literal positive>");
    r = consumeToken(b, INTEGER_POSITIVE);
    if (!r) r = consumeToken(b, DECIMAL_POSITIVE);
    if (!r) r = consumeToken(b, DOUBLE_POSITIVE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTEGER | DECIMAL | DOUBLE
  public static boolean NumericLiteralUnsigned(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NumericLiteralUnsigned")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMERIC_LITERAL_UNSIGNED, "<numeric literal unsigned>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, DOUBLE);
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
  // Object ( OP_COMMA Object )*
  public static boolean ObjectList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_LIST, "<object list>");
    r = Object(b, l + 1);
    r = r && ObjectList_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_COMMA Object )*
  private static boolean ObjectList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ObjectList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ObjectList_1", c)) break;
    }
    return true;
  }

  // OP_COMMA Object
  private static boolean ObjectList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ObjectPath ( OP_COMMA ObjectPath )*
  public static boolean ObjectListPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectListPath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_LIST_PATH, "<object list path>");
    r = ObjectPath(b, l + 1);
    r = r && ObjectListPath_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_COMMA ObjectPath )*
  private static boolean ObjectListPath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectListPath_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ObjectListPath_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ObjectListPath_1", c)) break;
    }
    return true;
  }

  // OP_COMMA ObjectPath
  private static boolean ObjectListPath_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectListPath_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && ObjectPath(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // GraphNodePath
  public static boolean ObjectPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ObjectPath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_PATH, "<object path>");
    r = GraphNodePath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_OFFSET INTEGER
  public static boolean OffsetClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OffsetClause")) return false;
    if (!nextTokenIs(b, KW_OFFSET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OFFSET_CLAUSE, null);
    r = consumeTokens(b, 1, KW_OFFSET, INTEGER);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_OPTIONAL GroupGraphPattern
  public static boolean OptionalGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalGraphPattern")) return false;
    if (!nextTokenIs(b, KW_OPTIONAL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL_GRAPH_PATTERN, null);
    r = consumeToken(b, KW_OPTIONAL);
    p = r; // pin = 1
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // KW_ORDER KW_BY OrderCondition+
  public static boolean OrderClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderClause")) return false;
    if (!nextTokenIs(b, KW_ORDER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ORDER_CLAUSE, null);
    r = consumeTokens(b, 1, KW_ORDER, KW_BY);
    p = r; // pin = 1
    r = r && OrderClause_2(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // ( ( KW_ASC | KW_DESC ) BrackettedExpression )
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

  // ( KW_ASC | KW_DESC ) BrackettedExpression
  private static boolean OrderCondition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = OrderCondition_0_0(b, l + 1);
    r = r && BrackettedExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_ASC | KW_DESC
  private static boolean OrderCondition_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OrderCondition_0_0")) return false;
    boolean r;
    r = consumeToken(b, KW_ASC);
    if (!r) r = consumeToken(b, KW_DESC);
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
  // PathAlternative
  public static boolean Path(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Path")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH, "<path>");
    r = PathAlternative(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PathSequence ( OP_PIPE PathSequence )*
  public static boolean PathAlternative(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathAlternative")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_ALTERNATIVE, "<path alternative>");
    r = PathSequence(b, l + 1);
    r = r && PathAlternative_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_PIPE PathSequence )*
  private static boolean PathAlternative_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathAlternative_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PathAlternative_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PathAlternative_1", c)) break;
    }
    return true;
  }

  // OP_PIPE PathSequence
  private static boolean PathAlternative_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathAlternative_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PIPE);
    r = r && PathSequence(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PathPrimary PathMod?
  public static boolean PathElt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathElt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_ELT, "<path elt>");
    r = PathPrimary(b, l + 1);
    r = r && PathElt_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PathMod?
  private static boolean PathElt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathElt_1")) return false;
    PathMod(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PathElt | OP_HAT PathElt
  public static boolean PathEltOrInverse(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathEltOrInverse")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_ELT_OR_INVERSE, "<path elt or inverse>");
    r = PathElt(b, l + 1);
    if (!r) r = PathEltOrInverse_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_HAT PathElt
  private static boolean PathEltOrInverse_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathEltOrInverse_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_HAT);
    r = r && PathElt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // OP_QUESTION_MARK | OP_MULT | OP_PLUS
  public static boolean PathMod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathMod")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_MOD, "<path mod>");
    r = consumeToken(b, OP_QUESTION_MARK);
    if (!r) r = consumeToken(b, OP_MULT);
    if (!r) r = consumeToken(b, OP_PLUS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PathOneInPropertySet | OP_LROUND ( PathOneInPropertySet ( OP_PIPE PathOneInPropertySet )* )? OP_RROUND
  public static boolean PathNegatedPropertySet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_NEGATED_PROPERTY_SET, "<path negated property set>");
    r = PathOneInPropertySet(b, l + 1);
    if (!r) r = PathNegatedPropertySet_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_LROUND ( PathOneInPropertySet ( OP_PIPE PathOneInPropertySet )* )? OP_RROUND
  private static boolean PathNegatedPropertySet_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && PathNegatedPropertySet_1_1(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( PathOneInPropertySet ( OP_PIPE PathOneInPropertySet )* )?
  private static boolean PathNegatedPropertySet_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet_1_1")) return false;
    PathNegatedPropertySet_1_1_0(b, l + 1);
    return true;
  }

  // PathOneInPropertySet ( OP_PIPE PathOneInPropertySet )*
  private static boolean PathNegatedPropertySet_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PathOneInPropertySet(b, l + 1);
    r = r && PathNegatedPropertySet_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( OP_PIPE PathOneInPropertySet )*
  private static boolean PathNegatedPropertySet_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet_1_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PathNegatedPropertySet_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PathNegatedPropertySet_1_1_0_1", c)) break;
    }
    return true;
  }

  // OP_PIPE PathOneInPropertySet
  private static boolean PathNegatedPropertySet_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathNegatedPropertySet_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PIPE);
    r = r && PathOneInPropertySet(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // iri | KW_A | OP_HAT ( iri | KW_A )
  public static boolean PathOneInPropertySet(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathOneInPropertySet")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_ONE_IN_PROPERTY_SET, "<path one in property set>");
    r = iri(b, l + 1);
    if (!r) r = consumeToken(b, KW_A);
    if (!r) r = PathOneInPropertySet_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_HAT ( iri | KW_A )
  private static boolean PathOneInPropertySet_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathOneInPropertySet_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_HAT);
    r = r && PathOneInPropertySet_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // iri | KW_A
  private static boolean PathOneInPropertySet_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathOneInPropertySet_2_1")) return false;
    boolean r;
    r = iri(b, l + 1);
    if (!r) r = consumeToken(b, KW_A);
    return r;
  }

  /* ********************************************************** */
  // iri | KW_A | OP_NOT PathNegatedPropertySet | OP_LROUND Path OP_RROUND
  public static boolean PathPrimary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathPrimary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_PRIMARY, "<path primary>");
    r = iri(b, l + 1);
    if (!r) r = consumeToken(b, KW_A);
    if (!r) r = PathPrimary_2(b, l + 1);
    if (!r) r = PathPrimary_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP_NOT PathNegatedPropertySet
  private static boolean PathPrimary_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathPrimary_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && PathNegatedPropertySet(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND Path OP_RROUND
  private static boolean PathPrimary_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathPrimary_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Path(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PathEltOrInverse ( OP_DIV PathEltOrInverse )*
  public static boolean PathSequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathSequence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_SEQUENCE, "<path sequence>");
    r = PathEltOrInverse(b, l + 1);
    r = r && PathSequence_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_DIV PathEltOrInverse )*
  private static boolean PathSequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathSequence_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PathSequence_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PathSequence_1", c)) break;
    }
    return true;
  }

  // OP_DIV PathEltOrInverse
  private static boolean PathSequence_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PathSequence_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DIV);
    r = r && PathEltOrInverse(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_PREFIX PNAME_NS IRIREF
  public static boolean PrefixDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixDecl")) return false;
    if (!nextTokenIs(b, KW_PREFIX)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_DECL, null);
    r = consumeTokens(b, 1, KW_PREFIX, PNAME_NS, IRIREF);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // PNAME_LN | PNAME_NS
  public static boolean PrefixedName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrefixedName")) return false;
    if (!nextTokenIs(b, "<prefixed name>", PNAME_LN, PNAME_NS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIXED_NAME, "<prefixed name>");
    r = consumeToken(b, PNAME_LN);
    if (!r) r = consumeToken(b, PNAME_NS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // BrackettedExpression | BuiltInCall | iriOrFunction | RDFLiteral | NumericLiteral | BooleanLiteral | Var
  public static boolean PrimaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PrimaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMARY_EXPRESSION, "<primary expression>");
    r = BrackettedExpression(b, l + 1);
    if (!r) r = BuiltInCall(b, l + 1);
    if (!r) r = iriOrFunction(b, l + 1);
    if (!r) r = RDFLiteral(b, l + 1);
    if (!r) r = NumericLiteral(b, l + 1);
    if (!r) r = BooleanLiteral(b, l + 1);
    if (!r) r = Var(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( BaseDecl | PrefixDecl )*
  public static boolean Prologue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prologue")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROLOGUE, "<prologue>");
    while (true) {
      int c = current_position_(b);
      if (!Prologue_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Prologue", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // BaseDecl | PrefixDecl
  private static boolean Prologue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Prologue_0")) return false;
    boolean r;
    r = BaseDecl(b, l + 1);
    if (!r) r = PrefixDecl(b, l + 1);
    return r;
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
  // Verb ObjectList ( OP_SEMI ( Verb ObjectList )? )*
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

  // ( OP_SEMI ( Verb ObjectList )? )*
  private static boolean PropertyListNotEmpty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PropertyListNotEmpty_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PropertyListNotEmpty_2", c)) break;
    }
    return true;
  }

  // OP_SEMI ( Verb ObjectList )?
  private static boolean PropertyListNotEmpty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListNotEmpty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SEMI);
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
  // PropertyListPathNotEmpty?
  public static boolean PropertyListPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPath")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_LIST_PATH, "<property list path>");
    PropertyListPathNotEmpty(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // ( VerbPath | VerbSimple ) ObjectListPath ( OP_SEMI ( ( VerbPath | VerbSimple ) ObjectListPath )? )*
  public static boolean PropertyListPathNotEmpty(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROPERTY_LIST_PATH_NOT_EMPTY, "<property list path not empty>");
    r = PropertyListPathNotEmpty_0(b, l + 1);
    r = r && ObjectListPath(b, l + 1);
    r = r && PropertyListPathNotEmpty_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VerbPath | VerbSimple
  private static boolean PropertyListPathNotEmpty_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_0")) return false;
    boolean r;
    r = VerbPath(b, l + 1);
    if (!r) r = VerbSimple(b, l + 1);
    return r;
  }

  // ( OP_SEMI ( ( VerbPath | VerbSimple ) ObjectListPath )? )*
  private static boolean PropertyListPathNotEmpty_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PropertyListPathNotEmpty_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PropertyListPathNotEmpty_2", c)) break;
    }
    return true;
  }

  // OP_SEMI ( ( VerbPath | VerbSimple ) ObjectListPath )?
  private static boolean PropertyListPathNotEmpty_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SEMI);
    r = r && PropertyListPathNotEmpty_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( ( VerbPath | VerbSimple ) ObjectListPath )?
  private static boolean PropertyListPathNotEmpty_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_2_0_1")) return false;
    PropertyListPathNotEmpty_2_0_1_0(b, l + 1);
    return true;
  }

  // ( VerbPath | VerbSimple ) ObjectListPath
  private static boolean PropertyListPathNotEmpty_2_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_2_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PropertyListPathNotEmpty_2_0_1_0_0(b, l + 1);
    r = r && ObjectListPath(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VerbPath | VerbSimple
  private static boolean PropertyListPathNotEmpty_2_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PropertyListPathNotEmpty_2_0_1_0_0")) return false;
    boolean r;
    r = VerbPath(b, l + 1);
    if (!r) r = VerbSimple(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // OP_LCURLY Quads OP_RCURLY
  public static boolean QuadData(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QuadData")) return false;
    if (!nextTokenIs(b, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LCURLY);
    r = r && Quads(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, m, QUAD_DATA, r);
    return r;
  }

  /* ********************************************************** */
  // OP_LCURLY Quads OP_RCURLY
  public static boolean QuadPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QuadPattern")) return false;
    if (!nextTokenIs(b, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LCURLY);
    r = r && Quads(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, m, QUAD_PATTERN, r);
    return r;
  }

  /* ********************************************************** */
  // TriplesTemplate? ( QuadsNotTriples OP_DOT? TriplesTemplate? )*
  public static boolean Quads(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUADS, "<quads>");
    r = Quads_0(b, l + 1);
    r = r && Quads_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TriplesTemplate?
  private static boolean Quads_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads_0")) return false;
    TriplesTemplate(b, l + 1);
    return true;
  }

  // ( QuadsNotTriples OP_DOT? TriplesTemplate? )*
  private static boolean Quads_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Quads_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Quads_1", c)) break;
    }
    return true;
  }

  // QuadsNotTriples OP_DOT? TriplesTemplate?
  private static boolean Quads_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = QuadsNotTriples(b, l + 1);
    r = r && Quads_1_0_1(b, l + 1);
    r = r && Quads_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_DOT?
  private static boolean Quads_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads_1_0_1")) return false;
    consumeToken(b, OP_DOT);
    return true;
  }

  // TriplesTemplate?
  private static boolean Quads_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Quads_1_0_2")) return false;
    TriplesTemplate(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // KW_GRAPH VarOrIri OP_LCURLY TriplesTemplate? OP_RCURLY
  public static boolean QuadsNotTriples(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QuadsNotTriples")) return false;
    if (!nextTokenIs(b, KW_GRAPH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_GRAPH);
    r = r && VarOrIri(b, l + 1);
    r = r && consumeToken(b, OP_LCURLY);
    r = r && QuadsNotTriples_3(b, l + 1);
    r = r && consumeToken(b, OP_RCURLY);
    exit_section_(b, m, QUADS_NOT_TRIPLES, r);
    return r;
  }

  // TriplesTemplate?
  private static boolean QuadsNotTriples_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QuadsNotTriples_3")) return false;
    TriplesTemplate(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // Prologue
  // ( SelectQuery | ConstructQuery | DescribeQuery | AskQuery )
  // ValuesClause
  public static boolean Query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY, "<query>");
    r = Prologue(b, l + 1);
    r = r && Query_1(b, l + 1);
    r = r && ValuesClause(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SelectQuery | ConstructQuery | DescribeQuery | AskQuery
  private static boolean Query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Query_1")) return false;
    boolean r;
    r = SelectQuery(b, l + 1);
    if (!r) r = ConstructQuery(b, l + 1);
    if (!r) r = DescribeQuery(b, l + 1);
    if (!r) r = AskQuery(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // Query
  public static boolean QueryUnit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "QueryUnit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY_UNIT, "<query unit>");
    r = Query(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // String ( LANGTAG | ( OP_HATHAT iri ) )?
  public static boolean RDFLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RDF_LITERAL, "<rdf literal>");
    r = String(b, l + 1);
    r = r && RDFLiteral_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( LANGTAG | ( OP_HATHAT iri ) )?
  private static boolean RDFLiteral_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1")) return false;
    RDFLiteral_1_0(b, l + 1);
    return true;
  }

  // LANGTAG | ( OP_HATHAT iri )
  private static boolean RDFLiteral_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LANGTAG);
    if (!r) r = RDFLiteral_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_HATHAT iri
  private static boolean RDFLiteral_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RDFLiteral_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_HATHAT);
    r = r && iri(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // KW_REGEX OP_LROUND Expression OP_COMMA Expression ( OP_COMMA Expression )? OP_RROUND
  public static boolean RegexExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression")) return false;
    if (!nextTokenIs(b, KW_REGEX)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REGEX_EXPRESSION, null);
    r = consumeTokens(b, 1, KW_REGEX, OP_LROUND);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_COMMA)) && r;
    r = p && report_error_(b, Expression(b, l + 1)) && r;
    r = p && report_error_(b, RegexExpression_5(b, l + 1)) && r;
    r = p && consumeToken(b, OP_RROUND) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( OP_COMMA Expression )?
  private static boolean RegexExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression_5")) return false;
    RegexExpression_5_0(b, l + 1);
    return true;
  }

  // OP_COMMA Expression
  private static boolean RegexExpression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RegexExpression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NumericExpression ( OP_EQ NumericExpression | OP_NE NumericExpression | OP_LT NumericExpression | OP_GT NumericExpression | OP_LE NumericExpression | OP_GE NumericExpression | KW_IN ExpressionList | KW_NOT KW_IN ExpressionList )?
  public static boolean RelationalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_EXPRESSION, "<relational expression>");
    r = NumericExpression(b, l + 1);
    r = r && RelationalExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_EQ NumericExpression | OP_NE NumericExpression | OP_LT NumericExpression | OP_GT NumericExpression | OP_LE NumericExpression | OP_GE NumericExpression | KW_IN ExpressionList | KW_NOT KW_IN ExpressionList )?
  private static boolean RelationalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1")) return false;
    RelationalExpression_1_0(b, l + 1);
    return true;
  }

  // OP_EQ NumericExpression | OP_NE NumericExpression | OP_LT NumericExpression | OP_GT NumericExpression | OP_LE NumericExpression | OP_GE NumericExpression | KW_IN ExpressionList | KW_NOT KW_IN ExpressionList
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
    if (!r) r = RelationalExpression_1_0_6(b, l + 1);
    if (!r) r = RelationalExpression_1_0_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_EQ NumericExpression
  private static boolean RelationalExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_EQ);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_NE NumericExpression
  private static boolean RelationalExpression_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NE);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LT NumericExpression
  private static boolean RelationalExpression_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LT);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_GT NumericExpression
  private static boolean RelationalExpression_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_GT);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LE NumericExpression
  private static boolean RelationalExpression_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LE);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_GE NumericExpression
  private static boolean RelationalExpression_1_0_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_GE);
    r = r && NumericExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_IN ExpressionList
  private static boolean RelationalExpression_1_0_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_IN);
    r = r && ExpressionList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_NOT KW_IN ExpressionList
  private static boolean RelationalExpression_1_0_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalExpression_1_0_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, KW_NOT, KW_IN);
    r = r && ExpressionList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QueryUnit | UpdateUnit
  static boolean Root(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Root")) return false;
    boolean r;
    r = QueryUnit(b, l + 1);
    if (!r) r = UpdateUnit(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // KW_SELECT ( KW_DISTINCT | KW_REDUCED )? ( ( Var | ( OP_LROUND Expression KW_AS Var OP_RROUND ) )+ | OP_MULT )
  public static boolean SelectClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause")) return false;
    if (!nextTokenIs(b, KW_SELECT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SELECT_CLAUSE, null);
    r = consumeToken(b, KW_SELECT);
    p = r; // pin = 1
    r = r && report_error_(b, SelectClause_1(b, l + 1));
    r = p && SelectClause_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( KW_DISTINCT | KW_REDUCED )?
  private static boolean SelectClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_1")) return false;
    SelectClause_1_0(b, l + 1);
    return true;
  }

  // KW_DISTINCT | KW_REDUCED
  private static boolean SelectClause_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_1_0")) return false;
    boolean r;
    r = consumeToken(b, KW_DISTINCT);
    if (!r) r = consumeToken(b, KW_REDUCED);
    return r;
  }

  // ( Var | ( OP_LROUND Expression KW_AS Var OP_RROUND ) )+ | OP_MULT
  private static boolean SelectClause_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SelectClause_2_0(b, l + 1);
    if (!r) r = consumeToken(b, OP_MULT);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( Var | ( OP_LROUND Expression KW_AS Var OP_RROUND ) )+
  private static boolean SelectClause_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SelectClause_2_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!SelectClause_2_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SelectClause_2_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // Var | ( OP_LROUND Expression KW_AS Var OP_RROUND )
  private static boolean SelectClause_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Var(b, l + 1);
    if (!r) r = SelectClause_2_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_LROUND Expression KW_AS Var OP_RROUND
  private static boolean SelectClause_2_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectClause_2_0_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_LROUND);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, KW_AS);
    r = r && Var(b, l + 1);
    r = r && consumeToken(b, OP_RROUND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SelectClause DatasetClause* WhereClause SolutionModifier
  public static boolean SelectQuery(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery")) return false;
    if (!nextTokenIs(b, KW_SELECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SelectClause(b, l + 1);
    r = r && SelectQuery_1(b, l + 1);
    r = r && WhereClause(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    exit_section_(b, m, SELECT_QUERY, r);
    return r;
  }

  // DatasetClause*
  private static boolean SelectQuery_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SelectQuery_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!DatasetClause(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "SelectQuery_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // KW_SERVICE KW_SILENT? VarOrIri GroupGraphPattern
  public static boolean ServiceGraphPattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceGraphPattern")) return false;
    if (!nextTokenIs(b, KW_SERVICE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SERVICE_GRAPH_PATTERN, null);
    r = consumeToken(b, KW_SERVICE);
    p = r; // pin = 1
    r = r && report_error_(b, ServiceGraphPattern_1(b, l + 1));
    r = p && report_error_(b, VarOrIri(b, l + 1)) && r;
    r = p && GroupGraphPattern(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // KW_SILENT?
  private static boolean ServiceGraphPattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ServiceGraphPattern_1")) return false;
    consumeToken(b, KW_SILENT);
    return true;
  }

  /* ********************************************************** */
  // GroupClause? HavingClause? OrderClause? LimitOffsetClauses?
  public static boolean SolutionModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SOLUTION_MODIFIER, "<solution modifier>");
    r = SolutionModifier_0(b, l + 1);
    r = r && SolutionModifier_1(b, l + 1);
    r = r && SolutionModifier_2(b, l + 1);
    r = r && SolutionModifier_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // GroupClause?
  private static boolean SolutionModifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_0")) return false;
    GroupClause(b, l + 1);
    return true;
  }

  // HavingClause?
  private static boolean SolutionModifier_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_1")) return false;
    HavingClause(b, l + 1);
    return true;
  }

  // OrderClause?
  private static boolean SolutionModifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_2")) return false;
    OrderClause(b, l + 1);
    return true;
  }

  // LimitOffsetClauses?
  private static boolean SolutionModifier_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SolutionModifier_3")) return false;
    LimitOffsetClauses(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // iri
  public static boolean SourceSelector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SourceSelector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SOURCE_SELECTOR, "<source selector>");
    r = iri(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_REPLACE OP_LROUND Expression OP_COMMA Expression OP_COMMA Expression ( OP_COMMA Expression )? OP_RROUND
  public static boolean StrReplaceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StrReplaceExpression")) return false;
    if (!nextTokenIs(b, KW_REPLACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STR_REPLACE_EXPRESSION, null);
    r = consumeTokens(b, 1, KW_REPLACE, OP_LROUND);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_COMMA)) && r;
    r = p && report_error_(b, Expression(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, OP_COMMA)) && r;
    r = p && report_error_(b, Expression(b, l + 1)) && r;
    r = p && report_error_(b, StrReplaceExpression_7(b, l + 1)) && r;
    r = p && consumeToken(b, OP_RROUND) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( OP_COMMA Expression )?
  private static boolean StrReplaceExpression_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StrReplaceExpression_7")) return false;
    StrReplaceExpression_7_0(b, l + 1);
    return true;
  }

  // OP_COMMA Expression
  private static boolean StrReplaceExpression_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StrReplaceExpression_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
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
  // SelectClause WhereClause SolutionModifier ValuesClause
  public static boolean SubSelect(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubSelect")) return false;
    if (!nextTokenIs(b, KW_SELECT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = SelectClause(b, l + 1);
    r = r && WhereClause(b, l + 1);
    r = r && SolutionModifier(b, l + 1);
    r = r && ValuesClause(b, l + 1);
    exit_section_(b, m, SUB_SELECT, r);
    return r;
  }

  /* ********************************************************** */
  // KW_SUBSTR OP_LROUND Expression OP_COMMA Expression ( OP_COMMA Expression )? OP_RROUND
  public static boolean SubstringExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubstringExpression")) return false;
    if (!nextTokenIs(b, KW_SUBSTR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUBSTRING_EXPRESSION, null);
    r = consumeTokens(b, 1, KW_SUBSTR, OP_LROUND);
    p = r; // pin = 1
    r = r && report_error_(b, Expression(b, l + 1));
    r = p && report_error_(b, consumeToken(b, OP_COMMA)) && r;
    r = p && report_error_(b, Expression(b, l + 1)) && r;
    r = p && report_error_(b, SubstringExpression_5(b, l + 1)) && r;
    r = p && consumeToken(b, OP_RROUND) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( OP_COMMA Expression )?
  private static boolean SubstringExpression_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubstringExpression_5")) return false;
    SubstringExpression_5_0(b, l + 1);
    return true;
  }

  // OP_COMMA Expression
  private static boolean SubstringExpression_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SubstringExpression_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TriplesSameSubjectPath ( OP_DOT TriplesBlock? )?
  public static boolean TriplesBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_BLOCK, "<triples block>");
    r = TriplesSameSubjectPath(b, l + 1);
    r = r && TriplesBlock_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_DOT TriplesBlock? )?
  private static boolean TriplesBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock_1")) return false;
    TriplesBlock_1_0(b, l + 1);
    return true;
  }

  // OP_DOT TriplesBlock?
  private static boolean TriplesBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesBlock_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DOT);
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
    if (!nextTokenIs(b, "<triples node>", OP_LROUND, OP_LSQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_NODE, "<triples node>");
    r = Collection(b, l + 1);
    if (!r) r = BlankNodePropertyList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CollectionPath | BlankNodePropertyListPath
  public static boolean TriplesNodePath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesNodePath")) return false;
    if (!nextTokenIs(b, "<triples node path>", OP_LROUND, OP_LSQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_NODE_PATH, "<triples node path>");
    r = CollectionPath(b, l + 1);
    if (!r) r = BlankNodePropertyListPath(b, l + 1);
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
  // VarOrTerm PropertyListPathNotEmpty | TriplesNodePath PropertyListPath
  public static boolean TriplesSameSubjectPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubjectPath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_SAME_SUBJECT_PATH, "<triples same subject path>");
    r = TriplesSameSubjectPath_0(b, l + 1);
    if (!r) r = TriplesSameSubjectPath_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // VarOrTerm PropertyListPathNotEmpty
  private static boolean TriplesSameSubjectPath_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubjectPath_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = VarOrTerm(b, l + 1);
    r = r && PropertyListPathNotEmpty(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TriplesNodePath PropertyListPath
  private static boolean TriplesSameSubjectPath_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesSameSubjectPath_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TriplesNodePath(b, l + 1);
    r = r && PropertyListPath(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TriplesSameSubject ( OP_DOT TriplesTemplate? )?
  public static boolean TriplesTemplate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesTemplate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TRIPLES_TEMPLATE, "<triples template>");
    r = TriplesSameSubject(b, l + 1);
    r = r && TriplesTemplate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( OP_DOT TriplesTemplate? )?
  private static boolean TriplesTemplate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesTemplate_1")) return false;
    TriplesTemplate_1_0(b, l + 1);
    return true;
  }

  // OP_DOT TriplesTemplate?
  private static boolean TriplesTemplate_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesTemplate_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_DOT);
    r = r && TriplesTemplate_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TriplesTemplate?
  private static boolean TriplesTemplate_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TriplesTemplate_1_0_1")) return false;
    TriplesTemplate(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OP_NOT PrimaryExpression
  // | OP_PLUS PrimaryExpression
  // | OP_MINUS PrimaryExpression
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

  // OP_NOT PrimaryExpression
  private static boolean UnaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_NOT);
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_PLUS PrimaryExpression
  private static boolean UnaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_PLUS);
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // OP_MINUS PrimaryExpression
  private static boolean UnaryExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_MINUS);
    r = r && PrimaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Prologue ( Update1 ( OP_SEMI Update )? )?
  public static boolean Update(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UPDATE, "<update>");
    r = Prologue(b, l + 1);
    r = r && Update_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( Update1 ( OP_SEMI Update )? )?
  private static boolean Update_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update_1")) return false;
    Update_1_0(b, l + 1);
    return true;
  }

  // Update1 ( OP_SEMI Update )?
  private static boolean Update_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Update1(b, l + 1);
    r = r && Update_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( OP_SEMI Update )?
  private static boolean Update_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update_1_0_1")) return false;
    Update_1_0_1_0(b, l + 1);
    return true;
  }

  // OP_SEMI Update
  private static boolean Update_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP_SEMI);
    r = r && Update(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Load | Clear | Drop | Add | Move | Copy | Create | InsertData | DeleteData | DeleteWhere | Modify
  public static boolean Update1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Update1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UPDATE_1, "<update 1>");
    r = Load(b, l + 1);
    if (!r) r = Clear(b, l + 1);
    if (!r) r = Drop(b, l + 1);
    if (!r) r = Add(b, l + 1);
    if (!r) r = Move(b, l + 1);
    if (!r) r = Copy(b, l + 1);
    if (!r) r = Create(b, l + 1);
    if (!r) r = InsertData(b, l + 1);
    if (!r) r = DeleteData(b, l + 1);
    if (!r) r = DeleteWhere(b, l + 1);
    if (!r) r = Modify(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Update
  public static boolean UpdateUnit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UpdateUnit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UPDATE_UNIT, "<update unit>");
    r = Update(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_USING ( iri | KW_NAMED iri )
  public static boolean UsingClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingClause")) return false;
    if (!nextTokenIs(b, KW_USING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, USING_CLAUSE, null);
    r = consumeToken(b, KW_USING);
    p = r; // pin = 1
    r = r && UsingClause_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // iri | KW_NAMED iri
  private static boolean UsingClause_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingClause_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = iri(b, l + 1);
    if (!r) r = UsingClause_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // KW_NAMED iri
  private static boolean UsingClause_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UsingClause_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_NAMED);
    r = r && iri(b, l + 1);
    exit_section_(b, m, null, r);
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
  // ( KW_VALUES DataBlock )?
  public static boolean ValuesClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValuesClause")) return false;
    Marker m = enter_section_(b, l, _NONE_, VALUES_CLAUSE, "<values clause>");
    ValuesClause_0(b, l + 1);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // KW_VALUES DataBlock
  private static boolean ValuesClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ValuesClause_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, KW_VALUES);
    r = r && DataBlock(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR1 | VAR2
  public static boolean Var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Var")) return false;
    if (!nextTokenIs(b, "<var>", VAR1, VAR2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR, "<var>");
    r = consumeToken(b, VAR1);
    if (!r) r = consumeToken(b, VAR2);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var | iri
  public static boolean VarOrIri(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VarOrIri")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_OR_IRI, "<var or iri>");
    r = Var(b, l + 1);
    if (!r) r = iri(b, l + 1);
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
  // VarOrIri | KW_A
  public static boolean Verb(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Verb")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERB, "<verb>");
    r = VarOrIri(b, l + 1);
    if (!r) r = consumeToken(b, KW_A);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Path
  public static boolean VerbPath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VerbPath")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERB_PATH, "<verb path>");
    r = Path(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Var
  public static boolean VerbSimple(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VerbSimple")) return false;
    if (!nextTokenIs(b, "<verb simple>", VAR1, VAR2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERB_SIMPLE, "<verb simple>");
    r = Var(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // KW_WHERE? GroupGraphPattern
  public static boolean WhereClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhereClause")) return false;
    if (!nextTokenIs(b, "<where clause>", KW_WHERE, OP_LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WHERE_CLAUSE, "<where clause>");
    r = WhereClause_0(b, l + 1);
    r = r && GroupGraphPattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // KW_WHERE?
  private static boolean WhereClause_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhereClause_0")) return false;
    consumeToken(b, KW_WHERE);
    return true;
  }

  /* ********************************************************** */
  // IRIREF | PrefixedName
  public static boolean iri(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iri")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IRI, "<iri>");
    r = consumeToken(b, IRIREF);
    if (!r) r = PrefixedName(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // iri ArgList?
  public static boolean iriOrFunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iriOrFunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IRI_OR_FUNCTION, "<iri or function>");
    r = iri(b, l + 1);
    r = r && iriOrFunction_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ArgList?
  private static boolean iriOrFunction_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iriOrFunction_1")) return false;
    ArgList(b, l + 1);
    return true;
  }

}
