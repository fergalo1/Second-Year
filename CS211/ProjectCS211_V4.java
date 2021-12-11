package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProjectCS211_V4 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
Scanner sc = new Scanner(System.in);
        double Min = Double.MAX_VALUE;
       int radius =6371;
       int used[]= new int[1001] ; //in the find shortest distance i want to store all j values that have been used so that i don't reuse distances
        int usedNum = 0;
        int NumOfUsed = 0;
       //convert to radians
        int count = 0;

        FileIO reader = new FileIO();
       String[] x = reader.load("C://Users//User//Documents//College second year//xcoordinates.txt");  //file to String distanceay
       String[] y = reader.load("C://Users//User//Documents//College second year//ycoordinates.txt");  //file to String distanceay
     
       double[] xint = new double[x.length];
      double[] yint = new double[y.length];
     
     double distance[] = new double[x.length];
      int currentPos = 0;
      double min[] = new double[1001];

      int q = 0;

		//Convert String to Double 
       for(int i = 0;i<x.length;i++)
       {
    	    xint[i] = Double.parseDouble(x[i]);
    	    yint[i] = Double.parseDouble(y[i]);
    	   
       }
       
       
       //getting distance  from on place to another
       for(int i = 0;i<distance.length;i++)
       { 
    	  
      
 	 
           Min = Integer.MAX_VALUE; //I want to reset after i've found the shortest distance


    	   for(int j = 1; j<distance.length;j++)
    	   {
    		  
    	       boolean usedyBoolean = false;
    	    	  
    	       
    	      for(int m = 0;m < used.length;m++)
    	      {
    	    		   if(used[m] == j) 
    	    		   {
    	    			   usedyBoolean = true; //if the same directions have already been used we want to skip

    	    			   //System.out.println(used[z]); //finding the used slots ie/ j values used
    	    			  //continue; //if j position has been used already then you want to go to the next value
    	    		   }
    	      }
    	      if(usedyBoolean == true)
    	      {
    	    	  continue;
    	      }
    	    	   if(currentPos < 203 && currentPos >199)
    	    	   {
    	    		   System.out.println("Here");
    	    	   }
    	    		   
    	    	   
       double currentPosition1 = xint[currentPos];
       double currentPosition2 = yint[currentPos];
       double targetPosition1 = xint[j];
       double targetPosition2 = yint[j];

//get lat and long
 double latitude  = Math.toRadians((currentPosition1-targetPosition1));
 double longitude = Math.toRadians((currentPosition2 - targetPosition2));

 double a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

double d = radius * c;
//d = Math.round(d);
//double minid = (d%100);

//how i round down
//if(minid < 50)
//{
//    d = d-minid;
//}



//int rounded = (int) (Math.ceil(d/100.0))*100;

distance[i] = d;
//System.out.println(rounded); //test to see after rounded

if(distance[i] < Min && distance[i] >=100) //finding the shortest distance if not under 100km
{
	Min = distance[i];
	//System.out.println(j); //see what number is used
	usedNum = j;
}


}
    	
    	  //System.out.println("Min Distance!:" + Min +" " + i);
    	 
    	   if(Min == Integer.MAX_VALUE) {
    		   System.out.println("Count: " + count +"currentPos :"+ currentPos + ". Min Distance: " + Min + ". J position:  " + usedNum);
    	count++;
    	}
    	   min[q] = Min; //getting the min distance
    	   used[q] = usedNum; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
    		q++;
    	   currentPos = usedNum;
    	   
    	   NumOfUsed++;
       }

     
    	
   
//Content of the min distance quick sorted
//int count = 1;
       for(int i = 0;i<used.length;i++)
       {
       	for(int j = 0;j<used.length;j++)
       	{
       		if(used[i] > used[j])
       		{
       			int temp = used[j];
       			used[j] = used[i];
       			used[i] = temp;
       		}
       	}
       }
       	   
          
//     for(int i = 0;i<used.length;i++)
//     {
//     
//     	System.out.println(used[i]);
//     
//     }


   }
    


  


}