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

public class SparqlGraphTermImpl extends ASTWrapperPsiElement implements SparqlGraphTerm {

  public SparqlGraphTermImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SparqlVisitor visitor) {
    visitor.visitGraphTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SparqlVisitor) accept((SparqlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SparqlBlankNode getBlankNode() {
    return findChildByClass(SparqlBlankNode.class);
  }

  @Override
  @Nullable
  public SparqlBooleanLiteral getBooleanLiteral() {
    return findChildByClass(SparqlBooleanLiteral.class);
  }

  @Override
  @Nullable
  public SparqlIRIref getIRIref() {
    return findChildByClass(SparqlIRIref.class);
  }

  @Override
  @Nullable
  public SparqlNil getNil() {
    return findChildByClass(SparqlNil.class);
  }

  @Override
  @Nullable
  public SparqlNumericLiteral getNumericLiteral() {
    return findChildByClass(SparqlNumericLiteral.class);
  }

  @Override
  @Nullable
  public SparqlRDFLiteral getRDFLiteral() {
    return findChildByClass(SparqlRDFLiteral.class);
  }

}
