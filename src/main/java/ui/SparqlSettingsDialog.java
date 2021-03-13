package ui;

import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

// used code from mybatis-builder as guide


public class SparqlSettingsDialog {
    private JPanel rootPanel;
    private JList endpointList;
    private JTextField nameTextField;
    private JTextField urlTextField;
    private JButton addButton;
    private JButton removeButton;
    private JFormattedTextField formattedTextField1;

    private SparqlAppSettingsManager settings;

    public SparqlSettingsDialog(){
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();


        // fill list with stored endpoint settings
        DefaultListModel<SparqlEndpointSettings> listModel = new DefaultListModel<>();
        for (SparqlEndpointSettings endpointSettings : settings.endpointSettingsList) {
            listModel.addElement(endpointSettings);
        }
        endpointList.setModel(listModel);



        // add listeners
        addButton.addActionListener(e -> doAdd());
        removeButton.addActionListener(e -> doRemove());
        endpointList.addListSelectionListener(e -> doSelect());


    }




    private void doAdd(){
        SparqlEndpointSettings sparqlEndpointSettings = new SparqlEndpointSettings("new");
        settings.endpointSettingsList.add(sparqlEndpointSettings);
        DefaultListModel model = (DefaultListModel) endpointList.getModel();
        model.addElement(sparqlEndpointSettings);
    }
    private void doRemove() {
        int selectedIndex = endpointList.getSelectedIndex();
        if (selectedIndex < 0){
            return;
        }
        settings.endpointSettingsList.remove(endpointList.getModel().getElementAt(selectedIndex));
        ((DefaultListModel) endpointList.getModel()).remove(selectedIndex);
    }

    private void doSelect() {
        SparqlEndpointSettings selected = (SparqlEndpointSettings) endpointList.getSelectedValue();
        if (selected == null) {
            return;
        }
        fillFields(selected);
    }

    private void fillFields(SparqlEndpointSettings data) {
        nameTextField.setText(data.getName());
        urlTextField.setText(data.getUrl());
    }


    // methods for configureable
    public void apply() {
        SparqlEndpointSettings selected = (SparqlEndpointSettings) endpointList.getSelectedValue();
        selected.setName(nameTextField.getText());
        selected.setUrl(urlTextField.getText());
    }

    public boolean isModified(){
        SparqlEndpointSettings selected = (SparqlEndpointSettings) endpointList.getSelectedValue();

        if (selected == null) {
            return false;
        }

        boolean modified = false;
        modified |= !nameTextField.getText().equals(selected.getName());
        modified |= !urlTextField.getText().equals(selected.getUrl());

        // modified |= !(Integer.parseInt(timeout.getText())==mConfig.getTimeout());
        return modified;

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

}
