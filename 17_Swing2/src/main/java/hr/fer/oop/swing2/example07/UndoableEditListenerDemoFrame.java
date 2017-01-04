package hr.fer.oop.swing2.example07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class UndoableEditListenerDemoFrame extends JFrame {

    private JTextArea textArea;
    private UndoManager undoManager;

    public UndoableEditListenerDemoFrame() {

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        this.add(textArea);

        //add undo menu bar
        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton undoButton = new JButton("<-");
        undoButton.setEnabled(false);
        toolBar.add(undoButton);

        JButton redoButton = new JButton("->");
        redoButton.setEnabled(false);
        toolBar.add(redoButton);

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                undoManager.undo();
                if (!undoManager.canUndo()) {
                    undoButton.setEnabled(false);
                }
                redoButton.setEnabled(true);
            }
        });

        redoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undoManager.redo();
                if (!undoManager.canRedo()) {
                    redoButton.setEnabled(false);
                }
                undoButton.setEnabled(true);
            }
        });

        //setup undo manager
        undoManager = new UndoManager();
        textArea.getDocument().addUndoableEditListener(undoManager);

        //add listener for undoable events
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoButton.setEnabled(true);
                redoButton.setEnabled(false);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UndoableEditListenerDemoFrame frame = new UndoableEditListenerDemoFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Undoable Edit Listener Demo");
                frame.setBounds(500, 500, 300, 300);
                frame.setVisible(true);
            }
        });
    }
}
