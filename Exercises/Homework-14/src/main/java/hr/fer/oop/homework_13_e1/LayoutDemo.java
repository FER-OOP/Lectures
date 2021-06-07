package hr.fer.oop.homework_13_e1;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class LayoutDemo extends JFrame {
	
	public LayoutDemo() {
		super("Layout demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tp = new JTabbedPane();
	    tp.addTab("Layout 1", new PanelWithLayout1());
	    tp.addTab("Layout 2", new PanelWithLayout2());
	    tp.addTab("Layout 3", new PanelWithLayout3()); 
	    tp.addTab("Input Data Form", new InputDataForm()); 
	    add(tp);
	   
	    pack();
	    setLocation(100, 200);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LayoutDemo().setVisible(true);
                System.out.println(Thread.currentThread());
            }
        });
	}
}
