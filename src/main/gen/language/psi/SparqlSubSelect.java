// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlSubSelect extends PsiElement {

  @NotNull
  SparqlSelectClause getSelectClause();

  @NotNull
  SparqlSolutionModifier getSolutionModifier();

  @NotNull
  SparqlValuesClause getValuesClause();

  @NotNull
  SparqlWhereClause getWhereClause();

}
