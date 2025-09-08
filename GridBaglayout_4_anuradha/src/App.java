import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    public static void main(String[] args) {
        JFrame f = new JFrame("Login Form");

        f.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel userLabel = new JLabel("Username:");
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.EAST; 
        f.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1; 
        gbc.gridy = 0; 
        gbc.anchor = GridBagConstraints.WEST; 
        f.add(userField, gbc);

        JLabel passLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        f.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        f.add(passField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        f.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if(username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(f, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Username or Password");
                }
            }
        });

        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); 
        f.setVisible(true);
    }
}




