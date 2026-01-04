import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class App implements ActionListener {
JFrame f;
    JButton browse;
    JLabel imageLabel;
App() {
        f = new JFrame("Image Viewer");
        imageLabel = new JLabel();
        imageLabel.setBounds(100, 30, 200, 150);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        f.add(imageLabel);
browse = new JButton("Browse");
        browse.setBounds(150, 200, 100, 30);
        browse.addActionListener(this);
        f.add(browse);
f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new App();
    }
@Override
    public void actionPerformed(ActionEvent e) {

        JFileChooser fc = new JFileChooser();
        int choice = fc.showOpenDialog(f);

        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            ImageIcon icon = new ImageIcon(file.getAbsolutePath());

            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(
                    imageLabel.getWidth(),
                    imageLabel.getHeight(),
                    Image.SCALE_SMOOTH
            );
imageLabel.setIcon(new ImageIcon(scaledImg));
        }
    }
}


