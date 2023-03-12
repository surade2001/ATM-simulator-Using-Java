package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton btn100, btn500, btn1000, btn2000, btn5000, btn10000, btnback;
    String pin;

    FastCash(String pin) {

        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Select Withdrawl Amount"); 
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        btn100 = new JButton("Rs 100");
        btn100.setBounds(138, 400, 130, 30);
        btn100.addActionListener(this);
        image.add(btn100);

        btn500 = new JButton("Rs 500");
        btn500.setBounds(330, 400, 130, 30);
        btn500.addActionListener(this);
        image.add(btn500);

        btn1000 = new JButton("Rs 1000");
        btn1000.setBounds(138, 431, 130, 30);
        btn1000.addActionListener(this);
        image.add(btn1000);

        btn2000 = new JButton("Rs 2000"); 
        btn2000.setBounds(330, 431, 130, 30);
        btn2000.addActionListener(this);
        image.add(btn2000);

        btn5000 = new JButton("Rs 5000");
        btn5000.setBounds(330, 461, 130, 30);
        btn5000.addActionListener(this);
        image.add(btn5000);

        btn10000 = new JButton("Rs 10000");
        btn10000.setBounds(138, 461, 130, 30);
        btn10000.addActionListener(this);
        image.add(btn10000);

        btnback = new JButton("Back");
        btnback.setBounds(330, 491, 130, 30);
        btnback.addActionListener(this);
        image.add(btnback);

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
            String amt = ((JButton) ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
           
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+pin+"'");
                 long balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != btnback && balance < Integer.parseInt(amt)) {

                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else{

                    Date date = new Date();
                    String query="insert into bank values('" + pin + "','" + date + "','Withdraw','" + amt + "')";
                    int i=conn.s.executeUpdate(query);
                    if(i==1){
                    JOptionPane.showMessageDialog(null, "Rs " + amt + " Successfully Debited");
                }
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
    public static void main(String[] args) {
        new Transactions("");
     }
    }
