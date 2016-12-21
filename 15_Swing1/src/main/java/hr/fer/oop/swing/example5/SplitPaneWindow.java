package hr.fer.oop.swing.example5;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import hr.fer.oop.swing.example4.InputUserDataPanel;
import hr.fer.oop.swing.example4.UserData;

public class SplitPaneWindow extends JFrame {
  private int commandId = 0;
  private List<UserData> userDataList;
  private List<JToggleButton> buttons;
  private InputUserDataPanel userDataPanel;
  private ActionListener toggleButtonListener;
  private JPanel buttonsPanel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SplitPaneWindow frame = new SplitPaneWindow();
      frame.setBounds(100, 100, 500, 400);
      frame.setVisible(true);
    });
  }

  public SplitPaneWindow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLayout(new BorderLayout()); 
    
    // tool bar
    JToolBar toolBar = new JToolBar();
    add(toolBar, BorderLayout.NORTH);
    createButtonsForToolbar(toolBar);
    
    //split pane
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    add(splitPane, BorderLayout.CENTER);
    
    //left pane will contain panel with buttons
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(0, 1));
    splitPane.setLeftComponent(buttonsPanel); 
   
    //right pane contains user data panel
    userDataPanel = new InputUserDataPanel();
    splitPane.setRightComponent(userDataPanel);

  	//define what happens when button is clicked (same for each button)
    toggleButtonListener = (actionEvent) -> {
      JToggleButton selectedButton = (JToggleButton) actionEvent.getSource();
      deselectOthers(selectedButton);
      int index = findButtonPosition(buttons, actionEvent.getActionCommand());
      userDataPanel.setUserData(userDataList.get(index));
    };
    
    //load users
    userDataList = UserDataFactory.getData();
    if (userDataList.size() > 0){    	
    	//create button for each user    	            
        
        buttons = new ArrayList<>();

        for (UserData data : userDataList) {
          JToggleButton button = new JToggleButton(data.getFirstName() + " "
        		  								 + data.getLastName());
          button.setActionCommand(Integer.toString(commandId++));      
          buttonsPanel.add(button);
          buttons.add(button);          
          button.addActionListener(toggleButtonListener);
        }
        
        // show the first user
    	userDataPanel.setUserData(userDataList.get(0));
    	buttons.get(0).setSelected(true);
    	
    }
  }

  private void createButtonsForToolbar(JToolBar toolBar) {
	  //new
	  JButton newUserData = new JButton("New");
	  toolBar.add(newUserData);
	  newUserData.addActionListener((actionEvent) -> {
	      JToggleButton tb = new JToggleButton("New User Data");
	      tb.setActionCommand(Integer.toString(commandId++));
	      tb.addActionListener(toggleButtonListener);
	      buttons.add(tb);	      
	      userDataList.add(new UserData());
	      buttonsPanel.add(tb);
	      buttonsPanel.revalidate();
	      tb.doClick();
	  });
	  
	  //delete
	  JButton deleteUserData = new JButton("Delete");
	  toolBar.add(deleteUserData);
	  deleteUserData.addActionListener((actionEvent) -> {		  
	      JToggleButton selectedToggleButon = null;
	      int selectedIndex = 0;
	      for (JToggleButton tb : buttons) {
	        if (tb.isSelected()) {
	          selectedToggleButon = tb;
	          break;
	        }
	        selectedIndex++;
	      }
	      if (selectedToggleButon != null){
		      buttons.remove(selectedIndex);
		      buttonsPanel.remove(selectedToggleButon);
		      userDataList.remove(selectedIndex);	      
		      buttonsPanel.revalidate();
		      if (buttons.size() > 0){
		    	  buttons.get(0).doClick();
		      }
	      }
	  });
  }

  private int findButtonPosition(List<JToggleButton> buttons, String actionCommand) {
    for(int i=0; i<buttons.size(); i++)	
      if (buttons.get(i).getActionCommand().equals(actionCommand)) 
        return i;     
    return -1;
  }

  private void deselectOthers(JToggleButton selectedButton) {
    for (JToggleButton button : buttons) {
      if (button != selectedButton && button.isSelected()) {
        //update data for previously shown user
        UserData data = userDataPanel.getUserData();
        int index = buttons.indexOf(button);
        userDataList.set(index, data);
        button.setText(data.getFirstName() + " " + data.getLastName());
        
        //change button state
        button.setSelected(false); 
      }
    }
  }
}
