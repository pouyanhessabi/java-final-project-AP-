import javax.swing.*;
import java.awt.*;


public class CenterPanel extends JPanel {
    JLabel jLabel=new JLabel();
    JButton jButton=new JButton();
    public CenterPanel() {
        this.add(jLabel);
        this.setLayout(new FlowLayout());

    }
}
