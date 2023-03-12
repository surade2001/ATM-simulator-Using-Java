
package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class SignUp2 extends JFrame implements ActionListener{

    JTextField   tfpan, tfadhar;
    JButton btnnext;
    JRadioButton rb_eac_yes, rb_eac_no,rb_sc_yes,rb_sc_no;
    JComboBox cb_rel,cb_category,cb_income,cb_qualification,cb_occupation;
    String formno;

    SignUp2(String formno) {
    
        this.formno=formno;
        setLayout(null);
        JLabel ad = new JLabel("Page 2:Additional Details");
        ad.setFont(new Font("Raleway", Font.BOLD, 22));
        ad.setBounds(250, 80, 300, 40);
        add(ad);

        JLabel lblrel = new JLabel("Religion:");
        lblrel.setFont(new Font("Raleway", Font.BOLD, 20));
        lblrel.setBounds(100, 140, 150, 30);
        add(lblrel);

        String religion[]={"Hindu","Muslim","Sikh","Christian","Others"};
        cb_rel = new JComboBox(religion);
        cb_rel.setBackground(Color.WHITE);
        cb_rel.setBounds(260, 140, 400, 30);
        add(cb_rel);

        JLabel lblcat = new JLabel("Category:");
        lblcat.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcat.setBounds(100, 180, 150, 30);
        add(lblcat);

        String category[]={"General","OBC","SC","ST","Others"};
        cb_category = new JComboBox(category);
        cb_category.setBackground(Color.WHITE);
        cb_category.setBounds(260, 180, 400, 30);
        add(cb_category);

        JLabel lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 20));
        lblincome.setBounds(100, 220, 150, 30);
        add(lblincome);

        String income[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        cb_income = new JComboBox(income);
        cb_income.setBackground(Color.WHITE);
        cb_income.setBounds(260, 220, 400, 30);
        add(cb_income);

        JLabel lblqualification = new JLabel("Qualification:");
        lblqualification.setFont(new Font("Raleway", Font.BOLD, 20));
        lblqualification.setBounds(100, 260, 150, 30);
        add(lblqualification);

        String qualification[]={"Non Graduate","Graduate","Post Graduate","Doctrate","Others"};
        cb_qualification = new JComboBox(qualification);
        cb_qualification.setBackground(Color.WHITE);
        cb_qualification.setBounds(260, 260, 400, 30);
        add(cb_qualification);
        
        

        JLabel lbloccupation = new JLabel("Occupation:");
        lbloccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        lbloccupation.setBounds(100, 300, 150, 30);
        add(lbloccupation);
        
        String occupation[]={"Salaried","Self Employed","Business","Student","Retired","Others"};
        cb_occupation = new JComboBox(occupation);
        cb_occupation.setBackground(Color.WHITE);
        cb_occupation.setBounds(260, 300, 400, 30);
        add(cb_occupation);
        

        JLabel lblpan = new JLabel("PAN No.:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 20));
        lblpan.setBounds(100, 340, 150, 30);
        add(lblpan);

        tfpan = new JTextField();
        tfpan.setFont(new Font("Raleway", Font.BOLD, 20));
        tfpan.setBounds(260, 340, 400, 30);
        add(tfpan);

        JLabel lbladdhar = new JLabel("Aadhar No.:");
        lbladdhar.setFont(new Font("Raleway", Font.BOLD, 20));
        lbladdhar.setBounds(100, 380, 150, 30);
        add(lbladdhar);

        tfadhar = new JTextField();
        tfadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        tfadhar.setBounds(260, 380, 400, 30);
        add(tfadhar);

        JLabel lblsc = new JLabel("Senior Citizen:");
        lblsc.setFont(new Font("Raleway", Font.BOLD, 20));
        lblsc.setBounds(100, 420, 150, 30);
        add(lblsc);

       rb_sc_yes=new JRadioButton ("Yes");
       rb_sc_yes.setBounds(260,420,100,30);
       rb_sc_yes.setBackground(Color.white);
       add(rb_sc_yes);
       
       rb_sc_no=new JRadioButton ("No");
       rb_sc_no.setBounds(380,420,100,30);
       rb_sc_no.setBackground(Color.white);
       add(rb_sc_no);
       
       ButtonGroup bg_sc = new ButtonGroup();
       bg_sc.add(rb_sc_yes);
       bg_sc.add(rb_sc_no);


        
        JLabel lbleac = new JLabel("Exisiting Ac.:");
        lbleac.setFont(new Font("Raleway", Font.BOLD, 20));
        lbleac.setBounds(100, 460, 150, 30);
        add(lbleac);

       rb_eac_yes=new JRadioButton ("Yes");
       rb_eac_yes.setBounds(260,460,100,30);
       rb_eac_yes.setBackground(Color.white);
       add(rb_eac_yes);
       
       rb_eac_no=new JRadioButton ("No");
       rb_eac_no.setBounds(380,460,100,30);
       rb_eac_no.setBackground(Color.white);
       add(rb_eac_no);
       
       ButtonGroup bg_ea = new ButtonGroup();
       bg_ea.add(rb_eac_no);
       bg_ea.add(rb_eac_yes);

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
    public void actionPerformed(ActionEvent ae){

        
        String religion = cb_rel.getSelectedItem().toString();
        String category=cb_category.getSelectedItem().toString();
        String income =cb_income.getSelectedItem().toString();
        String qualification=cb_qualification.getSelectedItem().toString();
        String occupation=cb_occupation.getSelectedItem().toString();
        String pan=tfpan.getText();
        String adhaar=tfadhar.getText();
        String existing_ac=null;
        if(rb_eac_yes.isSelected()){
        existing_ac="Yes";
        }
        if(rb_eac_no.isSelected()){
        existing_ac="No";
        }
        
       String senior_citizen=null;
       if(rb_sc_yes.isSelected()){
        senior_citizen="Yes";
        }
       if(rb_sc_no.isSelected()){
        senior_citizen="No";
        }

        try {
            
            Conn conn=new Conn();
            String query="insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+qualification+"','"+occupation+"','"+pan+"','"+adhaar+"','"+existing_ac+"','"+senior_citizen+"')";
            conn.s.executeUpdate(query);
            setVisible(false);
            new SignUp3(formno).setVisible(true);
            
            }

      catch (Exception e) {
            System.out.println("e");
        }

    
    }
}

