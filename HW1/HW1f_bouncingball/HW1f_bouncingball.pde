/**
 *@author:Rui Zhang
 *Hw1c: processing program that draws a bouncing ball that bounces off 4 walls
 */
 
 
 void setup(){
   size(400,400);
   smooth(8);
 }
 
float x=35.0,y=35.0;
float sx=+1.5,sy=+1.5;
 void draw(){
   background(255);
   fill(255,0,0);
   stroke(255,204,51);
   strokeWeight(4);
   ellipse(x,y,66,66);
   if(y<=35){
     x=x+sx;
   }
   if(x>=365){
     x=365;
     y+=sy;
   }
   if(y>=365){
     y=365;
     x=x-sx;
    }
   if(x<=35){
     x=35;
     y=y-sy;
   }
 }
         
       