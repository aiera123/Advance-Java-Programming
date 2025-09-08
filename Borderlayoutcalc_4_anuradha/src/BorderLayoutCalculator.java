import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutCalculator extends JFrame implements ActionListener {
    JTextField txtFirst, txtSecond, txtResult;
    JButton btnAdd, btnSub, btnMul, btnDiv;

    BorderLayoutCalculator() {
        setTitle("BorderLayout Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel northPanel = new JPanel();
        JLabel lblTitle = new JLabel("Simple Calculator Using BorderLayout", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        northPanel.add(lblTitle);
        add(northPanel, BorderLayout.NORTH);
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4, 1, 5, 5));

        btnAdd = new JButton("Add", new ImageIcon("add.png"));
        btnSub = new JButton("Subtract", new ImageIcon("sub.png"));
        btnMul = new JButton("Multiply", new ImageIcon("mul.png"));
        btnDiv = new JButton("Divide", new ImageIcon("div.png"));
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);

        eastPanel.add(btnAdd);
        eastPanel.add(btnSub);
        eastPanel.add(btnMul);
        eastPanel.add(btnDiv);

        add(eastPanel, BorderLayout.EAST);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblFirst = new JLabel("First Number:");
        JLabel lblSecond = new JLabel("Second Number:");
        JLabel lblResult = new JLabel("Result:");

        txtFirst = new JTextField();
        txtSecond = new JTextField();
        txtResult = new JTextField();
        txtResult.setEditable(false);

        centerPanel.add(lblFirst);   centerPanel.add(txtFirst);
        centerPanel.add(lblSecond);  centerPanel.add(txtSecond);
        centerPanel.add(lblResult);  centerPanel.add(txtResult);

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(txtFirst.getText());
            double num2 = Double.parseDouble(txtSecond.getText());
            double result = 0;

            if (e.getSource() == btnAdd) {
                result = num1 + num2;
            } else if (e.getSource() == btnSub) {
                result = num1 - num2;
            } else if (e.getSource() == btnMul) {
                result = num1 * num2;
            } else if (e.getSource() == btnDiv) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    txtResult.setText("Error: Divide by 0");
                    return;
                }
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input!");
        }
    }

    public static void main(String[] args) {
        new BorderLayoutCalculator();
    }
}
