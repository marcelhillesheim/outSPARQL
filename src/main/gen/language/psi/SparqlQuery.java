// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlQuery extends PsiElement {

  @Nullable
  SparqlAskQuery getAskQuery();

  @Nullable
  SparqlConstructQuery getConstructQuery();

  @Nullable
  SparqlDescribeQuery getDescribeQuery();

  @NotNull
  SparqlPrologue getPrologue();

  @Nullable
  SparqlSelectQuery getSelectQuery();

  @NotNull
  SparqlValuesClause getValuesClause();

}
