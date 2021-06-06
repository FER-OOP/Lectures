package hr.fer.oop.swing1.events.example1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class EnterNameFrame extends JFrame {

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      EnterNameFrame frame = new EnterNameFrame();
      frame.pack(); // slaganje komponenti na najmanje prostora
      frame.setVisible(true);
    });
  }

  /**
   * Create the frame.
   */
  public EnterNameFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(10, 10, 500, 200); // location and size

    JPanel panel = (JPanel) getContentPane(); // get content pane in order to set border
    panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    JLabel lblTitle = new JLabel("Title");
    lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(lblTitle, BorderLayout.NORTH);

    JLabel lblName = new JLabel("Enter name:");
    panel.add(lblName, BorderLayout.WEST);

    JTextField tfInput = new JTextField();
    panel.add(tfInput, BorderLayout.CENTER);
    tfInput.setColumns(10);

    JPanel southPanel = new JPanel();
    panel.add(southPanel, BorderLayout.SOUTH);

    JButton btnOK = new JButton("OK");
    southPanel.add(btnOK);
    
    btnOK.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(EnterNameFrame.this, 
					"Hello " + tfInput.getText());
			
		}
	});
  }
}
