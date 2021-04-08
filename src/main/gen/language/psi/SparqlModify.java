// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlModify extends PsiElement {

  @Nullable
  SparqlDeleteClause getDeleteClause();

  @NotNull
  SparqlGroupGraphPattern getGroupGraphPattern();

  @Nullable
  SparqlInsertClause getInsertClause();

  @NotNull
  List<SparqlUsingClause> getUsingClauseList();

  @Nullable
  SparqlIri getIri();

}
