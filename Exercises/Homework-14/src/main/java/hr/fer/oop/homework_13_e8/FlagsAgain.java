package hr.fer.oop.homework_13_e8;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class FlagsAgain extends JFrame implements ListSelectionListener {

	private JLabel lbFlagImage;
    private DefaultListModel<String> model;
    private JSplitPane spPanel;
    private final List<String> EUROPEAN = Arrays.asList( "Austria", "Andorra", "Albania", "Bulgaria",
    		 "Bosnia and Herzegovina", "Belgium", "Belarus", "Denmark", "Croatia", "Greece", "Georgia", 
    		 "France", "Germany", "Finland", "Estonia", "Italy", "Iceland");
    private final List<String> PACIFIC = Arrays.asList( "Australia", "Fiji");
    private JList<String> countries;
    private Map<String, ImageIcon> images = new HashMap<>();
    
    private JButton btLoad = new JButton("Load");
    private JCheckBox cbEuropean = new JCheckBox("European");
    private JCheckBox cbPacific = new JCheckBox("Pacific");
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private JTextField txStatus = new JTextField(" ");
    
    public FlagsAgain() {
    	super("Flags GUI");
    	setLocation(200,200);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	model = new DefaultListModel<>();
    	countries = new JList<>(model);
    	countries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	countries.addListSelectionListener(this);
    	JScrollPane listScrollPanel = new JScrollPane(countries);
    	
    	lbFlagImage = new JLabel();
    	lbFlagImage.setFont(lbFlagImage.getFont().deriveFont(Font.ITALIC));
    	lbFlagImage.setHorizontalAlignment(JLabel.CENTER);
    	JScrollPane pictureScrollPanel = new JScrollPane(lbFlagImage);
    	
    	spPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listScrollPanel, pictureScrollPanel);
    	//spPanel.setOneTouchExpandable(true);
    	spPanel.setDividerLocation(150);
 
        spPanel.setPreferredSize(new Dimension(600, 400));
        
        JPanel buttons = new JPanel();
        buttons.add(cbEuropean);
        buttons.add(cbPacific);
        buttons.add(btLoad);
        
        JPanel pnProgress = new JPanel();
        txStatus.setEditable(false);
        progressBar.setStringPainted(true);
        pnProgress.setLayout(new BorderLayout());
        pnProgress.add(progressBar, BorderLayout.NORTH);
        pnProgress.add(txStatus, BorderLayout.SOUTH);
        
        add(spPanel, BorderLayout.CENTER);
        add(buttons, BorderLayout.NORTH);
        add(pnProgress, BorderLayout.SOUTH);
        
        btLoad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btLoad.setEnabled(false);
				progressBar.setValue(0);
				txStatus.setText("");
			    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				model.clear();
				ImageLoader loader = new ImageLoader();
						
				loader.addPropertyChangeListener(new PropertyChangeListener() {
				      public void propertyChange(PropertyChangeEvent evt) {
					        if ("progress".equals(evt.getPropertyName())) {
					        	int progress = (Integer) evt.getNewValue();
						        progressBar.setValue(progress);
					        }
				      }
				});
					
				loader.execute();		
			}
        });
        
        pack();
        setResizable(false);
    }

	@Override  // stavi da frame bude i listener
	public void valueChanged(ListSelectionEvent e) {
		 @SuppressWarnings("unchecked")
		 JList<String> list = (JList<String>)e.getSource();
		 updateLabel(list.getSelectedValue());
	}
	
	public void updateLabel (String name) {
        ImageIcon icon = images.get(name); 
        lbFlagImage.setIcon(icon);
        if  (icon != null) {
        	lbFlagImage.setText(null);
        } else {
        	lbFlagImage.setText("Image not found");
        }
    }
	
	class ImageLoader extends SwingWorker<String, String> {
		@Override
		protected String doInBackground() throws Exception {
			List<String> toLoad = new ArrayList<>();
			if(cbEuropean.isSelected()) {
				toLoad.addAll(EUROPEAN);
			}	
			if(cbPacific.isSelected()) {
				toLoad.addAll(PACIFIC);
			}
			if(toLoad.isEmpty()) {
				return "Nothing to load.";
			}
			int lengthOfTask = toLoad.size();
			int current = 0;
			setProgress(0);
			for(String country: toLoad) {
				try {								
					String imageAddress = String.format("https://cdn.countryflags.com/thumbs/%s/flag-400.png", country.replace(' ', '-').toLowerCase());
                    URL url = new URL(imageAddress);
                    BufferedImage image = ImageIO.read(url);
                    images.put(country, new ImageIcon(image));
				} catch (Exception exp) {
					return "Problems with network";
                }  
                current++;
                setProgress(100 * current / lengthOfTask);
                publish(country);
                Thread.sleep(50); // to be slower
                
			}
			return "Finished";
		}
		@Override
		protected void process(List<String> countries) {
			for(String country: countries) txStatus.setText("Downloading " + country);
			model.addAll(countries);
		}
		@Override
		protected void done() {
			try {
				txStatus.setText(get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			setCursor(null);
			btLoad.setEnabled(true);
			countries.setSelectionInterval(0, 0);
			progressBar.setValue(0);
		}	
	}
	
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
			public void run() {
            	new FlagsAgain().setVisible(true);
            }
        });
	}

	
}
