// This is a generated file. Not intended for manual editing.
package language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static language.psi.SparqlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import language.psi.*;

public class SparqlBuiltInCallImpl extends ASTWrapperPsiElement implements SparqlBuiltInCall {

  public SparqlBuiltInCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitBuiltInCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlAggregate getAggregate() {
    return findChildByClass(SparqlAggregate.class);
  }

  @Override
  @Nullable
  public SparqlExistsFunc getExistsFunc() {
    return findChildByClass(SparqlExistsFunc.class);
  }

  @Override
  @Nullable
  public SparqlExpression getExpression() {
    return findChildByClass(SparqlExpression.class);
  }

  @Override
  @Nullable
  public SparqlExpressionList getExpressionList() {
    return findChildByClass(SparqlExpressionList.class);
  }

  @Override
  @Nullable
  public SparqlNotExistsFunc getNotExistsFunc() {
    return findChildByClass(SparqlNotExistsFunc.class);
  }

  @Override
  @Nullable
  public SparqlRegexExpression getRegexExpression() {
    return findChildByClass(SparqlRegexExpression.class);
  }

  @Override
  @Nullable
  public SparqlStrReplaceExpression getStrReplaceExpression() {
    return findChildByClass(SparqlStrReplaceExpression.class);
  }

  @Override
  @Nullable
  public SparqlSubstringExpression getSubstringExpression() {
    return findChildByClass(SparqlSubstringExpression.class);
  }

  @Override
  @Nullable
  public SparqlVar getVar() {
    return findChildByClass(SparqlVar.class);
  }

}
