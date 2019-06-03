package hr.fer.oop.audit12;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang.StringUtils;

//Search files under the given directory for specific word
public class SearchForWordWorker extends SwingWorker<Integer, String> {

  private static void failIfInterrupted() throws InterruptedException {
    if (Thread.currentThread().isInterrupted()) {
      throw new InterruptedException("Interrupted while searching files");
    }
  }

  //Word to search
  private final String word;

  //Directory to be searched
  private final File directory;

  //Area for writing a message
  private final JTextArea logArea;

  public SearchForWordWorker(final String word, final File directory, 
		  final JTextArea messagesTextArea) {
    this.word = word;
    this.directory = directory;
    this.logArea = messagesTextArea;
  }

  @Override
  protected Integer doInBackground() throws Exception {
    // The number of instances the word is found
    int matches = 0;

    //List all text files under the given directory using the Apache IO library. 
    publish("Listing all text files under the directory: " + directory);
    final List<File> textFiles = new ArrayList<File>(
        FileUtils.listFiles(directory, new SuffixFileFilter(".txt"), TrueFileFilter.TRUE));
    SearchForWordWorker.failIfInterrupted();
    publish("Found " + textFiles.size() + " text files under the directory: " + directory);

    for (int i = 0, size = textFiles.size(); i < size; i++) {
      //Check if interrupted.
      SearchForWordWorker.failIfInterrupted();
      // Update the status and indicate which file is being searched.
      final File file = textFiles.get(i);
      publish("Searching file: " + file);
      //Count the word occurrences and update the progress bar
      final String text = FileUtils.readFileToString(file);
      matches += StringUtils.countMatches(text, word);
      // Update the progress
      setProgress((i + 1) * 100 / size);
    }
    // Return the number of matches found
    publish("Found " + matches + " occurences of the word: " + word);
    return matches;
  }

  @Override
  protected void process(final List<String> chunks) {
    // Updates the messages text area
    for (final String string : chunks) {
      logArea.append(string);
      logArea.append("\n");
    }
  }
}