package learn;


// inner class, anonoymance 

public class learnInnerClass {

	private class Inner{

		
	}
	private Inner x;
	public learnInnerClass(){
		x=new Inner();//points to this, there is no pointer to parent
	}
	public static void main(String[] args){
		//illeagl: must be within a method of learnInnerClass  Inner x = new Inner;

		new learnInnerClass();
	}
}
