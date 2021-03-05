// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlSelectQuery extends PsiElement {

  @NotNull
  List<SparqlDatasetClause> getDatasetClauseList();

  @NotNull
  SparqlSolutionModifier getSolutionModifier();

  @NotNull
  List<SparqlVar> getVarList();

  @NotNull
  SparqlWhereClause getWhereClause();

}
