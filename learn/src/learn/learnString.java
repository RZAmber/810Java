// learn String and to String
//在一个class里面用toString ，return 一个语句，如“ "I AM CAR" + Speed +" !" "
// 在另外一个class的main中调用的时候可以直接实例化之后输出，不必写很长的输出语句


package learn;

public class learnString {
    private String color;
    public learnString(String c) {color = c;}
    public String toString(){ return "I am a Car! I am " +color;}
    
    public String getColor() {return color;}
    
   
	public static void main(String[] args) {
		learnString c = new learnString("red");
		System.out.println(c);
		
		
		String a = "abc";
		String b = "def";
		if (a == b) {
			System.out.println("a==b???");
		}
		String s1 = new String("abc");
		String s2 = "abc";
		System.out.println(s1 == s2); // identity comparison: is s1 the same object as s2?
		String s3 = "abc";
		System.out.println(s2 == s3);
		String s3b = "ab" + "c";
		String s6 = "ab";
		String s7 = "c";
		String s8 = s6 + s7;
		System.out.println(s3 == s3b);
		System.out.println(s8 == s3b); // is s8 the same object as s3
		System.out.println(s8.equals(s3)); // does s8 have the same letters as s3?
		String s4 = s1 + s2;
		s4 += s1;
		System.out.println(s4);
	}

}
