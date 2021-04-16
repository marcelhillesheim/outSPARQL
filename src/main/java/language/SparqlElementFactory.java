package language;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import language.psi.SparqlFile;
import language.psi.SparqlPrefixDecl;
import language.psi.SparqlPrefixedName;

public class SparqlElementFactory {

    public static SparqlPrefixDecl createPrefixDecl(Project project, String prefix) {
        final SparqlFile file = createFile(project, "PREFIX " + prefix +": <>");
        return PsiTreeUtil.findChildOfType(file, SparqlPrefixDecl.class);
    }

    public static SparqlPrefixedName createPrefixedName(Project project, String prefixedName) {
        final SparqlFile file = createFile(project, "SELECT ?a WHERE {?a ?b " + prefixedName + "}");
        return PsiTreeUtil.findChildOfType(file, SparqlPrefixedName.class);
    }

    public static SparqlFile createFile(Project project, String text) {
        String name = "dummy.sparql";
        return (SparqlFile) PsiFileFactory.getInstance(project).createFileFromText(name, SparqlFileType.INSTANCE, text);
    }
}
