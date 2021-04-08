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

public class SparqlModifyImpl extends ASTWrapperPsiElement implements SparqlModify {

  public SparqlModifyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitModify(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlDeleteClause getDeleteClause() {
    return findChildByClass(SparqlDeleteClause.class);
  }

  @Override
  @NotNull
  public SparqlGroupGraphPattern getGroupGraphPattern() {
    return findNotNullChildByClass(SparqlGroupGraphPattern.class);
  }

  @Override
  @Nullable
  public SparqlInsertClause getInsertClause() {
    return findChildByClass(SparqlInsertClause.class);
  }

  @Override
  @NotNull
  public List<SparqlUsingClause> getUsingClauseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlUsingClause.class);
  }

  @Override
  @Nullable
  public SparqlIri getIri() {
    return findChildByClass(SparqlIri.class);
  }

}
