package hr.fer.oop.swing2.events;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class CorrectWay extends JFrame {
	JButton btnAction = new JButton();
	JProgressBar pbProgress = new JProgressBar();

	public CorrectWay() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbProgress.setMaximum(10);
		pbProgress.setMinimum(0);
		btnAction.setText("Start");
		btnAction.addActionListener((e) -> {
			btnAction_actionPerformed(e);
		});
		this.getContentPane().add(btnAction, BorderLayout.WEST);
		this.getContentPane().add(pbProgress, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CorrectWay frame = new CorrectWay();
			frame.pack();
			frame.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		btnAction.setEnabled(false);
		pbProgress.setValue(0);

		new Thread(() -> {
			for (int i = 0; i <= 10; i++) {
				int progressValue = i;
				SwingUtilities.invokeLater(() -> pbProgress.setValue(progressValue));
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
			SwingUtilities.invokeLater(() -> btnAction.setEnabled(true));
		}).start();
	}
}
