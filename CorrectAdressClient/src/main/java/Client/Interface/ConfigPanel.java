package Client.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

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
        languages.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Locale locale;
                String selected = (String) languages.getSelectedItem();
                switch (selected){
                    case "Romanian":
                        locale = new Locale("ro","RO");
                        break;
                    case "French":
                        locale = new Locale("fr","FR");
                        break;
                    case "Spanish":
                        locale = new Locale("es","ES");
                        break;
                    case "German":
                        locale = new Locale("de","DE");
                        break;
                    case "Italian":
                        locale = new Locale("it","IT");
                        break;
                    default:
                        locale = Locale.getDefault();
                        break;
                }
                mainframe.message = ResourceBundle.getBundle("Messages",locale);
                mainframe.formPanel.countryLabel.setText(mainframe.message.getString("country"));
                mainframe.formPanel.cityLabel.setText(mainframe.message.getString("city"));
                mainframe.formPanel.stateLabel.setText(mainframe.message.getString("state"));
                mainframe.resultPanel.result.setText(mainframe.message.getString("result"));
                mainframe.configPanel.languageLabel.setText(mainframe.message.getString("language"));
                mainframe.controlPanel.submit.setText(mainframe.message.getString("submit"));
                mainframe.repaint();



            }
        });


        add(languageLabel);
        add(languages);
    }
}
