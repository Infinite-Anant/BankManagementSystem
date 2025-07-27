
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    Transaction(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("Osward", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(210, 300, 700, 35);
        image.add(text);
        
         b1 = new JButton("Deposit");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
          b2 = new JButton("Cash Withhdraw");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
         b3 = new JButton("Fast Cash");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        image.add(b3);
        
         b4 = new JButton("Balance-Enquiry");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);
        
        b5 = new JButton("Mini-Staement");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);
        
         b6 = new JButton("Pin Change");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);
        
        
        b7 = new JButton("EXIT");
        b7.setBounds(355,520,150,30);
          b7.addActionListener(this);
        image.add(b7);
        
       setSize(900,900);
       setLocation(300,0);
       //setUndecorated(true);
       setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==b7){
            System.exit(0);
        }else if (ae.getSource()== b1){
          setVisible(false);
         new Deposit(pin).setVisible(true);
        } else if (ae.getSource()==b2){
            setVisible(false);
        new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource()==b3){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if (ae.getSource()==b4){
            setVisible(false);
            new balanceenquiry(pin).setVisible(true);
            
        }else if (ae.getSource()==b5){
            setVisible(false);
            new ministatement(pin).setVisible(true);
            }else if (ae.getSource()==b6){
            setVisible(false);
            new pinnchange(pin).setVisible(true);
            }
    }

    
    public static void main (String args[]){
        new Transaction("");
        
    }
}
