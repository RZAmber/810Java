/* @ Rui ZHANG
 * Hw1c: draw an n*n grid on the screen
 */
void setup(){
  size(800,600);
}
int n=4;
void draw(){
  for(float x=0; x<width; x=x+800.0/n){
    line(x,0,x,height);
  }
  for(float y=0; y<height; y=y+600.0/n){
    line(0,y,width,y);
  }
}