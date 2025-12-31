import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class CheckBoxExample extends JFrame implements ItemListener{
    JCheckBox c1,c2, c3, c4, c5;
    List list;
    public CheckBoxExample(){
        
    setTitle("Course Selection");
        setSize(350, 250);
        setLayout( new FlowLayout());

        c1 = new JCheckBox("Java");
        c2 = new JCheckBox("C++");
       c3 = new JCheckBox("Python");
      c4 = new JCheckBox("Oracle");
      c5 = new JCheckBox("Data Science");
                       
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
c5.addItemListener(this);

list = new List();
add(c1); add(c2); add(c3); add(c4); add(c5);
add(list);
setVisible(true);
    }
    public void itemStateChanged(ItemEvent e) {
        JCheckBox cb = (JCheckBox) e.getSource();
        String course = cb.getText();
        if(cb.isSelected()) {
            list.add(course);
        } else {
            list.remove(course);
        }
    }
    public static void main(String[] args) {
        new CheckBoxExample();
    }
}