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

public class SparqlDescribeQueryImpl extends ASTWrapperPsiElement implements SparqlDescribeQuery {

  public SparqlDescribeQueryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitDescribeQuery(this);
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
  @Nullable
  public SparqlSolutionModifier getSolutionModifier() {
    return findChildByClass(SparqlSolutionModifier.class);
  }

  @Override
  @NotNull
  public List<SparqlVarOrIri> getVarOrIriList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVarOrIri.class);
  }

  @Override
  @Nullable
  public SparqlWhereClause getWhereClause() {
    return findChildByClass(SparqlWhereClause.class);
  }

}
