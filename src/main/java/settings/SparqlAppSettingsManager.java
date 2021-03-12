package settings;


import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
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
//TODO remove 2. Had to change cause the original file got compromised
@State(
        name = "SparqlAppSettings",
        storages = {@Storage("SparqlPluginAppSettings.xml")}
)
public class SparqlAppSettingsManager implements PersistentStateComponent<SparqlAppSettingsManager> {

    public List<SparqlEndpointSettings> endpointSettings = new ArrayList<>();

    public static SparqlAppSettingsManager getInstance() {
        return ServiceManager.getService(SparqlAppSettingsManager.class);
    }


    @Nullable
    @Override
    public SparqlAppSettingsManager getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull SparqlAppSettingsManager state) {
        XmlSerializerUtil.copyBean(state, this);
    }



}