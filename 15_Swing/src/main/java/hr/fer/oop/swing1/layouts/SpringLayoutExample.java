package hr.fer.oop.swing1.layouts;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SpringLayoutExample extends JFrame {

  public SpringLayoutExample() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    SpringLayout layout = new SpringLayout();
    setLayout(layout);

    JButton btn1 = new JButton("Gumb 1");
    add(btn1);
    JButton btn2 = new JButton("Gumb 2");
    add(btn2);
    JButton btn3 = new JButton("Gumb 3");
    add(btn3);

    layout.putConstraint(SpringLayout.WEST, btn1, 5, SpringLayout.WEST,
        getContentPane());
    layout.putConstraint(SpringLayout.NORTH, btn1, 5, SpringLayout.NORTH,
        getContentPane());
    layout.putConstraint(SpringLayout.WEST, btn2, 10, SpringLayout.EAST, btn1);
    layout
        .putConstraint(SpringLayout.NORTH, btn2, 10, SpringLayout.SOUTH, btn1);
    layout.putConstraint(SpringLayout.EAST, btn2, -5, SpringLayout.EAST,
        getContentPane());
    layout.putConstraint(SpringLayout.SOUTH, btn3, -5, SpringLayout.SOUTH,
        getContentPane());
    layout.putConstraint(SpringLayout.EAST, btn3, -5, SpringLayout.EAST,
        getContentPane());
  }

  public static void main(String[] args) {
    try {
      SwingUtilities.invokeAndWait(new Runnable() {

        @Override
        public void run() {
          SpringLayoutExample window = new SpringLayoutExample();
          window.setLocation(20, 20);
          window.setSize(400, 400);
          window.setVisible(true);
        }
      });
    } catch (InvocationTargetException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
