package bank.management.system;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class SignUp2 extends JFrame implements ActionListener {
    
    JTextField t1, t2;
    JButton  next, back;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, occupation, education, income;
    String formno;
    
    SignUp2(String formno){
         this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT FORM - PAGE 2");
        
       
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionaldetails.setBounds(290, 80, 400, 30);
        add(additionaldetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[]= {"Please Select","Hindu", "Muslim", "Sikh", "Christian", "Other"};
         religion = new JComboBox(valReligion); 
         religion.setBounds(300, 140, 400, 30);
         religion.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(religion);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 190, 200, 30);
        add(dob);
        
         String incomecat[]= {" Please Select","Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
         income = new JComboBox(incomecat);
         income.setBounds(300, 190, 400, 30);
         income.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(income);
        
       
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 255, 200, 30);
        add(gender);
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 280, 200, 30);
        add(email);
        
         String educationValues[]= {" Please Select","Non Graduation", "Graduate", "Post-Graduate", "Doctrate", "Others"};
         education = new JComboBox(educationValues);
         education.setBounds(300, 265, 400, 30);
         education.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(education);
        
       
        
        JLabel marry = new JLabel("Occupation:");
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 340, 200, 30);
        add(marry);
        
         String occupationValues[]= {"Please Select","Self-Employed", "Bussiness", "Student", "Private-Job", "Others"};
         occupation = new JComboBox(occupationValues);
         occupation.setBounds(300, 340, 400, 30);
         occupation.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(occupation);
        
      
        
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 390, 200, 30);
        add(address);
        
        t1 = new JTextField();
        t1.setBounds(300, 390, 400, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(t1);
        
        JLabel city = new JLabel("ADHAAR Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 440, 200, 30);
        add(city);
        
        t2 = new JTextField();
        t2.setBounds(300, 440, 400, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(t2);
        
        JLabel state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 490, 200, 30);
        add(state);
        
           syes = new JRadioButton("Yes");
        syes.setBounds(300, 490, 100, 30);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 490, 100, 30);
        add(sno);
        
        ButtonGroup smaritalgroup = new ButtonGroup();
        smaritalgroup.add(syes);
        smaritalgroup.add(sno);
        
       
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);
        
          eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 540, 100, 30);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 540, 100, 30);
        add(eno);
        
        ButtonGroup emaritalgroup = new ButtonGroup();
        emaritalgroup.add(eyes);
        emaritalgroup.add(eno);
        
       
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 15));
        back.setBounds(100, 660, 80, 30); 
        back.addActionListener(this);
        add(back);
        
             
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
    }
        
        public void actionPerformed(ActionEvent ae){
             if (ae.getSource() == next) {
            String sreligion = (String) religion.getSelectedItem();
            String sincome =(String) income.getSelectedItem();
            String seducation =(String) education.getSelectedItem();
            String soccupation =(String) occupation.getSelectedItem();
            String seniorcitizen = null;
            if(syes.isSelected()){
                seniorcitizen= "Yes";
            }else if(sno.isSelected()){
                seniorcitizen ="No";
            
        }
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()){
            existingaccount= "No";
                    
        }
        String span =t1.getText();
        String sadhaar =t2.getText();
        
         
        
        try{ 
           
                Conn c = new Conn();
                String query = "insert into signUp2 values('"+formno+"','"+sreligion+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"','"+span+"', '"+sadhaar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
                
                
                
        } catch (Exception e){
            System.out.println(e);}
        
        }else if (ae.getSource() == back) {
        // Go back to SignUp1
        new SignUpOne();  
        setVisible(false);
      
        }
        }
     public static void main(String args[]){
        
        new SignUp2("formno");
        
        }
}
