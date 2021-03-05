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

public class SparqlPropertyListNotEmptyImpl extends ASTWrapperPsiElement implements SparqlPropertyListNotEmpty {

  public SparqlPropertyListNotEmptyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitPropertyListNotEmpty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlObjectList> getObjectListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlObjectList.class);
  }

  @Override
  @NotNull
  public List<SparqlVerb> getVerbList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVerb.class);
  }

}
