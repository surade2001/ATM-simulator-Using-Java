package bank.management.system;

 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
 
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener, KeyListener {

    JTextField tfamt;
    JButton btnwitdraw, btnback;
    String pin;

    Withdrawl(String pin) {

        this.pin = pin;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 800);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(150, 280, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 15));
        image.add(text);

        tfamt = new JTextField();
        tfamt.setFont(new Font("Raleway", Font.BOLD, 20));
        tfamt.addKeyListener(this);
        tfamt.setBounds(150, 330, 300, 30);
        image.add(tfamt);

        btnwitdraw = new JButton("Withdraw");
        btnwitdraw.setBounds(330, 463, 130, 30);
        btnwitdraw.addActionListener(this);
        image.add(btnwitdraw);

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
        } else if (ae.getSource() == btnwitdraw) {
            String amt = tfamt.getText().toString();
            Date date = new Date();
            if (amt.isBlank()) {
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Withdraw");
            } else {
                Conn conn = new Conn();
                try {

                    long bal = 0;
                    ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pin + "'");
                    while (rs.next()) {

                        if (rs.getString("type").equals("Deposit")) {
                            bal += Integer.parseInt(rs.getString("amount"));

                        } else {

                            bal += Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (bal > Integer.parseInt(amt)) {
                        String query = "insert into bank values ('" + pin + "','" + date + "','Withdraw','" + amt + "')";
                        int r = conn.s.executeUpdate(query);
                        if (r == 1) {
                            JOptionPane.showMessageDialog(null, "Rs " + amt + " Withdraw Sucessfullly");
                            setVisible(false);
                            new Transactions(pin).setVisible(true);
                        }

                    } else {

                        JOptionPane.showMessageDialog(null," Insufficient Balance");
                         new Transactions(pin).setVisible(true);
                    }
                } catch (Exception e) {
                }
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {

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
