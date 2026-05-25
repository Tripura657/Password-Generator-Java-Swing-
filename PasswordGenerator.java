import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PasswordGenerator extends JFrame implements ActionListener {

    JLabel label1, label2;
    JTextField lengthField, passwordField;
    JButton generateBtn;

    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&*";

    PasswordGenerator() {

        setTitle("Password Generator");
        setSize(400, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel("Password Length:");
        label1.setBounds(50, 40, 150, 30);

        lengthField = new JTextField();
        lengthField.setBounds(200, 40, 100, 30);

        generateBtn = new JButton("Generate");
        generateBtn.setBounds(120, 90, 120, 35);
        generateBtn.addActionListener(this);

        label2 = new JLabel("Generated Password:");
        label2.setBounds(50, 140, 150, 30);

        passwordField = new JTextField();
        passwordField.setBounds(200, 140, 150, 30);
        passwordField.setEditable(false);

        add(label1);
        add(lengthField);
        add(generateBtn);
        add(label2);
        add(passwordField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            int length = Integer.parseInt(lengthField.getText());

            String password = generatePassword(length);

            passwordField.setText(password);

        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter valid length!");
        }
    }

    public String generatePassword(int length) {

        Random random = new Random();

        StringBuilder password = new StringBuilder();

        for(int i=0; i<length; i++) {

            int index = random.nextInt(chars.length());

            password.append(chars.charAt(index));
        }

        return password.toString();
    }

    public static void main(String args[]) {

        new PasswordGenerator();
    }
}