package hr.fer.oop.swing1.events.example2;

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

    // buttons
    JPanel buttonsPanel = new JPanel();
    add(buttonsPanel, BorderLayout.SOUTH);

    JPanel buttonsGridPanel = new JPanel();
    buttonsGridPanel.setLayout(new GridLayout(1, 0, 10, 0));
    buttonsPanel.add(buttonsGridPanel);

    JButton btnOK = new JButton("U redu");
    buttonsGridPanel.add(btnOK);

    JButton btnCancel = new JButton("Odustani");
    buttonsGridPanel.add(btnCancel);

    // actions
    btnOK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        UserData data = userDataPanel.getUserData();

        System.out.println(data);
      }
    });

    btnCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
        // use dispose(); in order to end the frame but not the program
      }
    });

  }

}
