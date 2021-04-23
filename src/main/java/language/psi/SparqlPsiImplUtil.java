package language.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import org.apache.jena.shared.PrefixMapping;
import settings.SparqlSettingsUtil;

import java.util.Collection;

import static language.psi.SparqlTypes.*;

public class SparqlPsiImplUtil {
    public static String getPrefix(SparqlPrefixedName element) {
        return element.getText().split(":",2)[0];
    }

    /**
     *
     * @param element any PsiElement within a SPARQL query
     * @return jena PrefixMapping with Prefixes extracted from query itself and common prefixes defined by the user via settings
     */
    public static PrefixMapping getPrefixMapping(PsiElement element) {
        PrefixMapping prefixMapping = PrefixMapping.Factory.create();
        PsiElement root = element.getContainingFile().getNode().getPsi();
        Collection<SparqlPrefixDecl> prefixDecls = PsiTreeUtil.findChildrenOfType(root, SparqlPrefixDecl.class);
        for (SparqlPrefixDecl prefixDecl : prefixDecls) {
            if (!PsiTreeUtil.hasErrorElements(prefixDecl)) {
                prefixMapping.setNsPrefix(
                    prefixDecl.getNode().getChildren(TokenSet.create(PNAME_NS))[0].getText().replace(":",""),
                    prefixDecl.getNode().getChildren(TokenSet.create(IRIREF))[0].getText().replaceAll("[<\\>]","")
                );
            }
        }
        SparqlSettingsUtil.addCommonPrefixes(prefixMapping);

        return prefixMapping;
    }
}
