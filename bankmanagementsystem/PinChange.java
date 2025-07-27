package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    JButton b1, b2;
    JPasswordField pinn,repin;
    JLabel pintext,repintext ;
    String pin;
    
   PinChange(String pin){
       this.pin = pin;
       
       setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
         JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("Osward", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 500, 35);
        image.add(text);
        
        
         pintext = new JLabel("NEW PIN:");
        pintext.setFont(new Font("Osward", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);
        
         pinn = new JPasswordField();
        pinn.setFont(new Font("Osward", Font.BOLD, 25));
        pinn.setBounds(330, 320, 180, 25);
        image.add(pinn);
        
        
         repintext = new JLabel("Re-Enter  NEW PIN:");
        repintext.setFont(new Font("Osward", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);
        
         repin = new JPasswordField();
        repin.setFont(new Font("Osward", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        
         b1 = new JButton("CHANGE");
        b1.setBounds(355,485,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
         b2 = new JButton("BACK");
        b2.setBounds(355,520,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
       setLocation(300,0);
       setVisible(true);
        
   }
   
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == b1) {
        try {
            String npin = pinn.getText();
            String rpin = repin.getText();

            if (!npin.equals(rpin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (npin.equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE ENTER NEW PIN");
                return;
            }

            if (rpin.equals("")) {
                JOptionPane.showMessageDialog(null, "PLEASE RE-ENTER NEW PIN");
                return;
            }

            

             
            
            
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin_number = '"+pin+"'";
            String query3 = "update signUp3 set pin = '"+rpin+"' where pinnumber = '"+pin+"'";
            

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            
            
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transaction(rpin).setVisible(true); 
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    } else if (ae.getSource() == b2) {
        setVisible(false);
        new Transaction(pin).setVisible(true); // Return to Transaction with old PIN
    }
}
    
public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}

