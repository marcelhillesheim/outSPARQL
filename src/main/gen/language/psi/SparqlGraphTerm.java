// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlGraphTerm extends PsiElement {

  @Nullable
  SparqlBlankNode getBlankNode();

  @Nullable
  SparqlBooleanLiteral getBooleanLiteral();

  @Nullable
  SparqlIRIref getIRIref();

  @Nullable
  SparqlNil getNil();

  @Nullable
  SparqlNumericLiteral getNumericLiteral();

  @Nullable
  SparqlRDFLiteral getRDFLiteral();

}
