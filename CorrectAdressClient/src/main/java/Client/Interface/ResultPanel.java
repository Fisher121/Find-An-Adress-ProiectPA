package Client.Interface;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class ResultPanel extends JPanel{
    final Mainframe mainframe;
    final static int W = 400, H = 600;
    JLabel result;
    List<JLabel> lines;
    GridBagConstraints gbc;


    public ResultPanel(Mainframe mainframe) {
        this.mainframe = mainframe;
        lines = new LinkedList<>();
        init();
    }
    void init(){
        setPreferredSize(new Dimension(W, H));
        //setLayout(new GridLayout(0,1));

        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        setBorder(BorderFactory.createEtchedBorder());
        result = new JLabel("Result");
        add(result, gbc);
    }
    public void addLine(String str){
        JLabel label = new JLabel(str);
        add(label,gbc);
        lines.add(label);
        revalidate();
        repaint();
    }
}
