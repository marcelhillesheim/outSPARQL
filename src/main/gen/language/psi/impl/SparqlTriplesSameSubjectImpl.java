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

public class SparqlTriplesSameSubjectImpl extends ASTWrapperPsiElement implements SparqlTriplesSameSubject {

  public SparqlTriplesSameSubjectImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitTriplesSameSubject(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlPropertyList getPropertyList() {
    return findChildByClass(SparqlPropertyList.class);
  }

  @Override
  @Nullable
  public SparqlPropertyListNotEmpty getPropertyListNotEmpty() {
    return findChildByClass(SparqlPropertyListNotEmpty.class);
  }

  @Override
  @Nullable
  public SparqlTriplesNode getTriplesNode() {
    return findChildByClass(SparqlTriplesNode.class);
  }

  @Override
  @Nullable
  public SparqlVarOrTerm getVarOrTerm() {
    return findChildByClass(SparqlVarOrTerm.class);
  }

}
