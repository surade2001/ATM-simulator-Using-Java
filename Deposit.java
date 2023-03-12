package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;

public class Deposit extends JFrame implements ActionListener,KeyListener {
    
    JTextField tfamt;
    JButton btndeposit, btnback;
    String pin;
    
    Deposit(String pin) {
        
        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setBounds(150, 280, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);
        
        tfamt = new JTextField();
        tfamt.setFont(new Font("Raleway", Font.BOLD, 20));
        tfamt.addKeyListener(this);
        tfamt.setBounds(150, 330, 300, 30);
        image.add(tfamt);
        
        btndeposit = new JButton("Deposit");
        btndeposit.setBounds(330, 463, 130, 30);
        btndeposit.addActionListener(this);
        image.add(btndeposit);
        
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
        }
        else if(ae.getSource()==btndeposit){
        String amt=tfamt.getText().toString();
        Date date=new Date();
        if(amt.isBlank()){
        JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
        }
        else{
        Conn conn=new Conn();
            try {
                String query="insert into bank values ('"+pin+"','"+date+"','Deposit','"+amt+"')";
               int r= conn.s.executeUpdate(query);
               if(r==1){
               JOptionPane.showMessageDialog(null, "Rs "+amt+" Deposited Sucessfullly");
                   setVisible(false);
                   new Transactions(pin).setVisible(true);
               }
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
        }
    }
 @Override
    public void keyTyped(KeyEvent evt) {
         char c=evt.getKeyChar();
        if(!Character.isDigit(c)){

            evt.consume();
    }
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
   

   
}
