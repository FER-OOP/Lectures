package hr.fer.oop.swing.example5;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import hr.fer.oop.swing.example4.InputUserDataPanel;
import hr.fer.oop.swing.example4.UserData;

public class SplitPaneWindow extends JFrame {
  private List<UserData> userDataList;
  private List<JToggleButton> buttons;
  private InputUserDataPanel userDataPanel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SplitPaneWindow frame = new SplitPaneWindow();
      frame.setBounds(100, 100, 500, 400);
      frame.setVisible(true);
    });
  }

  public SplitPaneWindow() {
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	userDataList = UserDataFactory.getData();
	buttons = new LinkedList<JToggleButton>();
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	add(splitPane);
	
	JPanel panel = new JPanel();
	splitPane.setLeftComponent(panel);
	panel.setLayout(new GridLayout(0, 1));
	
	for (UserData data : userDataList) {
	  JToggleButton button = new JToggleButton(data.getFirstName() + " "
	      + data.getLastName());
	  panel.add(button);
	  buttons.add(button);
	}
	
	userDataPanel = new InputUserDataPanel();
	splitPane.setRightComponent(userDataPanel);
 }
}
