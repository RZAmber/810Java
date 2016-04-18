/** @ Rui Zhang
 * 
 * HW3c - Designing Class Complex 
 * Design a class to represent a complex number.
 * Try to write a complete representation with all the methods you think it should have.
 * 
 * % java complex
 * a = 3.0 + 4.5i
 * b = -4.0 + 6.0i
 * This file can output real part, imaginary part, square, modulus, 
 * phase, conjugate and reciprocal of complex
 * and add, minus, times and divides results
 * and represent Erler's formula
 */

package hw3c_DesigningClassComplex;

public class Complex {
	private double re; // the real part of complex number
	private double img; // the imaginary part
	
	// Construct an object
    public Complex(double real, double imaginary) {
    	re = real;
    	img = imaginary;
    }
    
    // return a string representation, for use in println() and other objects
    public String toString(){
    	if (img == 0) return re + " ";
    	if (img < 0) return re + " - " + (-img) + "i";
    	if (re == 0) return img + "i";
    	return re + " + " + img + "i";
    	// which symbols in "" will print 
    }
    
    public double getReal(){
    	return re;
    }
    
    public double getImag(){
    	return img;
    }
    
    // square
    public Complex square(){
    	double real = re * re - img * img;
    	double imaginary = 2* re * img;
    	return new Complex(real,imaginary);
    }
    // return modulus
    public double modulus() {
    	return Math.sqrt(re*re + img * img);
    }
    
    // return angle of complex number
    public double phase(){
    	return Math.atan2(img, re);
    }
    
    // return new object which is conjugate complex 
    public Complex conjugate(){
    /*	Complex a = this;
    	double real = re;
    	double imaginary = -img;
    	return new Complex(real,imaginary); 
    	*/
    	return new Complex(re,-img); 
    	/* it is easy to display compared to the above code 
    	 * when the variables are easy to show
    	 */
    }
    
    /* add one complex number to this complex number 
     * and return a new complex object whose value is this+other
     */
    public Complex add(Complex other) {
    	Complex a = this;
    	double real = a.re + other.re; // in Complex object, defined re=real
    	double imaginary = a.img + other.img;
		return new Complex(real,imaginary);  	
    }
    
    // add two complex number together, a+b
    public static Complex add(Complex a, Complex b){
    	return new Complex(a.re+b.re,a.img+b.img);
    }
    
    // minus one complex number from this number, a-other
    public Complex minus(Complex other){
       	Complex a = this;
    	double real = a.re - other.re; // in Complex object, defined re=real
    	double imaginary = a.img - other.img;
		return new Complex(real,imaginary); 
    }
    
    // minus two complex number a-b
    public static Complex minus(Complex a, Complex b){
    	return new Complex(a.re-b.re,a.img-b.img);
    }
    
    // multiply two complex number, a*b
    public Complex times(Complex b){
    	Complex a= this;
    	double real = a.re * b.re - a.img * b.img;
    	double imaginary = a.img * b.re + a.re * b.img;
    	return new Complex(real,imaginary);
    }
    
    // scalar multiplication, u*a, u=constant
    public Complex times(double u){
    	return new Complex(u*re,u*img);
    }
    
    
    // reciprocal 1/a
    public Complex reciprocal(){
    	double sum = re * re + img * img;
    	return new Complex(re/sum, -img/sum);
       
    }
    // division a/b = (x+yi)(w-ni)/(w^2+n^2) = a*1/b
    public Complex divides(Complex b){  
    	Complex a = this;
    	double den =b.re * b.re + b.img * b.img;
    	Complex num = a.times(b.conjugate());
    	double real = num.re / den;
    	double imaginary = num.img / den;
    	return new Complex(real,imaginary);
    	/* return a.times(b.reciprocal());
    	 */
    }
    
    /*Euler's formula e^(x*i) = conx + i*sinx
     * the method need static, check the reason at notebook.
     */
    public static Complex Euler(double x) {
    	double real = Math.cos(x);
    	double imaginary = Math.sin(x);
        return new Complex(real,imaginary);
    }
    
    // sample for testing 
    public static void main(String[] args){
    	Complex a = new Complex(3.0,4.5);
    	Complex b = new Complex(-4.0,6.0);
    	double x = Math.PI/3;
    	double u = 2.0;
    	
    	System.out.println("a = " + a);
    	System.out.println("b = " + b);
    	System.out.println("Re(a) = " + a.getReal());
    	System.out.println("Im(b) = " + b.getImag());
    	System.out.println("a^2 = " + a.square());
    	System.out.println("|a| = " + a.modulus());
    	System.out.println("phase = " + a.phase());
    	System.out.println("conj(a) = " + a.conjugate());
    	System.out.println("a+b = " + a.add(b));
    	System.out.println("a+b = " + Complex.add(a, b));//have the same result 
    	System.out.println("a-b = " + a.minus(b));
    	System.out.println("a*b = " + a.times(b));
    	System.out.println("a*u = " + a.times(u));
    	System.out.println("1/a = " + a.reciprocal());
    	System.out.println("a/b = " + a.divides(b));
    	System.out.println("Euler's formula: e^(i*x)     =" + Complex.Euler(x));
    	
    }
}
