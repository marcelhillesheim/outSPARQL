// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlConstructQuery extends PsiElement {

  @NotNull
  SparqlConstructTemplate getConstructTemplate();

  @NotNull
  List<SparqlDatasetClause> getDatasetClauseList();

  @NotNull
  SparqlSolutionModifier getSolutionModifier();

  @NotNull
  SparqlWhereClause getWhereClause();

}
