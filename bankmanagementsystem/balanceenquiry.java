package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class balanceenquiry extends JFrame implements ActionListener {
    
    String pin;
    JButton back;
    JLabel text;
    
    balanceenquiry(String pin) {
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        text = new JLabel();
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 30);
        image.add(text);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        int balance = 0;
        try {
            Conn conn = new Conn(); // Your DB connection class
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            
            while (rs.next()) {
    String type = rs.getString("type");
    String amountStr = rs.getString("amount").replaceAll("[^0-9]", ""); // fix here
    int amount = Integer.parseInt(amountStr);
    
    if (type.equals("Deposit")) {
        balance += amount;
    } else {
        balance -= amount;
    }
}

        } catch (Exception e) {
            e.printStackTrace();
        }

        text.setText("Your current Account Balance is Rs " + balance);
        
        
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pin).setVisible(true); // Takes user back to transaction menu
    }
    
    public static void main(String[] args) {
        new balanceenquiry("").setVisible(true);
    }
}
