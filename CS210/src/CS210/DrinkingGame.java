package CS210;
import java.util.*;
public class DrinkingGame {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	//1 acts like a joker
	int a[]=new int[5];
	int b[]=new int[5];
	int c[]=new int[5];
	int d[]=new int[5];
	int e[]=new int[5];
	int count =0;
	for(int i =0;i<5;i++)
	{
		a[i]= (int)(Math.random()*7)+1;
		b[i]= (int)(Math.random()*7)+1;
		c[i]= (int)(Math.random()*7)+1;
		d[i]= (int)(Math.random()*7)+1;
		e[i]= (int)(Math.random()*7)+1;
		
		if(a[i] == 1)
		{
			while(a[i]==1)
			{
				a[i]=sc.nextInt();
			}
			a[i]=sc.nextInt();
		}
		if(b[i] == 1)
		{
			b[i]=sc.nextInt();
			while(b[i]==1)
			{
				b[i]=sc.nextInt();
			}
		}
		if(c[i] == 1)
		{
			c[i]=sc.nextInt();
			while(c[i]==1)
			{
				c[i]=sc.nextInt();
			}
		}
		if(d[i] == 1)
		{
			d[i]=sc.nextInt();
			while(d[i]==1)
			{
				d[i]=sc.nextInt();
			}
		}
		if(e[i] == 1)
		{
			e[i]=sc.nextInt();
			while(e[i]==1)
			{
				e[i]=sc.nextInt();
			}
		}
		
		
	}
	for(int i =0;i<5;i++)
	{
	System.out.print(a[i] + " ");
	}
	System.out.println();
	for(int i =0;i<5;i++)
	{
	System.out.print(b[i] + " ");
	}
	System.out.println();
	for(int i =0;i<5;i++)
	{
	System.out.print(c[i] + " ");
	}
	System.out.println();
	for(int i =0;i<5;i++)
	{
	System.out.print(d[i] + " ");
	}
	System.out.println();
	for(int i =0;i<5;i++)
	{
	System.out.print(e[i] + " ");
	}
	System.out.println();
	
	
		
		
		
	}
}

