package hr.fer.oop.swing2.example05;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SharedModelDemoFrame extends JFrame {

    public SharedModelDemoFrame() {

        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPanel.setResizeWeight(0.5d); //equal width of the components

        JTextField tf1 = new JTextField(0);
        splitPanel.setLeftComponent(tf1);

        //create the second textpane with the model from the first
        JTextField tf2 = new JTextField(tf1.getDocument(), null, 0);
        splitPanel.setRightComponent(tf2);

        this.add(splitPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SharedModelDemoFrame frame = new SharedModelDemoFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Shared Model Demo");
                frame.setBounds(500, 500, 500, 200);
                frame.setVisible(true);
            }
        });
    }
}
