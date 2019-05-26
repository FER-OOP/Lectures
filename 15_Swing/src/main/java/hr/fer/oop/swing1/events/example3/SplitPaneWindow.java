package hr.fer.oop.swing1.events.example3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import hr.fer.oop.swing1.events.example2.InputUserDataFrame;
import hr.fer.oop.swing1.events.example2.InputUserDataPanel;
import hr.fer.oop.swing1.events.example2.UserData;

public class SplitPaneWindow extends JFrame {	
	private Map<String, UserData> userData;	
	private InputUserDataPanel userDataPanel;
	private ActionListener toggleButtonListener;
	private JPanel buttonsPanel;
	private JSplitPane splitPane;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			SplitPaneWindow frame = new SplitPaneWindow();
			frame.setBounds(100, 100, 500, 400);
			frame.setVisible(true);
		});
	}

	public SplitPaneWindow() {

		// set layout and behaviour
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// set up split pane's left and right component, and add it to the frame content
		// pane
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);

		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(0, 1));
		splitPane.setLeftComponent(buttonsPanel);

		userDataPanel = new InputUserDataPanel();
		splitPane.setRightComponent(userDataPanel);

		// load data
		userData = UserDataFactory.getData();

		// define common button listener
		// which buttons had been clicked is recognized by its action command value
		toggleButtonListener = (actionEvent) -> {			
			JToggleButton selectedButton = (JToggleButton) actionEvent.getSource();			
			deselectOthers(selectedButton);
			String uid = actionEvent.getActionCommand();
			userDataPanel.setUserData(userData.get(uid));
			selectedButton.setSelected(true); //cannot be turned off
		};

		// create a button for each record
		for (Map.Entry<String, UserData> entry : userData.entrySet()) {
			JToggleButton button = new JToggleButton(
					entry.getValue().getFirstName() + " " + entry.getValue().getLastName());
			button.setActionCommand(entry.getKey());
			button.addActionListener(toggleButtonListener);
			buttonsPanel.add(button);
		}
		//

		createToolbar();

		// show the first one or hide split pane
		selectFirst();

	}

	private void selectFirst() {
		if (userData.size() > 0) {
			for (Component c : buttonsPanel.getComponents()) {
				if (c instanceof JToggleButton) {
					((JToggleButton) c).doClick();
					break;
				}
			}
		}
		else
		{
			splitPane.setVisible(false);
		}
	}

	private void createToolbar() {
		JToolBar toolbar = new JToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		JButton newUserData = new JButton("New");
		toolbar.add(newUserData);

		newUserData.addActionListener((actionEvent) -> {
			// create new user and assign a new id to the user
			String uid = UUID.randomUUID().toString();
			userData.put(uid, new UserData());

			JToggleButton tb = new JToggleButton("New User Data");
			tb.setActionCommand(uid.toString());
			tb.addActionListener(toggleButtonListener);
			buttonsPanel.add(tb);			
			if (userData.size() == 1) {
				splitPane.getParent().revalidate();
				splitPane.setVisible(true);
			} else {
				buttonsPanel.revalidate();
			}
			tb.doClick();
		});

		JButton deleteUserData = new JButton("Delete");
		toolbar.add(deleteUserData);
		deleteUserData.addActionListener((actionEvent) -> {
			// find selected button
			JToggleButton selectedToggleButon = null;
			for (Component c : buttonsPanel.getComponents()) {
				if (c instanceof JToggleButton) {
					JToggleButton button = (JToggleButton) c;
					if (button.isSelected()) {
						selectedToggleButon = button;
						break;
					}
				}
			}
				
			if (selectedToggleButon != null) {
				buttonsPanel.remove(selectedToggleButon);
				userData.remove(selectedToggleButon.getActionCommand());
				buttonsPanel.revalidate();
				selectFirst();
			}
		});
	}

	private void deselectOthers(JToggleButton selectedButton) {
		for (Component c : selectedButton.getParent().getComponents()) {
			if (c instanceof JToggleButton) {
				JToggleButton button = (JToggleButton) c;
				if ((button != selectedButton) && button.isSelected()) {
					String uid = button.getActionCommand();
					UserData data = userDataPanel.getUserData();
					userData.put(uid, data);
					button.setText(data.getFirstName() + " " + data.getLastName());
					button.setSelected(false);
				}
			}
		}
	}
}
