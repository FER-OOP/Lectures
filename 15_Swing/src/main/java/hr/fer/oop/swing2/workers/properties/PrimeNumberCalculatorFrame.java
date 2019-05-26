package hr.fer.oop.swing2.workers.properties;

import hr.fer.oop.swing1.layouts.SpringUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.WindowConstants;

public class PrimeNumberCalculatorFrame extends JFrame {

    private JTextField tfNumber;
    private JTextArea textArea;
    private JButton bCalculate;
    private JProgressBar progressBar;

    public PrimeNumberCalculatorFrame() {

        JPanel panel = new JPanel();

        panel.setLayout(new SpringLayout());

        // row 0
        panel.add(new JLabel("Prvih koliko prostih brojeva:", SwingConstants.RIGHT));

        tfNumber = new JTextField();
        tfNumber.setColumns(10);
        panel.add(tfNumber);

        //row 1
        panel.add(new JLabel("Pokreni izračun:", SwingConstants.RIGHT));

        bCalculate = new JButton();
        bCalculate.setText("Start");
        panel.add(bCalculate);

        bCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int number = Integer.parseInt(tfNumber.getText());

                    //reset GUI components
                    progressBar.setValue(0);
                    bCalculate.setEnabled(false);
                    textArea.setText("");
                    
                    Runnable onDone = () -> bCalculate.setEnabled(true);
                    Consumer<List<Integer>> processChunks = chunks -> {
                    	 for (int primeNumber : chunks) {
                             textArea.append(primeNumber + "\n");
                         }
                    };
                    
                    SwingWorker worker = new PrimeNumbersWorker(number, processChunks, onDone);
                    worker.addPropertyChangeListener(new PropertyChangeListener() {
                        @Override
                        public void propertyChange(PropertyChangeEvent evt) {
                            if ("progress".equals(evt.getPropertyName())) {
                                progressBar.setValue((Integer) evt.getNewValue());
                                System.out.println("Izvodim li se unutar dretve Event Dispatch? " + SwingUtilities.isEventDispatchThread());
                            }
                        }
                    });
                    worker.execute();

                } catch (NumberFormatException ex) {
                    //do nothing
                }
            }
        });

        //row 2
        panel.add(new JLabel("Napredak:", SwingConstants.RIGHT));

        progressBar = new JProgressBar();
        panel.add(progressBar);

        // row 3
        panel.add(new JLabel("Rezultat:", SwingConstants.RIGHT));

        textArea = new JTextArea(10, 25);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        SpringUtilities.makeCompactGrid(panel, 4, 2, 0, 0, 5, 5);

        this.add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrimeNumberCalculatorFrame frame = new PrimeNumberCalculatorFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Prime Numbers Demo");
                frame.setBounds(500, 500, 400, 280);
                frame.setVisible(true);
            }
        });
    }   
}
