package learn;

import java.awt.*;
import javax.swing.*;

public class learnFrame extends JFrame {
//	public static void learnFrame(){
		//create the frame
////		JFrame f= new JFrame("Test");
		//what happens when the frame close
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//create components and put them in the frame
//		f.getContentPane().add(comp, constraints);
		//size the frame,all its contents are at or above their preferred sizes
		//f.pack();
//		f.setSize(800, 400);
		//show it
//		f.setVisible(true);


	public learnFrame(String title, Color bg) {
		//father  class
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		Container c = getContentPane();
		c.setBackground(bg);
		JButton b = new JButton("ok");
//		c.add(BorderLayout.SOUTH,  new JLabel("testing"));
		JTextField t;
		c.add(BorderLayout.SOUTH,  t = new JTextField("testing"));
		t.setFont(new Font("Times", Font.PLAIN, 28));
		c.add(BorderLayout.NORTH, b);
		b = new JButton("cancel");
		c.add(BorderLayout.EAST, b);
		
		JPanel p = new JPanel();
		p.setBackground(Color.GREEN);
		p.setLayout(new GridLayout(2, 3, 5, 10));
		for (int i = 0; i < 6; i++) {
			b = new JButton(i + "");
			p.add(b);
		}
		c.add(BorderLayout.CENTER, p);
		
		
		
		
		
		this.setVisible(true);		
	}
	public static void main(String[] args) {
		new learnFrame("test", Color.RED);
		
	}

}
