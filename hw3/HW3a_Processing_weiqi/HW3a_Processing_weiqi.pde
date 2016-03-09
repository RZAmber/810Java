/* @Rui Zhang
 * HW3a: weiqi
 * display a game board and allow user input, 
 * when you click on the board, a piece should be put down (Go/WeiQi)
*/


void setup(){
  size(608,608);
  Box=width/N;
};

int Box;
final int N = 19;
int currentColor = 1;
int[] board = new int[N*N];

void draw(){
  background(255,200,0);
  for(int i = 0; i < N; i++){
    line(Box/2,Box/2+i*Box,width-Box/2,i*Box+Box/2);
    line(i*Box+Box/2,Box/2,i*Box+Box/2,height-Box/2);
  }
  for(int i = 0; i< board.length;i++){
    int x= i % N;
    int y= i/N;
    
    switch(board[i]){
      case 0:
           break; 
      case 1:
           fill(0);
           ellipse(x*Box+Box/2,y*Box+Box/2,25,25);
           break;
      case -1:
           fill(255);
           ellipse(x*Box+Box/2,y*Box+Box/2,25,25);
           break;
    }
  }
      
}
  
void mousePressed(){
  int x = mouseX/Box, y = mouseY/Box;
  board[x+y*N] = currentColor;
  currentColor=-currentColor;
}