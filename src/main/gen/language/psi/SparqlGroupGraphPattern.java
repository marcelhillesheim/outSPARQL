// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlGroupGraphPattern extends PsiElement {

  @NotNull
  List<SparqlFilter> getFilterList();

  @NotNull
  List<SparqlGraphPatternNotTriples> getGraphPatternNotTriplesList();

  @NotNull
  List<SparqlTriplesBlock> getTriplesBlockList();

}
