package language.editor;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import language.psi.*;
import org.jetbrains.annotations.NotNull;
import static language.psi.SparqlTypes.IRIREF;

public class SparqlPrefixAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        // annotate prefixedname, if prefix hasn't been declared within the query
        if (element instanceof SparqlPrefixedName){
            SparqlPrefixedName prefixedName = (SparqlPrefixedName) element;
            if (!SparqlPsiImplUtil.getPrefixMapping(prefixedName).getNsPrefixMap().containsKey(prefixedName.getPrefix())) {
                holder.newAnnotation(
                        HighlightSeverity.WEAK_WARNING, "The prefix hasn't been declared within the query.")
                        .withFix(new SparqlCreatePrefixDeclQuickFix(prefixedName.getPrefix()))
                        .create();
            }
        }

        // annotate iri, if iri can be shortened with a prefix
        // SparqlIri is already excluding Iris in Prologue
        if (element instanceof SparqlIri && element.getNode().getChildren(TokenSet.create(IRIREF)).length == 1) {
            String iri = element.getNode().getChildren(TokenSet.create(IRIREF))[0].getText().replaceAll("[<\\>]","");
            String prefixed = SparqlPsiImplUtil.getPrefixMapping(element).qnameFor(iri);

            if (prefixed != null) {
                holder.newAnnotation(
                        HighlightSeverity.WEAK_WARNING, "The IRI can be shortened by " + prefixed + "."
                )
                        .create();
            }

        }

    }

}
