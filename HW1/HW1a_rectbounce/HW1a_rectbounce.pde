/**
 *@author:Rui Zhang
 *Hw1a:a processing program that draws a rectangle bounce off 4 walls
 */
 
 
 void setup(){
   size(800,600);
 }
 int x=2,y=2;
 int vx=+2,vy=+2;
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
   if(x<=2){
     x=2;
     y=y-vy;
   }
 }
         
       