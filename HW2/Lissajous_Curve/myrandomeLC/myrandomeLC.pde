/* @ Rui Zhang
 *HW2e: LissajousCurve. Plot a Lisajous curve where x = cos(13t) and y = cos(15t).
 * try to do this first stepping t from 0 to 2*PI stepping 0.1 (too coarse) 
 * try finer gradations.
 */

void setup(){
  size(300,300);
  background(255);
  smooth();
 frameRate(200);
}
float wx = random(10);
float wy = random(10);
//increment both value by different amounts
float prev_x = 150, prev_y = 150; // previous points
float t= 0; // put changing parameters outside the method
void draw(){
   translate(width/2,height/2);
   stroke(color(255,0,0));
   strokeWeight(0.5);
   float x = width/2 * cos(wx*t); // scale to adjust this window
   float y = height/2 * cos(wy*t);
   if( t < 2*PI){
   line(prev_x,prev_y,x,y);}
   prev_x=x;
   prev_y=y;
//   t+=0.1;
   t+=.01;
}