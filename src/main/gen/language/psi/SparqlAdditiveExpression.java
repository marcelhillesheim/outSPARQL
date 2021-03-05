// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlAdditiveExpression extends PsiElement {

  @NotNull
  List<SparqlMultiplicativeExpression> getMultiplicativeExpressionList();

  @NotNull
  List<SparqlNumericLiteralNegative> getNumericLiteralNegativeList();

  @NotNull
  List<SparqlNumericLiteralPositive> getNumericLiteralPositiveList();

}
