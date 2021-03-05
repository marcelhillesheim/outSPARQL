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

public class SparqlFunctionCallImpl extends ASTWrapperPsiElement implements SparqlFunctionCall {

  public SparqlFunctionCallImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitFunctionCall(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public SparqlArgList getArgList() {
    return findNotNullChildByClass(SparqlArgList.class);
  }

  @Override
  @NotNull
  public SparqlIRIref getIRIref() {
    return findNotNullChildByClass(SparqlIRIref.class);
  }

}
