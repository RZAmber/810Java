package hw6b_julianDate;

public class testgetmonth {
	private static String[] monthNames = {"Jan.", "Feb.", "Mar.", "Apr." ,"May.",
            "Jun.","Jul.","Aug.","Sep.","Oct.","Nov.","Dec."};
   
//	public static void setMonthNames(String[] monthNames) {
//		testgetmonth.monthNames = monthNames;
//	}
	public static String getMonthNames(int i) {
		return monthNames[i];
	}
  
	public static void main(String[] args){
	    String b1 = testgetmonth.getMonthNames(1);
		System.out.println(b1);
	}
	
	
}
