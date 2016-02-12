/* @ Rui Zhang
 *HW2e: LissajousCurve. Plot a Lisajous curve where x = cos(13t) and y = cos(15t).
 * try to do this first stepping t from 0 to 2*PI stepping 0.1 (too coarse) 
 * try finer gradations.
 */

void setup(){
  size(300,300);
  background(255);
}
//increment both value by different amounts
//float t = 0;
void draw(){
  translate(width/2,height/2);
  for(float t = 0; t<= 2*PI; t+=0.001){
  float x = 150*cos(13*t);
  float y = 150*cos(15*t);
  ellipse(x,y,10,10);
  }
//  stroke(255,0,0);
//  strokeWeight(1);
//  t+=0.01;
}