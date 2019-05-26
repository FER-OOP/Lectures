package hr.fer.oop.swing1.layouts;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class BorderLayoutExample extends JFrame {

  public BorderLayoutExample() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    add(new JButton("Sjever"), BorderLayout.NORTH);
    add(new JButton("Zapad"), BorderLayout.WEST);
    add(new JButton("Centar"), BorderLayout.CENTER);
    add(new JButton("Istok"), BorderLayout.EAST);
    add(new JButton("Jug"), BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    try {
      SwingUtilities.invokeAndWait(new Runnable() {

        @Override
        public void run() {
          BorderLayoutExample window = new BorderLayoutExample();
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
