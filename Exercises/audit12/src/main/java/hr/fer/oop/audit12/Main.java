package hr.fer.oop.audit12;

import javax.swing.SwingUtilities;

public class Main {
  public static void main(final String[] args) {
	  SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			new Application();
		}
	});
  }
}