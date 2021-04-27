package ui;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  model for settings, which can be displayed via a table.
 */

public abstract class SettingsTableModel<T> extends AbstractTableModel {
    protected static class RowData<T> {
        T settingUnit;

        RowData(T settingUnit) {
            this.settingUnit = settingUnit;
        }
    }

    protected final List<RowData<T>> tableData;
    protected String[] columnNames;
    protected List<T> settingsList;

    public SettingsTableModel(List<T> settingsList, String[] columnNames) {
        this.settingsList = settingsList;
        this.columnNames = columnNames;
        tableData = settingsList.stream()
                .map(RowData<T>::new)
                .collect(Collectors.toList());
    }

    public abstract T createSettingUnit ();

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return tableData.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    public void addRow() {
        T settingUnit = createSettingUnit();
        settingsList.add(settingUnit);
        tableData.add(new RowData<>(settingUnit));
        fireTableDataChanged();
    }

    public void removeRows(int[] selectedRows) {
        Arrays.sort(selectedRows);
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            settingsList.remove(tableData.get(selectedRows[i]).settingUnit);
            tableData.remove(selectedRows[i]);
        }
        fireTableDataChanged();
    }

}
