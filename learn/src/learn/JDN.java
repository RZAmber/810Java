package learn;

import hw3c_DesigningClassComplex.Complex;

public class JDN {
    //在方法中，void是没有返回值，如果有返回值一定要写返回值类型
	//final是不可更改的方法
	//static是静态方法
	//父类的private成员方法是不能被子类方法覆盖的，private类型的方法默认是final类型的
	//三者都是关键字，可以组合

	//有参constructor. 构造函数名称与类名相同。
	//不能有返回值，所以不能定义返回值类型
	//不能被static，final,synchronized、abstract和native修饰
	public JulianDate(int year, int mon, int day) {
		//Within an instance method or a constructor
		//this is a reference to the current object — the object whose method or constructor is being called.
		//You can refer to any member of the current object from within an instance method or a constructor by using this.
		year=this.year ; //wrong
		this.year= year;//right,right year is the parameter, left year is the number when you new a object
		//第一个year是全局变量，所以构造函数将参数year赋值给这个变量（默认初始值为0），这样就可以在所有方法中使用。
	}
    //无参构造函数
    public JDN() {
		
  	}
    //下面就是错误的
    public int JDN(){
    	
    }
    //下面两个是返回类型为这个类的实例，参数需要Complex类型的参数，其实就是new出来的某一个实例
    public Complex add(Complex other) {
    	Complex a = this;
    	double real = a.re + other.re; // in Complex object, defined re=real
    	double imaginary = a.img + other.img;
		return new Complex(real,imaginary);  	
    }
    
    public static Complex add(Complex a, Complex b){
    	return new Complex(a.re+b.re,a.img+b.img);
    }
    
    //与constructor同名但是加了void，就是普通method
    public void JDN(final int year){//标明final
    	
    }

    // 有返回值类型的方法（须定义返回值类型，int,double...)
    //需要有返回值，一定要定义返回值类型
    public int test(){
    	return 1; //一定有return
    }
    
    //以下三种有void存在，都是无返回值的
    
    //正常
    public void test3(){
    	
    }
    
    //static:静态 有这个存在，可以直接调用此方法，不需要实例化
    //由于静态方法不依赖于任何对象就可以进行访问，因此对于静态方法来说，是没有this的，因为它不依附于任何对象，只能访问static成员
    //非静态成员方法中是可以访问静态成员方法/变量的
    public static void test1(){
    		
    }
    public static int test2(){
		return 1;
    }  //有返回值一定要定义返回值类型

    
    //final:不可改变
    //final方法不能被子类的方法覆盖，但可以被继承。
    //final类不能被继承，没有子类，final类中的方法默认是final的。
    public final void test4(){
    	
    }
    
    public static final void test5(){
    	
    }

    
    
    
	public static void main(String[] args) {
    JDN a = new JDN(2016,3,10);//实例化a，引用变量为JDN
    int d = a.test(); //实例化后可以调用非static的方法了
    int e = a.test2(); //可以，但不推荐
    
    b = JDN.test1(); //错误，因为我定义了这个方法没有返回值
    ////由于静态方法不依赖于任何对象就可以进行访问，因此对于静态方法来说，是没有this的，因为它不依附于任何对象
    //有static无返回值如何调用
    new JDN();
    JDN.test1();
    //无返回值的方法直接调用方法
    new JDN().test3();
    
    
    int c = JDN.test2(); //调用方法，赋值给int型的c
    JDN f = new JDN(2016,3,10);
    f.test3();
    JDN h = f.test3();//错
    int z = f.test3();//错
、、
	}

}
