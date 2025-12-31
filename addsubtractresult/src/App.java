import javax.swing.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame f;
    JTextField firstDigit, secondDigit, resultField;
    JPopupMenu operations;
    JMenuItem addition, subtraction, multiplication, division;
    App() {
        f = new JFrame("ClickButton");
        JLabel firstLabel = new JLabel("Enter first digit: ");
        firstLabel.setBounds(20, 20, 130, 25);
        firstDigit = new JTextField();
        firstDigit.setBounds(140, 20 ,200, 25);
        f.add(firstLabel);
        f.add(firstDigit);

        JLabel secondLabel = new JLabel("Enter second digit: ");
        secondLabel.setBounds(20, 60, 130, 25);
        secondDigit = new JTextField();
        secondDigit.setBounds(140, 60 ,200, 25);
        f.add(secondLabel);
        f.add(secondDigit);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 100, 130, 25);
        resultField = new JTextField();
        resultField.setBounds(140, 100 ,200, 25);
        f.add(resultLabel);
        f.add(resultField);

        operations = new JPopupMenu();
        addition = new JMenuItem("Add");
        subtraction = new JMenuItem("Subtract");
        multiplication = new JMenuItem("Multiply");
        division = new JMenuItem("Divide");

        addition.addActionListener(this);
        subtraction.addActionListener(this);
        multiplication.addActionListener(this);
        division.addActionListener(this);
        operations.add(addition);
        operations.add(subtraction);
        operations.add(multiplication);
        operations.add(division);
        f.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {//not needed to write this swingutilities
                    operations.show(f, e.getX(), e.getY());
                }
            }
        });
        f.add(operations);

        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(firstDigit.getText());
        double num2 = Double.parseDouble(secondDigit.getText());
        double result = 0;
        if (e.getSource() == addition) {
            result = num1 + num2;
        } else if (e.getSource() == subtraction) {
            result = num1 - num2;
        } else if (e.getSource() == multiplication) {
            result = num1 * num2;
        } else if (e.getSource() == division) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                JOptionPane.showMessageDialog(f, "Cannot divide by zero");
                return;
            }
        }
        resultField.setText(String.valueOf(result));
    }
}
