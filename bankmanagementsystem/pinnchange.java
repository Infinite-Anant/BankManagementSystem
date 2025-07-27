package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class pinnchange extends JFrame implements ActionListener {

    JPasswordField pin, repin;
    JButton change, back;
    String pinNumber;

    pinnchange(String pinNumber) {
        this.pinNumber = pinNumber;

        setLayout(null);
        setTitle("Change PIN");

        JLabel pinText = new JLabel("New PIN:");
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(100, 100, 150, 30);
        add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 14));
        pin.setBounds(250, 100, 150, 30);
        add(pin);

        JLabel repinText = new JLabel("Re-Enter New PIN:");
        repinText.setFont(new Font("System", Font.BOLD, 16));
        repinText.setBounds(100, 150, 150, 30);
        add(repinText);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 14));
        repin.setBounds(250, 150, 150, 30);
        add(repin);

        change = new JButton("Change");
        change.setBounds(150, 220, 100, 30);
        change.addActionListener(this);
        add(change);

        back = new JButton("Back");
        back.setBounds(270, 220, 100, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(500, 350);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String newPin = pin.getText();
                String reEnterPin = repin.getText();

                if (!newPin.equals(reEnterPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }

                if (reEnterPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }

                Conn conn = new Conn();
                String q1 = "UPDATE bank SET pin = '" + newPin + "' WHERE pin = '" + pinNumber + "'";
                String q2 = "UPDATE login SET pin_number = '" + newPin + "' WHERE pin_number = '" + pinNumber + "'";
                String q3 = "UPDATE signup3 SET pin_number = '" + newPin + "' WHERE pin_number = '" + pinNumber + "'";

                conn.s.executeUpdate(q1);
                conn.s.executeUpdate(q2);
                conn.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transaction(newPin).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
