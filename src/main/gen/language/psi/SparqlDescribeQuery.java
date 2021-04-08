// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlDescribeQuery extends PsiElement {

  @NotNull
  List<SparqlDatasetClause> getDatasetClauseList();

  @Nullable
  SparqlSolutionModifier getSolutionModifier();

  @NotNull
  List<SparqlVarOrIri> getVarOrIriList();

  @Nullable
  SparqlWhereClause getWhereClause();

}
