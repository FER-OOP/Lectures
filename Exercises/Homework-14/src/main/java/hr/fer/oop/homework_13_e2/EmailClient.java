package hr.fer.oop.homework_13_e2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class EmailClient extends JFrame {
	private JTextField txFrom = new JTextField();
    private JTextField txTo = new JTextField();
    private JTextField txSubject = new JTextField();
    private JTextArea taMessage = new JTextArea();
    private JButton btSendMail = new JButton("Send e-mail");
    private JButton btClearMessage = new JButton("Clear Message");
    
	public EmailClient() {
		createAndShowGUI();
	}
	
	private void createAndShowGUI() {
		setTitle("E-mail Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 400, 480);
        setLayout(new BorderLayout());  // unnecessarily, default layout for JFrame
        
        JPanel panel = (JPanel) this.getContentPane(); 
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(new JLabel("From:  ", JLabel.RIGHT));
        labelPanel.add(new JLabel("To:  ", JLabel.RIGHT));
        labelPanel.add(new JLabel("Subject:  ", JLabel.RIGHT));
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(3, 1, 3, 3));
        textFieldPanel.add(txFrom);
        textFieldPanel.add(txTo);
        textFieldPanel.add(txSubject);
                
        northPanel.add(labelPanel, BorderLayout.WEST);
        northPanel.add(textFieldPanel, BorderLayout.CENTER);
        
        
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(new JLabel("Message:"), BorderLayout.NORTH);
        taMessage.setLineWrap(true);
        taMessage.setWrapStyleWord(true);
        messagePanel.add(taMessage, BorderLayout.CENTER);
        
        JPanel buttonsPanel = new JPanel();  // flow layout - default
        buttonsPanel.add(btSendMail);
        buttonsPanel.add(btClearMessage);
        
        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(messagePanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
        
        setVisible(true);
	}
}

