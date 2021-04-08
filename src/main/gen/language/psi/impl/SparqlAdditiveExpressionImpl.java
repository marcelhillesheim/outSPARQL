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

public class SparqlAdditiveExpressionImpl extends ASTWrapperPsiElement implements SparqlAdditiveExpression {

  public SparqlAdditiveExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitAdditiveExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlMultiplicativeExpression> getMultiplicativeExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlMultiplicativeExpression.class);
  }

  @Override
  @NotNull
  public List<SparqlNumericLiteralNegative> getNumericLiteralNegativeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlNumericLiteralNegative.class);
  }

  @Override
  @NotNull
  public List<SparqlNumericLiteralPositive> getNumericLiteralPositiveList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlNumericLiteralPositive.class);
  }

  @Override
  @NotNull
  public List<SparqlUnaryExpression> getUnaryExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlUnaryExpression.class);
  }

}
