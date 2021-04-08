// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlAskQuery extends PsiElement {

  @NotNull
  List<SparqlDatasetClause> getDatasetClauseList();

  @Nullable
  SparqlSolutionModifier getSolutionModifier();

  @Nullable
  SparqlWhereClause getWhereClause();

}
