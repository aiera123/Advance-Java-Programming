import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorButtonDemo extends JFrame implements ActionListener {
    JButton btnRed, btnBlue, btnGreen;

    ColorButtonDemo() {
    
        setTitle("Color Button Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnRed = new JButton("RED");
        btnBlue = new JButton("BLUE");
        btnGreen = new JButton("GREEN");
        btnRed.addActionListener(this);
        btnBlue.addActionListener(this);
        btnGreen.addActionListener(this);
        add(btnRed);
        add(btnBlue);
        add(btnGreen);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRed) {
            btnRed.setBackground(Color.RED);
            btnRed.setForeground(Color.WHITE);
        } else if (e.getSource() == btnBlue) {
            btnBlue.setBackground(Color.BLUE);
            btnBlue.setForeground(Color.WHITE);
        } else if (e.getSource() == btnGreen) {
            btnGreen.setBackground(Color.GREEN);
            btnGreen.setForeground(Color.BLACK);
        }
    }
    public static void main(String[] args) {
        new ColorButtonDemo();
    }
}

