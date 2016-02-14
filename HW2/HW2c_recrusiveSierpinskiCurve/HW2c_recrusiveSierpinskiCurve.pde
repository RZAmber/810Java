/* @Rui Zhang
 * HW2c: RecursiveSierpinskiCurve
 * Draw a sierpinski curve with the following parameters:
 * void sierpinski(int x1,int y1,int x2,int y2,int x3,int y3,int level);
*/

void setup(){
  size(600,600);
  background(255);
  frameRate(1);
  smooth();
}

void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level){  
  if(level<1){
     triangle(x1,y1,x2,y2,x3,y3);  // draw each little triangle
     return;// endless loop without return, no picture.
  } 
    sierpinski(x1,y1,(x1+x2)/2,y1,(x1+x3)/2,(y1+y3)/2,level-1); //leftbottom
    sierpinski((x1+x2)/2,y1,x2,y2,(x2+x3)/2,(y2+y3)/2,level-1); //rightbottom
    sierpinski((x1+x3)/2,(y1+y3)/2,(x2+x3)/2,(y2+y3)/2,x3,y3,level-1); //top
}

int level=0;
void draw(){
  float c=150*(7-level)/3.5;
  fill(c);
  // triangle(0,height,width,height,width/2,0)
  sierpinski(0,height,width,height,width/2,0,level);
  level ++;
  if(level>=7) level=0;
}

/*
void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level){  
  if(level<1){
     triangle(x1,y1,x2,y2,x3,y3);  // draw each little triangle
     
  } 
  else{
    sierpinski(x1,y1,(x1+x2)/2,y1,(x1+x3)/2,(y1+y3)/2,level-1); //leftbottom
    sierpinski((x1+x2)/2,y1,x2,y2,(x2+x3)/2,(y2+y3)/2,level-1); //rightbottom
    sierpinski((x1+x3)/2,(y1+y3)/2,(x2+x3)/2,(y2+y3)/2,x3,y3,level-1); //top
  }
}
*/

      