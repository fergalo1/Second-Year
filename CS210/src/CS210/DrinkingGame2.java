package CS210;
import java.util.*;
public class DrinkingGame2 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int player = sc.nextInt();
		int maxNum = 0; //largest
		int count = 0; //number found
		int max =0;
		String rolled = input.charAt(0)+""+input.charAt(2)+""+input.charAt(4)+""+input.charAt(6)+""+input.charAt(8); //31455
	
		for(int i=0;i<rolled.length();i++) {
			count  = 0;
			for(int j=0;j<rolled.length();j++) {
				if(rolled.charAt(i)==rolled.charAt(j)||rolled.charAt(j)=='1') {
					count++;
				
				}
			}
			if(max<count) {
				max = count;
				maxNum = Integer.parseInt(rolled.charAt(i)+""); //1 3 4 5 5 = 3
			}
		}
	
	double probab = 0.0;	
	int dice = (player-1)*5;
	int loop = player -1;
	int count2 =0;
	double result = 0.0;
	while(count2<=loop*5)
	{
	probab = nCr(dice, count2)*Math.pow(1.0/3.0, count2)*Math.pow(2.0/3.0, (dice-count2));	//Binomial Distribution Formula
	result += probab; //Cumulative Density Function
	if(result>0.5)
	{
		break;
	}
	count2++;
	}
	
	System.out.println((count2 + count) + " " + maxNum + "'s");
	
	
}
public static double nCr(int n, int r)
{
	if(r>n/2)
	{
		r=n-r;
	}
	double answer =1;
	for(int i =1;i <=r;i++)
	{
		answer *= (n-r+i);
		answer/=i;
	}
	return answer;
	
}

public static double nFactorial (double n)
{
	double result =1;
	for(int i = 1;i<=n;i++)
	{
		result=result*i;
	}
	return result;
}
}
