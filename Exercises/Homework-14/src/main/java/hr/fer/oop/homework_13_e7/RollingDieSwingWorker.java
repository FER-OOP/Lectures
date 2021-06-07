package hr.fer.oop.homework_13_e7;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.BorderFactory;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class RollingDieSwingWorker extends JFrame {

	private JLabel lbRollings = new JLabel("", JLabel.CENTER);
	private JSlider slRollings = new JSlider(0, 1000000, 200000);
	private final JTextField [] txOccurences, txRelFrequency;
	private JButton btStart = new JButton("Start");
	private JButton btCalculate = new JButton("Calculate relative freq."); 
	private long total;
	int dieValue = 0;
	private final int DIE_VALUES = 6;
	
	public RollingDieSwingWorker() {
		super("Rolling Die");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(200, 200);
		
		JPanel pnSlider = new JPanel();
		pnSlider.setLayout(new BorderLayout());
		lbRollings.setBackground(Color.WHITE);
		lbRollings.setOpaque(true);
		slRollings.setMajorTickSpacing(200000);
		slRollings.setMinorTickSpacing(100000);
		slRollings.setPaintTicks(true);
		slRollings.setPaintLabels(true);
		lbRollings.setText(String.valueOf(slRollings.getValue()));
		pnSlider.add(lbRollings, BorderLayout.NORTH);
		pnSlider.add(slRollings, BorderLayout.SOUTH);
		add(pnSlider, BorderLayout.NORTH);

		JPanel pnResults = new JPanel();
		pnResults.setLayout(new GridLayout(DIE_VALUES, 0, 3, 3));
		txOccurences = makeTextFields();
		txRelFrequency = makeTextFields();
		for(int i = 0; i < DIE_VALUES; i++) {
			pnResults.add(txOccurences[i]);
			pnResults.add(txRelFrequency[i]);
		}
		add(pnResults, BorderLayout.CENTER);

		JPanel pnButtons = new JPanel();
		pnButtons.add(btStart);
		pnButtons.add(btCalculate);
		add(pnButtons, BorderLayout.SOUTH);
		pack();
		
		slRollings.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				lbRollings.setText(String.valueOf(slRollings.getValue()));
			}	
	    });
		
		btStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btStart.setEnabled(false); 
				slRollings.setEnabled(false);
				for(int i = 0; i<DIE_VALUES; i++) {
					txOccurences[i].setText("0");
					txRelFrequency[i].setText("0");
				}
				new RollingTask(Integer.parseInt(lbRollings.getText())).execute();
			}
		});
		
		btCalculate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i<DIE_VALUES; i++) {
					try {
						txRelFrequency[i].setText(
						String.format("%5.4f  ",Integer.valueOf(txOccurences[i].getText())/(double)total));
					}catch(NumberFormatException ex) {
						System.out.println(ex);
					}
				}
			}	
		});
		
	}

	
	private class RollingTask extends SwingWorker<Void, Integer []> {
		private int noOfRolling; 
		
		public RollingTask(int noRolling){
			this.noOfRolling = noRolling;
		}
		@Override
		protected Void doInBackground() {
			total = 0L;
			Integer [] outcome = {0, 0, 0, 0, 0, 0}; 
			Random random = new Random();
			System.out.println("Intensive task is running on Event Dispatch Thread? " + SwingUtilities.isEventDispatchThread());
			while(total < noOfRolling) {
				total++;
				dieValue = random.nextInt(DIE_VALUES);
				outcome[dieValue]++;
				if(total % 1000 == 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) { }
				}	
				publish(outcome);
				
  			}
			return null;
		}

		@Override
		protected void process(List<Integer[]> progress) {
			Integer[] lastOutcome = progress.get(progress.size() - 1);  // only last is taken
			for(int i = 0; i < DIE_VALUES; i++) {
				txOccurences[i].setText(String.format("%d", lastOutcome[i]));
			}
		}
		
		@Override
		protected void done() {
		      btStart.setEnabled(true);
		      slRollings.setEnabled(true);
		}
		
	}
	
	private JTextField [] makeTextFields() {
		JTextField [] texts = new JTextField[DIE_VALUES];
		for(int i = 0; i<texts.length; i++) {
			JTextField t = new JTextField(20);
			t.setEditable(false);
			t.setHorizontalAlignment(JTextField.RIGHT);
			t.setText("0");
			texts[i] = t;
		}
		return texts;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new RollingDieSwingWorker().setVisible(true);
			}
		});
	}	
}
