package hr.fer.oop.task4;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

public class IBANFrame extends JFrame {

    private JTextField ibanField;
    private JTextField validField;

    public IBANFrame() {
        super.setLayout(new GridLayout(3, 2));

        JLabel ibanLabel = new JLabel("IBAN");
        super.add(ibanLabel);

        ibanField = new JTextField("HR", 21);
        super.add(ibanField);

        JLabel validLabel = new JLabel("Validan:");
        super.add(validLabel);

        validField = new JTextField();
        validField.setEditable(false);
        super.add(validField);

        //empty label to occupy space
        super.add(new JLabel());

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

        super.add(button);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JFrame frame = new IBANFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setLocation(100, 100);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
