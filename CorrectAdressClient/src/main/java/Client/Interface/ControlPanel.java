package Client.Interface;

import Client.api.ClientCommunicationHandler;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final Mainframe mainframe;
    JToggleButton submit;
    public ControlPanel(Mainframe mainframe) {
        this.mainframe = mainframe;
        init();
    }
    void init(){
        submit = new JToggleButton("SUBMIT");
        submit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JSONObject response = ClientCommunicationHandler.getAdress(mainframe.formPanel.cityField.getText(),mainframe.formPanel.stateField.getText(),mainframe.formPanel.countryField.getText());
                        for(String key : response.keySet()){
                            mainframe.resultPanel.addLine(mainframe.message.getString(key) + " : " + response.get(key));
                        }
                    }
                }
        );
        add(submit);
    }
}
