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

public class SparqlGraphPatternNotTriplesImpl extends ASTWrapperPsiElement implements SparqlGraphPatternNotTriples {

  public SparqlGraphPatternNotTriplesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitGraphPatternNotTriples(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlBind getBind() {
    return findChildByClass(SparqlBind.class);
  }

  @Override
  @Nullable
  public SparqlFilter getFilter() {
    return findChildByClass(SparqlFilter.class);
  }

  @Override
  @Nullable
  public SparqlGraphGraphPattern getGraphGraphPattern() {
    return findChildByClass(SparqlGraphGraphPattern.class);
  }

  @Override
  @Nullable
  public SparqlGroupOrUnionGraphPattern getGroupOrUnionGraphPattern() {
    return findChildByClass(SparqlGroupOrUnionGraphPattern.class);
  }

  @Override
  @Nullable
  public SparqlInlineData getInlineData() {
    return findChildByClass(SparqlInlineData.class);
  }

  @Override
  @Nullable
  public SparqlMinusGraphPattern getMinusGraphPattern() {
    return findChildByClass(SparqlMinusGraphPattern.class);
  }

  @Override
  @Nullable
  public SparqlOptionalGraphPattern getOptionalGraphPattern() {
    return findChildByClass(SparqlOptionalGraphPattern.class);
  }

  @Override
  @Nullable
  public SparqlServiceGraphPattern getServiceGraphPattern() {
    return findChildByClass(SparqlServiceGraphPattern.class);
  }

}
