package settings;

public class SparqlEndpointSettings {

    private String name;
    private String url;

    public SparqlEndpointSettings() {

    }

    public SparqlEndpointSettings(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
