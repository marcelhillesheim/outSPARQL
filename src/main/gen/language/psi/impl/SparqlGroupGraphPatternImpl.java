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

public class SparqlGroupGraphPatternImpl extends ASTWrapperPsiElement implements SparqlGroupGraphPattern {

  public SparqlGroupGraphPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitGroupGraphPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlFilter> getFilterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlFilter.class);
  }

  @Override
  @NotNull
  public List<SparqlGraphPatternNotTriples> getGraphPatternNotTriplesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlGraphPatternNotTriples.class);
  }

  @Override
  @NotNull
  public List<SparqlTriplesBlock> getTriplesBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlTriplesBlock.class);
  }

}
