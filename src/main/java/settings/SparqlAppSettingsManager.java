package settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */

@State(
        name = "SparqlAppSettings",
        storages = {@Storage("SparqlPluginAppSettings.xml")}
)
public class SparqlAppSettingsManager implements PersistentStateComponent<SparqlAppSettingsManager> {

    public boolean default_prefixes_setup_v0_2_0;
    public List<SparqlEndpointSettings> endpointSettingsList = new ArrayList<>();
    public List<SparqlPrefixSettings> prefixSettingsList = new ArrayList<>();

    public SparqlEndpointSettings endpointSettingsForExecution = new SparqlEndpointSettings();
    public String limitForExecution = "unmodified";

    public static SparqlAppSettingsManager getInstance() {
        return ApplicationManager.getApplication().getService(SparqlAppSettingsManager.class);
    }

    @Nullable
    @Override
    public SparqlAppSettingsManager getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SparqlAppSettingsManager state) {
        XmlSerializerUtil.copyBean(state, this);

        // check if plugin got updated or new installation
        if (!default_prefixes_setup_v0_2_0) {
            String[][] defaultPrefixes = {
                {"rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#"},
                {"dc", "http://purl.org/dc/elements/1.1/"},
                {"foaf", "http://xmlns.com/foaf/0.1/"},
                {"rdfs", "http://www.w3.org/2000/01/rdf-schema#"},
                {"xsd", "http://www.w3.org/2001/XMLSchema#"},
                {"owl", "http://www.w3.org/2002/07/owl#"},

                {"vann", "http://purl.org/vocab/vann/"},
                {"cc", "http://web.resource.org/cc/"},
                {"vs", "http://www.w3.org/2003/06/sw-vocab-status/ns#"},

                {"wot", "http://xmlns.com/wot/0.1/"},
                {"geo", "http://www.w3.org/2003/01/geo/wgs84_pos#"}
            };
            for (String[] defaultPrefix : defaultPrefixes) {
                this.prefixSettingsList.add(new SparqlPrefixSettings(defaultPrefix[0], defaultPrefix[1], true));
            }

            this.default_prefixes_setup_v0_2_0 = true;
        }
    }
}