package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ministatement extends JFrame implements ActionListener {

    String pin;
    JLabel bankLabel, cardLabel, statementLabel, balanceLabel;
    JButton back;

    ministatement(String pin) {
        this.pin = pin;
        setTitle("Mini Statement");

        setLayout(null);

        bankLabel = new JLabel("State Bank of India");
        bankLabel.setBounds(150, 20, 200, 20);
        bankLabel.setFont(new Font("System", Font.BOLD, 16));
        add(bankLabel);

        cardLabel = new JLabel();
        cardLabel.setBounds(20, 60, 300, 20);
        add(cardLabel);

        statementLabel = new JLabel();
        statementLabel.setBounds(20, 100, 440, 200);
        statementLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(statementLabel);

        balanceLabel = new JLabel();
        balanceLabel.setBounds(20, 320, 400, 20);
        balanceLabel.setFont(new Font("System", Font.BOLD, 14));
        add(balanceLabel);

        // Back button
        back = new JButton("Back");
        back.setBounds(200, 370, 100, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.WHITE);

        // Show masked card number
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT card_number FROM login WHERE pin_number = '" + pin + "'");
            if (rs.next()) {
                String cardNumber = rs.getString("card_number");
                cardLabel.setText("Card Number: " + cardNumber.substring(0, 4) + "XXXXXXXX" + cardNumber.substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Show last 5 transactions
        int balance = 0;
        StringBuilder statement = new StringBuilder("<html>");
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "' ORDER BY date DESC LIMIT 5");

            while (rs.next()) {
                String date = rs.getString("date");
                String type = rs.getString("type");
                String amount = rs.getString("amount").replaceAll("[^0-9]", "");

                int amt = Integer.parseInt(amount);
                if (type.equalsIgnoreCase("Deposit")) {
                    balance += amt;
                    statement.append("<span style='color:green;'>🟢 ")
                             .append(date).append(" - ").append(type).append(" ₹").append(amt).append("</span><br>");
                } else {
                    balance -= amt;
                    statement.append("<span style='color:red;'>🔴 ")
                             .append(date).append(" - ").append(type).append(" ₹").append(amt).append("</span><br>");
                }
            }

            statement.append("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        statementLabel.setText(statement.toString());
        balanceLabel.setText("Current Balance: ₹" + balance);

        setSize(500, 450);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new ministatement("").setVisible(true);
    }
}
