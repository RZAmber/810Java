void setup(){
  size(800,800);
  background(255);
  frameRate(1);
  smooth();
}
void draw(){
  triangle(100,400+150*sqrt(3),700,400+150*sqrt(3),400,400-150*sqrt(3));

}