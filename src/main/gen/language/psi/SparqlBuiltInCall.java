// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlBuiltInCall extends PsiElement {

  @Nullable
  SparqlAggregate getAggregate();

  @Nullable
  SparqlExistsFunc getExistsFunc();

  @Nullable
  SparqlExpression getExpression();

  @Nullable
  SparqlExpressionList getExpressionList();

  @Nullable
  SparqlNotExistsFunc getNotExistsFunc();

  @Nullable
  SparqlRegexExpression getRegexExpression();

  @Nullable
  SparqlStrReplaceExpression getStrReplaceExpression();

  @Nullable
  SparqlSubstringExpression getSubstringExpression();

  @Nullable
  SparqlVar getVar();

}
