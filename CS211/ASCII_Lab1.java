package CS211;
import java.util.Scanner;
public class ASCII_Lab1 {

public static void main(String[] args)
{
Scanner input = new Scanner(System.in);
System.out.println("Enter Sentence");
String sentence = input.nextLine();
String binaryString="";
//Store the String of binary code

for(int i = 0; i < sentence.length();i++)//for loop to go through the sentence
{
int decimalValue = (int)sentence.charAt(i); // convert string to decimal
String binaryValue = Integer.toBinaryString(decimalValue);// decimal to binary

for(int j = 7; j > binaryValue.length();i--)
{
binaryString += "0";
}
binaryString +=binaryValue+" "; // add to the next string of binary
}
System.out.println(binaryString); //prints out the binary

int[] array = new int[256]; //array to store the quantity of letters

for(int i = 0; i < sentence.length();i++) // goes through the sentence
{
array[(int)sentence.charAt(i)]++;//adds the amount of letters repeated
}
for(int i = 0; i < array.length;i++)
{
if(array[i]>0)
{
//prints out the repititions
System.out.println("'" + (char)i+ "' appeared " + array[i] + " times");
}
}

}
}
