package ui;

import settings.SparqlAppSettingsManager;
import settings.SparqlPrefixSettings;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrefixTableModel extends AbstractTableModel {
    private static class RowData {
        SparqlPrefixSettings prefixSettings;

        RowData(SparqlPrefixSettings prefixSettings) {
            this.prefixSettings = prefixSettings;
        }
    }

    private final String[] columnNames = {"Prefix", "IRI", "Known"};
    private final List<RowData> tableData;

    public PrefixTableModel(List<SparqlPrefixSettings> prefixSettingsList) {
        tableData = prefixSettingsList.stream()
                .map(RowData::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SparqlPrefixSettings prefixSettings = tableData.get(rowIndex).prefixSettings;
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
        switch (columnIndex) {
            case 0:
                tableData.get(rowIndex).prefixSettings.setPrefix((String) value);
            case 1:
                tableData.get(rowIndex).prefixSettings.setIri((String) value);
            case 2:
                if (value instanceof Boolean) {
                    tableData.get(rowIndex).prefixSettings.setStandard((Boolean) value);
                }
        }
    }

    void addRow() {
        SparqlPrefixSettings prefixSettings = new SparqlPrefixSettings();
        SparqlAppSettingsManager.getInstance().prefixSettingsList.add(prefixSettings);
        tableData.add(new RowData(prefixSettings));
        fireTableDataChanged();
    }

    void removeRows(int[] selectedRows) {
        Arrays.sort(selectedRows);
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            tableData.remove(selectedRows[i]);
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
}
