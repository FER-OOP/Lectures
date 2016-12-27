package hr.fer.oop.threads.example4;

import javax.swing.SwingUtilities;

public class CountThread extends Thread {
	private CorrectWay gui;

	public CountThread(CorrectWay gui) {
		this.gui = gui;
	}

	public void run() {
		setProgerssBar(0);

		for (int i = 0; i <= 10; i++) {
			setProgerssBar(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException ie) {
			}
		}
		SwingUtilities.invokeLater(() -> {
			gui.setEnabledStartButton(true);
		});
	}

	private void setProgerssBar(int value) {
		SwingUtilities.invokeLater(() -> {
			gui.setProgressBarValue(value);
		});
	}
}
