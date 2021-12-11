package CS211;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GPS {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Prdouble output to STDOUT */

        //meant to be 6,371
Scanner sc = new Scanner(System.in);
        double num1 = 53.3813;
        double Maynooth = 6.5918;
        double num2 = 30.5928;
        double Wuhan = -114.3055;
       int radius =6371;
        //convert to radians


 double latitude  = Math.toRadians((num1-num2));
 double longitude = Math.toRadians((Maynooth - Wuhan));

 double a = (Math.sin(latitude/2) * Math.sin(latitude/2)) + 
 (Math.cos(Math.toRadians(num1)) * Math.cos(Math.toRadians((num2))) * (Math.sin(longitude/2) * Math.sin(longitude/2)));

double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));

double d = radius * c;
d = Math.round(d);
double minid = (d%100);

//how i round down
if(minid < 49)
{
    d = d-minid;
}



// 6/10 here
int rounded = (int) (Math.ceil(d/100.0))*100;

System.out.println(rounded);

    }
}