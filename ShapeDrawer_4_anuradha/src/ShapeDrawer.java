import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeDrawer extends JFrame implements ActionListener {
    JButton btnCircle, btnSquare, btnTriangle;
    String shape = ""; 
    ShapeDrawer() {
        setTitle("Shape Drawer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        btnCircle = new JButton("Circle");
        btnSquare = new JButton("Square");
        btnTriangle = new JButton("Triangle");
        btnCircle.addActionListener(this);
        btnSquare.addActionListener(this);
        btnTriangle.addActionListener(this);
        add(btnCircle);
        add(btnSquare);
        add(btnTriangle);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCircle) {
            shape = "Circle";
        } else if (e.getSource() == btnSquare) {
            shape = "Square";
        } else if (e.getSource() == btnTriangle) {
            shape = "Triangle";
        }
        repaint();}

    public void paint(Graphics g) {
        super.paint(g);

        int width = getWidth();
        int height = getHeight();
        int size = 150;
        int x = (width - size) / 2;
        int y = (height - size) / 2;

        if (shape.equals("Circle")) {
            g.setColor(Color.RED);
            g.fillOval(x, y, size, size);
        } else if (shape.equals("Square")) {
            g.setColor(Color.BLUE);
            g.fillRect(x, y, size, size);
        } else if (shape.equals("Triangle")) {
            g.setColor(Color.GREEN);
            int[] xPoints = {width / 2, x, x + size};
            int[] yPoints = {y, y + size, y + size};
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }

    public static void main(String[] args) {
        new ShapeDrawer();
    }
}
