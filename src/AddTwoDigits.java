import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddTwoDigits extends JFrame implements ActionListener {
    JTextField txtOne, txtTwo, txtResult;
    JButton btnAdd;

    AddTwoDigits() {
     
        setTitle("Add Two Digits");
        setSize(350, 200);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lbl1 = new JLabel("Enter First Number:");
        lbl1.setBounds(20, 30, 120, 20);
        add(lbl1);

        JLabel lbl2 = new JLabel("Enter Second Number:");
        lbl2.setBounds(20, 60, 140, 20);
        add(lbl2);

        JLabel lbl3 = new JLabel("Result:");
        lbl3.setBounds(20, 120, 80, 20);
        add(lbl3);
        txtOne = new JTextField();
        txtOne.setBounds(160, 30, 100, 20);
        add(txtOne);

        txtTwo = new JTextField();
        txtTwo.setBounds(160, 60, 100, 20);
        add(txtTwo);

        txtResult = new JTextField();
        txtResult.setBounds(160, 120, 100, 20);
        txtResult.setEditable(false);
        add(txtResult);
        btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 90, 80, 25);
        btnAdd.addActionListener(this);
        add(btnAdd);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            int first = Integer.parseInt(txtOne.getText());
            int second = Integer.parseInt(txtTwo.getText());
            int sum = first + second;
            txtResult.setText(String.valueOf(sum));
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input!");
        }
    }

    public static void main(String[] args) {
        new AddTwoDigits();
    }
}

