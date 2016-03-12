package learn;

import java.util.ArrayList;

public class bianliang {
	
	//public and private
	//public 和 private是访问权限限定
	
	
	//final
	//用final修饰的成员变量表示常量，值一旦给定就无法改变！
    // final修饰的变量有三种：静态变量，实例变量，局部变量
    //final变量定义的时候，可以先声明，而不给初值
	
	//以下三个为实例变量
    private final String S = "final实例变量S"; 
    private final int A = 100; 
    public final int B = 90; 
    
    // 当函数参数为final类型时，你可以读取使用该参数，但是无法改变该参数的值。
    public void f1(final int i) { //属于局部变量！！！！！！
        //i++;    //i是final类型的,值不允许改变的.  
        System.out.print(i); 
        
        
     //static：   
    //用public修饰的static成员变量和成员方法本质是全局变量和全局方法，
    //当声明它类的对象时，不生成static变量的副本，而是类的所有实例共享同一个static变量。
    //可以通过类名直接访问

    //按照是否静态的对类成员变量进行分类可分两种：
        //一种是被static修饰的变量，叫静态变量或类变量：对于静态变量在内存中只有一个拷贝（节省内存），JVM只为静态分配一次内存
        //另一种是没有被static修饰的变量，叫实例变量：每创建一个实例，就会为实例变量分配一次内存
        
        //static是不允许用来修饰局部变量！！！！！！！！！！！！
        private static int a; //静态变量
        private int b; //实例变量
	
        
     //static final
     //static final用来修饰成员变量和成员方法，可简单理解为“全局常量”！
     // 对于被static和final修饰过的实例常量，实例本身不能再改变了，
      //但对于一些容器类型（比如，ArrayList、HashMap）的实例变量，不可以改变容器变量本身，但可以修改容器中存放的对象
        private static final ArrayList<String> alStaticFinalVar = new ArrayList<String>(); 
	    public void test(){
	    	alStaticFinalVar.add("aaa");        //正确，容器变量本身没有变化，但存放内容发生了变化。这个规则是非常常用的，有很多用途。 
	    }
	
	
	
	public static void main(String[] args) {
		 new bianliang().test(); 
 
	}

}
