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

public class SparqlGroupConditionImpl extends ASTWrapperPsiElement implements SparqlGroupCondition {

  public SparqlGroupConditionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitGroupCondition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlBuiltInCall getBuiltInCall() {
    return findChildByClass(SparqlBuiltInCall.class);
  }

  @Override
  @Nullable
  public SparqlExpression getExpression() {
    return findChildByClass(SparqlExpression.class);
  }

  @Override
  @Nullable
  public SparqlFunctionCall getFunctionCall() {
    return findChildByClass(SparqlFunctionCall.class);
  }

  @Override
  @Nullable
  public SparqlVar getVar() {
    return findChildByClass(SparqlVar.class);
  }

}
