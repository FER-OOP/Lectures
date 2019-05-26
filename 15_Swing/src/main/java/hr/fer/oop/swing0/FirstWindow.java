package hr.fer.oop.swing0;

import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FirstWindow extends JFrame {
	public FirstWindow() {
		JLabel label = new JLabel("Hello from Swing GUI.");
		add(label);
		setSize(200, 100);
	}

	public static void main(String[] args) {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				@Override
				public void run() {
					FirstWindow window = new FirstWindow();
					window.setLocation(20, 20);
					window.setVisible(true);
				}
			});
		} 
		catch (InvocationTargetException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
