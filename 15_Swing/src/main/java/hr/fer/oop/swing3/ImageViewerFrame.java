package hr.fer.oop.swing3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class ImageViewerFrame extends JFrame {

    private final JPanel imagePanel;
    private JMenu openRecentMenu;
    private final Set<String> recentItems = new HashSet<>();
    private JFileChooser chooser = new JFileChooser();
    private JCheckBoxMenuItem rememberSelectionItem;

    public ImageViewerFrame() {
        //add menu bar
        this.add(getMyMenuBar(), BorderLayout.NORTH);

        //add image pane
        imagePanel = new JPanel();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(imagePanel);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private JMenuBar getMyMenuBar() {
        // menu bar
        JMenuBar menuBar = new JMenuBar();

        //file menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        JMenuItem openMenuItem = new JMenuItem();
        openMenuItem.setAction(new OpenFileAction());
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        fileMenu.add(openMenuItem);

        openRecentMenu = new JMenu("Open Recent");
        openRecentMenu.setIcon(new ImageIcon("icons/document-open-recent.png"));
        openRecentMenu.setMnemonic(KeyEvent.VK_R);
        fileMenu.add(openRecentMenu);

        JMenuItem exitMenuItem = new JMenuItem();
        exitMenuItem.setAction(new ExitAction());
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        //settings menu
        JMenu settingsMenu = new JMenu("Settings");
        settingsMenu.setMnemonic(KeyEvent.VK_S);

        //remember selection menu item
        rememberSelectionItem = new JCheckBoxMenuItem("Remember selection");
        rememberSelectionItem.setIcon(new ImageIcon("icons/process-stop.png"));
        rememberSelectionItem.setMnemonic(KeyEvent.VK_M);
        rememberSelectionItem.setSelected(true);
        settingsMenu.add(rememberSelectionItem);

        menuBar.add(settingsMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ImageViewerFrame frame = new ImageViewerFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Simple Image Viewer");
                frame.setBounds(500, 500, 500, 200);
                frame.setVisible(true);
            }
        });
    }

    private class ShowImageInPanelAction extends AbstractAction {

        private BufferedImage image;

        public ShowImageInPanelAction(BufferedImage image, String name) {
            super(name);
            this.image = image;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JLabel label = new JLabel(new ImageIcon(image));
            imagePanel.removeAll();
            imagePanel.add(label);
            imagePanel.revalidate();
        }
    }

    private class ExitAction extends AbstractAction {

        public ExitAction() {
            super("Exit", new ImageIcon("icons/window-close.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class OpenFileAction extends AbstractAction {

        public OpenFileAction() {
            super("Open", new ImageIcon("icons/document-open.png"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!rememberSelectionItem.isSelected()) {
                chooser = new JFileChooser();
            }

            int option = chooser.showOpenDialog(ImageViewerFrame.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();

                if (file == null) {
                    return;
                }

                try {
                    BufferedImage image = ImageIO.read(file);

                    //try to show only files which are images
                    if (image != null) {

                        Action showImageInPanelAction = new ShowImageInPanelAction(image, file.getAbsolutePath());

                        if (rememberSelectionItem.isSelected()) {
	                        //add image to recent items if not already added
	                        if (!recentItems.contains(file.getAbsolutePath())) {
	                            recentItems.add(file.getAbsolutePath());
	
	                            JMenuItem recentItem = new JMenuItem();
	                            recentItem.setAction(showImageInPanelAction);
	
	                            openRecentMenu.add(recentItem);
	                            openRecentMenu.revalidate();
	                        }
                        }

                        //show image in panel
                        showImageInPanelAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

                    } else {
                        JOptionPane.showMessageDialog(ImageViewerFrame.this, "Cannot open the selected file", "Problem", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(ImageViewerFrame.this, "Cannot open the selected file", "Problem", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
