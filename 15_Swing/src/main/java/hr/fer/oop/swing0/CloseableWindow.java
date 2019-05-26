package hr.fer.oop.swing0;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class CloseableWindow extends JFrame {

	public CloseableWindow() {
		JLabel label = new JLabel("Hello from Swing GUI.");
		add(label);
		setSize(200, 100);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Closeable Window");
	}

	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeAndWait(() -> 
		{
			CloseableWindow window = new CloseableWindow();
			window.setLocation(20, 20);
			window.setVisible(true);
		});
	}
}
