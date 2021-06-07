package hr.fer.oop.homework_13_e4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ComplexNumbersConverter extends JFrame {
	private JLabel  lbModule = new JLabel(" Module:  ", SwingConstants.RIGHT);
	private JLabel  lbAngle = new JLabel(" Angle (in degrees)):  ", SwingConstants.RIGHT);
	private JLabel  lbReal = new JLabel(" Real part:  ", SwingConstants.RIGHT);
	private JLabel  lbImag = new JLabel(" Imaginary part:  ", SwingConstants.RIGHT);
	
	private JTextField txModule = new JTextField(JTextField.CENTER);
	private JTextField txAngle = new JTextField(JTextField.CENTER);
	private JTextField txReal = new JTextField(JTextField.CENTER);
	private JTextField txImag = new JTextField(JTextField.CENTER);
		
	private JToggleButton tbRectangular= new JToggleButton("To rectg");
    private JToggleButton tbPolar = new JToggleButton("To polar");
    
    private JTextArea taResult = new JTextArea();
    
    private JMenuBar mb = new JMenuBar();
    private JMenu mAction = new JMenu("Action");
    private JMenuItem calculateItem = new JMenuItem("Calculate");
    private JMenuItem clearItem = new JMenuItem("Clear");
    private JMenuItem exitItem = new JMenuItem("Exit");
    private JMenu mStyle = new JMenu("Style");
    private JMenuItem boldItem = new JMenuItem("BOLD");
    private JMenuItem plainItem = new JMenuItem("PLAIN");
	 
    private Font fontPlain = new Font("Monospaced", Font.PLAIN, 20);
    private Font fontBold = new Font("Monospaced", Font.BOLD, 20); 
    private DecimalFormatSymbols decimalSeparator = new DecimalFormatSymbols();
    private DecimalFormat formatter;
   
    
    public ComplexNumbersConverter()  {
		super("Rectangular <-> Polar");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		decimalSeparator.setDecimalSeparator('.');
		formatter = new DecimalFormat("###.##", decimalSeparator);
		
		JMenu actionMenu = createActionMenu();
	    JMenu styleMenu = createStyleMenu();
	    mb.add(actionMenu);
	    mb.add(styleMenu);
	    setJMenuBar(mb);
		
	    JPanel buttonPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        tbPolar.setSelected(true);
        buttonGroup.add(tbRectangular);
        buttonPanel.add(tbRectangular);
        buttonGroup.add(tbPolar);
        buttonPanel.add(tbPolar);
       
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(4, 0, 3, 3));
        labelPanel.add(lbReal);
        labelPanel.add(lbImag);
        labelPanel.add(lbModule);
        labelPanel.add(lbAngle);
        
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 0, 3, 3));
        txModule.setEditable(false);
        txAngle.setEditable(false);
        inputPanel.add(txReal);
        inputPanel.add(txImag);
        inputPanel.add(txModule);
        inputPanel.add(txAngle);
        
        taResult.setEditable(false);
        taResult.setFont(fontPlain);
        
        add(buttonPanel, BorderLayout.PAGE_START);
        add(labelPanel, BorderLayout.LINE_START);
        add(inputPanel, BorderLayout.CENTER);
        add(taResult, BorderLayout.PAGE_END);
        
        txReal.setHorizontalAlignment(JTextField.CENTER);
        txReal.setFont(fontPlain);
        txImag.setHorizontalAlignment(JTextField.CENTER);
        txImag.setFont(fontPlain);
        txModule.setHorizontalAlignment(JTextField.CENTER);
		txModule.setFont(fontPlain);
		txAngle.setHorizontalAlignment(JTextField.CENTER);
		txAngle.setFont(fontPlain);
		
		tbRectangular.addActionListener((event)->{
			clearItem.doClick();
			txReal.setEditable(false);
			txImag.setEditable(false);
			txModule.setEditable(true);
			txAngle.setEditable(true);
		});
		tbPolar.addActionListener((event)->{
			clearItem.doClick();
			txReal.setEditable(true);
			txImag.setEditable(true);
			txModule.setEditable(false);
			txAngle.setEditable(false);
		});
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txReal.requestFocusInWindow();
			}
		});
		
	}
    
    
    private JMenu createActionMenu() {
    	//set shortcut ALT+A ( on mac os ?)
        KeyStroke ctrlA = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK);
        calculateItem.setAccelerator(ctrlA);
        mAction.add(calculateItem);
        calculateItem.addActionListener((e)->{
	    	taResult.setText("");
	    	if(tbPolar.isSelected()) {
	    		double real = 0.;
	    		double imag = 0.;
 	    		try {
	    			real = Double.valueOf(txReal.getText());
	    			imag = Double.valueOf(txImag.getText());
	    		}catch (NumberFormatException ex) {
		        	taResult.setText("wrong input");
		        	txModule.setText("");
		        	txAngle.setText("");
			        return;
			    }
 	    		double [] result = Calculator.toPolar(real, imag);
 	    		txModule.setText(formatter.format(result[0]));
 	    		txAngle.setText(formatter.format(result[1]));
	    		taResult.setText(formatter.format(result[0]) +"  |" + formatter.format(result[1]));
	    	}
	    	if(tbRectangular.isSelected()) {
	    		double module = 0.;
	    		double angle = 0.;
 	    		try {
	    			module = Double.valueOf(txModule.getText());
	    			angle = Double.valueOf(txAngle.getText());
	    			if(module < 0.) throw new NumberFormatException();
	    		}catch (NumberFormatException ex) {
		        	taResult.setText("wrong input");
		        	txReal.setText("");
		        	txImag.setText("");
			        return;
			    }
 	    		double [] result = Calculator.toRectg(module, angle);
 	    		txReal.setText(formatter.format(result[0]));
 	    		txImag.setText(formatter.format(result[1]));
 	    		if(result[1]<0.)
 	    			taResult.setText(formatter.format(result[0]) +  formatter.format(result[1]) +"i");
 	    		else
 	    			taResult.setText(formatter.format(result[0]) + "+" +  formatter.format(result[1])+"i");
	    	}
	    	
	    });
			
    	mAction.add(clearItem);
    	clearItem.addActionListener(event -> {
    		txReal.setText("");
			txImag.setText("");
			txModule.setText("");
			txAngle.setText("");
			taResult.setText("");
			if(tbPolar.isSelected()) {
				txReal.requestFocusInWindow();
			}else {
				txModule.requestFocusInWindow();
			}
    	});
    	
    	mAction.addSeparator();
    	  
    	mAction.add(exitItem);
    	exitItem.addActionListener(event -> System.exit(0));
       
        return mAction;
    }
    
    private JMenu createStyleMenu() {
    	mStyle.add(boldItem);
    	boldItem.addActionListener(event -> {
    		txReal.setFont(fontBold);
			txImag.setFont(fontBold);
			txModule.setFont(fontBold);
			txAngle.setFont(fontBold);
			taResult.setFont(fontBold);
    	});
    	
    	mStyle.add(plainItem);
    	plainItem.addActionListener(event -> {
    		txReal.setFont(fontPlain);
			txImag.setFont(fontPlain);
			txModule.setFont(fontPlain);
			txAngle.setFont(fontPlain);
			taResult.setFont(fontPlain);
    	});
    
    	return mStyle;
    }	

	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->  new ComplexNumbersConverter().setVisible(true));
	}
}


