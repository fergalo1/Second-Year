package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ProjectCS211_V3 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
Scanner sc = new Scanner(System.in);
      Stack s = new Stack();
        int Min = Integer.MAX_VALUE;
       int radius =6371;
       int used[]= new int[1001] ; //in the find shortest distance i want to store all j values that have been used so that i don't reuse distances
        int usedNum = 0;
       //convert to radians
       FileIO reader = new FileIO();
       String[] x = reader.load("C://Users//User//Documents//College second year//xcoordinates.txt");  //file to String distanceay
       String[] y = reader.load("C://Users//User//Documents//College second year//ycoordinates.txt");  //file to String distanceay
      double[] xint = new double[x.length];
      double[] yint = new double[y.length];
      int distance[] = new int[x.length];
      int min[] = new int[1001];
int l = x.length;
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
    	   int z = -1;
       boolean usedBoolean = false;
    	  
       if(i != 0) //if 'i' is at zero then no point checking
    	  {
       while(usedBoolean == false && z != 1000)
    	   {
    		   z++;

    		   
    		   if(used[z] == i) 
    		   {
    			   //System.out.println(used[z]); //finding the used slots ie/ j values used
    			  //continue; //if j position has been used already then you want to go to the next value
    		   
    		   }
    		   else
    		   {
    			   usedBoolean = true;
    		   }
    	   }
    		   
    	   }
           Min = Integer.MAX_VALUE; //I want to reset after i've found the shortest distance


    	   for(int j = 1; j<distance.length;j++)
    	   {
       double currentPosition1 = xint[i];
       double currentPosition2 = yint[i];
       double targetPosition1 = xint[j];
       double targetPosition2 = yint[j];

//get lat and long
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


distance[i] = rounded;

//System.out.println(rounded); //test to see after rounded

if(distance[i] == 100)
{
	Min = distance[i];
	usedNum = j;
	//System.out.println(j); //see what number is used
	break;
}
else if(distance[i] < Min && distance[i] >99) //finding the shortest distance if not under 100km
{
	Min = distance[i];
	//System.out.println(j); //see what number is used
	usedNum = j;
}


}
    	  //System.out.println("Min Distance!:" + Min +" " + i);
    	  min[q] = Min; //getting the min distance
    	   used[q] = usedNum; // putting the shortest distance onto the sortingarrayay, j's value so that i does not reuse the same co-ord
    	   q++;
       }
//    	   Content of the min distance
//    	  for(int i = 0;i<min.length;i++)
//    	  {
//    		    System.out.println(i + " : " +min[i] );
//
//    	  }
    
   
//partition(min,0,min.length-1);
sort(min,0,min.length-1);
//Content of the min distance quick sorted
for(int i = 0;i<min.length;i++)
{
	    System.out.println(min[i]);

}


    }
    

///////////////////////////////////////////////////////////////////
   public static int partition(int sortingarray[], int Start, int End) 
    { 
        int pivot = sortingarray[End];  
        int i = (Start-1); // index of smaller element 
        for (int j=Start; j<End; j++) 
        { 
            // If current element is smaller than the pivot 
            if (sortingarray[j] < pivot)  
            { 
                i++; 
  
                // swap sortingarray[i] and sortingarray[j] 
                int temp = sortingarray[i]; 
                sortingarray[i] = sortingarray[j]; 
                sortingarray[j] = temp; 
            } 
        } 
  
        // swap sortingarray[i+1] and sortingarray[End] (or pivot) 
        int temp = sortingarray[i+1]; 
        sortingarray[i+1] = sortingarray[End]; 
        sortingarray[End] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      sortingarray[] --> Array to be sorted, 
      Start  --> Starting index, 
      End  --> Ending index */
   public static void sort(int sortingarray[], int Start, int End) 
    { 
        if (Start < End) 
        { 
            /* pi is partitioning index, sortingarray[pi] is  
              now at right place */
            int pi = partition(sortingarray, Start, End); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(sortingarray, Start, pi-1); 
            sort(sortingarray, pi+1, End); 
        } 
    } 
  


}