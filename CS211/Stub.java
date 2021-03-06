package CS211;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.lang.Object.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Stub{    
    
    public static void main (String[] args){
        Scanner myscanner = new Scanner(System.in);
        int num = Integer.parseInt(myscanner.nextLine());
        String[] dictionary = new String[num];
        for(int i=0;i<num;i++){
            dictionary[i]=myscanner.nextLine();
        }
        String hash = dictionary[num-1]+(int)(Math.random()*100);
        int games = 100;
        int score = 0;
        for(int x=0;x<games;x++){

            Random r = new Random();
            String target = dictionary[r.nextInt(num)];

            String blackout="";
            for(int i=0;i<target.length();i++){
                blackout=blackout+"_";
            }

            Brain mybrain = new Brain(dictionary, blackout);
            int lives=8;

            boolean running = true;

            while(running){
                char guess = mybrain.guessLetter();
                String original = mybrain.hiddenWord;
                char[] arrayform = original.toCharArray();
                for(int i=0;i<target.length();i++){
                    if(target.charAt(i)==guess){
                        arrayform[i]=guess;
                    }
                }
                String newform = "";
                for(int i=0;i<target.length();i++){
                    newform=newform+arrayform[i];
                }
                mybrain.hiddenWord=newform;
                if(newform.equals(original)){
                    lives=lives-1;
                }
                if(lives==0){
                    running=false;
                }
                if(mybrain.hiddenWord.equals(target)){
                    running=false;
                    score=score+1;
                }
            }
        }
        System.out.println("You got "+score+" correct out of 100");
        try{
            System.out.println("Your Receipt: "+sha256(hash+score));
        }catch(NoSuchAlgorithmException e){};
    }
    
    public static String sha256(String input) throws NoSuchAlgorithmException {
        byte[] in = hexStringToByteArray(input);
        MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
        byte[] result = mDigest.digest(in);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
    
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        if(len%2==1){
            s=s+"@";
            len++;
        }
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

class Brain{
    
    public String[] dictionary;
    public String hiddenWord="_____";
       char start[] =  {' ','a','b','c','d','e','f','g','h','i'};
           int starternumber = 0;
           int endnumber = 0;

           char end[] = {' ','e','y','s','n','t','m','a','r','c','l','d','o','k','g','p','x','i','w','u','f','b','j','v'};
    
    char common[]= {' ','e','a','i','o','r','t','n','s','l','c','p','m','u','h','g','y','d','b','f','v','k','w','x','q','z','j'};

        int comnum = -1;
    public Brain(String[] wordlist, String target){
        dictionary = wordlist;
        hiddenWord = target;
    }
      
    public char guessLetter(){
        System.out.println(hiddenWord);
        
        if(starternumber < 9)
        {
            starternumber++;
        }
        else
        {
            starternumber = 1;
        }
         if(endnumber < 23)
        {
            endnumber++;
        }
        else
        {
            endnumber = 1;
        }
        String starter = "" + hiddenWord.charAt(0);
        String ender = "" +hiddenWord.charAt(hiddenWord.length()-1);
            System.out.println("gets to if statement" + starter + " " + ender);
if(hiddenWord.length() == 1 )
{
	if(starter.equals("_"))
    {
        System.out.println("met start");

        starternumber++;
        return start[starternumber];
    }
}
else
{
        if(starter.equals("_"))
        {
            System.out.println("met start");

            starternumber++;
            return start[starternumber];
        }
        if(ender.equals("_"))
        {
            System.out.println("met end");
            return end[endnumber];
        }
        comnum++;
        if(comnum > common.length)
        {
            comnum = 0;
        }
        String com = "" + common[comnum];
        boolean inf = true;
        while(inf)
        {
        if(ender.equals(com) || starter.equals(com))
        {
            comnum++;
            com = "" + common[comnum];
        }
        else{
            return common[comnum];
        }
        }
        return 'z';
}
    }       
}
