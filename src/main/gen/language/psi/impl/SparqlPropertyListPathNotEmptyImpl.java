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

public class SparqlPropertyListPathNotEmptyImpl extends ASTWrapperPsiElement implements SparqlPropertyListPathNotEmpty {

  public SparqlPropertyListPathNotEmptyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitPropertyListPathNotEmpty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlObjectListPath> getObjectListPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlObjectListPath.class);
  }

  @Override
  @NotNull
  public List<SparqlVerbPath> getVerbPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVerbPath.class);
  }

  @Override
  @NotNull
  public List<SparqlVerbSimple> getVerbSimpleList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVerbSimple.class);
  }

}
