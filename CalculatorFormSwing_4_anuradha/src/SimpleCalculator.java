import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField txtFirst, txtSecond, txtResult;
    JComboBox<String> cmbOperation;
    JButton btnCalculate;

    SimpleCalculator() {
        // Frame settings
        setTitle("Simple Calculator");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel lbl1 = new JLabel("First Digit:");
        lbl1.setBounds(30, 30, 100, 20);
        add(lbl1);

        JLabel lbl2 = new JLabel("Second Digit:");
        lbl2.setBounds(30, 60, 100, 20);
        add(lbl2);

        JLabel lbl3 = new JLabel("Operation:");
        lbl3.setBounds(30, 90, 100, 20);
        add(lbl3);

        JLabel lbl4 = new JLabel("Result:");
        lbl4.setBounds(30, 150, 100, 20);
        add(lbl4);

        // Text fields
        txtFirst = new JTextField();
        txtFirst.setBounds(140, 30, 120, 20);
        add(txtFirst);

        txtSecond = new JTextField();
        txtSecond.setBounds(140, 60, 120, 20);
        add(txtSecond);

        txtResult = new JTextField();
        txtResult.setBounds(140, 150, 120, 20);
        txtResult.setEditable(false);
        add(txtResult);

        // Dropdown for operation
        String[] operations = {"Add", "Subtract", "Multiply", "Divide"};
        cmbOperation = new JComboBox<>(operations);
        cmbOperation.setBounds(140, 90, 120, 20);
        add(cmbOperation);

        // Calculate button
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(140, 120, 120, 25);
        btnCalculate.addActionListener(this);
        add(btnCalculate);

        // Show frame
        setVisible(true);
    }

    // Event handler
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(txtFirst.getText());
            double num2 = Double.parseDouble(txtSecond.getText());
            double result = 0;

            String operation = (String) cmbOperation.getSelectedItem();

            switch (operation) {
                case "Add":
                    result = num1 + num2;
                    break;
                case "Subtract":
                    result = num1 - num2;
                    break;
                case "Multiply":
                    result = num1 * num2;
                    break;
                case "Divide":
                    if (num2 != 0)
                        result = num1 / num2;
                    else {
                        txtResult.setText("Cannot divide by 0");
                        return;
                    }
                    break;
            }

            txtResult.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            txtResult.setText("Invalid Input!");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}

