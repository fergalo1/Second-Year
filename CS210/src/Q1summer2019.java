import java.util.*;
public class Q1summer2019 {
public static void main(String args[])
{
Scanner sc= new Scanner(System.in);

int check = sc.nextInt();
int distance = 0;
boolean isPrime = false;

while(isPrime == false)
{
	
	for(int i = 2;i<check;i++)
	{
		if(check % i==0)
		{
		isPrime = true;	
		}
	}
	
	check++;
	distance++;
}
if(isPrime == true)
{
	System.out.println(distance);
}
}
}
