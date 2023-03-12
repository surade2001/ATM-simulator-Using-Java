package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener,KeyListener{
     JButton btnsignin,btnclear,btnsignup;
     JTextField tfcardno;
     JPasswordField pfpin;
     
    Login() {
        setLayout(null);
        
        setTitle("ATM Machine");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel label=new JLabel(i3);
        label.setBounds(150,10,100,100);
        add(label);
  
        JLabel txtwelcome=new JLabel("Welcome To Atm");
        txtwelcome.setBounds(280,40,400,40);
        txtwelcome.setFont(new Font("Osward",Font.BOLD,38));
        add(txtwelcome);
        
        JLabel lblcardno=new JLabel("Card No:");
        lblcardno.setFont(new Font ("Raleway",Font.BOLD,38));
        lblcardno.setBounds(180,220,200,40);
        add(lblcardno);
        
        JLabel lblpinno=new JLabel("Pin");
        lblpinno.setFont(new Font ("Raleway",Font.BOLD,38));
        lblpinno.setBounds(180,280,200,40);
        add(lblpinno);
        
        tfcardno=new JTextField();
        tfcardno.setBounds(400,220,200,40);
        tfcardno.setFont(new Font("Ariel",Font.BOLD,14));
        tfcardno.addKeyListener(this);
        add(tfcardno);
        
        pfpin=new JPasswordField();
        pfpin.setBounds(400,280,200,40);
        pfpin.setFont(new Font("Ariel",Font.BOLD,14));
        pfpin.addKeyListener(this);
        add(pfpin);
        
        btnsignin=new JButton("SIGN IN");
        btnsignin.setBounds(250,340,100,40);
        btnsignin.addActionListener(this);
                add(btnsignin);
        
        btnclear=new JButton("CLEAR");
        btnclear.setBounds(370,340,100,40);
        btnclear.addActionListener(this);
        add(btnclear);
        
        btnsignup=new JButton("SIGN UP");
        btnsignup.setBounds(290,400,160,40);
        btnsignup.addActionListener(this);
        add(btnsignup);
        
       
        
        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setVisible(true);
        setLocation(550, 50);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    
 
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==btnclear){
        tfcardno.setText("");
        pfpin.setText("");}
            else if(ae.getSource()==btnsignup){
            setVisible(false);
            new SignUp1().setVisible(true);
            }
            else if(ae.getSource()==btnsignin){
                Conn conn=new Conn();
                String cardnumber =tfcardno.getText();
                String pin=pfpin.getText();
                String query ="select * from login where cardnumber ='"+cardnumber+"' and pin='"+pin+"'";
                try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                
                    setVisible(false);
                     new Transactions(pin).setVisible(true);
                }
                else if(tfcardno.getText().isEmpty() && pfpin.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Card No. and Pin is Empty");
                }
                else if(tfcardno.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Card No. is Empty");
                }
                else if(pfpin.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Pin is Empty");
                }
                else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin ");
                }
                }
                catch(Exception e ){
                    System.out.println(e);
                }
           
            }

            }
        
        @Override
    public void keyTyped(KeyEvent e) {
        char cha=e.getKeyChar();
        if(!Character.isDigit(cha)){
        e.consume();
        }
     
    }

    @Override
    public void keyPressed(KeyEvent e) {
      
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
        
    public static void main(String[] args) {
        new Login();
    }

    
}
