package ui;

import settings.SparqlPrefixSettings;
import java.util.List;

public class PrefixTableModel extends SettingsTableModel<SparqlPrefixSettings> {

    public PrefixTableModel(List<SparqlPrefixSettings> settingsList) {
        super(settingsList, new String[]{"Prefix", "IRI", "Standard"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SparqlPrefixSettings prefixSettings = tableData.get(rowIndex).settingUnit;
        switch (columnIndex) {
            case 0:
                return prefixSettings.getPrefix();
            case 1:
                return prefixSettings.getIri();
            case 2:
                return prefixSettings.getStandard();
        }
        return "unknown value";
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        SparqlPrefixSettings prefixSettings = tableData.get(rowIndex).settingUnit;
        switch (columnIndex) {
            case 0:
                prefixSettings.setPrefix((String) value);
                break;
            case 1:
                prefixSettings.setIri((String) value);
                break;
            case 2:
                if (value instanceof Boolean) {
                    prefixSettings.setStandard((Boolean) value);
                }
                break;
        }
    }

    @Override
    public SparqlPrefixSettings createSettingUnit() {
        return new SparqlPrefixSettings();
    }
}
