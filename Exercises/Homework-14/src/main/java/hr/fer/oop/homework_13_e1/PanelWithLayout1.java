package hr.fer.oop.homework_13_e1;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelWithLayout1 extends JPanel {
	JButton b1 = new JButton("Button1");
	JButton b2 = new JButton("Button2");
	JButton b3 = new JButton("Button3");
	JButton b4 = new JButton("Button4");
	JButton b5 = new JButton("Button5");
	
	public PanelWithLayout1 () {
		setLayout(new BorderLayout());
		add(b1, BorderLayout.CENTER);
		add(b2, BorderLayout.NORTH); //BorderLayout.PAGE_START
		add(b3, BorderLayout.SOUTH);
		add(b4, BorderLayout.EAST);
		add(b5, BorderLayout.WEST);
	}
}
