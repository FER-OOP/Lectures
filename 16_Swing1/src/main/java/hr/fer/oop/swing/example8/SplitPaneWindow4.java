package hr.fer.oop.swing.example8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
import hr.fer.oop.swing.example5.UserDataFactory;

public class SplitPaneWindow4 extends JFrame {
  private int lastIndex = 0;
  private List<UserData> userDataList;
  private List<JToggleButton> buttons;
  private InputUserDataPanel userDataPanel;
  private ActionListener toggleButtonListener;  
  private JPanel buttonsPanel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SplitPaneWindow4 frame = new SplitPaneWindow4();
      frame.setBounds(100, 100, 500, 400);
      frame.setVisible(true);
    });
  }

  public SplitPaneWindow4() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout());
    userDataList = UserDataFactory.getData();
    buttons = new LinkedList<JToggleButton>();

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    getContentPane().add(splitPane, BorderLayout.CENTER);

    buttonsPanel = new JPanel();
    splitPane.setLeftComponent(buttonsPanel);
    buttonsPanel.setLayout(new GridLayout(0, 1));

    toggleButtonListener = (actionEvent) -> {
        JToggleButton selectedButton = (JToggleButton) actionEvent.getSource();
        deselectOthers(selectedButton);
        int index = findIndexOfAction(actionEvent.getActionCommand());
        userDataPanel.setUserData(userDataList.get(index));
      };
    
    for (UserData data : userDataList) {
      JToggleButton button = new JToggleButton(data.getFirstName() + " "
          + data.getLastName());
      button.setActionCommand(Integer.toString(lastIndex++));
      buttonsPanel.add(button);
      buttons.add(button);
           
      button.addActionListener(toggleButtonListener);
    }

    userDataPanel = new InputUserDataPanel();
    splitPane.setRightComponent(userDataPanel);

    // tool bar
    JToolBar toolBar = new JToolBar();
    getContentPane().add(toolBar, BorderLayout.NORTH);

    JButton newUserData = new JButton("New");
    toolBar.add(newUserData);
    newUserData.addActionListener((actionEvent) -> {
      JToggleButton tb = new JToggleButton("New User Data");
      tb.setActionCommand(Integer.toString(lastIndex++));
      tb.addActionListener(toggleButtonListener);
      buttons.add(tb);
      UserData ud = new UserData();
      userDataList.add(ud);
      buttonsPanel.add(tb);
      buttonsPanel.revalidate();
      tb.doClick();
    });

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
      buttons.remove(selectedIndex);
      buttonsPanel.remove(selectedToggleButon);
      userDataList.remove(selectedIndex);
      buttons.get(0).setSelected(true);
      userDataPanel.setUserData(userDataList.get(0));
      buttonsPanel.revalidate();
    });

    // inicijalno selektirano
    userDataPanel.setUserData(userDataList.get(0));
    buttons.get(0).setSelected(true);
  }

  private int findIndexOfAction(String actionCommand) {
    int index = 0;
    for (JToggleButton tb : buttons) {
      if (tb.getActionCommand().equals(actionCommand)) {
        return index;
      }
      index++;
    }
    return -1;
  }

  private void deselectOthers(JToggleButton selectedButton) {
    for (JToggleButton button : buttons) {
      if ((button != selectedButton) && button.isSelected()) {
        button.setSelected(false);
        UserData data = userDataPanel.getUserData();
        int index = buttons.indexOf(button);
        userDataList.set(index, data);
        button.setText(data.getFirstName() + " " + data.getLastName());
      }
    }
  }
}
