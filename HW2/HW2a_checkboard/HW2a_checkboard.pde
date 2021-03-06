/* @Rui Zhang
 * HW2a: draw a checkerboard and clicking on the board should put a red circle inside the square.
 */

void setup(){
  size(600,600);
}

final int n=8;
void draw(){
  background(255);
  final int box=width/n;
  color white = color(255),black = color(0);
  boolean l = false;
  for(int y=0; y<height; y+=2*box){   // draw 2 line at the same time
    for(int x=0; x< width; x+=box){
       fill(l ? white : black);
       rect(x,y,box,box);
       fill(!l ? white : black);
       rect(x,y+box,box,box);
       l=!l;
     } 
  }
}

void mousePressed(){
  frameRate(0.8);    // control the appear time of circle
  int BOX=width/n;
  if(mouseButton == LEFT)  // right button cannot control it
  for(int i = 0 ; i <=8; i++){
    if(mouseX>= i * BOX & mouseX < (i+1)*BOX){
      for(int j = 0; j<=8;j++){
        if(mouseY>=j*BOX & mouseY<(j+1)*BOX){
          fill(255,0,0);
          int w = i*BOX+BOX/2;
          int h = j*BOX+BOX/2;
          ellipse(w,h,BOX,BOX);
        }
      }
    }
  }
}