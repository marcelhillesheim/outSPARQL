// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlConstructQuery extends PsiElement {

  @Nullable
  SparqlConstructTemplate getConstructTemplate();

  @NotNull
  List<SparqlDatasetClause> getDatasetClauseList();

  @Nullable
  SparqlSolutionModifier getSolutionModifier();

  @Nullable
  SparqlTriplesTemplate getTriplesTemplate();

  @Nullable
  SparqlWhereClause getWhereClause();

}
