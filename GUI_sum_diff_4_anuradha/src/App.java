import java.awt.*;
import java.awt.event.*;

public class App implements MouseListener {
    Label lblOutput;
    TextField txtOne, txtTwo;

    App() {
        Frame f = new Frame("Sum and Difference using Mouse Events");
        Label lbl1 = new Label("Enter First Number:");
        lbl1.setBounds(20, 50, 120, 20);
        txtOne = new TextField();
        txtOne.setBounds(150, 50, 100, 20);

        Label lbl2 = new Label("Enter Second Number:");
        lbl2.setBounds(20, 80, 120, 20);
        txtTwo = new TextField();
        txtTwo.setBounds(150, 80, 100, 20);

        lblOutput = new Label("Result will appear here");
        lblOutput.setBounds(20, 120, 200, 20);
        f.add(lbl1);
        f.add(txtOne);
        f.add(lbl2);
        f.add(txtTwo);
        f.add(lblOutput);
        f.addMouseListener(this);
        f.setSize(300, 200);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new App();
    }
    public void mousePressed(MouseEvent e) {
        try {
            int first = Integer.parseInt(txtOne.getText());
            int second = Integer.parseInt(txtTwo.getText());
            int result = first + second;
            lblOutput.setText("Sum: " + result);
        } catch (NumberFormatException ex) {
            lblOutput.setText("Invalid Input!");
        }
    }

    public void mouseReleased(MouseEvent e) {
        try {
            int first = Integer.parseInt(txtOne.getText());
            int second = Integer.parseInt(txtTwo.getText());
            int result = first - second;
            lblOutput.setText("Difference: " + result);
        } catch (NumberFormatException ex) {
            lblOutput.setText("Invalid Input!");
        }
    }

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

