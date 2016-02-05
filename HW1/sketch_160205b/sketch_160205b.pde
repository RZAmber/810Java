 void setup(){
   size(800,600);
 }
 float x=2.0,y=2.0;
 float vx=+2.0,vy=+2.0;
 void draw(){
   background(0);
   fill(255,0,0);
   stroke(0,0,255);
   strokeWeight(4);
   rect(x,y,100,100);
   if(y<=2){
     x+=vx;
   }
   if(x>=698){
     x=698;
     y+=vy;
   }
   if(y>=498){
     y=498;
     x=x-vx;
    }
 }