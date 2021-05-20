package Client.Interface;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    ConfigPanel configPanel;
    FormPanel formPanel;
    ResultPanel resultPanel;
    ControlPanel controlPanel;
    public Mainframe(){
        super("Correct an Address");
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
