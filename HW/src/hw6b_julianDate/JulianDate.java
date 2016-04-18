package hw6b_julianDate;
/**
 * 
 * @author Rui Zhang
 *  
 * Hw6b:Julian Date
 * 
 * GGC:gregorian calender 
 * it need to get Julian Day Number(JDN) based on base date given current GGC.
 * I need to get Julian Date(JD):is JDN plus the fraction of the day since that instant.
 * I need to use JND to make sure present GGC.
 * I need to do some operation based on input Date. ex: 2012/3/15 +1 = 2012/3/16 or 2012 May. 16 and get day of week.
 * 
 * pick a base date:
 * 2000/1/1  : so 2000, Jan. 1 = 0.00 after noon:12:00
 * Jan.2 = 1
 * Jan. 1 2001 = 366
 * 
 * leap year = 366 days (Feb. 29)
 * year mod 4 == 0 , eg 2004, 2008, 2012 LEAP YEAR
 * year mod 100 == 0, eg 1900, 1700, 1500 NOT A LEAP YEAR (Exception)
 * year mod 400 == 0, LEAP YEAR, 2000 is a leap year, 2400 LEAP
 * 
 * compute the JDN from GGC: m months
 * JDN=day+365y+(y-1)/4-(y-1)/100+(y-1)/400+ (m-1)months days -1+1; 
 * if month = 1 JDN = day +365y+(y-1)/4-(y-1)/100+(y-1)/400 -1+1;
 * JD=JDN+(hour-12)/24+minute/1440+second/86400
 * 
 * 
 * The true Julian Date begins from Jan.1 4713BC.
 * According to the standard formula
 * 2000 1.1: 1+(153*10+2)/5+365*6799+6799/4-6799/100+6799/400-32045=2451545   32045 is 29 February 4801BCE in gregorian calendar
 * 2016 3.10: 10+365*6816+6816/4-6816/100+6816/400-32045=2457458
 * So the difference is 5913
 * So I will verify it to promise the value which i compute adds 2451545 equals the right Julian Day as the Web says                   
 *
 * 
 */

public class JulianDate {
    
	private static double JDN,JD;
	private static int year,mon,day;
	private double hour,min,sec;
	private static int y,m;
  
	private static String[] monthNames = {"Jan.", "Feb.", "Mar.", "Apr." ,"May.",
			                  "Jun.","Jul.","Aug.","Sep.","Oct.","Nov.","Dec."};
	//2000.1.1 is Sat, so let DayofWeek[0] is Sat.
    private static String[] DayofWeek={"Sat.","Sun.","Mon.","Tues.","Wed.","Thur.","Fri."};
	
    
	public JulianDate(int year, int mon, int day) {
		this.year= year;
		this.mon = mon;
		this.day = day;
	}
	public JulianDate(int year, int mon, int day,
				int hour, int min, int sec) {
		this.year = year;
		this.mon = mon;
		this.day = day;
		this.hour = hour;
		this.min = min;
		this.sec = sec;	
	}
	public JulianDate(double i) {
		this.JDN= i;
	}
	
	static int[] monthValues = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static int[] monthSum(){
		int[] sum = new int[12];
		y=year-2000; // known years 
		int y1 = getYear(JDN)-2000;  // known JDN
		if(y%4 ==0|| y1%4==0) {monthValues[1]=29;} //leap year
		for(int i=0; i<sum.length; i++){ 
			if(i==0) {sum[i]=monthValues[i];} //the first element is the days of the first month
			else{
				sum[i]=sum[i-1]+monthValues[i]; // the other elements is the totals days before month. sum[1]=31+29
			}
		}
		return sum;
	}
	
	//Julian day number
	public double JDN(){
		int[] sum = monthSum();
		y = year-2000;
		m = mon-1; //if Jan., use other styple
		if(m==0){JDN = day+365*y+(y-1)/4-(y-1)/100+(y-1)/400-1+1; }
		else{
			JDN = day+365*y+(y-1)/4-(y-1)/100+(y-1)/400 + sum[m-1]-1+1; //-1:2000.1.1=0; +1: 2000 is leap year
		}
		if(year==2000) {JDN=JDN-1;} // minus the added 1 which stands for leap year of 2000.
		return JDN;
	}
	
	//Julian day
	public double JD(double JDN){
		JD=JDN + (hour-12)/24 + min/1440 + sec/86400;
		return JD;	
	}
	
	//get year
	public static int getYear(double JDN){
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
	
	//get day
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
    
    public static void setMonthNames(String[] monthNames) {
		JulianDate.monthNames = monthNames;
	}
	public static void setDayofWeek(String[] dayofWeek) {
		JulianDate.DayofWeek = dayofWeek;
	}
	
	public static String getMonthNames(int i) {
		return monthNames[i-1];
	}
    
	//0: Sun, 1:Mon, 2 : Tues...
	public static String getDayofWeeks(int i) {
		return DayofWeek[i];
	}
	
    // add i days 
	public int add(int i){
		int a = (int) JDN();
		return a+i;	
	}
	
	// the diff between two date
    public static int sub(double i, double j){
		return (int)(j-i);  	
    }

    public int minus(int i){
    	int m = (int) JDN();
    	return m-i;
    	
    }
	// return 2016.1.1
    public String calendar(double JDN){
	    int a = getYear(JDN);
		int b = getMonth(JDN);
		String b1 = getMonthNames(b);
		int c = getDay(JDN);
		return a+"."+b1+""+c;
    }
    
    public String calendar1(int year, int mon, int day){
		return year+"."+mon+"."+day;
    }
    
    
	public static void main(String[] args) {
		JulianDate d1 = new JulianDate(2000, 2, 29,13,45,40);
		double JDN1 = d1.JDN();
		double JD1 = d1.JD(JDN1);
		String week1 = JulianDate.getDayofWeeks((int)(JDN1%7));
		System.out.println(d1.calendar1(year, mon, day)+": The Julian Day Number is " + JDN1);
		System.out.println(d1.calendar1(year, mon, day)+": The Julian Day is " + JD1);
		System.out.println(d1.calendar1(year, mon, day)+" is " + week1);
		double JDN2 = 5904.0;
		JulianDate d2 = new JulianDate(JDN2);
		String week2 = JulianDate.getDayofWeeks((int)(JDN2%7));
		System.out.println("Julian Day Number of " + JDN2 + " is "+d2.calendar(JDN2)+", " + week2);
		int d3 = JulianDate.sub(JDN1,JDN2);
		System.out.println("The difference between " + d1.calendar1(year, mon, day)+" and "+ d2.calendar(JDN2)+" is "+d3+" day");
		int dadd = 9;
		JulianDate d4 = new JulianDate(2016, 3, 1);
		JulianDate d5 = new JulianDate(d4.add(dadd));
		System.out.println(d4.calendar1(year, mon, day)+" adds " + dadd+ " days equal " + d5.calendar(d4.add(dadd)));
		int dminus = 9;
		JulianDate d6 = new JulianDate(2016, 3, 10);
		JulianDate d7 = new JulianDate(d6.minus(dminus));
		System.out.println(d6.calendar1(year, mon, day)+" minus " + dminus+ " days equal " + d7.calendar(d6.minus(dminus)));

	}



	}


