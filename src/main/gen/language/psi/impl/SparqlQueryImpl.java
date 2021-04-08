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

public class SparqlQueryImpl extends ASTWrapperPsiElement implements SparqlQuery {

  public SparqlQueryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitQuery(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlAskQuery getAskQuery() {
    return findChildByClass(SparqlAskQuery.class);
  }

  @Override
  @Nullable
  public SparqlConstructQuery getConstructQuery() {
    return findChildByClass(SparqlConstructQuery.class);
  }

  @Override
  @Nullable
  public SparqlDescribeQuery getDescribeQuery() {
    return findChildByClass(SparqlDescribeQuery.class);
  }

  @Override
  @NotNull
  public SparqlPrologue getPrologue() {
    return findNotNullChildByClass(SparqlPrologue.class);
  }

  @Override
  @Nullable
  public SparqlSelectQuery getSelectQuery() {
    return findChildByClass(SparqlSelectQuery.class);
  }

  @Override
  @NotNull
  public SparqlValuesClause getValuesClause() {
    return findNotNullChildByClass(SparqlValuesClause.class);
  }

}
