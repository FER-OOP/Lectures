package hr.fer.oop.swing2.example08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;

public class ShoppingListFrame extends JFrame {

    private final JTextField newItemField;
    private final DefaultListModel<String> listModel;
    private final JPopupMenu popupMenu;    
    private int selectedIndex = -1;

    public ShoppingListFrame() {

        //create a list model and add some items to it
        listModel = new DefaultListModel<>();
        listModel.addElement("glavica kupusa");
        listModel.addElement("jogurt");
        listModel.addElement("jaja");
        listModel.addElement("brašno");
        listModel.addElement("mentol bomboni");
        listModel.addElement("banane");
        listModel.addElement("voćni sok");
        listModel.addElement("tijesto za pizzu");
        listModel.addElement("sardine");

        //setup list view        
        JList<String> itemList = new JList<>(listModel);
        itemList.setLayoutOrientation(JList.VERTICAL_WRAP);
        itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //set list selection model        
        ListSelectionModel listSelectionModel = itemList.getSelectionModel();
        listSelectionModel.addListSelectionListener(this.getListSelectionListener());

        JScrollPane scrollPane = new JScrollPane(itemList);
        this.add(scrollPane, BorderLayout.CENTER);

        //add components to button panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton removeButton = new JButton("Ukloni");
        removeButton.setForeground(Color.RED);
        removeButton.addActionListener(this.getRemoveListener(itemList, removeButton));
        buttonPanel.add(removeButton);

        newItemField = new JTextField(18);
        buttonPanel.add(newItemField);

        JButton addButton = new JButton("Dodaj");
        addButton.addActionListener(this.getAddListener(itemList, removeButton));
        buttonPanel.add(addButton);

        this.add(buttonPanel, BorderLayout.SOUTH);

        //add popup menu to list
        popupMenu = new JPopupMenu();
        JMenuItem copyItem = new JMenuItem("Kopiraj");
        copyItem.setMnemonic(KeyEvent.VK_K);
        copyItem.addActionListener(this.getCopyListener(itemList));
        popupMenu.add(copyItem);

        JMenuItem pasteItem = new JMenuItem("Zalijepi");
        pasteItem.setMnemonic(KeyEvent.VK_Z);
        pasteItem.addActionListener(this.getPasteListener(itemList));
        popupMenu.add(pasteItem);

        JMenu filesItem = new JMenu("Datoteka");
        filesItem.setMnemonic(KeyEvent.VK_D);
        popupMenu.add(filesItem);

        JMenuItem menuItem = new JMenuItem("Snimi kao...");
        menuItem.setMnemonic(KeyEvent.VK_S);
        menuItem.addActionListener(this.getSaveListener());
        filesItem.add(menuItem);

        JMenuItem loadMenuItem = new JMenuItem("Otvori");
        loadMenuItem.setMnemonic(KeyEvent.VK_O);
        loadMenuItem.addActionListener(this.getLoadListener());
        filesItem.add(loadMenuItem);

        itemList.setComponentPopupMenu(popupMenu);
    }

    private ListSelectionListener getListSelectionListener() {
        return new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();

                if (!lsm.getValueIsAdjusting()) {
                    selectedIndex = lsm.getMinSelectionIndex();
                }
            }
        };
    }

    private ActionListener getCopyListener(JList itemList) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = selectedIndex; //alternatively use itemList.getSelectedIndex();

                if (index != -1) {
                    String itemName = listModel.get(index);

                    Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();

                    StringSelection clipboardData = new StringSelection(itemName);
                    c.setContents(clipboardData, clipboardData);
                }
            }
        };
    }

    private ActionListener getPasteListener(JList itemList) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable t = c.getContents(null);

                if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String itemName = (String) t.getTransferData(DataFlavor.stringFlavor);
                        insertItemToList(itemName, itemList);

                    } catch (UnsupportedFlavorException | IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        };
    }

    private ActionListener getLoadListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add file filter to chooser
            	JFileChooser chooser = new javax.swing.JFileChooser();
                chooser.addChoosableFileFilter(new TxtFileFilter());

                int option = chooser.showOpenDialog(ShoppingListFrame.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = chooser.getSelectedFile();

                    try {
                        List<String> lines = Files.readAllLines(file.toPath());
                        //delete items from the model and add loaded lines
                        listModel.clear();
                        for (String line : lines) {
                            listModel.addElement(line);
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ShoppingListFrame.this, "Cannot open the selected file", "Problem", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
    }

    private ActionListener getSaveListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.addChoosableFileFilter(new TxtFileFilter());

                int option = chooser.showSaveDialog(ShoppingListFrame.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = chooser.getSelectedFile();

                        //copy list items to a string list and save it to the disk
                        List<String> items = Arrays.asList(Arrays.copyOf(listModel.toArray(), listModel.size(), String[].class));
                        Files.write(file.toPath(), items, StandardOpenOption.CREATE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(ShoppingListFrame.this, "Cannot save the file", "Problem", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
    }

    private ActionListener getAddListener(JList itemList, JButton removeButton) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = newItemField.getText();
                if (insertItemToList(itemName, itemList)) {
                    if (listModel.size() == 1) {
                        //first item in the list, enable removal
                        removeButton.setEnabled(true);
                    }
                };
            }
        };
    }

    private ActionListener getRemoveListener(JList itemList, JButton removeButton) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = selectedIndex; //alternatively use itemList.getSelectedIndex();

                if (index != -1) {
                    listModel.remove(index);

                    if (listModel.getSize() == 0) {
                        //no items left, disable removal
                        removeButton.setEnabled(false);
                        selectedIndex = -1;
                    } else {
                        //if the removed item is last in the list, select the one above it
                        if (index == listModel.getSize()) {
                            index--;
                        }

                        itemList.setSelectedIndex(index);
                        itemList.ensureIndexIsVisible(index);
                    }
                }
            }
        };
    }

    private boolean insertItemToList(String itemName, JList itemList) {
        //show alert when item name is too short
        if (itemName.length() < 3) {
            JOptionPane.showMessageDialog(ShoppingListFrame.this, "Naziv stavke koju dodajete treba imati barem tri slova", "Obavijest", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if (listModel.contains(itemName)) {
            //show alert when item is already added
            JOptionPane.showMessageDialog(ShoppingListFrame.this, "Stavka je već dodana u listu", "Upozorenje", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            int index = selectedIndex; //alternatively use itemList.getSelectedIndex();

            //add item after the selected item or at the bottom
            if (index == -1) {
                index = listModel.getSize();
            } else {
                index++;
            }
            listModel.insertElementAt(itemName, index);

            //clear the field
            newItemField.setText("");

            //select the new item and make it visible.
            itemList.setSelectedIndex(index);
            itemList.ensureIndexIsVisible(index);
            return true;
        }
    }

    private static class TxtFileFilter extends FileFilter {

        @Override
        public boolean accept(File file) {
            if (file == null) {
                return false;
            }
            return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
        }

        @Override
        public String getDescription() {
            return "TXT files";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShoppingListFrame frame = new ShoppingListFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Simple Shopping List");
                frame.setBounds(500, 500, 400, 200);
                frame.setVisible(true);
            }
        });
    }
}
