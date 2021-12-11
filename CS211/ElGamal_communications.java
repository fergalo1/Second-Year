package CS211;
import java.util.Scanner;
import java.math.*;
public class ElGamal_communications {
public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Alice");
	String Alice = sc.nextLine();
	String splited[] = Alice.split("\\s+"); 
	while(splited.length != 3 )
	{
		Alice = "4027 2423 2270";
		splited = Alice.split("\\s+");
	}
	BigInteger A1 = new BigInteger(splited[0]);
	BigInteger A2 = new BigInteger(splited[1]);
	BigInteger A3 = new BigInteger(splited[2]);
	
	BigInteger x = new BigInteger("0");//unknown
	
	
	BigInteger p=new BigInteger(splited[0]); // public key
	BigInteger g=new BigInteger(splited[1]); //3 numbers
	BigInteger answerx=new BigInteger(splited[2]); //is the answer to g^x modp we need to find a way to find x
	BigInteger addInLoop = new BigInteger("1");
	BigInteger c = new BigInteger("0");
	//y is p,g and g^x modp
	
	boolean match = false;
	while(match != true)
	{
		 c = (g.modPow(x, p));
		 
		System.out.println(c + " + " +  answerx);
				if(c.intValue() == answerx.intValue())
				{
					match = true;
					System.out.println(x);
					break;
				}
					
		x = x.add(addInLoop);
		System.out.print(x + " ");
		
	}
	BigInteger m = new BigInteger("0"); //is either g^x and y or x and g^y

///////////////////////////////////////////////
	System.out.println("Bob");
	String Bob = sc.nextLine();
	String splitedbob[] = Bob.split("\\s+");
	while(splitedbob.length != 2 )
	{
		Bob = sc.nextLine();
		splitedbob = Bob.split("\\s+");
	}
	BigInteger c1 = new BigInteger(splitedbob[0]);
	BigInteger c2 = new BigInteger(splitedbob[1]);
    
    
    m = (c1.pow((p.intValue()-1)-x.intValue()));
    m = m.multiply(c2);
    m = m.mod(p);
    
    System.out.println(m);
	
	
	
	
	
	
	
}
}
