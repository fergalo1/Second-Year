package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CS211PlaneProject {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
Scanner sc = new Scanner(System.in);
        double Min = Double.MAX_VALUE;
       int radius =6371;
       int used[]= new int[1001] ; //in the find shortest distance i want to store all j values that have been used so that i don't reuse distances
        int usedNum = 0;
       //convert to radians
        int count = 0;

        FileIO reader = new FileIO();
       String[] x = reader.load("C://Users//User//Documents//College second year//xcoordinates.txt");  //file to String distanceay
       String[] y = reader.load("C://Users//User//Documents//College second year//ycoordinates.txt");  //file to String distanceay

       boolean usedboolean = false;
       double currentPosition1 = 0;
       double currentPosition2 = 0;
       double targetPosition1 = 0;
       double targetPosition2 = 0;
       
       double[] xint = new double[x.length];
      double[] yint = new double[y.length];
     
     double distance[] = new double[x.length];
      int currentPos = 0;
      double min[] = new double[1001];
 
     double latitude  = 0;
      double longitude = 0;

      double a = 0;

     double c = 0;

  double d = 0;
      int q = 0;

      //Method one
       arrayfiller(xint,yint,x,y);

       
       int ran = 0;
       //getting distance  from on place to another
       for(int i = 0;i<distance.length;i++)
       { 
    	   usedNum = 0;
    	   ran = (int)(Math.random()*1000);
    	  
    	   for(int m = 0;m<distance.length;m++)
    	   {
     if(ran != used[m])
     {
    	 break;
     }
     else
     {
    	 usedNum++;
    	 
     }
     if(usedNum == used.length)
     {
    	 ran = 0;
     }
    	   }
    	   System.out.println(ran);
    	   			currentPosition1 = xint[currentPos];
   	    	        currentPosition2 = yint[currentPos];
   	    	        targetPosition1 = xint[ran];
   	    	       targetPosition2 = yint[ran];  
    	    	   
    		   
//get lat and long
 latitude  = Math.toRadians((currentPosition1-targetPosition1));
 longitude = Math.toRadians((currentPosition2 - targetPosition2));

 a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 d = radius * c;


  
     
      
    	  //System.out.println("Min Distance!:" + Min +" " + i);
    	 
    	   min[q] = d; //getting the min distance
    	  
    	   used[q] = usedNum; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
    		q++;
    	   currentPos = usedNum; //destination
    	   
    	   if( usedboolean == true)
    	   {
    		   break;
    	   }
    }
       
       



    

   
         
   
    	
    
    	   
       
    	
   
////Content of the min distance quick sorted
int counter = 1;
for(int i = 0;i<min.length;i++)
{

	System.out.println(i + " " + min[i]);
	counter++;

}

int added = 0;

for(int i = 0;i<min.length;i++) {
	
	added += min[i];
}
//System.out.println("added: " + added);

int time = 800 * added;
//System.out.println("Time: " + time);
time += 30 * 1000;
System.out.println("Distance: " + added);
System.out.println("speed " + 800);
System.out.println("Time: " + time);

	



  }
    
    //Method one
public static void arrayfiller(double xint[],double yint[],String x[],String y[])
{
	//Convert String to Double 
    for(int i = 0;i<x.length;i++)
    {
 	    xint[i] = Double.parseDouble(x[i]);
 	    yint[i] = Double.parseDouble(y[i]);
 	   
 	    //System.out.println(xint[i] + " " + yint[i]);
    }
	
}
}

  



