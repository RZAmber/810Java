/**
 * 
 * @author Rui Zhan
 *  
 * Hw5a:Calculator
 * Create a calculator with a display (You can look up JLabel or JTextField)
 * Buttons (see our example, class is JButton).
 * Use layout managers BorderLayout (the default) and GridLayout. 
 * If you wish, you can look up the more complicated GridBagLayout
**/


package hw5a_calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {		
	private JTextField display;
	
	public Calculator(){
		super("Calculator");
		
		display = new JTextField();
		Font f = new Font("Times New Roman",Font.BOLD,55);
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,4));
		JButton[] buttons = new JButton[20];
		String[] buttonsS = {
				"AC","C","%","÷",
				"7","8","9","×",
				"4","5","6","-",
				"1","2","3","+",
				"0",".","+/-","="};
		
		// create the dimension widths and heights of the buttons
//		int[] dimW={400,100,200};
//		int[] dimH={150,90};

	
		// inner class
		for (int i = 0; i < 20; i++) {
			buttons[i]=new JButton();
			buttons[i].setText(buttonsS[i]);
			p.add(buttons[i]);
	 		buttons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					display.setText(  ((JButton)e.getSource()).getText() );
				}
			});
		}
		
		display.setFont(f);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		display.setPreferredSize(displayDimension);
//		for(int i = 0; i<17;i++)
//			buttons[i].setPreferredSize(regularDimension);
//		Dimension zeroButDimension = new Dimension(200,90);
//		buttons[18].setPreferredSize(zeroButDimension);
		
		setSize(400,600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);			
		
		Container c = getContentPane();
		c.add(BorderLayout.CENTER, p);
		c.add(BorderLayout.NORTH, display);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new Calculator();
	}

}
