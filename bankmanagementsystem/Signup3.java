package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    Signup3( String formno){
        
        this.formno = formno;
        setLayout(null);
        JLabel l1= new JLabel ("Page 3: Account Details:");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400,40);
        add(l1);
        
        JLabel type= new JLabel (" Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200,30);
        add(type); 
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 18));
        r1.setBounds(100,180,250,20);
        add(r1);
        
         r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 18));
        r2.setBounds(350,180,250,20);
        add(r2);
        
         r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 18));
        r3.setBounds(100,220,250,20);
        add(r3);
        
         r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 18));
        r4.setBounds(350,220,270,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
         JLabel card= new JLabel ("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(105, 300, 200,30);
        add(card); 
        
         JLabel number= new JLabel ("XXXX-XXXX-XXXX-0000");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300,30);
        add(number); 
        
        JLabel pin= new JLabel ("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(110, 370, 200,30);
        add(pin); 
        
         JLabel pnumber= new JLabel ("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300,30);
        add(pnumber); 
        
        JLabel service= new JLabel ("Services Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(110, 440, 300,30);
        add(service); 
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway", Font.BOLD, 13));
        c7.setBounds(100,680,600,30); 
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(420, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 15));
        cancel.setBounds(250, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
         getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);

}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Savings Acoount";
            } else if (r2.isSelected() ){
                accountType = "Fixed Deposit Account";
            }else if  (r3.isSelected()){
                accountType = "Current Account";
            }else if (r4.isSelected()){
                accountType = "Reccuring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = ""+Math.abs(random.nextLong()%90000000L + 5040936000000000L);
            
            
            String pinnumber =""+ Math.abs((random.nextLong()%9000L)+1000L);
            
            String facility ="";
            

         if (c1.isSelected()) facility += "ATM Card, ";
         if (c2.isSelected()) facility += "Internet Banking, ";
         if (c3.isSelected()) facility += "Mobile Banking, ";
         if (c4.isSelected()) facility += "EMAIL & SMS Alerts, ";
         if (c5.isSelected()) facility += "Cheque Book, ";
         if (c6.isSelected()) facility += "E-Statement";

         if (facility.endsWith(", ")) {
           facility = facility.substring(0, facility.length() - 2);
        }

            
            if (!c7.isSelected()){
                JOptionPane.showMessageDialog(null, "You must agree to the declaration before proceeding.");
        return;
    
                
            }
            
            try {
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signUp3 values('"+formno+"', '"+accountType+"',  '"+cardnumber+"', '"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";
                   
                    conn.s.executeUpdate(query1);
                     conn.s.executeUpdate(query2);
                    
                JOptionPane.showMessageDialog(null, "Account Created Successfully\nCard No: " + cardnumber + "\nPIN: " + pinnumber);
               
                setVisible(false);
                new Deposit(pinnumber).setVisible(false);
                
               
        }
                        }  catch (Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource() == cancel){
            dispose();
         setVisible(false);
         new Login().setVisible(true);
        
        }
    }
    public static void main(String args[]){
        new Signup3("formno");
    }
    
}
