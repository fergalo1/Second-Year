import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner myscanner = new Scanner(System.in);
        String letters = myscanner.nextLine();
        String array[] = new String[216555];
        for(int i=0;i<216555;i++){
            array[i]=myscanner.nextLine();
        }
        System.out.println(findLength(letters,array));
    }
        

    public static int findLength(String letters, String[] array){
           String res[]= new String[30000];
       int a=0;
   for(int i=0;i<array.length;i++)
   {
    boolean match=Word(array[i],letters);
    if(match)
    {
   
    res[a]=array[i];//assign to valid array
   
    a++;//
    }
   }
     
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
        //System.out.println(res[i]);
         return res[i].length();
      }
  }
       
return 0;
     
}
public static boolean Word(String in, String let)
{

char []inputArray=in.toCharArray();
char [] letterArray=let.toCharArray();

for(int i=0;i<inputArray.length;i++)//cycle through array
{
for(int x=0;x<letterArray.length;x++)//cycle through letters
{
if(inputArray[i]==letterArray[x])
{
inputArray[i]='\0';
letterArray[x]='\0';//don't need it anymore
}

}
}
int closeness=0;
for(int i=0;i<inputArray.length;i++)//cycle though array word has the same length as 0s in
{
if(inputArray[i]==0)
{
closeness++; //increment closeness
}

if(closeness==inputArray.length)//full word match
{
    //System.out.println(inputArray[i]);
return true;
}
}

return false;
}



        
    


}