package hr.fer.oop.generictable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 * A class to demonstrate the usage of GenericTablePanel
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class GenericTableMain {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JFrame window = new JFrame();
            window.setLocation(20, 20);
            window.setSize(200, 120);
            window.setVisible(true);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setTitle("Generic Table Demonstrator");

            //define the table size and add it to the frame center
            GenericTablePanel<Record> tablePanel = new GenericTablePanel<>(Record.class);
            tablePanel.setPreferredSize(new Dimension(200, 100));
            window.add(tablePanel, BorderLayout.CENTER);

            JButton button = new JButton("Add records");
            window.add(button, BorderLayout.SOUTH);
            button.addActionListener(e -> {
                //fill the table with some records and show them
                List<Record> recordList = new ArrayList<>();
                recordList.add(new Record(1, 1.0, "jedan"));
                recordList.add(new Record(2, 2.0, "dva"));
                recordList.add(new Record(3, 3.0, "tri"));                
                tablePanel.update(recordList);

                //print tabe content to the console
                List<Record> recordsInTableList = tablePanel.getRecords();
                for (Record record : recordsInTableList) {
                    System.out.println(record);
                }
            });

            window.pack();
        });
    }

    public static class Record {

        public int valueA;
        public double valueB;
        public String valueC;

        public Record(int valueA, double valueB, String valueC) {
            this.valueA = valueA;
            this.valueB = valueB;
            this.valueC = valueC;
        }

        @Override
        public String toString() {
            return "Record{" + "valueA=" + valueA + ", valueB=" + valueB + ", valueC=" + valueC + '}';
        }
    }
}
