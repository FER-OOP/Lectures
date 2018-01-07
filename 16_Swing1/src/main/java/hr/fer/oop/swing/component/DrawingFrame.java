package hr.fer.oop.swing.component;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class DrawingFrame extends JFrame {

  public DrawingFrame() {
    Drawing drawing = new Drawing(100);
    add(drawing, BorderLayout.NORTH);

    JButton buttonLarger = new JButton("Pove�aj");
    add(buttonLarger, BorderLayout.SOUTH);
    buttonLarger.addActionListener((event) -> {
      drawing.setRadius(drawing.getRadius() + 10);
    });

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      DrawingFrame frame = new DrawingFrame();
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.setSize(300, 300);
      frame.setVisible(true);
    });
  }
}
