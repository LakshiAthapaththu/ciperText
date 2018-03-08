/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciper;

import java.util.ArrayList;



public class encrypt {
Functions func = new Functions();
Decrypt decr = new Decrypt();
public static int counter=0;
public static int counter1=0;
keyGenerater K = new keyGenerater();
private static String keyFinal;
String key;
Integer dev;
int x=8;
int shiftval;
public String getEncryoted(String text){
    ArrayList<String> array = (sperate(func.getAscii(text, 8)));
   String encry = shuffle(array,key);
   String subs =(substitute(encry, key));
   return(subs);
  
   
}
public ArrayList sperate(String bin){
    key = K.generateKey();
    dev = key.length();
    //seperate blocks of dev(given number)
    int length = bin.length();
    int remainder = length%dev;
    remainder=dev-remainder;
    ArrayList<String> subStrings = new ArrayList<>();
    
    for(int i=0;i<remainder;i++){
        bin+="0";
        counter++;//should be added to the key
    }
   
    for(int j=0;j<bin.length();j+=dev){
        subStrings.add(bin.substring(j,j+dev));
        }
    //System.out.println("substr"+subStrings);
    return (subStrings);
    
 }

public String shuffle(ArrayList substrings,String key){
    ArrayList<Integer> keyarray = new ArrayList<>();
    String shuffleString ;
    for(int i=0;i<key.length();i++){
        keyarray.add(Integer.parseInt(key.substring(i, i+1))); 
    }
    //System.out.println(keyarray);
    ArrayList<String> afterSuffle = new ArrayList<>();
    String Wholetext = "";
    for(int j=0;j<substrings.size();j++){
        String substr= (String)substrings.get(j);
        //down cast to type string from object
        //System.out.println(substr);
        shuffleString ="";
        for(int k=0;k<substr.length();k++){
           
            shuffleString+=substr.substring((keyarray.indexOf(k+1)),keyarray.indexOf(k+1)+1);
            }
        afterSuffle.add(shuffleString);
        Wholetext+=shuffleString;
        
    }
 //System.out.println("aftershuf"+afterSuffle);   
 //System.out.println(Wholetext);
 String text = "";
 int wholeTextLength = Wholetext.length();
    //System.out.println(wholeTextLength);
 int rem = wholeTextLength%x;
 rem=x-rem;
 for(int i=0;i<rem;i++){
        Wholetext+="0";
        counter1++;//should be added to the key
    }
    
String subStr="";
String encrypted ="";
 for(int j=0;j<Wholetext.length();j+=x){
     
     
     encrypted+=((char)(func.getDecimal(Wholetext.substring(j,j+x))));
     
 }

return (encrypted);
    
    

}


public String substitute(String str,String key){
    int max=0;
    for(int i=0;i<str.length();i++){
        if((int)str.charAt(i)>max){
            max=(int)str.charAt(i);
        }
    }
    int keys = Integer.parseInt(key);
    int shift = 256-max;
    shiftval=shift;
    int ascii;
    String newStr = "";
    for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        ascii = (char)cha;
        ascii = ascii+shiftval;
        newStr += (char)ascii;
        
        
    }
   
    return newStr;
        }
public String getKey(){
 String shif = Integer.toString(shiftval);
 while(shif.length()!=3){
    shif="0"+shif ;
 }
 keyFinal = key+shif+Integer.toString(counter)+Integer.toString(counter1);
 return keyFinal;
}
}
    

