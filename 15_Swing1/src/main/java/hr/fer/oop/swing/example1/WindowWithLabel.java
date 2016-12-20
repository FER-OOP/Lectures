package hr.fer.oop.swing.example1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class WindowWithLabel extends JFrame {

  public WindowWithLabel() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setSize(500, 200);
    setTitle("Window with label");
        
    JLabel label = new JLabel();
    label.setText("One of the first examples...");
    add(label);    
  }

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeAndWait(() -> {
      WindowWithLabel window = new WindowWithLabel();
      window.setLocation(20, 20);      
      window.setVisible(true);
    });
  }
}
