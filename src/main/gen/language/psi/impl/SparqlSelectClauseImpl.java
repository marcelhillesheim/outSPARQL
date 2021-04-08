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

public class SparqlSelectClauseImpl extends ASTWrapperPsiElement implements SparqlSelectClause {

  public SparqlSelectClauseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitSelectClause(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlExpression.class);
  }

  @Override
  @NotNull
  public List<SparqlVar> getVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVar.class);
  }

}
