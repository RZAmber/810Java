
//对了

package hw6b_julianDate;


public class testJLD {
	private double JDN,JD;
	private static int year,mon,day;
	private double hour,min,sec;
	private static int y,m;
    
    
	public testJLD(int year,int mon,int day) {
		this.year = year;
		this.mon = mon;
		this.day = day;
	}
	
	public testJLD(int year, int mon, int day,
			int hour, int min, int sec) {
	this.year = year;
	this.mon = mon;
	this.day = day;
	this.hour = hour;
	this.min = min;
	this.sec = sec;	
}
	
	
	static int[] monthValues = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int[] monthSum(){
		int[] sum = new int[12];
		y=year-2000;
		if(y%4==0) {monthValues[1]=29;}
		for(int i=0; i<sum.length; i++){
			if(i==0) {sum[i]=monthValues[i];}
			else{
				sum[i]=sum[i-1]+monthValues[i];
			}
		}
		return sum;
	}
	
	public double JDN(){
		int[] sum = monthSum();
		y = year-2000;
		m = mon-1;
		if(m==0){JDN = day+365*y+(y-1)/4-(y-1)/100+(y-1)/400-1+1; }
		else{
			JDN = day+365*y+(y-1)/4-(y-1)/100+(y-1)/400 + sum[m-1]-1+1; //-1:2000.1.1=0; +1: 2000 is leap year
		}
		if(year==2000) {JDN=JDN-1;}
		return JDN;
	}
	
	public double JD(double JDN){
		JD=JDN + (hour-12)/24 + min/1440 + sec/86400;
		return JD;
		
	}
	
	
	
	public static void main(String[] args) {
		testJLD d1 = new testJLD(2016,3,10);
		double JDN1= d1.JDN();
		testJLD d3 = new testJLD(2001,1,1);
		double JDN2= d3.JDN();
	    System.out.println(JDN1);
		System.out.println(JDN2);
//	    testJLD d2 = new testJLD(2016,3,10,15,20,00);
//		double JD1 = d2.JD(d2.JDN());
//		System.out.println(JD1);
	}



}
