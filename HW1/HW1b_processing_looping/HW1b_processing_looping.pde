/*@author Amber
 *HW1b looping
 */
 // 1. Print 1 3 5 up to 99 separated by spaces,followed by a new line.
 // 2. Print the numbers 2 4 8 doubling up to 32768 followed by a new line.
 void setup(){
   for (int i = 1; i <100; i+=2){
     print(i);
     println();
   }
   for (int i = 1; i<=32768; i=i*2){
     print(i);
     println();
   }
   exit();
 }