package language;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import language.psi.SparqlFile;
import language.psi.SparqlPrefixDecl;

public class SparqlElementFactory {

    public static SparqlPrefixDecl createPrefixDecl(Project project, String prefix) {
        final SparqlFile file = createFile(project, "PREFIX " + prefix +": <>");
        return PsiTreeUtil.findChildOfType(file, SparqlPrefixDecl.class);
    }

    public static SparqlFile createFile(Project project, String text) {
        String name = "dummy.sparql";
        return (SparqlFile) PsiFileFactory.getInstance(project).createFileFromText(name, SparqlFileType.INSTANCE, text);
    }
}
