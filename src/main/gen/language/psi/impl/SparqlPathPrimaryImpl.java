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

public class SparqlPathPrimaryImpl extends ASTWrapperPsiElement implements SparqlPathPrimary {

  public SparqlPathPrimaryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitPathPrimary(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlPath getPath() {
    return findChildByClass(SparqlPath.class);
  }

  @Override
  @Nullable
  public SparqlPathNegatedPropertySet getPathNegatedPropertySet() {
    return findChildByClass(SparqlPathNegatedPropertySet.class);
  }

  @Override
  @Nullable
  public SparqlIri getIri() {
    return findChildByClass(SparqlIri.class);
  }

}
