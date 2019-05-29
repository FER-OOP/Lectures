package hr.fer.oop.swing1.layouts;

import java.awt.GridLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class GridLayoutExample extends JFrame {

  public GridLayoutExample() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new GridLayout(3, 0)); // 3 rows    

    add(new JButton("Gumb 1"));
    add(new JButton("2"));
    add(new JButton("Gumb 3"));
    add(new JButton("Dugački naziv gumba 4"));
    add(new JButton("Gumb 5"));
  }

  public static void main(String[] args) {
    try {
      SwingUtilities.invokeAndWait(new Runnable() {

        @Override
        public void run() {
          GridLayoutExample window = new GridLayoutExample();
          window.setLocation(20, 20);
          window.pack();
          window.setVisible(true);
        }
      });
    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
