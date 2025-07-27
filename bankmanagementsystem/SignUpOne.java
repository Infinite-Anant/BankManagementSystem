package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener {

    long random;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8;
    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dateChooser;

    SignUpOne() {

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO." + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel name = new JLabel("<html>Name<font color='red'>*</font>:</html>");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        t1 = new JTextField();
        t1.setBounds(300, 140, 400, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        add(t1);

        JLabel fname = new JLabel("<html>Father's Name<font color='red'>*</font>:</html>");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        t2 = new JTextField();
        t2.setBounds(300, 190, 400, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15));
        add(t2);

        JLabel dob = new JLabel("<html>Date of Birth<font color='red'>*</font>:</html>");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);

        JLabel gender = new JLabel("<html>Gender<font color='red'>*</font>:"
                + "</html>");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("<html>Email Address<font color='red'>*</font>:</html>");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        t3 = new JTextField();
        t3.setBounds(300, 340, 400, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        add(t3);

        JLabel marry = new JLabel("<html>Marital Status<font color='red'>*</font>:</html>");
        marry.setFont(new Font("Raleway", Font.BOLD, 20));
        marry.setBounds(100, 390, 200, 30);
        add(marry);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        add(unmarried);

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JLabel address = new JLabel("<html>Address<font color='red'>*</font>:</html>");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        t4 = new JTextField();
        t4.setBounds(300, 440, 400, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 15));
        add(t4);

        JLabel city = new JLabel("<html>City<font color='red'>*</font>:</html>");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        t5 = new JTextField();
        t5.setBounds(300, 490, 400, 30);
        t5.setFont(new Font("Arial", Font.BOLD, 15));
        add(t5);

        JLabel state = new JLabel("<html>State<font color='red'>*</font>:</html>");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        t6 = new JTextField();
        t6.setBounds(300, 540, 400, 30);
        t6.setFont(new Font("Arial", Font.BOLD, 15));
        add(t6);

        JLabel pincode = new JLabel("<html>Pin Code<font color='red'>*</font>:</html>");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        t7 = new JTextField();
        t7.setBounds(300, 590, 400, 30);
        t7.setFont(new Font("Arial", Font.BOLD, 15));
        add(t7);
        
        JLabel phone = new JLabel("<html>Phone Number<font color='red'>*</font>:</html>");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(100, 640, 200, 30);
        add(phone);

        t8 = new JTextField();
        t8.setBounds(300, 640, 400, 30);
        t8.setFont(new Font("Arial", Font.BOLD, 15));
        add(t8);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(620, 700, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random; //long 
        String name = t1.getText(); //setText
        String fname = t2.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";

        }
        String email = t3.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";

        }
        String address = t4.getText();
        String city = t5.getText();
        String state = t6.getText();
        String pin = t7.getText();
        String phone = t8.getText();

        try {
           if (name.equals("")) {
    JOptionPane.showMessageDialog(null, "Name is required.");
} else if (fname.equals("")) {
    JOptionPane.showMessageDialog(null, "Father's name is required.");
} else if (dob.equals("")) {
    JOptionPane.showMessageDialog(null, "Date of birth is required.");
} else if (gender == null) {
    JOptionPane.showMessageDialog(null, "Gender is required.");
} else if (address.equals("")) {
    JOptionPane.showMessageDialog(null, "Address is required.");
} else if (city.equals("")) {
    JOptionPane.showMessageDialog(null, "City is required.");
} else if (state.equals("")) {
    JOptionPane.showMessageDialog(null, "State is required.");
} else if (pin.equals("")) {
    JOptionPane.showMessageDialog(null, "Pin Code is required.");
} else if (email.equals("") && phone.equals("")) {
    JOptionPane.showMessageDialog(null, "Either Email or Phone Number is required.");

        
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pin + "', '" + state + "', '" + phone + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String args[]) {

        new SignUpOne();

    }
}
