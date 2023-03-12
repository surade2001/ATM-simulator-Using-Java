package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JLabel lblbalance;
    JButton btnback;
    String pin;

    public BalanceEnquiry(String pin) {
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Total Balance");
        text.setBounds(250, 300, 150, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);
        Conn conn = new Conn();
        int bal = 0;
        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+this.pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));

                }
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

        lblbalance = new JLabel("Rs="+bal);
        lblbalance.setBounds(260, 330, 150, 30);
        lblbalance.setForeground(Color.white);
        lblbalance.setFont(new Font("System", Font.BOLD, 15));
        image.add(lblbalance);

        btnback = new JButton("Back");
        btnback.setBounds(330, 491, 130, 30);
        btnback.addActionListener(this);
        image.add(btnback);
        
        setLayout(null);
        setLocation(550, 50);
        setSize(800, 800);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnback){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
}
