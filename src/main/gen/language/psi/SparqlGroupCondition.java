// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlGroupCondition extends PsiElement {

  @Nullable
  SparqlBuiltInCall getBuiltInCall();

  @Nullable
  SparqlExpression getExpression();

  @Nullable
  SparqlFunctionCall getFunctionCall();

  @Nullable
  SparqlVar getVar();

}
