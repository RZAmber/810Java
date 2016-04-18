/**
 * @Rui Zhang
 * hw10a: Pars text file equation
 * Open a text file hw10a.dat containing the following
 * 10 + 4         output = 14
 * 5 / 2             output = 2.5
 * 2 * 4           output = 8
 */


package hw10a_ParseTextFileEquation;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ParseEquation {
	
	public static String Calculate(String expression){
		String equation = "(\\d+)(\\+|\\-|\\/|\\*)(\\d+)";// in java, use double slash instead of one slash in regex
		Pattern pattern = Pattern.compile(equation);
		Matcher matcher = pattern.matcher(expression);
		String finalExp=expression;
		String result = "";
		while(matcher.find()){
			double d1 = Double.parseDouble(matcher.group(1).trim()); //group 1 is the content of the first parentheses of equation
			double d2 = Double.parseDouble(matcher.group(3).trim()); //String.trim(): move the space of the start and end
			String operator = matcher.group(2);
			if(operator.equals("+"))
				result = Double.toString(d1+d2);
			if(operator.equals("/"))
				result = Double.toString(d1/d2);
			if(operator.equals("-"))
				result = Double.toString(d1-d2);
			if(operator.equals("*"))
				result = Double.toString(d1*d2);
			
//			finalExp=matcher.replaceFirst(result);
//			matcher.reset(finalExp);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("/Users/apple/SIT/2016S/810Java/810Java/810Java/HW/hw10a.dat");
		// read hw10a.dat 
		try{
			FileReader fr = new FileReader(f);
			BufferedReader bReader = new BufferedReader(fr);
			String st;
			while( (st = bReader.readLine()) != null) {
				if(st != null){
					System.out.println(st + " = " +ParseEquation.Calculate(st));
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
