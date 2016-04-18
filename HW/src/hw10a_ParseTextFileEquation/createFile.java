package hw10a_ParseTextFileEquation;
//write a dat file contain 10+4  5/2  2*4



import java.io.*;
public class createFile {
	public static void main(String[] args) throws Exception {
		File f = new File("/Users/apple/SIT/2016S/810Java/810Java/810Java/HW");
		f = new File("/Users/apple/SIT/2016S/810Java/810Java/810Java/HW/hw10a.dat");
		f.createNewFile();
		
		try{
		FileWriter fw = new FileWriter(f,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("10+4");
		bw.newLine();
		bw.write("5/2");
		bw.newLine();
		bw.write("2*4");
		bw.flush();
		bw.close();
		fw.close();
		} catch(IOException e){
			e.printStackTrace();
		}
		// read file line by line to confirm the content 
		try{
			FileReader fr = new FileReader(f);
			BufferedReader bReader = new BufferedReader(fr);
			String string;
			while( (string = bReader.readLine()) != null) {
				if(string != null){
					System.out.println(string);
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
