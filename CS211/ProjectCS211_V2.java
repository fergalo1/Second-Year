package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProjectCS211_V2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
Scanner sc = new Scanner(System.in);
      
        
       int radius =6371;
       
        //convert to radians
       FileIO reader = new FileIO();
       String[] x = reader.load("C://Users//User//Documents//College second year//xcoordinates.txt");  //file to String distanceay
       String[] y = reader.load("C://Users//User//Documents//College second year//ycoordinates.txt");  //file to String distanceay
      double[] xint = new double[x.length];
      double[] yint = new double[y.length];
      int distance[] = new int[x.length];
      int shortestDis = Integer.MAX_VALUE;

       for(int i = 0;i<x.length;i++)
       {
    	    xint[i] = Double.parseDouble(x[i]);
    	    yint[i] = Double.parseDouble(y[i]);
    	   
       }
       for(int i = 0;i<distance.length;i++)
       {
    	   
    	   for(int j = i+1; j<distance.length;j++)
    	   {
    		   shortestDis = Integer.MAX_VALUE;   
       double currentPosition1 = xint[0];
       double currentPosition2 = yint[0];
       double targetPosition1 = xint[j];
       double targetPosition2 = yint[j];


 double latitude  = Math.toRadians((currentPosition1-targetPosition1));
 double longitude = Math.toRadians((currentPosition2 - targetPosition2));

 double a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

double d = radius * c;
d = Math.round(d);
double minid = (d%100);

//how i round down
if(minid < 50)
{
    d = d-minid;
}



int rounded = (int) (Math.ceil(d/100.0))*100;
//System.out.println(rounded);

distance[i] = rounded;

if(shortestDis > distance[i])
{
	shortestDis = distance[i];
}

}
    	   
    	   for(int k = i+1; k< distance.length;k++)
    	   {
    		   if(shortestDis == distance[k])
    		   {
    			  
    			   break;
    			   //System.out.println("found a slot " + k);
    		   }
    		   else
    		   {
    			   //System.out.println(shortestDis);
    		   }
    	   }
       }
    
       System.out.println(shortestDis);
   
for(int i =1;i<distance.length;i++)
{
	for(int j = i+1;distance.length > j;j++)
	if(distance[i] > distance[j])
	{
		int temp = distance[i];
		distance[i] = distance[j];
		distance[j] = temp;
	}

}

//for(int i =1;i<distance.length;i++)
//{
//	//System.out.println(distance[i]);
//
//}
//
//for(int i = 0;i<distance.length;i++)
//{
//	for(int j = i+1;j < distance.length;j++)
//	{
//		if(distance[j]-distance[i] < 100)
//		{
//			System.out.println(distance[j]-distance[i]);
//		continue;
//		}
//		else
//		{
//			System.out.println("good distance");
//			break;
//		}
//	}
//}

    }
    




}