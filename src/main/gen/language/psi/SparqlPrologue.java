// This is a generated file. Not intended for manual editing.
package language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SparqlPrologue extends PsiElement {

  @Nullable
  SparqlBaseDecl getBaseDecl();

  @NotNull
  List<SparqlPrefixDecl> getPrefixDeclList();

}
