package hr.fer.oop.swing2.example06;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class DocumentListenerDemoFrame extends JFrame {

    private final JTextArea taRight;
    private JTextArea taLeft;

    public DocumentListenerDemoFrame() {

        JSplitPane splitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPanel.setResizeWeight(0.5d); //equal width of the components

        taLeft = new JTextArea();
        taLeft.setLineWrap(true);
        taLeft.getDocument().addDocumentListener(new LeftDocumentListener());

        taRight = new JTextArea();
        taRight.setLineWrap(true);
        taRight.setEditable(false);

        //add components to the panel
        splitPanel.setLeftComponent(taLeft);
        splitPanel.setRightComponent(taRight);

        this.add(splitPanel);
    }

    private class LeftDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            Document leftDocument = (Document) e.getDocument();
            int leftCaretPosition = e.getOffset();
            try {
                taRight.getDocument().insertString(leftCaretPosition, reverseCase(leftDocument.getText(leftCaretPosition, e.getLength())), null);
            } catch (BadLocationException ex) {
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
                taRight.getDocument().remove(e.getOffset(), e.getLength());
            } catch (BadLocationException ex) {
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private static String reverseCase(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DocumentListenerDemoFrame frame = new DocumentListenerDemoFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Document Listener Demo");
                frame.setBounds(500, 500, 500, 200);
                frame.setVisible(true);
            }
        });
    }
}

