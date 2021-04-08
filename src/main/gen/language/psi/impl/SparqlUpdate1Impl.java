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

public class SparqlUpdate1Impl extends ASTWrapperPsiElement implements SparqlUpdate1 {

  public SparqlUpdate1Impl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitUpdate1(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlAdd getAdd() {
    return findChildByClass(SparqlAdd.class);
  }

  @Override
  @Nullable
  public SparqlClear getClear() {
    return findChildByClass(SparqlClear.class);
  }

  @Override
  @Nullable
  public SparqlCopy getCopy() {
    return findChildByClass(SparqlCopy.class);
  }

  @Override
  @Nullable
  public SparqlCreate getCreate() {
    return findChildByClass(SparqlCreate.class);
  }

  @Override
  @Nullable
  public SparqlDeleteData getDeleteData() {
    return findChildByClass(SparqlDeleteData.class);
  }

  @Override
  @Nullable
  public SparqlDeleteWhere getDeleteWhere() {
    return findChildByClass(SparqlDeleteWhere.class);
  }

  @Override
  @Nullable
  public SparqlDrop getDrop() {
    return findChildByClass(SparqlDrop.class);
  }

  @Override
  @Nullable
  public SparqlInsertData getInsertData() {
    return findChildByClass(SparqlInsertData.class);
  }

  @Override
  @Nullable
  public SparqlLoad getLoad() {
    return findChildByClass(SparqlLoad.class);
  }

  @Override
  @Nullable
  public SparqlModify getModify() {
    return findChildByClass(SparqlModify.class);
  }

  @Override
  @Nullable
  public SparqlMove getMove() {
    return findChildByClass(SparqlMove.class);
  }

}
