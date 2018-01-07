package hr.fer.oop.swing.example6;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import hr.fer.oop.swing.example5.UserDataFactory;

public class SplitPaneWindow2 extends JFrame {
  private List<UserData> userDataList;
  private List<JToggleButton> buttons;
  private InputUserDataPanel userDataPanel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      SplitPaneWindow2 frame = new SplitPaneWindow2();
      frame.setBounds(100, 100, 500, 400);
      frame.setVisible(true);
    });
  }

  public SplitPaneWindow2() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    userDataList = UserDataFactory.getData();
    buttons = new LinkedList<JToggleButton>();

    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    add(splitPane);

    JPanel panel = new JPanel();
    splitPane.setLeftComponent(panel);
    panel.setLayout(new GridLayout(0, 1));

    int i = 0;
    for (UserData data : userDataList) {
      JToggleButton button = new JToggleButton(data.getFirstName() + " "
          + data.getLastName());
      button.setActionCommand(Integer.toString(i));
      panel.add(button);
      buttons.add(button);
      i++;
    
      button.addActionListener(new ActionListener() {
    
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
          JToggleButton selectedButton = (JToggleButton) actionEvent
              .getSource();
          deselectOthers(selectedButton);
          int index = Integer.parseInt(actionEvent.getActionCommand());
          userDataPanel.setUserData(userDataList.get(index));
        }
      });
    }

    userDataPanel = new InputUserDataPanel();
    splitPane.setRightComponent(userDataPanel);

    // inicijalno selektirano
    userDataPanel.setUserData(userDataList.get(0));
    buttons.get(0).setSelected(true);
  }

  protected void deselectOthers(JToggleButton selectedButton) {
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
