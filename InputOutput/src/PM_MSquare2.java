import java.util.Scanner;
/**
* Write a description of class PM_MSquare2 here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class PM_MSquare2
{
/* Generates a magic square using a scanner number
* 
*/
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("What is the width of the desired magic sqare?");
int side = sc.nextInt();
if(!(side%2==0)){
int row = 0; //the top of the square
int column = side/2; //the middle of the square
int[][] mSquare = new int[side][side];
int value = 1;
while(value < 1+ Math.pow(side, 2)){
int newColumn;
int newRow;
if (row <0)row = side-1; //reset the row if it is too long
if(column > side-1) column = 0; //reset the column if its too long
mSquare[row][column] = value;
newColumn = column +1;
newRow = row-1;
value++;
if (newRow <0)newRow = side-1; //reset the row if it is too long
if(newColumn > side-1) newColumn = 0; //reset the column if its too long
if(mSquare[newRow][newColumn] == 0){row = newRow; column = newColumn;}
else row++;
}
int len = String.valueOf(side*side).length() + 1;
String format = "%" + len + "d";
if(check(mSquare, side)){
for(int i = 0; i<side; i++){
for(int j = 0; j<side; j++){
System.out.printf(format, mSquare[i][j]);
}
System.out.println();
}
}
else System.out.println("Dev Error, pls contact me");
}
else System.out.println("Sorry, this program only supports odd numbers");
}
public static boolean check(int[][] mSquare, int side){
boolean[] check = new boolean[side*side];
for(int i = 0; i<side; i++){
for(int c = 0; c<side; c++){
check[mSquare[i][c] -1] = true;
}
}
for(int i = 0; i<side*side; i++){
if(check[i] != true){
return false;
}
}
int[] column = new int[side]; int[] row = new int[side]; int[] diag = new int[side];
for(int i = 0; i<side; i++){
for(int j = 0; j<side; j++){
row[i] += mSquare[i][j];
column[i] += mSquare[j][i];
}
diag[0] += mSquare[i][i];
diag[1] += mSquare[i][side-1-i];
}
for(int i = 1; i<side; i++){
if((row[i] !=row[0]) || (column[i] != column[0])|| (row[i] != column[0])) return false;
}
if((diag[1] != diag[0]) || (diag[0] != row[0]))return false;
return true;
}
}