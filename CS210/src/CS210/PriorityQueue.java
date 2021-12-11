package CS210;

import java.util.Scanner;

public class PriorityQueue {
	public static void main(String args[])
	{
Scanner sc = new Scanner(System.in);
int size = sc.nextInt();
Queue a[] = new Queue[size];
for(int i =0; i<size;i++)
{
	a[i].insert(sc.nextLine());
	
}
for(int i = 0;i<size;i++)
{
	for(int j = 0;i<size;i++)
	{
	int compare = a[i].compareTo(a[j]) ;
}
}

}}




	


