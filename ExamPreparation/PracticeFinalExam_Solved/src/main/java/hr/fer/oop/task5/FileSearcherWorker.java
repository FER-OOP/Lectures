package hr.fer.oop.task5;

import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import hr.fer.oop.task4.FileSearchMonitor;
import hr.fer.oop.task4.FileSearcher;

public class FileSearcherWorker extends SwingWorker<List<String>, String> implements FileSearchMonitor {

	private FileSearchMonitor monitor;
	private String from, to;

	public FileSearcherWorker(FileSearchMonitor monitor, String from, String to) {
		this.monitor = monitor;
		this.from = from;
		this.to = to;
	}

	@Override
	protected List<String> doInBackground() {
		FileSearcher searcher = new FileSearcher(this);
		return searcher.findPDFsInRange(this.from, to);
	}

	@Override
	public void directoryChangedTo(String directory) {
		SwingUtilities.invokeLater(() -> {
			monitor.directoryChangedTo(directory);
		});
	}

	@Override
	public void fileFound(String filename) {
		SwingUtilities.invokeLater(() -> {
			monitor.fileFound(filename);
		});
	}

	@Override
	public void searchFinished() {
		SwingUtilities.invokeLater(() -> {
			monitor.searchFinished();
		});
	}
}
