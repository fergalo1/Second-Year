package CS211;
import java.util.*;
public class Scrabble1
{
public static void main(String args[])
{
   FileIO reader = new FileIO();
   Scanner sc = new Scanner(System.in);
   
   System.out.println("please enter your letters");
   String letters= sc.nextLine();

   String[] dict = reader.load("C://Users//Ferga//OneDrive//Documents//College second year//Dictionary.txt");  //file to String array
   String res[]= new String[10000];
 
   int a=0;
   for(int i=0;i<dict.length;i++)
   {
    boolean match=Word(dict[i],letters);
    if(match)
    {
   
    res[a]=dict[i];//assign to valid array
   
    a++;//
    }
   }
   System.out.println("Here are the top 10 suggestions : ");
     
   //sorts out words by word length
   for(int j=0; j<res.length;j++)
   {
    for (int i=j+1 ; i<res.length; i++)
           {
               if(res[i]==null)
               {
                //do nothing
               }
           else if(res[i].length()>res[j].length())
           {
                String temp= res[j];
                res[j]= res[i];
                res[i]=temp;
           }
      }
  }
  for(int i=0;i<10;i++)
  {
      if(res[i]!=null)//use null not"null"
      {
          System.out.println(res[i]);
      }
  }
       

      sc.close();
}
public static boolean Word(String in, String let)
{

char []inputArray=in.toCharArray();
char [] letterArray=let.toCharArray();

for(int i=0;i<inputArray.length;i++)//cycle through dict
{
for(int x=0;x<letterArray.length;x++)//cycle through letters
{
if(inputArray[i]==letterArray[x])
{
inputArray[i]='\0';
letterArray[x]='\0';//don't nee to look for it anymore
}

}
}
int corr=1;
for(int i=0;i<inputArray.length;i++)//cycle though dict word has the same length as 0s in
{
if(inputArray[i]==0)
{
corr++; //increment correctness
}

if(corr==inputArray.length)//full word match
{
return true;
}
}

return false;
}

}