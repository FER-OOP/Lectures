package hr.fer.oop.threads.example4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class WrongWay extends JFrame {
	JButton btnAction = new JButton();
	JProgressBar pbProgress = new JProgressBar();

	public WrongWay() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pbProgress.setMaximum(10);
		pbProgress.setMinimum(0);
		btnAction.setText("Start");
		btnAction.addActionListener((e) -> {
			btnAction_actionPerformed(e);
		});
		add(btnAction, BorderLayout.WEST);
		add(pbProgress, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			WrongWay wrongWay1 = new WrongWay();
			wrongWay1.pack();
			wrongWay1.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		pbProgress.setValue(0);
		for (int i = 0; i <= 10; i++) {
			pbProgress.setValue(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
	}
}
