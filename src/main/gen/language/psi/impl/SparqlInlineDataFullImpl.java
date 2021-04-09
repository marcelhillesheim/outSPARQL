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

public class SparqlInlineDataFullImpl extends ASTWrapperPsiElement implements SparqlInlineDataFull {

  public SparqlInlineDataFullImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitInlineDataFull(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SparqlDataBlockValue> getDataBlockValueList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlDataBlockValue.class);
  }

  @Override
  @NotNull
  public List<SparqlVar> getVarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SparqlVar.class);
  }

}