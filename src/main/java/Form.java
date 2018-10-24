import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    private JPanel firstpanel;
    private JLabel nadpis;
    private JButton openTableButton;


    public Form() {
        openTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetInformation information = new SetInformation();
                information.table();
            }
        });
    }

    public JPanel getFirstpanel() {
        return firstpanel;
    }
}
