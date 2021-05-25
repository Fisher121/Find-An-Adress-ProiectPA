package Client.Interface;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Mainframe extends JFrame {
    ConfigPanel configPanel;
    FormPanel formPanel;
    ResultPanel resultPanel;
    ControlPanel controlPanel;
    public ResourceBundle message;
    public Mainframe(){
        super("Correct an Address");
        message = ResourceBundle.getBundle("Messages", Locale.getDefault());
        init();
    }
    void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        configPanel = new ConfigPanel(this);
        formPanel = new FormPanel(this);
        resultPanel = new ResultPanel(this);
        controlPanel = new ControlPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(formPanel,BorderLayout.WEST);
        add(resultPanel,BorderLayout.EAST);
        add(controlPanel,BorderLayout.SOUTH);

        pack();
    }
}
