package hr.fer.oop.homework_13_e1;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputDataForm extends JPanel {
	JTextField txName = new JTextField();
	JCheckBox chVaccinated = new JCheckBox("vaccinated");
	JTextField txAddress = new JTextField();
	
	public InputDataForm() {
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new GridLayout(3, 2, 5, 5));
		add(new JLabel("Name:", SwingConstants.RIGHT));
		add(txName);
		add(new JLabel()); // placeholder
		add(chVaccinated);
		add(new JLabel("Address:", SwingConstants.RIGHT));
		add(txAddress);
	}
}
