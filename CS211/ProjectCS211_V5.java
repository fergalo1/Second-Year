package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProjectCS211_V5 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
        double Min = Double.MAX_VALUE;
       int radius =6371;
       int used[]= new int[1013] ; //in the find shortest distance i want to store all j values that have been used so that i don't reuse distances
        int usedNum = 0;

        FileIO reader = new FileIO();
       String[] x = reader.load("C://Users//User//Documents//College second year//xcoordinates.txt");  //file to String distancesx
       String[] y = reader.load("C://Users//User//Documents//College second year//ycoordinates.txt");  //file to String distancesy

       double currentPosition1 = 0;
       double currentPosition2 = 0;
       double targetPosition1 = 0;
       double targetPosition2 = 0;
       
       double[] xint = new double[x.length];
      double[] yint = new double[y.length];
     
     double distance[] = new double[x.length];
      int currentPos = 0;
      double min[] = new double[1013];
 
     double latitude  = 0;
      double longitude = 0;

      double a = 0;

     double c = 0;

  double d = 0;
      int q = 0;

      //Method one
       arrayfiller(xint,yint,x,y); // converts String arrays to integer
 used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		
		

       int o = 0;
       int japan = 200;
       int directions[] = {206,207,574,575,576,577};
       int t = -1;
       
       
       while(t < directions.length-1)
       {
    	   t++;
    	   q++;
    	   currentPosition1 = xint[currentPos];
	        currentPosition2 = yint[currentPos];
	        targetPosition1 = xint[directions[t]];
	       targetPosition2 = yint[directions[t]];
	     
	    
	       //get lat and long
	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

	       
	       d = radius * c;
	       
	       
	     
	       
	     
	       min[q] = d; //getting the min distance
	      
   	   used[q] = directions[t]; // putting the shortest distance onto the array,store the distance in the used array
   	q++;
   		currentPos = directions[t];
   		if(currentPos == 577)
   		{
   			currentPosition1 = xint[currentPos];
   		    currentPosition2 = yint[currentPos];
   		    targetPosition1 = xint[0];
   		    targetPosition2 = yint[0];
   		     
   		    
   		       //get lat and long
   		       latitude  = Math.toRadians((currentPosition1-targetPosition1));
   		       longitude = Math.toRadians((currentPosition2 - targetPosition2));

   		       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
   		       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

   		       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

   		       
   		       d = radius * c;
   		      
   		       min[q] = d; //getting the min distance
   			   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
   				
   			   currentPos = 0;
   		}
   		else {
   			//head back to maynooth
   	currentPosition1 = xint[currentPos];
    currentPosition2 = yint[currentPos];
    targetPosition1 = xint[0];
    targetPosition2 = yint[0];
     
    
       //get lat and long
       latitude  = Math.toRadians((currentPosition1-targetPosition1));
       longitude = Math.toRadians((currentPosition2 - targetPosition2));

       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

       
       d = radius * c;
      
       min[q] = d; //getting the min distance
	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		
	   currentPos = 0;
   		}

       }
       
       
       
       
       int u = o;
       
       //getting distance  from on place to another
       for(int i = 0;i<distance.length;i++)
       { 
    
    	   
if(currentPos == 199)
{
	 
		   currentPosition1 = xint[currentPos];
       currentPosition2 = yint[currentPos];
       targetPosition1 = xint[0];
      targetPosition2 = yint[0];
      
      //get lat and long
      latitude  = Math.toRadians((currentPosition1-targetPosition1));
      longitude = Math.toRadians((currentPosition2 - targetPosition2));

      a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
      (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

      c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

      
      d = radius * c;
      min[q] = d; //getting the min distance
	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		q++;
		
	   currentPos = 0; //destination	  
}
	 else
	 {

while(o < 7)
	    	  {
	int s = 171;
			   if(o == 0)
			   {
				   
			   currentPosition1 = xint[currentPos];
 	        currentPosition2 = yint[currentPos];
 	        targetPosition1 = xint[s];
 	       targetPosition2 = yint[s];
 	       
 	       //get lat and long
 	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
 	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

 	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 	       
 	       d = radius * c;
 	       if(u == 0)
 	       {
 	    
 	    	  currentPosition1 = xint[currentPos];
 	  	        currentPosition2 = yint[currentPos];
 	  	        targetPosition1 = xint[0];
 	  	       targetPosition2 = yint[0];
 	  	       
 	  	       //get lat and long
 	  	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
 	  	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

 	  	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 	  	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 	  	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 	  	       
 	  	       d = radius * c;
 	    	   
 	 	       min[q] = d; //getting the min distance
 	     	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
 	     		q++;
 	     		
 	     	   currentPos = 0; //destination
u++;
 	       }
 	       else
 	       {
 	      if(d < 100 )
    	   {
 	    	  s = 0;
 	    	 currentPosition1 = xint[currentPos];
  	        currentPosition2 = yint[currentPos];
  	        targetPosition1 = xint[s];
  	       targetPosition2 = yint[s];
  	       
  	       //get lat and long
  	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
  	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

  	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
  	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

  	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

  	       
  	       d = radius * c;
    	   }
 	       min[q] = d; //getting the min distance
     	   used[q] = s; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
     		q++;
     		
     	   currentPos = s; //destination
     	   o++;
 	       }
     	   
     	   
     	  
     	  
			   }
			   else
			   {
				   if(currentPos==577)
				   {
					   currentPosition1 = xint[currentPos];
		    	        currentPosition2 = yint[currentPos];
		    	        targetPosition1 = xint[0];
		    	       targetPosition2 = yint[0];
		    	       
		    	       
		    	    //get lat and long
		 	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
		 	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

		 	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
		 	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

		 	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

		 	       
		 	       d = radius * c;
		 	       min[q] = d; //getting the min distance
		     	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		     		q++;
		     		
		     	   currentPos = 0; //destination
		     	   
		     	  currentPosition1 = xint[currentPos];
	    	        currentPosition2 = yint[currentPos];
	    	        targetPosition1 = xint[171];
	    	       targetPosition2 = yint[171];
	    	       
	    	       
	    	    //get lat and long
	 	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
	 	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

	 	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
	 	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

	 	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

	 	       
	 	       d = radius * c;
	 	       min[q] = d; //getting the min distance
	     	   used[q] = 171; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
	     		q++;
	     		
	     	   currentPos = 171; //destination
	     	   
		     	  
		     	   
				   }
				   if(currentPos==171)
				   {
					   currentPosition1 = xint[currentPos];
		    	        currentPosition2 = yint[currentPos];
		    	        targetPosition1 = xint[0];
		    	       targetPosition2 = yint[0];
		    	       
		    	       
		    	    //get lat and long
		 	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
		 	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

		 	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
		 	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

		 	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

		 	       
		 	       d = radius * c;
		 	       min[q] = d; //getting the min distance
		     	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		     		q++;
		     		
		     	   currentPos = 0; //destination
		     	  
		     	  
		     	   
				   }
				   else
				   {
			   if(currentPos == 0)
			   {
				   
	    		  currentPosition1 = xint[currentPos];
	    	        currentPosition2 = yint[currentPos];
	    	        targetPosition1 = xint[japan];
	    	       targetPosition2 = yint[japan];
	    	       //get lat and long
	    	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
	    	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

	    	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
	    	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

	    	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

	    	       
	    	       d = radius * c;
	    	      
	    	       min[q] = d; //getting the min distance
	        	   used[q] = japan; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
	        		q++;
	        		
	        	   currentPos = japan; //destination
	        	   o++;
	        	   
	        	
	        	   
			   }
			   else
			   {
				   
				   currentPosition1 = xint[currentPos];
    	        currentPosition2 = yint[currentPos];
    	        targetPosition1 = xint[0];
    	       targetPosition2 = yint[0];
    	       
    	       
    	    //get lat and long
 	       latitude  = Math.toRadians((currentPosition1-targetPosition1));
 	       longitude = Math.toRadians((currentPosition2 - targetPosition2));

 	       a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 	       (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 	       c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 	       
 	       d = radius * c;

 	       min[q] = d; //getting the min distance
     	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
     		q++;
     		
     	   currentPos = 0; //destination
     	   o++;
     	   japan++;
     	  
			   }
			   }
	        	   
	    	  }
	    	  }

     if(currentPos == 201)
     {
    	 currentPosition1 = xint[currentPos];
	        currentPosition2 = yint[currentPos];
	        targetPosition1 = xint[0];
	       targetPosition2 = yint[0];
	       
	       
	    //get lat and long
     latitude  = Math.toRadians((currentPosition1-targetPosition1));
     longitude = Math.toRadians((currentPosition2 - targetPosition2));

     a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
     (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

     c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

     
     d = radius * c;
     min[q] = d; //getting the min distance
	   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
		q++;
		
	   currentPos = 0; //destination
	   
	  

     }
    	   if(i > 989)
      {
    	   for(int j = 990; j<distance.length;j++)
    	   {
    		   		
    		  
    	    	   if(currentPos == 199)
    	    	   {
       currentPosition1 = xint[currentPos];
        currentPosition2 = yint[currentPos];
        targetPosition1 = xint[j];
       targetPosition2 = yint[j];
    	    	   }
    	    	   else
    	    	   {
    	    		   currentPosition1 = xint[currentPos];
   	    	        currentPosition2 = yint[currentPos];
   	    	        targetPosition1 = xint[0];
   	    	       targetPosition2 = yint[0];  
    	    	   }
    		   
    		   
//get lat and long
 latitude  = Math.toRadians((currentPosition1-targetPosition1));
 longitude = Math.toRadians((currentPosition2 - targetPosition2));

 a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 d = radius * c;


min[j] = d; //getting the min distance
if(j == 1000)
{
	
}
else
{
	
currentPos = j; //destination
}
}
      }
      else {
 	 
           Min = Double.MAX_VALUE; //I want to reset after i've found the shortest distance

         
    	   for(int j = 0; j<distance.length;j++)
    	   {
    		   
    		  
    	       boolean usedyBoolean = false;
    	    	  
    	       
    	      for(int m = 0;m < used.length;m++)
    	      {
    	    	 
    	    		   if(used[m] == j) 
    	    		   {
    	    			   usedyBoolean = true; //if the same directions have already been used we want to skip
    	    		   }
    	      }
    	      if(usedyBoolean == true)
    	      {
    	    	  continue;
    	      }
    	      if(currentPos == 939)
    	      {
    	    	  currentPosition1 = xint[currentPos];
    		        currentPosition2 = yint[currentPos];
    		        targetPosition1 = xint[0];
    		       targetPosition2 = yint[0];
    		       
    		       
    		    //get lat and long
    	     latitude  = Math.toRadians((currentPosition1-targetPosition1));
    	     longitude = Math.toRadians((currentPosition2 - targetPosition2));

    	     a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
    	     (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

    	     c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

    	     
    	     d = radius * c;
    	     min[q] = d; //getting the min distance
    		   used[q] = 0; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
    			q++;
    			
    		   currentPos = 0; //destination
    		   
    		   
    	    	  currentPosition1 = xint[currentPos];
  		        currentPosition2 = yint[currentPos];
  		        targetPosition1 = xint[970];
  		       targetPosition2 = yint[970];
  		       
  		       
  		    //get lat and long
  	     latitude  = Math.toRadians((currentPosition1-targetPosition1));
  	     longitude = Math.toRadians((currentPosition2 - targetPosition2));

  	     a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
  	     (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

  	     c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

  	     
  	     d = radius * c;
  	     min[q] = d; //getting the min distance
  		   used[q] = 970; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
  			q++;
  			
  		   currentPos = 970; //destination
    		   
    		   
        	       
        	       
    	      }
    	
    	    	
    	      

    	      if(i == 1000)
    	      {
    	    	  currentPosition1 = xint[currentPos];
      	        currentPosition2 = yint[currentPos];
      	        targetPosition1 = xint[0];
      	       targetPosition2 = yint[0];
      	    
      	       
    	      }
    	      else
    	      {
    	    	
    	    	currentPosition1 = xint[currentPos];
    	        currentPosition2 = yint[currentPos];
    	        targetPosition1 = xint[j];
    	       targetPosition2 = yint[j];
    	      }
    	      
    	       
    	    
//get lat and long
 latitude  = Math.toRadians((currentPosition1-targetPosition1));
 longitude = Math.toRadians((currentPosition2 - targetPosition2));

 a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(currentPosition1)) * Math.cos(Math.toRadians((targetPosition1))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

 c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

 
 d = radius * c;




if(d <= Min && d >= 100) //finding the shortest distance if not under 100km
{
	
	Min = d;
	usedNum = j;
	continue;
	
}
           }
    	
    	 
    	   min[q] = Min; //getting the min distance
    	   used[q] = usedNum; // putting the shortest distance onto the  array,i place j's value into the array so that i do not reuse the same co-ord
    		q++;
    		
    	   currentPos = usedNum; //destination
    	   
       }
       }
       }

   
   
         
   
    	

  
    	   
minDistance(used);
finalResult(min);
   




  }
    
    //Method one
public static void arrayfiller(double xint[],double yint[],String x[],String y[])
{
	//Convert String to Double 
    for(int i = 0;i<x.length;i++)
    {
 	    xint[i] = Double.parseDouble(x[i]);
 	    yint[i] = Double.parseDouble(y[i]);
 	   
    }
	
}
public static void minDistance(int used[])
{
	System.out.println(" Distance Start: \n");
	   for(int i = 0;i<used.length;i++)
	     {
	     	System.out.println(" " +used[i] +",");

	     }
		System.out.println("\n Distance End \n");

}

//Method three
public static void finalResult(double min[])
{
	int added = 0;
	for(int i = 0;i<min.length;i++) {
		added += min[i];
	}
	double hours = 0;

	 hours=added/800.0;
	 
	System.out.println(" Distance: " + added);
	System.out.println();
	System.out.println(" speed: " + 800);
	System.out.println();
	System.out.println(" Time in hours: " + hours);
}


  


}
