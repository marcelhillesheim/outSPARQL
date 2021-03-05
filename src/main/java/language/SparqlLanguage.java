package language;

import com.intellij.lang.Language;

public class SparqlLanguage extends Language {

    public static final SparqlLanguage INSTANCE = new SparqlLanguage();

    private SparqlLanguage() {
        super("Sparql");
    }

}