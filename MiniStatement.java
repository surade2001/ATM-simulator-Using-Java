package bank.management.system;

import javax.swing.*;
import java.sql.*;


public class MiniStatement extends JFrame {
    
    String pin;
    
    public MiniStatement(String pin) {
        setTitle("Mini Statement");
        this.pin = pin;
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin='" + pin + "'");
            while (rs.next()){
                card.setText("Card :" + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pin + "'");
            while(rs.next()){
            mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        JLabel lblbal=new JLabel();
        lblbal.setBounds(20,400,300,20);
        add(lblbal);
        
        int bal = 0;
        try {
            Conn conn=new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='"+this.pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));

                }
            }
            lblbal.setText("Total Balance ="+bal);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setLayout(null);
        setSize(400, 500);
        setLocation(20, 20);
        setVisible(true);
    }
    
}
