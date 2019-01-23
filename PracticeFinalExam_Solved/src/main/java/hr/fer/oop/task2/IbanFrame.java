package hr.fer.oop.task2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

public class IbanFrame extends JFrame {
    
    public IbanFrame() {
        setLayout(new GridLayout(0, 2));

        JLabel ibanLabel = new JLabel("IBAN");
        add(ibanLabel);

        JTextField ibanField = new JTextField("HR", 21);
        add(ibanField);

        JLabel validLabel = new JLabel("Validan:");
        add(validLabel);

        JTextField validField = new JTextField();
        validField.setEditable(false);
        add(validField);

        //empty label to occupy space
        add(new JLabel());

        JButton button = new JButton("Validiraj");

        button.addActionListener((ActionEvent e) -> {
            String enteredIban = ibanField.getText();

            Runnable heavyTask = () -> {
                IBANCheckDigit validator = new IBANCheckDigit();

                String validText;
                if (validator.isValid(enteredIban)) {
                    validText = "DA";
                } else {
                    validText = "NE";
                }

                SwingUtilities.invokeLater(() -> validField.setText(validText));
            };

            new Thread(heavyTask).start();
        });

        add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new IbanFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocation(100, 100);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

