package hr.fer.oop.audit12;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker.StateValue;

public class Application extends JFrame {

	private static final long serialVersionUID = 1;

	private Action searchCancelAction;
	private Action browseAction;

	private JTextField wordTextField;
	private JTextField directoryPathTextField;
	private JTextArea messagesTextArea;
	private JProgressBar searchProgressBar;

	private SearchForWordWorker searchWorker;

	// Constructor for the GUI
	public Application() {
		initActions();
		initComponents();
	}

	private void cancel() {
		searchWorker.cancel(true);
	}

	// Initialization of new actions - browse + cancel
	private void initActions() {
		browseAction = new AbstractAction("Browse") {

			private static final long serialVersionUID = 1;

			public void actionPerformed(final ActionEvent e) {
				final File dir = new File(directoryPathTextField.getText()).getAbsoluteFile();
				final JFileChooser fileChooser = new JFileChooser(dir.getParentFile());
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				final int option = fileChooser.showOpenDialog(Application.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					final File selected = fileChooser.getSelectedFile();
					directoryPathTextField.setText(selected.getAbsolutePath());
				}
			}
		};

		searchCancelAction = new AbstractAction("Search") {

			private static final long serialVersionUID = 1;

			public void actionPerformed(final ActionEvent e) {
				if (searchWorker == null) {
					search();
				} else {
					cancel();
				}
			}
		};
	}

	// Initialization of the main window and its components
	private void initComponents() {
		JFrame frame = new JFrame();
		frame.setTitle("Word Search");

		JLabel word = new JLabel("Word");
		word.setBounds(10, 10, 50, 25);
		frame.add(word);

		wordTextField = new JTextField();
		wordTextField.setText("dario");
		wordTextField.setBounds(55, 10, 440, 25);
		frame.add(wordTextField);

		JLabel path = new JLabel("Path");
		path.setBounds(10, 35, 50, 25);
		frame.add(path);

		directoryPathTextField = new JTextField();
		directoryPathTextField.setText("G:\\Dropbox\\CurrentWork\\"
				+ "eclipse-workspace\\audit12\\TXT");
		directoryPathTextField.setBounds(55, 35, 440, 25);
		frame.add(directoryPathTextField);

		JButton browseButton = new JButton(browseAction);
		browseButton.setBounds(500, 35, 80, 25);
		frame.add(browseButton);

		messagesTextArea = new JTextArea();
		messagesTextArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(messagesTextArea);
		scrollPane.setBounds(10, 70, 570, 250);
		frame.add(scrollPane);

		searchProgressBar = new JProgressBar();
		searchProgressBar.setStringPainted(true);
		searchProgressBar.setVisible(false);
		searchProgressBar.setBounds(10, 325, 480, 25);
		frame.add(searchProgressBar);

		JButton search = new JButton(searchCancelAction);
		search.setBounds(500, 325, 80, 25);
		frame.add(search);

		frame.setLayout(null);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	// Search action - start NEW WORKER
	private void search() {
		final String word = wordTextField.getText();
		final File directory = new File(directoryPathTextField.getText());
		messagesTextArea.setText(
				"Searching for word '" + word + "' in text files"
						+ " under: " + directory.getAbsolutePath() + "\n");
		searchWorker = new SearchForWordWorker(word, directory, messagesTextArea);
		searchWorker.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(final PropertyChangeEvent event) {
				switch (event.getPropertyName()) {
				case "progress":
					searchProgressBar.setIndeterminate(false);
					searchProgressBar.setValue((Integer) event.getNewValue());
					break;
				case "state":
					switch ((StateValue) event.getNewValue()) {
					case DONE:
						searchProgressBar.setVisible(false);
						searchCancelAction.putValue(Action.NAME, "Search");
						searchWorker = null;
						break;
					case STARTED:
					case PENDING:
						searchCancelAction.putValue(Action.NAME, "Cancel");
						searchProgressBar.setVisible(true);
						searchProgressBar.setIndeterminate(true);
						break;
					}
					break;
				}
			}
		});
		searchWorker.execute();
	}
}