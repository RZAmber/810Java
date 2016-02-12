float wx = random(10); // horizontal angular frequency
float wy = random(10); // vertical angular frequency
 
float xpos, ypos; // plotted point
float px, py; // previous points
float a = 1;
float b = 1; // constants
int frame = 0;
 
float dx = PI/2; // horizontal angular phase
float ax = 1; // horizontal amplitude
float dy = 0; // vertical angular phase
float ay = 1; // vertical amplitude
 
void setup() {
  size(400,400);
  fill(64, 64, 64, 64);
  background(255);
  smooth();
}
 
void draw() {
  fill(255,1);
  rect(0,0,width,height);
   
  xpos = ((width/3) * a * sin(frame))+(width/2);
  ypos = ((height/3)* b * cos(frame))+ (height/2);
 
  xpos = width/3 * ax*sin(wx*radians(frame)+dx) + width/2;
  ypos = height/3 * ay*sin(wy*radians(frame)+dy) + height/2;
 
  fill(64);
  stroke(3);
  if(frame>0) { line(px, py, xpos, ypos); }
 
  px = xpos;
  py = ypos; 
  frame++;
   
}
 
void keyPressed() {
  saveFrame("lissajous_curve_x"+wx+"_y"+wy+".png");
  exit(); // stops the program
}