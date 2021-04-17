package ui;

import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;

// used code from mybatis-builder as guide


public class SparqlEndpointSettingsDialog {
    private JPanel rootPanel;
    private JList<SparqlEndpointSettings> endpointList;
    private JTextField nameTextField;
    private JTextField urlTextField;
    private JButton addButton;
    private JButton removeButton;

    private final SparqlAppSettingsManager settings;

    public SparqlEndpointSettingsDialog(){
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();

        // fill list with stored endpoint settings
        DefaultListModel<SparqlEndpointSettings> listModel = new DefaultListModel<>();
        for (SparqlEndpointSettings endpointSettings : settings.endpointSettingsList) {
            listModel.addElement(endpointSettings);
        }
        endpointList.setModel(listModel);
        if (listModel.getSize() > 0) {
            endpointList.setSelectedIndex(0);
        }

        // add listeners
        addButton.addActionListener(e -> doAdd());
        removeButton.addActionListener(e -> doRemove());
        endpointList.addListSelectionListener(e -> doSelect());
    }




    private void doAdd(){
        SparqlEndpointSettings sparqlEndpointSettings = new SparqlEndpointSettings("new");
        settings.endpointSettingsList.add(sparqlEndpointSettings);
        DefaultListModel<SparqlEndpointSettings> model = (DefaultListModel<SparqlEndpointSettings>) endpointList.getModel();
        model.addElement(sparqlEndpointSettings);
        endpointList.setSelectedIndex(model.indexOf(sparqlEndpointSettings));
    }

    private void doRemove() {
        int selectedIndex = endpointList.getSelectedIndex();
        if (selectedIndex < 0){
            return;
        }
        settings.endpointSettingsList.remove(endpointList.getModel().getElementAt(selectedIndex));
        ((DefaultListModel<SparqlEndpointSettings>) endpointList.getModel()).remove(selectedIndex);

        if (endpointList.getModel().getSize() > selectedIndex) {
            endpointList.setSelectedIndex(selectedIndex);
        } else if (selectedIndex > 0) {
            endpointList.setSelectedIndex(selectedIndex - 1);
        }

    }

    private void doSelect() {
        SparqlEndpointSettings selected = endpointList.getSelectedValue();
        if (selected == null) {
            return;
        }
        fillFields(selected);
    }

    private void fillFields(SparqlEndpointSettings data) {
        nameTextField.setText(data.getName());
        urlTextField.setText(data.getUrl());
    }


    // methods for configurable
    public void apply() {
        SparqlEndpointSettings selected = endpointList.getSelectedValue();
        selected.setName(nameTextField.getText());
        selected.setUrl(urlTextField.getText());
    }

    public void reset() {
        SparqlEndpointSettings selected = endpointList.getSelectedValue();
        if (selected == null) {
            return;
        }
        fillFields(selected);
    }

    public boolean isModified(){
        SparqlEndpointSettings selected = endpointList.getSelectedValue();

        if (selected == null) {
            return false;
        }

        boolean modified = !nameTextField.getText().equals(selected.getName());
        modified |= !urlTextField.getText().equals(selected.getUrl());

        return modified;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
