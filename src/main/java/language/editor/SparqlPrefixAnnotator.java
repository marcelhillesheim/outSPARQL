package language.editor;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import language.psi.SparqlPrefixedName;
import language.psi.SparqlPsiImplUtil;
import org.jetbrains.annotations.NotNull;

public class SparqlPrefixAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        // mark prefixedname, if prefix hasn't been declared within the query
        if (element instanceof SparqlPrefixedName){
            SparqlPrefixedName prefixedName = (SparqlPrefixedName) element;
            if (!SparqlPsiImplUtil.getPrefixMapping(prefixedName).getNsPrefixMap().containsKey(prefixedName.getPrefix())) {
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "The prefix hasn't been declared within the query.").create();
            }
        }
    }

}
