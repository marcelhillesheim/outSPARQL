package execution;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ex.CustomComponentAction;
import settings.SparqlAppSettingsManager;
import settings.SparqlEndpointSettings;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SparqlExecutionLimitSliderAction extends AnAction implements CustomComponentAction
{
    public void actionPerformed( AnActionEvent e ) {

    }

    public JComponent createCustomComponent(Presentation presentation )
    {
        SparqlAppSettingsManager settings = SparqlAppSettingsManager.getInstance();

        ArrayList<String> sliderValueToProperValue  = new ArrayList<>();
        sliderValueToProperValue.add("unmodified");
        sliderValueToProperValue.add("1");
        sliderValueToProperValue.add("5");
        sliderValueToProperValue.add("10");
        sliderValueToProperValue.add("50");
        sliderValueToProperValue.add("100");
        sliderValueToProperValue.add("500");
        sliderValueToProperValue.add("1000");
        sliderValueToProperValue.add("5000");
        sliderValueToProperValue.add("removed");

        // set minimum size according to length of the longest value
        JLabel value = new JLabel(sliderValueToProperValue.get(0));
        value.setMinimumSize(value.getPreferredSize());

        value.setText(settings.limitForExecution);

        JSlider slider = new JSlider();
        slider.setMaximum(sliderValueToProperValue.size()-1);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(1);
        slider.setValue(sliderValueToProperValue.indexOf(settings.limitForExecution));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                value.setText(sliderValueToProperValue.get(source.getValue()));
                value.setPreferredSize(value.getMinimumSize());
                settings.limitForExecution = sliderValueToProperValue.get(source.getValue());
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(new Label("Limit:"));
        panel.add(value);
        panel.add(slider);

        return panel;
    }



}