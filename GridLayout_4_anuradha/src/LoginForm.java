import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {
    JTextField txtUser;
    JPasswordField txtPass;
    JButton btnLogin;
    JLabel lblMessage;

    LoginForm() {
     
        setTitle("Simple Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        setLayout(new GridLayout(4, 2, 10, 10));

       
        JLabel lblUser = new JLabel("Username:");
        txtUser = new JTextField();

        JLabel lblPass = new JLabel("Password:");
        txtPass = new JPasswordField();

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(this);

        lblMessage = new JLabel("");

        add(lblUser);   add(txtUser);
        add(lblPass);   add(txtPass);
        add(btnLogin);  add(lblMessage);

        setVisible(true);
    }

   
    public void actionPerformed(ActionEvent e) {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        if (user.equals("admin") && pass.equals("1234")) {
            lblMessage.setText("Login Successful!");
        } else {
            lblMessage.setText("Invalid Username/Password");
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}

