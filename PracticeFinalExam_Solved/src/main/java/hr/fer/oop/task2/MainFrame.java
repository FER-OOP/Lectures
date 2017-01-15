package hr.fer.oop.task2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	ButtonGroup sideBtnGroup;		
	ButtonGroup upDownBtnGroup;
	JTextField text = new JTextField();
	public MainFrame(){		
		text.setEditable(false);
		text.setHorizontalAlignment(JTextField.CENTER);		
		text.setFont(new Font("Courier", Font.BOLD, 200));
		add(text, BorderLayout.CENTER);
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		JPanel west = new JPanel();
		west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		JPanel east = new JPanel();
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		sideBtnGroup = new ButtonGroup();		
		upDownBtnGroup = new ButtonGroup();
		for(int i=0; i<10; i++){					
			String s = Integer.toString(i+1);				
			JToggleButton btnLeft = new JToggleButton(s);			
			btnLeft.setActionCommand(s);
			JToggleButton btnRight = new JToggleButton(s);			
			btnRight.setModel(btnLeft.getModel());
			sideBtnGroup.add(btnLeft);
			west.add(btnLeft);
			east.add(btnRight);
			
			JToggleButton btnUp = new JToggleButton(s);
			btnUp.setActionCommand(s);
			JToggleButton btnDown = new JToggleButton(s);
			btnDown.setModel(btnUp.getModel());
			upDownBtnGroup.add(btnUp);
			north.add(btnUp);
			south.add(btnDown);
			
			btnLeft.addActionListener(getActionListener());
			btnUp.addActionListener(getActionListener());
		}
	}
	
	

	private ActionListener getActionListener() {
		return new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				ButtonModel left = sideBtnGroup.getSelection();
				ButtonModel right = upDownBtnGroup.getSelection();				
				if (left != null && right != null){
					Integer a = Integer.parseInt(left.getActionCommand());
					Integer b = Integer.parseInt(right.getActionCommand());
					text.setText(Integer.toString(a * b));
				}
				else{
					text.setText("");
				}				
			}
		};		
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new MainFrame();
			frame.pack();
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		});

	}

}
