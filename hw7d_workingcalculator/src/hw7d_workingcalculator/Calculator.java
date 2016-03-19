package hw7d_workingcalculator;

/**
 * 
 * @author Rui Zhan
 *  
 * Hw7d:Calculator
 * Create a working calculator.
 * it should be a full working 4-function calculator(add,subtract,multiply, deivide)
**/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{		
	Font f = new Font("Times New Roman",Font.BOLD,55);
	Font f1 = new Font("Times New Roman",Font.BOLD,20);
	double[] temporary = {0,0};
	boolean[] function = new boolean[4];
	JButton[] buttons = new JButton[20];
	String[] buttonsS = {
			"AC","C","%","÷",
			"7","8","9","×",
			"4","5","6","-",
			"1","2","3","+",
			"0",".","+/-","="};
	
	JTextArea display = new JTextArea(1,20);
	JPanel p = new JPanel();
	
	Calculator(){
		super("Calculator");

		setSize(250,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,4));	
	
		// inner class
		for (int i = 0; i < 20; i++) {
			buttons[i]=new JButton();
			buttons[i].setText(buttonsS[i]);
			buttons[i].setFont(f1);
			p.add(buttons[i]);
	 		buttons[i].addActionListener(this);	
		}
		
		display.setFont(f);
		display.setEditable(false);// making the input is not allowed by keyboard
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);//make input appears from right to left on the display	
		
		Container c = getContentPane();
		c.add(BorderLayout.NORTH, display);
		c.add(BorderLayout.CENTER, p);
		setVisible(true);
	}

	public void clear(){
		try{
			display.setText("");
			for(int i = 0; i<4 ;i++)
				function[i]=false;
			for(int i=0 ; i<2; i++)
				temporary[i]=0;
		}catch(NullPointerException e){
		}
	}
	public void delete(){
		display.setText(display.getText().substring(0,display.getText().length()-1));
	}
	public void perc(){
		double i = Double.parseDouble(display.getText());//change String to double
		display.setText(Double.toString(i/100));//change double to string
	}
	public void getPosNeg(){
		double x = Double.parseDouble(display.getText());
		if(x!=0){
			x=x*(-1);
			display.setText(Double.toString(x));
		}

		
	}
	public void getresult(){
		double result = 0;
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==buttons[4])
		    display.append("7");	
		if(e.getSource()==buttons[5])
			display.append("8");
		if(e.getSource()==buttons[6])
			display.append("9");
		if(e.getSource()==buttons[8])
			display.append("4");
		if(e.getSource()==buttons[9])
			display.append("5");
		if(e.getSource()==buttons[10])
			display.append("6");
		if(e.getSource()==buttons[12])
			display.append("1");
		if(e.getSource()==buttons[13])
			display.append("2");
		if(e.getSource()==buttons[14])
			display.append("3");
		if(e.getSource()==buttons[16])
			display.append("0");
		if(e.getSource()==buttons[17])
			display.append(".");

		if(e.getSource()==buttons[3]){
			temporary[0]=Double.parseDouble(display.getText());
			//divide funtion[0]
			function[0]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[7]){
			temporary[0]=Double.parseDouble(display.getText());//transfer string to double
			//multiply function[1]
			function[1]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[11]){
			temporary[0]=Double.parseDouble(display.getText());
			//multiply function[1]
			function[2]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[15]){
			temporary[0]=Double.parseDouble(display.getText());
			//multiply function[1]
			function[3]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[0]) clear();
		if(e.getSource()==buttons[1]) delete();
		if(e.getSource()==buttons[2]) perc();
		if(e.getSource()==buttons[18]) getPosNeg();
		if(e.getSource()==buttons[19]) getresult();
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
