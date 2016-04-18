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
			"AC","CE","%","÷",
			"7","8","9","×",
			"4","5","6","-",
			"1","2","3","+",
			"0",".","+/-","="};
//	StringBuilder operator = new StringBuilder("");//store operator
	JTextArea display = new JTextArea(1,20);
	JPanel p = new JPanel();
	
	public Calculator(){
		super("Calculator");
		setSize(250,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
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
// button AC methond
	public void clear(){
			display.setText("");
			for(int i = 0; i<4 ;i++)
				function[i]=false;
			for(int i=0 ; i<2; i++)
				temporary[i]=0;
	}
//	button CE methond
	public void delete(){
		display.setText(display.getText().substring(0,display.getText().length()-1));
	}
//	button % method
	public void perc(){
		double i = Double.parseDouble(display.getText());//change String to double
		display.setText(Double.toString(i/100));//change double to string
	}
//	button +/- method
	public void getPosNeg(){
		StringBuilder s1 = new StringBuilder();
		s1.append(display.getText());
		if(display.getText().equals("")||display.getText().equals("0")){
			s1.append("");
			display.setText(s1.toString());
		}else{
			if(s1.toString().endsWith("-")){
				s1.deleteCharAt(display.getText().length()-1);
				display.setText(s1.toString());
			}
			else{
				s1.insert(display.getText().length(),"-");				
    			display.setText(s1.toString());
		}
		}
	}
//	button = method
	public void getresult(){
		double result = 0;
		temporary[1]=testPN(display.getText());     
		if(function[0]==true)
			result = temporary[0]/temporary[1];
		else if(function[1]==true)
			result = temporary[0]*temporary[1];
		else if(function[2]==true)
			result = temporary[0]-temporary[1];
		else if(function[3]==true)
			result = temporary[0]+temporary[1];
		if(result<0) 
			display.setText(Double.toString(result).substring(1, Double.toString(result).length())+"-");
		else
			display.setText(Double.toString(result));
		for(int i=0; i<4;i++)
			function[i]=false;
//        operator.setLength(0);
//        operator.append("=");
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
			if(display.getText().contains("."))
				display.append("");
			else
				display.append(".");
		
		if(e.getSource()==buttons[3]){
			temporary[0]=testPN(display.getText());
			//divide funtion[0]
			function[0]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[7]){
			temporary[0]=testPN(display.getText());;
			//multiply function[1]
			function[1]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[11]){
			temporary[0]=testPN(display.getText());
			//subtract function[2]
			function[2]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[15]){
			temporary[0]=testPN(display.getText());
			//add function[3]
			function[3]=true;
			display.setText("");
		}
		if(e.getSource()==buttons[0]) clear();
		if(e.getSource()==buttons[1]) delete();
		if(e.getSource()==buttons[2]) perc();
		if(e.getSource()==buttons[18]) getPosNeg();
		if(e.getSource()==buttons[19]) getresult();	
	}
	public double testPN(String s2){
		double temp;
		if(s2.contains("-")){
			String[] s20=s2.split("-",2);
			temp=(Double.parseDouble(s20[0])*-1);
			}else{
			temp=Double.parseDouble(display.getText());
			}
		return temp;
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

}
