// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlPrimaryExpression extends PsiElement {

  @Nullable
  SparqlBooleanLiteral getBooleanLiteral();

  @Nullable
  SparqlBrackettedExpression getBrackettedExpression();

  @Nullable
  SparqlBuiltInCall getBuiltInCall();

  @Nullable
  SparqlNumericLiteral getNumericLiteral();

  @Nullable
  SparqlRDFLiteral getRDFLiteral();

  @Nullable
  SparqlVar getVar();

  @Nullable
  SparqlIriOrFunction getIriOrFunction();

}
