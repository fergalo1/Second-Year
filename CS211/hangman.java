package CS211;
import java.util.*;
public class hangman {
public static void main(String args[])
{
Scanner sc = new Scanner(System.in);
FileIO reader = new FileIO();
String[] inputs = reader.load("C://Users//Ferga//OneDrive//Documents//College second year//Dictionary.txt");  //file to String array

int min = 0;
 int max = inputs.length;
int random = (int) (Math.floor(Math.random() * (max - min + 1)) + min); //The maximum is inclusive and the minimum is inclusive
String a =  inputs[random];
int count = 0;

char[] line= new char[a.length()-1];

for(int i = 0;i < a.length()-1;i++)
{
line[i]= '_';

}
System.out.println(line.length);
for(int i = 0;i < a.length()-1;i++)
{
System.out.print(line[i] + " ");
}



int lives = 8;
boolean right = false;
int c = 0;
String convert = "";
//////////////////////////////////////////////////////////////////

while(lives >0 || right != true)
{
System.out.println("\n Enter your letter");
char letter = sc.next().charAt(0);

for(int i = 0;i<a.length()-1;i++)
{
if(letter == a.charAt(i))
{
line[i] = letter;
}

System.out.print(" " + line[i]);

}
convert = String.valueOf(line);


if(checkIftrue(convert,letter) == false)
{
System.out.println("\nyour input is wrong");
lives--;
System.out.println("you have " + lives + " lives");
}
else
{
System.out.println("\n you are right");
}


if(convert.matches("[^_]+"))
{

right = true;
break;
}

if(lives == 0)
{
break;

}
}
if(right)
{
System.out.println("you won");
}
else
{
System.out.println("you lost");
}

}

//////////////////////////////////////////////////////////////////////////////////////
public static boolean checkIftrue(String convert,char letter)
{
int t = convert.length();
for(int i = 0;i<convert.length();i++)
{
if(letter != convert.charAt(i))
{
t--;
}
}
if(t == 0)
{
return false;
}
else
{
return true;
}
}
}
