package Client.Interface;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final Mainframe mainframe;

    JLabel languageLabel;
    JComboBox languages;

    public ConfigPanel(Mainframe mainframe) {
        this.mainframe = mainframe;
        init();
    }
    void init(){

        languageLabel = new JLabel("Language:");
        languages = new JComboBox(new String[]{"English","Romanian","Italian","Spanish","French","German"});


        add(languageLabel);
        add(languages);
    }
}
