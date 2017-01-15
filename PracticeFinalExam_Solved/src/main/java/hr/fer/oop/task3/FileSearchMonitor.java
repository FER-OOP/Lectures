package hr.fer.oop.task3;

public interface FileSearchMonitor {
	public void directoryChangedTo(String directory);
	public void fileFound(String filename);
	public void searchFinished();	
}
