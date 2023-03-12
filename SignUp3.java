package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class SignUp3 extends JFrame implements ActionListener {

    JRadioButton rb_sa, rb_ca, rb_fda, rb_rda;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton btnsubmit, btncancel;
    String formno;

    SignUp3(String formno) {
        this.formno = formno;
        setLayout(null);
        JLabel ad = new JLabel("Page 3:Account Details");
        ad.setFont(new Font("Raleway", Font.BOLD, 22));
        ad.setBounds(250, 80, 300, 40);
        add(ad);

        JLabel lbltype = new JLabel("Account Type");
        lbltype.setBounds(100, 140, 150, 30);
        lbltype.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lbltype);

        rb_sa = new JRadioButton("Savings Account");
        rb_sa.setFont(new Font("Raleway", Font.BOLD, 16));
        rb_sa.setBackground(Color.WHITE);
        rb_sa.setBounds(100, 190, 200, 30);
        add(rb_sa);

        rb_ca = new JRadioButton("Current Account");
        rb_ca.setFont(new Font("Raleway", Font.BOLD, 16));
        rb_ca.setBackground(Color.WHITE);
        rb_ca.setBounds(350, 190, 200, 30);
        add(rb_ca);

        rb_fda = new JRadioButton("Fixed Deposit Ac");
        rb_fda.setFont(new Font("Raleway", Font.BOLD, 16));
        rb_fda.setBackground(Color.WHITE);
        rb_fda.setBounds(100, 230, 200, 30);
        add(rb_fda);

        rb_rda = new JRadioButton("Recurring Deposit Ac");
        rb_rda.setFont(new Font("Raleway", Font.BOLD, 16));
        rb_rda.setBackground(Color.WHITE);
        rb_rda.setBounds(350, 230, 200, 30);
        add(rb_rda);

        ButtonGroup ac = new ButtonGroup();
        ac.add(rb_ca);
        ac.add(rb_sa);
        ac.add(rb_fda);
        ac.add(rb_rda);

        JLabel lblcard = new JLabel("Card Number:");
        lblcard.setFont(new Font("Railway", Font.BOLD, 20));
        lblcard.setBounds(100, 280, 150, 30);
        add(lblcard);

        JLabel lblcard_desc = new JLabel("(Your 16 Digit Card Number)");
        lblcard_desc.setFont(new Font("Railway", Font.BOLD, 10));
        lblcard_desc.setBounds(100, 310, 150, 30);
        add(lblcard_desc);

        JLabel lblcard_no = new JLabel("XXXX-XXXX-XXXX-XXXX");
        lblcard_no.setFont(new Font("Railway", Font.BOLD, 16));
        lblcard_no.setBounds(350, 280, 300, 30);
        add(lblcard_no);

        JLabel lblpin = new JLabel("PIN:");
        lblpin.setFont(new Font("Railway", Font.BOLD, 20));
        lblpin.setBounds(100, 350, 150, 30);
        add(lblpin);

        JLabel lblpin_desc = new JLabel("(Your 4 Digit Password)");
        lblpin_desc.setFont(new Font("Railway", Font.BOLD, 10));
        lblpin_desc.setBounds(100, 380, 150, 30);
        add(lblpin_desc);

        JLabel lblpinno = new JLabel("XXXX");
        lblpinno.setFont(new Font("Railway", Font.BOLD, 16));
        lblpinno.setBounds(350, 350, 150, 30);
        add(lblpinno);

        JLabel lblservice = new JLabel("Services Required:");
        lblservice.setFont(new Font("Railway", Font.BOLD, 20));
        lblservice.setBounds(100, 420, 200, 30);
        add(lblservice);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Railway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        c1.setBounds(100, 470, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Railway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        c2.setBounds(350, 470, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Railway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        c3.setBounds(100, 510, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Railway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        c4.setBounds(350, 510, 200, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Railway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        c5.setBounds(100, 550, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Railway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        c6.setBounds(350, 550, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Railway", Font.BOLD, 11));
        c7.setBackground(Color.white);
        c7.setBounds(100, 620, 550, 30);
        add(c7);

        btncancel = new JButton("Cancel");
        btncancel.setFont(new Font("Railway", Font.BOLD, 11));
        btncancel.setBounds(230, 670, 100, 30);
        btncancel.setBackground(Color.black);
        btncancel.setForeground(Color.white);
        add(btncancel);

        btnsubmit = new JButton("Submit");
        btnsubmit.setFont(new Font("Railway", Font.BOLD, 11));
        btnsubmit.setBounds(380, 670, 100, 30);
        btnsubmit.setBackground(Color.black);
        btnsubmit.setForeground(Color.white);
        btnsubmit.addActionListener(this);
        add(btnsubmit);

        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(550, 50);
                setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnsubmit) {

            String account_type = null;
            if (rb_ca.isSelected()) {
                account_type = "Current Account";
            } else if (rb_sa.isSelected()) {
                account_type = "Savings Account";
            } else if (rb_fda.isSelected()) {
                account_type = "Fixed Deposit Account";
            } else if (rb_rda.isSelected()) {
                account_type = "Recurring Deposit Account";

            }
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000000000000L)) % 5043939000000000L;
            String pinnumber = "" + Math.abs((random.nextLong() % 90000L)) % 10000L;
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet Banking";
            }
            if (c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }
            if (c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            }
            if (c5.isSelected()) {
                facility = facility + " Cheque Book";
            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            try {
                if (account_type.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signup3 values('" + formno + "','" + account_type + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "Card Number:" + cardnumber + "\n Pin:" + pinnumber);
                    conn.s.executeUpdate(query2);
                }
            } catch (Exception e) {
                System.out.println(e);

            }

        } else if (ae.getSource() == btncancel) {

        }
    }

}
