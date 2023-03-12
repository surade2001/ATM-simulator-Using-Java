package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton btndeposit, btncashwithdrawl, btnfastcash, btnministatement, btnbalancenquiry, btnpinchange, btnexit ;
    String pin;

    Transactions(String pin) {

        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(190, 270, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        btndeposit = new JButton("Deposit");
        btndeposit.setBounds(138, 400, 130, 30);
        btndeposit.addActionListener(this);
        image.add(btndeposit);

        btncashwithdrawl = new JButton("Cash Withdrawl");
        btncashwithdrawl.setBounds(330, 400, 130, 30);
        btncashwithdrawl.addActionListener(this);
        image.add(btncashwithdrawl);

        btnfastcash = new JButton("Fast Cash");
        btnfastcash.setBounds(138, 431, 130, 30);
        btnfastcash.addActionListener(this);
        image.add(btnfastcash);

        btnministatement = new JButton("Mini Statement");
        btnministatement.setBounds(330, 431, 130, 30);
        btnministatement.addActionListener(this);
        image.add(btnministatement);

        btnbalancenquiry = new JButton("Balance Enquiry");
        btnbalancenquiry.setBounds(330, 461, 130, 30);
        btnbalancenquiry.addActionListener(this);
        image.add(btnbalancenquiry);

        btnpinchange = new JButton("Pin Change");
        btnpinchange.setBounds(138, 461,130, 30);
        btnpinchange.addActionListener(this);
        image.add(btnpinchange);

        btnexit = new JButton("Exit");
        btnexit.setBounds(330, 491, 130, 30);
        btnexit.addActionListener(this);
        image.add(btnexit);
        
        

        setSize(800, 800);
        setLocation(550, 50);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == btnexit){
            System.exit(0);
        }
            else if(ae.getSource()==btndeposit){
                setVisible(false);
                new Deposit(pin).setVisible(true);
                
                    }
            else if(ae.getSource()==btncashwithdrawl){
            setVisible(false);
            new Withdrawl(pin).setVisible(true);
            }
         else if(ae.getSource()==btnfastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
         }
         else if(ae.getSource()==btnpinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
         }
         else if(ae.getSource()==btnbalancenquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
         }
         else{
         new MiniStatement(pin).setVisible(true);
         } 
    }
}