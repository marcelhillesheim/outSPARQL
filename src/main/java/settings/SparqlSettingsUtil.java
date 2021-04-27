package settings;

import org.apache.jena.shared.PrefixMapping;

public class SparqlSettingsUtil {

    //TODO cleanup
    public static PrefixMapping getStoredPrefixes() {
        PrefixMapping prefixMapping = PrefixMapping.Factory.create();
        for (SparqlPrefixSettings prefixSettings : SparqlAppSettingsManager.getInstance().prefixSettingsList) {
                prefixMapping.setNsPrefix(prefixSettings.getPrefix(), prefixSettings.getIri());
        }
        return prefixMapping;
    }

    public static PrefixMapping getStandardPrefixes() {
        PrefixMapping prefixMapping = PrefixMapping.Factory.create();
        addStandardPrefixes(prefixMapping);
        return prefixMapping;
    }

    /**
     * Adds common prefixes defined by the user via settings
     * @param prefixMapping which should be extended by the common prefixes
     * @return prefixMapping with common prefixes added
     */
    public static PrefixMapping addStandardPrefixes(PrefixMapping prefixMapping) {
        for (SparqlPrefixSettings prefixSettings : SparqlAppSettingsManager.getInstance().prefixSettingsList) {
            // add prefix if prefix hasn't been defined yet
            // also check if it is a common prefix
            if (prefixMapping.getNsPrefixURI(prefixSettings.getPrefix()) == null && prefixSettings.getStandard()) {
                prefixMapping.setNsPrefix(prefixSettings.getPrefix(), prefixSettings.getIri());
            }
        }
        return  prefixMapping;
    }

}
