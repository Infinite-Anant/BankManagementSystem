package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener  {
    
    JButton login, signup, clear; 
    JTextField t1;
    JPasswordField t2;
    
    Login() {
        
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        t1 = new JTextField();
        t1.setBounds(300, 150, 230, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(t1);
        
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        t2 = new JPasswordField();
        t2.setBounds(300, 220, 230, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15 ));
        add(t2);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
                        
              
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== clear){
            t1.setText("");
            t2.setText("");
    } else if (ae.getSource()== login){
         Conn conn = new Conn ();
         String cardno= t1.getText();
         String pin= t2.getText();
         String query = "select * from login where card_number= '"+cardno+"' and pin_number = '"+pin+"'";
         try {
             ResultSet rs = conn.s.executeQuery(query);
             if (rs.next()){
                 setVisible(false);
                 new Transaction(pin).setVisible(true);
             } else {
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
             }
         }catch (Exception e){
                     System.out.println(e);
         }
                     
             
             
         
         
         
         
    } else if (ae.getSource()== signup){
        setVisible(false);
        new SignUpOne().setVisible(true);
    }
 }
    
    public static void main (String args[]){
       new Login();
    }
    
 }
    

