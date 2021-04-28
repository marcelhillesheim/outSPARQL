package settings;

import org.apache.jena.shared.PrefixMapping;

public class SparqlSettingsUtil {

    public static PrefixMapping getStoredPrefixes() {
        return getPrefixes(false);
    }

    public static PrefixMapping getStandardPrefixes() {
        return getPrefixes(true);
    }

    private static PrefixMapping getPrefixes(Boolean onlyStandard) {
        PrefixMapping prefixMapping = PrefixMapping.Factory.create();
        for (SparqlPrefixSettings prefixSettings : SparqlAppSettingsManager.getInstance().prefixSettingsList) {
            if (!onlyStandard || prefixSettings.getStandard()) {
                prefixMapping.setNsPrefix(prefixSettings.getPrefix(), prefixSettings.getIri());
            }
        }
        return prefixMapping;
    }
}
