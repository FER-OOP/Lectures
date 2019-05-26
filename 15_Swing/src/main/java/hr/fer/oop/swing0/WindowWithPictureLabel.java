package hr.fer.oop.swing0;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class WindowWithPictureLabel extends JFrame {

  public WindowWithPictureLabel() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Picture");
    
    ImageIcon image = new ImageIcon("fer.jpg");
    JLabel label = new JLabel(image);
    add(label, BorderLayout.CENTER);    
  }

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeAndWait(() -> {
      WindowWithPictureLabel window = new WindowWithPictureLabel();
      window.setLocation(20, 20);
      window.pack();
      window.setVisible(true);
    });
  }
}
