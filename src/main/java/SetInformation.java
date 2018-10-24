import Hibernate.HibernateUtil;
import Hibernate.Records;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class SetInformation {
    public void table() {

        Color green = new Color(133, 147, 49);
        Color orange = new Color(254, 151, 44);
        Color beige = new Color(240, 232, 220);

        JFrame frame2 = new JFrame("Registry");
        frame2.setBackground(beige);

        final JTable table = new JTable();

        Object[] columns = {"Id", "Meno preberajúceho", "Tovar", "Počet kusov", "Krajina pôvodu"};
        final DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        table.setModel(model);


        table.setBackground(beige);
        table.setForeground(green);
        Font font = new Font("Century Gothic", 1, 22);
        table.setFont(font);
        table.setRowHeight(30);

        final JLabel lblName = new JLabel();
        final JTextField textName = new JTextField();
        final JLabel lblComposition = new JLabel();
        final JTextField textComposition = new JTextField();
        final JLabel lblPrice = new JLabel();
        final JTextField textPrice = new JTextField();
        final JLabel lblVolume = new JLabel();
        final JTextField textVolume = new JTextField();
        final JLabel lblType = new JLabel();


        final JLabel lblActive = new JLabel();


        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");

        btnAdd.setBackground(green);
        btnAdd.setForeground(Color.white);

        btnUpdate.setBackground(green);
        btnUpdate.setForeground(Color.white);

        btnDelete.setBackground(orange);
        btnDelete.setForeground(Color.white);

        lblName.setForeground(green);
        lblComposition.setForeground(green);
        lblPrice.setForeground(green);
        lblVolume.setForeground(green);
        lblActive.setForeground(green);
        lblType.setForeground(green);

        lblName.setText("Meno preberajúceho : ");
        lblComposition.setText("Tovar : ");
        lblPrice.setText("Počet kusov : ");
        lblVolume.setText("Krajina pôvodu : ");


        lblName.setBounds(20, 220, 140, 25);
        textName.setBounds(150, 220, 170, 25);

        lblComposition.setBounds(20, 250, 80, 25);
        textComposition.setBounds(150, 250, 170, 25);

        lblPrice.setBounds(320, 220, 80, 25);
        textPrice.setBounds(430, 220, 60, 25);

        lblVolume.setBounds(320, 250, 120, 25);
        textVolume.setBounds(430, 250, 60, 25);

        lblActive.setBounds(480, 220, 80, 25);


        lblType.setBounds(480, 250, 80, 25);


        btnAdd.setBounds(700, 220, 100, 25);
        btnUpdate.setBounds(700, 250, 100, 25);
        btnDelete.setBounds(700, 280, 100, 25);

        // create JScrollPane
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 880, 200);
        pane.setBackground(beige);

        frame2.setLayout(null);

        frame2.add(pane);

        // add JTextFields to the jframe
        frame2.add(lblName);
        frame2.add(lblActive);
        frame2.add(lblComposition);
        frame2.add(lblPrice);
        frame2.add(lblType);
        frame2.add(lblVolume);

        frame2.add(textName);

        frame2.add(textComposition);
        frame2.add(textPrice);

        frame2.add(textVolume);


        frame2.add(btnAdd);
        frame2.add(btnDelete);
        frame2.add(btnUpdate);

        frame2.setBackground(beige);


        frame2.setSize(900, 400);
        frame2.setLocationRelativeTo(null);

        frame2.setVisible(true);


        final Object[] row = new Object[5];
        long id = 0;
        String name = null;
        String tovar = null;
        int pocet = 0;
        String krajina = null;







        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session se = sf.openSession();
        se.beginTransaction();
        Query qry = se.createQuery("from Records");
        List<Records> itemsInfo = (List<Records>) qry.list();
        se.getTransaction().commit();
        se.close();

        for (Records x : itemsInfo) {

            id = x.getId();
            name = x.getName();
            tovar = x.getTovar();
           pocet = x.getPocet();
           krajina = x.getKrajina();



            row[0] = id;
            row[1] = name;
            row[2] = tovar;
            row[3] = pocet;
            row[4] = krajina;

            // add row to the model
            model.addRow(row);


        }

        btnAdd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SessionFactory sf = HibernateUtil.getSessionFactory();
                Session s = sf.openSession();
                s.beginTransaction();
                Records records = new Records();

                records.setName(textName.getText());
                records.setTovar(textComposition.getText());
                records.setPocet(Integer.parseInt(textPrice.getText()));
                records.setKrajina(textVolume.getText());



                s.save(records);
                s.getTransaction().commit();
                s.close();


                JOptionPane.showMessageDialog(null, "Item "+textName.getText()+" successfully added!");
                JComponent comp = (JComponent) e.getSource();
                Window win = SwingUtilities.getWindowAncestor(comp); //get top window
                win.dispose();
                table();

            }

        });





    }


}
