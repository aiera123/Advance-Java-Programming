import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Layout Manager Example");
        f.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        JLabel rollLabel = new JLabel("Roll No.");
        JLabel classLabel = new JLabel("Class");
        northPanel.add(nameLabel);
        northPanel.add(rollLabel);
        northPanel.add(classLabel);
        f.add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 5, 5 ));
        JLabel userLabel = new JLabel("Username");
        JTextField userTextField = new JTextField();
        JLabel passLabel = new JLabel("Password");
        JPasswordField passTextField = new JPasswordField();
        JCheckBox remember = new JCheckBox("Remember Me");
        JButton loginButton = new JButton("Login");
        centerPanel.add(userLabel);
        centerPanel.add(userTextField);
        centerPanel.add(passLabel);
        centerPanel.add(passTextField);
        centerPanel.add(remember);
        centerPanel.add(loginButton);
        f.add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout());
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");
        southPanel.add(resetButton);
        southPanel.add(exitButton);
        f.add(southPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String username = userTextField.getText();
                JOptionPane.showMessageDialog(f, "Username entered: "+ username);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                userTextField.setText("");
                passTextField.setText("");
                remember.setSelected(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        f.setVisible(true);
        f.setSize(400, 300);
    }
}











