package ui;

import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EndpointTableModel extends AbstractTableModel {
    private static class RowData {
        SparqlEndpointSettings endpointSettings;

        RowData(SparqlEndpointSettings endpointSettings) {
            this.endpointSettings = endpointSettings;
        }
    }

    private final String[] columnNames = {"Name", "URL"};
    private final List<RowData> tableData;

    public EndpointTableModel(List<SparqlEndpointSettings> endpointSettingsList) {
        tableData = endpointSettingsList.stream()
                .map(RowData::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SparqlEndpointSettings endpointSettings = tableData.get(rowIndex).endpointSettings;
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
                tableData.get(rowIndex).endpointSettings.setName((String) value);
                break;
            case 1:
                tableData.get(rowIndex).endpointSettings.setUrl((String) value);
                break;
        }
    }

    void addRow() {
        SparqlEndpointSettings endpointSettings = new SparqlEndpointSettings();
        SparqlAppSettingsManager.getInstance().endpointSettingsList.add(endpointSettings);
        tableData.add(new RowData(endpointSettings));
        fireTableDataChanged();
    }

    void removeRows(int[] selectedRows) {
        Arrays.sort(selectedRows);
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            SparqlAppSettingsManager.getInstance().endpointSettingsList.remove(tableData.get(selectedRows[i]).endpointSettings);
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
