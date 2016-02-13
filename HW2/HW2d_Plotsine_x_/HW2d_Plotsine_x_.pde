/* @ Rui Zhang
 * HW2d: Using transformation commands(translate and scale) plot the function 
 * sin(x) +1/3sin(3x) + 1/5sin(5x) +1/7sin(7x) +1/9sin(9x)  0n 0 to 10pi.
 */
void setup(){
  size(600,300);
  background(#F5F2F2);
  smooth(0); // important
}

void draw(){
  translate(0,height/2); // reset orgin at (0,150)
  scale(width/(10*PI),-150); // the reason of using negative y is putting curve reversal
  strokeWeight(0.01); 
  stroke(color(0)); // line color
  line(0,0,width,0); // horizontal line
  stroke(color(#FF0303)); // curve color
  float a = 0;
  float prev_x=0,prev_y=0,x,y;
  float dx = 10*PI/width;
  for(x = dx; x<= 10*PI;x+=dx){
    y= sin(x);
    for (int i = 3; i <= 9;i+=2){
      y+=1.0/i*sin(i*x);
    }
//   point(x,y);
    line(prev_x,prev_y,x,y);  // instead of point() function
    prev_x=x;
    prev_y=y;
  }
 }