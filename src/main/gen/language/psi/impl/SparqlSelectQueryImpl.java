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

public class SparqlSelectQueryImpl extends ASTWrapperPsiElement implements SparqlSelectQuery {

  public SparqlSelectQueryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitSelectQuery(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlDatasetClause> getDatasetClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlDatasetClause.class);
  }

  @Override
  @NotNull
  public SparqlSolutionModifier getSolutionModifier() {
    return findNotNullChildByClass(SparqlSolutionModifier.class);
  }

  @Override
  @NotNull
  public List<SparqlVar> getVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVar.class);
  }

  @Override
  @NotNull
  public SparqlWhereClause getWhereClause() {
    return findNotNullChildByClass(SparqlWhereClause.class);
  }

}
