package hr.fer.oop.threads.example4;

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
			CorrectWay wrongWay1 = new CorrectWay();
			wrongWay1.pack();
			wrongWay1.setVisible(true);
		});
	}

	private void btnAction_actionPerformed(ActionEvent e) {
		btnAction.setEnabled(false);
		new CountThread(this).start();
	}

	public void setProgressBarValue(int value) {
		pbProgress.setValue(value);
	}

	public void setEnabledStartButton(boolean enable) {
		btnAction.setEnabled(enable);
	}
}
