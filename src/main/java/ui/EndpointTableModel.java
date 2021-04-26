package ui;

import settings.SparqlAppSettingsManager;
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
        switch (columnIndex) {
            case 0:
                tableData.get(rowIndex).settingUnit.setName((String) value);
                break;
            case 1:
                tableData.get(rowIndex).settingUnit.setUrl((String) value);
                break;
        }
    }

    void addRow() {
        SparqlEndpointSettings endpointSettings = new SparqlEndpointSettings();
        SparqlAppSettingsManager.getInstance().endpointSettingsList.add(endpointSettings);
        tableData.add(new RowData<>(endpointSettings));
        fireTableDataChanged();
    }

}
