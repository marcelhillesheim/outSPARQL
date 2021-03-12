package ui;

import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;

public class SparqlSettingsDialog {
    private JPanel rootPanel;
    private JList endpointList;
    private JTextField nameTextField;
    private JTextField urlTextField;
    private JButton addButton;

    private SparqlAppSettingsManager settings;

    public SparqlSettingsDialog(){
        // access settings
        this.settings = SparqlAppSettingsManager.getInstance();


        // fill list with stored endpoint settings
        DefaultListModel<SparqlEndpointSettings> listModel = new DefaultListModel<>();
        for (SparqlEndpointSettings endpointSettings : settings.endpointSettings) {
            listModel.addElement(endpointSettings);
        }
        endpointList.setModel(listModel);



        // add listeners
        addButton.addActionListener(e -> doAdd());


    }

    private void doAdd(){
        SparqlEndpointSettings sparqlEndpointSettings = new SparqlEndpointSettings("test","");
        settings.endpointSettings.add(sparqlEndpointSettings);
        DefaultListModel model = (DefaultListModel) endpointList.getModel();
        model.addElement(sparqlEndpointSettings);
    }


    public JPanel getRootPanel() {

        return rootPanel;
    }
}
