package Client.Interface;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    final Mainframe mainframe;
    final static int W = 400, H = 600;
    JLabel countryLabel;
    JTextField countryField;
    JLabel stateLabel;
    JTextField stateField;
    JLabel cityLabel;
    JTextField cityField;



    public FormPanel(Mainframe mainframe) {
        this.mainframe = mainframe;
        init();
    }
    void init(){
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        setLayout(new GridLayout(0,2));
        countryLabel = new JLabel("Country:" );
        countryField = new JTextField("Some country");
        countryField.setSize(new Dimension(W/10,H/10));
        stateLabel = new JLabel("State:");
        stateField = new JTextField("Some state");
        cityLabel = new JLabel("City:");
        cityField = new JTextField("Some city");
        add(countryLabel);
        add(countryField);
        add(stateLabel);
        add(stateField);
        add(cityLabel);
        add(cityField);
    }
}
