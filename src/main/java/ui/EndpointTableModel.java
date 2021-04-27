package ui;

import settings.SparqlEndpointSettings;

import java.util.List;

public class EndpointTableModel extends SettingsTableModel<SparqlEndpointSettings> {


    public EndpointTableModel(List<SparqlEndpointSettings> settingsList) {
        super(settingsList, new String[]{"Name", "URL"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SparqlEndpointSettings endpointSettings = tableData.get(rowIndex).settingUnit;
        switch (columnIndex) {
            case 0:
                return endpointSettings.getName();
            case 1:
                return endpointSettings.getUrl();
        }
        return "unknown value";
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        SparqlEndpointSettings endpointSettings = tableData.get(rowIndex).settingUnit;
        switch (columnIndex) {
            case 0:
                endpointSettings.setName((String) value);
                break;
            case 1:
                endpointSettings.setUrl((String) value);
                break;
        }
    }

    @Override
    public SparqlEndpointSettings createSettingUnit() {
        return new SparqlEndpointSettings();
    }
}
