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

public class SparqlSolutionModifierImpl extends ASTWrapperPsiElement implements SparqlSolutionModifier {

  public SparqlSolutionModifierImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitSolutionModifier(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlGroupClause getGroupClause() {
    return findChildByClass(SparqlGroupClause.class);
  }

  @Override
  @Nullable
  public SparqlHavingClause getHavingClause() {
    return findChildByClass(SparqlHavingClause.class);
  }

  @Override
  @Nullable
  public SparqlLimitOffsetClauses getLimitOffsetClauses() {
    return findChildByClass(SparqlLimitOffsetClauses.class);
  }

  @Override
  @Nullable
  public SparqlOrderClause getOrderClause() {
    return findChildByClass(SparqlOrderClause.class);
  }

}
