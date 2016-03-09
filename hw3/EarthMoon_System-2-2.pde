/* @Rui Zhang
 * HW3: Earth-Moon System
 * create the moon at a distance of 4 diameters of earth away 
 * make the moon go around the earth at correct scale speed
*/

PShape Earth,Moon;

void setup(){
  size(1000,600,OPENGL);
  PImage imge=loadImage("earthmap.jpg");
  PImage imgm=loadImage("moonmap.jpg");
  noStroke();
  Earth = createShape(SPHERE,200);
  Moon = createShape(SPHERE,0.273*200); // diameter of moon
  Earth.setTexture(imge); //set image to shpere
  Moon.setTexture(imgm);
}

float ange = 0;
float angm = 0;
void draw(){
  background(0);
  translate(width/2,height/2,-800);
  //add light
  ambientLight(100,100,70);
  pointLight(255,255,255,550,150,150);
  
  pushMatrix(); // keep the origin coordinate 
  rotateZ(23.4*PI/180); // earth axial tilt to orbit, clockwise
  rotateY(ange);
  shape(Earth);
  popMatrix();
  
  pushMatrix();
  rotateZ(-5.14*PI/180); // inclination
  rotateY(angm); // this Y is the center
  translate(800,0); // distance(4 times diameter of earth
  rotateZ(-6.68*PI/180); // moon axital titl to orbit, counterclockwise
  shape(Moon);
  popMatrix();
  
  ange +=0.05;
  angm +=0.05/28.5;
}
  
  