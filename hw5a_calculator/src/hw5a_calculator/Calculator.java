/**
 * 
 * @author Rui Zhang
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
		Font f = new Font("Dialog",Font.ITALIC,32);
		display.setFont(f);
		display.setEditable(false);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,4));
		String[] names = {
				"AC","+/-","%","/",
				"7","8","9","*",
				"4","5","6","-",
				"1","2","3","+",
				"0","0",".","="
		};
		for (int i = 0; i < names.length; i++) {
			JButton b = new JButton(names[i]);
			p.add(b);
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					display.setText(  ((JButton)e.getSource()).getText() );
				}
			});
		}
		setSize(400,600);
		Container c = getContentPane();
		c.add(BorderLayout.CENTER, p);
		c.add(BorderLayout.NORTH, display);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new Calculator();
	}

}
