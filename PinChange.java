package bank.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pfold, pfnew;
    JButton btnback, btnchange;
    String pin;

    PinChange(String pin) {

        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Enter The Old Pin");
        text.setForeground(Color.white);
        text.setBounds(230, 300, 200, 30);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        pfold = new JPasswordField();
        pfold.setBounds(250, 330, 100, 30);
        image.add(pfold);

        JLabel text2 = new JLabel("Enter The New Pin");
        text2.setForeground(Color.white);
        text2.setBounds(230, 380, 200, 30);
        text2.setFont(new Font("System", Font.BOLD, 15));
        image.add(text2);

        pfnew = new JPasswordField();
        pfnew.setBounds(250, 410, 100, 30);
        image.add(pfnew);

        btnback = new JButton("Back");
        btnback.setBounds(330, 496, 130, 30);
        btnback.addActionListener(this);
        image.add(btnback);

        btnchange = new JButton("Change");
        btnchange.setBounds(138, 496, 130, 30);
        btnchange.addActionListener(this);
        image.add(btnchange);

        setLayout(null);
        setSize(800, 800);
        setLocation(550, 50);

        setUndecorated(true);
        setVisible(true);

    }

   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnback) {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            Conn conn = new Conn();
            try {

                String oldpin = pfold.getText();
                String newpin = pfnew.getText();
                String query1 = "update login Set pin='" + newpin + "' where pin='" + oldpin + "' ";
                String query2 = "update  bank Set pin='" + newpin + "' where pin='" + oldpin + "' ";
                String query3 = "update signup3 Set pin='" + newpin + "' where pin='" + oldpin + "' ";
                int i = conn.s.executeUpdate(query1);
                int j = conn.s.executeUpdate(query2);
                int k = conn.s.executeUpdate(query3);
                if (i != 0 && j != 0 & k != 0) {     // for validation
                    JOptionPane.showMessageDialog(null, "Pin Successfully Updated");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
