package hr.fer.oop.swing.example4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InputUserDataFrame extends JFrame {

  private InputUserDataPanel userDataPanel;

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      InputUserDataFrame frame = new InputUserDataFrame();
      frame.setBounds(100, 100, 500, 400);
      frame.setVisible(true);
    });
  }

  public InputUserDataFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    userDataPanel = new InputUserDataPanel();
    add(userDataPanel, BorderLayout.CENTER);

    // FlowLayout panel -> GridLayout panel -> 2 buttons in row    
    JPanel buttonsGridPanel = new JPanel();
    buttonsGridPanel.setLayout(new GridLayout(1, 0, 10, 0));
    
    JButton btnOK = new JButton("U redu");
    buttonsGridPanel.add(btnOK);

    JButton btnCancel = new JButton("Odustani");
    buttonsGridPanel.add(btnCancel);
        
    JPanel buttonsPanel = new JPanel();
    buttonsPanel.add(buttonsGridPanel);
    add(buttonsPanel, BorderLayout.SOUTH);
    //

    // buttons actions
    btnOK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        UserData data = userDataPanel.getUserData();

        System.out.println(data);
      }
    });

    btnCancel.addActionListener(e -> System.exit(0)); //or e -> dispose() if we only want to close window   
  }

}
