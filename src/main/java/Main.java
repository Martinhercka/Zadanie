import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("First screen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setContentPane(new Form().getFirstpanel());
        frame.setVisible(true);





    }







}
