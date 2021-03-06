package settings;

public class SparqlPrefixSettings {
    private String prefix = "";
    private String iri = "";
    private Boolean isStandard = Boolean.FALSE;

    public SparqlPrefixSettings () {

    }
    public SparqlPrefixSettings (String prefix, String iri, Boolean isStandard) {
        this.prefix = prefix;
        this.iri = iri;
        this.isStandard = isStandard;
    }


    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getIri() {
        return iri;
    }

    public void setIri(String iri) {
        this.iri = iri;
    }

    public Boolean getStandard() {
        return isStandard;
    }

    public void setStandard(Boolean standard) {
        isStandard = standard;
    }
}
