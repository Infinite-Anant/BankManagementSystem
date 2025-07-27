
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.SwingUtilities;
import java.text.SimpleDateFormat;



public class Withdrawl extends JFrame implements ActionListener{
    
    JButton b1,b2;
    JTextField amount;
    String pin;

// Format: "yyyy-MM-dd HH:mm:ss" → 19 characters
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String formattedDate = sdf.format(new Date());

    
    Withdrawl(String pin){
        
        this.pin = pin;
        setLayout(null);
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        
         JLabel text = new JLabel("Enter the Amount You Want To Withdraw");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(180, 300, 400, 20);
        image.add(text);
        
        
       amount = new JTextField("₹ ");
amount.setFont(new Font("Raleway", Font.BOLD, 20));
amount.setBounds(180, 355, 320, 25);
image.add(amount);

// Focus Listener
amount.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        if (amount.getText().isEmpty()) {
            amount.setText("₹ ");
        }
        SwingUtilities.invokeLater(() -> {
            amount.setCaretPosition(amount.getText().length());
        });
    }

    public void focusLost(FocusEvent e) {
        if (amount.getText().trim().equals("₹") || amount.getText().trim().equals("₹ ")) {
            amount.setText("₹ ");
        }
    }
});

// Prevent deletion of ₹
amount.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if (amount.getCaretPosition() <= 2 &&
            (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE)) {
            e.consume(); // Don't let user delete ₹
        }
    }
});

        
        b1 = new JButton("Withdraw");
        b1.setBounds(355,485,150,30);
        b1.addActionListener(this);
        image.add(b1);
        
          b2 = new JButton("Back");
        b2.setBounds(355,520,150,30);
        b2.addActionListener(this);
        image.add(b2);
        
        setSize(900,900);
       setLocation(300,0);
       //setUndecorated(true);
       setVisible(true);
    }
    
       public void actionPerformed(ActionEvent ae){   
           
       if (ae.getSource()== b1){
           String number = amount.getText();
           Date date = new Date();
           
          if (number.equals("")) {
          JOptionPane.showMessageDialog(null, "Please enter a valid amount that you want to Withdraw");
          } else {
          try {
           Conn conn = new Conn();
           String query = "insert into bank values('"+pin+"','"+ formattedDate +"','Withdrawl','"+number+"')";
           conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null, number + " Withdraw Successfully");

          setVisible(false);
          new Transaction(pin).setVisible(true);
          } catch (Exception e) {
           System.out.println(e);
          }
        }
       
       }else if (ae.getSource()== b2){
           setVisible(false);
           new Transaction(pin).setVisible(true);
           
                   
                   
       }
}
    public static void main (String args[]){
        new Withdrawl("");
        
    }
    
}
