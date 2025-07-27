
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton b1, b2, b3, b4, b5, b6, b7;
    String pin;
    FastCash(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setFont(new Font("Osward", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(210, 300, 700, 35);
        image.add(text);
        
         b1 = new JButton("Rs 100");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        b1.setActionCommand("100");
        image.add(b1);
        
          b2 = new JButton("Rs 500 ");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        b2.setActionCommand("500");
        image.add(b2);
        
         b3 = new JButton("Rs 1000");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        b3.setActionCommand("1000");
        image.add(b3);
        
          b4 = new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        b4.setActionCommand("2000");
        image.add(b4);
        
        
         b5 = new JButton("Rs 5000");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        b5.setActionCommand("5000");
        image.add(b5);
        
         b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        b6.setActionCommand("10000");
        image.add(b6);
        
        b7 = new JButton("BACK");
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
           setVisible(false);
           new Transaction(pin).setVisible(true);
        }else {
        
          try {
             JButton sourceBtn = (JButton) ae.getSource();
            String btnText = sourceBtn.getText(); 
            String amountStr = btnText.replaceAll("[^0-9]", ""); 
            int amount = Integer.parseInt(amountStr);
    
    
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pin +"'");
              int balance = 0;
             

              while (rs.next()){
                  String type = rs.getString("type");
                String rawAmount = rs.getString("amount").replaceAll("[^0-9]", "");

                if (!rawAmount.isEmpty()) {
                    int amt = Integer.parseInt(rawAmount);
                    if (type.equals("Deposit")) {
                        balance += amt;
                    } else {
                        balance -= amt;
                    }
                }
            }
                  
              if (balance < amount){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
              
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              String formattedDate = sdf.format(new Date());

              String query ="insert into bank values ('" + pin + "','"+formattedDate+"', 'Withdrawl','" + amount + "')";
              c.s.execute(query);
              JOptionPane.showMessageDialog(null, "Rs " + amount+ " Debited Successfully");
              
              setVisible(false);
              new Transaction(pin).setVisible(true);
              
          } catch (Exception e){
             e.printStackTrace();
          
          }
      
        }
    }

    
    public static void main (String args[]){
        new FastCash("");
        
    }
}
