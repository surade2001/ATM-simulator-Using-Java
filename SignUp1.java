package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener {

    long random;
    JTextField tfname, tffname, tfemail, tfaddress, tfcity, tfstate, tfpincode;
    JButton btnnext;
    JRadioButton rbgenmale, rbgenfemale, rbgenothers, rb_mstatus_single, rb_mstatus_married, rb_mstatus_others;
    JDateChooser dcdob;

    SignUp1() {
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 90000L) % 10000L);

        JLabel formno = new JLabel("Application FORM NO." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(150, 20, 600, 40);
        add(formno);

        JLabel pd = new JLabel("Page 1:Personal Details");
        pd.setFont(new Font("Raleway", Font.BOLD, 22));
        pd.setBounds(250, 80, 300, 40);
        add(pd);

        JLabel lblname = new JLabel("Name:");
        lblname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblname.setBounds(100, 140, 150, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setFont(new Font("Raleway", Font.BOLD, 20));
        tfname.setBounds(260, 140, 400, 30);
        add(tfname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblfname.setBounds(100, 180, 150, 30);
        add(lblfname);

        tffname = new JTextField();
        tffname.setFont(new Font("Raleway", Font.BOLD, 20));
        tffname.setBounds(260, 180, 400, 30);
        add(tffname);

        JLabel lbldob = new JLabel("Date Of Birth:");
        lbldob.setFont(new Font("Raleway", Font.BOLD, 20));
        lbldob.setBounds(100, 220, 150, 30);
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(260, 220, 400, 30);
        dcdob.setForeground(Color.black);
        add(dcdob);

        JLabel lblgen = new JLabel("Gender:");
        lblgen.setFont(new Font("Raleway", Font.BOLD, 20));
        lblgen.setBounds(100, 260, 150, 30);
        add(lblgen);

        rbgenmale = new JRadioButton("Male");
        rbgenmale.setBounds(260, 260, 100, 30);
        rbgenmale.setBackground(Color.white);
        add(rbgenmale);

        rbgenfemale = new JRadioButton("Female");
        rbgenfemale.setBounds(380, 260, 100, 30);
        rbgenfemale.setBackground(Color.white);
        add(rbgenfemale);

        rbgenothers = new JRadioButton("Others");
        rbgenothers.setBounds(500, 260, 100, 30);
        rbgenothers.setBackground(Color.white);
        add(rbgenothers);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setFont(new Font("Raleway", Font.BOLD, 20));
        lblemail.setBounds(100, 300, 150, 30);
        add(lblemail);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(rbgenmale);
        gendergroup.add(rbgenfemale);
        gendergroup.add(rbgenothers);

        tfemail = new JTextField();
        tfemail.setFont(new Font("Raleway", Font.BOLD, 20));
        tfemail.setBounds(260, 300, 400, 30);
        add(tfemail);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 20));
        lbladdress.setBounds(100, 340, 150, 30);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setFont(new Font("Raleway", Font.BOLD, 20));
        tfaddress.setBounds(260, 340, 400, 30);
        add(tfaddress);

        JLabel lblmstatus = new JLabel("Marital Status:");
        lblmstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        lblmstatus.setBounds(100, 380, 150, 30);
        add(lblmstatus);

        rb_mstatus_single = new JRadioButton("Single");
        rb_mstatus_single.setBounds(260, 380, 100, 30);
        rb_mstatus_single.setBackground(Color.white);
        add(rb_mstatus_single);

        rb_mstatus_married = new JRadioButton("Married");
        rb_mstatus_married.setBounds(380, 380, 100, 30);
        rb_mstatus_married.setBackground(Color.white);
        add(rb_mstatus_married);

        rb_mstatus_others = new JRadioButton("Others");
        rb_mstatus_others.setBounds(500, 380, 100, 30);
        rb_mstatus_others.setBackground(Color.white);
        add(rb_mstatus_others);

        ButtonGroup mstatus_group = new ButtonGroup();
        add(rb_mstatus_single);
        add(rb_mstatus_married);
        add(rb_mstatus_others);

        JLabel lblcity = new JLabel("City:");
        lblcity.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcity.setBounds(100, 420, 150, 30);
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setFont(new Font("Raleway", Font.BOLD, 20));
        tfcity.setBounds(260, 420, 400, 30);
        add(tfcity);

        JLabel lblstate = new JLabel("State:");
        lblstate.setFont(new Font("Raleway", Font.BOLD, 20));
        lblstate.setBounds(100, 460, 150, 30);
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setFont(new Font("Raleway", Font.BOLD, 20));
        tfstate.setBounds(260, 460, 400, 30);
        add(tfstate);

        JLabel lblpincode = new JLabel("Pin Code:");
        lblpincode.setFont(new Font("Raleway", Font.BOLD, 20));
        lblpincode.setBounds(100, 500, 150, 30);
        add(lblpincode);

        tfpincode = new JTextField();
        tfpincode.setFont(new Font("Raleway", Font.BOLD, 20));
        tfpincode.setBounds(260, 500, 400, 30);
        add(tfpincode);

        btnnext = new JButton("Next");
        btnnext.setForeground(Color.white);
        btnnext.setBackground(Color.black);
        btnnext.setBounds(580, 550, 80, 30);
        btnnext.addActionListener(this);
        add(btnnext);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setSize(800, 800);
        setLocation(550, 50);
                setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = tfname.getText();
        String fname = tffname.getText();
        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (rbgenmale.isSelected()) {
            gender = "Male";
        } else if (rbgenfemale.isSelected()) {
            gender = "Female";
        } else {
            gender = "Others";
        }
        String email = tfemail.getText();
        String address = tfaddress.getText();
        String mstatus = null;
        if (rb_mstatus_married.isSelected()) {
            mstatus = "Married";
        } else if (rb_mstatus_single.isSelected()) {
            mstatus = "Single";
        } else {
            mstatus = "Others";
        }
        String city = tfcity.getText();
        String state = tfstate.getText();
        String pin = tfpincode.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else{
            Conn conn=new Conn();
            String query="insert into signup1 values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+address+"','"+mstatus+"','"+city+"','"+state+"','"+pin+"')";
            conn.s.executeUpdate(query);
            setVisible(false);
            new SignUp2(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println("e");
        }

    }

}
