// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlRelationalExpression extends PsiElement {

  @Nullable
  SparqlExpressionList getExpressionList();

  @NotNull
  List<SparqlNumericExpression> getNumericExpressionList();

}
