void setup(){
  size(600,300);
  background(#F5F2F2);
  smooth(0);
}

void draw(){
  translate(0,height/2);
  scale(width/(10*PI),-150);
  strokeWeight(0.01);
  stroke(color(0));
  line(0,0,width,0);
  stroke(color(#FF0303));
  float a = 0;
  float prev_x=0,prev_y=0,x,y;
  float dx = 10*PI/width;
  for(x = dx; x<= 10*PI;x+=dx){
    y= sin(x);
    for (int i = 3; i <= 9;i+=2){
      y+=1.0/i*sin(i*x);
    }
    line(prev_x,prev_y,x,y);
    prev_x=x;
    prev_y=y;
  }
 }