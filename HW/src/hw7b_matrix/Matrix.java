/**
 * 
 * @author Rui Zhang
 *  
 * Hw7ba:Matrix
 *Create a matrix object starting with the framework given in class and make it work.  
 *Your matrix will have to support addition, subtraction, printing, etc. 
**/

package hw7b_matrix;

public class Matrix {
	private double[] data;
	private int rows,cols;

	public Matrix(int rows,int cols){
		this.rows = rows;
		this.cols = cols;
		data = new double[rows * cols];		
	}
	
	public static Matrix ident(int n){
		Matrix I = new Matrix(n,n);
		for(int i=0;i<n*n;) {
			I.data[i]=1;
			i=i+n+1;
		}
		return I;
	}
	
	public void set(int i, int j, double v){
		if(i<=rows && j<= cols){
			data[(i-1)*cols+j-1] = v;
		}else{
			System.out.println("Can't find this location");
		}
	}
	
	public double get(int i, int j){
		double v = 0;
		if(i<=rows && j<= cols){
			v =data[(i-1)*cols+j-1];
		}else{
			System.out.println("Can't find this location");
		}
		return v;
	}
	
	public Matrix add(Matrix other){
		Matrix C = new Matrix(rows,cols);
		if(this.rows != other.rows || this.cols != other.cols) 
			System.out.println("Illegal matrix dimension");
		for(int i=0; i< cols*rows;i++)
			C.data[i]=this.data[i]+other.data[i];
		return C;
	}

	public Matrix sub(Matrix other){
		Matrix C = new Matrix(rows,cols);
		if(this.rows != other.rows || this.cols != other.cols) 
			System.out.println("Illegal matrix dimension");
		for(int i=0; i< cols*rows;i++)
			C.data[i]=this.data[i]-other.data[i];
		return C;
	}
	
	public Matrix transpose(){
		Matrix C = new Matrix(cols,rows);
		for(int i=0; i< rows*cols;i+=rows){
			C.data[i]=this.data[i/rows];
			for(int j = i+1;j<i+rows;j++)
				C.data[j]=this.data[i/rows+cols];	
		}
		
		return C;
	}
	public String toString(){		
		String mst = "";
		for (int i = 0; i<rows*cols; i++){
			mst += Double.toString(data[i])+" ";
			if((i+1)%cols == 0)
				mst += "\n";
			if(i+1==rows*cols)
				mst += "";
		}
		return mst;
	}
	
	public static void main(String[] args) {
	int i=4,j=3;
	int m=1,n=1;
	double v = 1;
	Matrix b = Matrix.ident(i);
	System.out.println("The identity matrix is: \n" + b);
	
	Matrix a = new Matrix(i,j);
	a.set(1,1, 3.5);
	a.set(1,2,4);
	a.set(2,1,7);
	a.set(2,2,3);
	a.set(2,3,2);
	a.set(3,3,1);
	a.set(4,1,1);
	a.set(4,2,2.2);
	System.out.print("If setting location out of range: ");
	a.set(5,2,3);
	System.out.println();
	System.out.println("The Matrix A: \n" + a);
	System.out.println("The element of (" + m +","+n+") location in A is:" +a.get(m,n));
	System.out.println("The element of (" + i +","+j+") location in A is:" +a.get(i,j));
	System.out.println();
	System.out.println("The transposed matix of A is: \n"+a.transpose());
	
	Matrix c = new Matrix(i,j);
	for(int x=1; x<=i;x++)
		for(int y= 1; y<=j;y++){
			c.set(x,y,v);
			v++;
		}
	System.out.println("The Matrix B: \n"+c);
	System.out.println("A+B= \n"+a.add(c));
	System.out.println("A-B= \n"+a.sub(c));

	}

}
