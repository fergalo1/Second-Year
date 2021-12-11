package CS211;

import java.util.Scanner;

 

public class LAB1 {

public static void main(String args[])

{

Scanner sc = new Scanner(System.in);

String a = sc.nextLine();


for(int i = 0;i<a.length();i++)

{

int b = (int)a.charAt(i);

String c = Integer.toBinaryString(b);
if(c.length() != 7)
{
c = "0" + c;
}

System.out.print(c + " ");

}


System.out.println("\n");
int freq[] = new int[a.length()];
char string[] = a.toCharArray();
for(int i = 0;i<a.length();i++)
{
freq[i]= 1;

for(int j = i+1; j < a.length();j++)
{
if(string[i] == string[j])
{
freq[i]++;
string[j] = '0';
}
}
}
for(int i = 0;i <freq.length;i++)
{
if(string[i] != '0')
{
System.out.println("\"" + string[i] +"\"" + "Appeared: " + freq[i]);
}
}
}
}