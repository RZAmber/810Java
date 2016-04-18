package hw6b_julianDate;

public class getYear {
	
	private static double JDN;
	private static int year,mon,day;
	private static int y,m;
	
	static int[] monthValues = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int[] monthSum(){
		int[] sum = new int[12];
		y=year-2000;
		int y1 = getY(JDN)-2000;
		if(y%4 ==0|| y1%4==0) {monthValues[1]=29;}
		for(int i=0; i<sum.length; i++){
			if(i==0) {sum[i]=monthValues[i];}
			else{
				sum[i]=sum[i-1]+monthValues[i];
			}
		}
		return sum;
	}
	
	//get year
	public static int getY(double JDN){
		int y1 =(int)(JDN/365);
		return y1+2000;
	}
	
	//get days at this year
	public static int getDaysN(double JDN){
		int[] sum = monthSum();
		int m1,m2,m3,m4;

		m1 =(int)(JDN/365);
		m2 = (int)JDN%365;
		
		if(m1==0) {m3 = 0;}
		else{ 
		    m3 = (m1-1)/4 - (m1-1)/100 + (m1-1)/400+1;// 1 is the 366-365 at 2000.
		}
		m4 = m2 - m3 +1;
		return m4;
	}
	
	//get month
	public static int getMonth(double JDN){
			int[] sum = monthSum();
			int mm=0;
			int m4 = getDaysN(JDN);
			for(int i=0; i<12;i++){
				if(m4<=sum[0]){ mm = 1; return mm;}
				if(m4>sum[i]&&m4<=sum[i+1]){
					mm=i+2;
					return mm;	
				}
			}
				
			return mm;

		}
	
	public static int getDay(double JDN){
	    int[] sum = monthSum();
	    int d=0;
	    int m4 = getDaysN(JDN);
	    int mm = getMonth(JDN);
	    if(mm==1){d=m4;}
	    else{
	   	    d = m4 - sum[mm-2];
	    }
 	    return d;
	}
	
	
	public static void main(String[] args){
		int d3 = getYear.getY(5904.0);
		System.out.println(d3);
		int d4 = getYear.getMonth(5904.0);
		System.out.println(d4);
		int d5 = getYear.getDay(5904.0);
		System.out.println(d5);

		
	}
}
