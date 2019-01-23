package hr.fer.oop.task5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import hr.fer.oop.task4.FileSearchMonitor;

public class MainFrame extends JFrame implements FileSearchMonitor  {
	private JTextArea text;
	public MainFrame(){
		text = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(text);
		add(scrollPane, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(800, 600));
	}
	@Override
	public void directoryChangedTo(String directory) {
		text.append("Dir changed to: " + directory + "\n");
		//System.out.println(Thread.currentThread());
	}

	@Override
	public void fileFound(String filename) {
		text.append(filename + "\n");
		//System.out.println(Thread.currentThread());
	}

	@Override
	public void searchFinished() {
		text.append("Search finihed");
		//System.out.println(Thread.currentThread());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			MainFrame frame = new MainFrame();
			frame.pack();
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			SwingWorker <List<String>, String> worker = new FileSearcherWorker(frame, "data", "data/Books/Java");
			worker.execute();
		});
	}
}
