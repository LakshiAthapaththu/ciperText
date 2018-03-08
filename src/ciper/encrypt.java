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
    System.out.println("encry"+encry);
   //return(decr.removeShuffle(encry, getKey()));
   String subs =(substitute(encry, key));
   ///return(subs);
    System.out.println("subs"+subs);
   String removesub =(decr.removeSubstitute(subs, getKey(),shiftval));
   //return(removesub);
   //System.out.println(removesub);
   return(decr.removeShuffle(removesub,getKey()));
   
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
    //System.out.println(counter);
    //System.out.println(bin);
    for(int j=0;j<bin.length();j+=dev){
        subStrings.add(bin.substring(j,j+dev));
        }
    System.out.println("substr"+subStrings);
    return (subStrings);
    
 }

public String shuffle(ArrayList substrings,String key){
    ArrayList<Integer> keyarray = new ArrayList<>();
    String shuffleString ;
    for(int i=0;i<key.length();i++){
        keyarray.add(Integer.parseInt(key.substring(i, i+1))); 
    }
    System.out.println(keyarray);
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
 System.out.println("aftershuf"+afterSuffle);   
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
    //System.err.println(counter1);
//System.out.println("whole text is:"+Wholetext); 
String subStr="";
String encrypted ="";
 for(int j=0;j<Wholetext.length();j+=x){
     
     //System.out.println((Wholetext.substring(j,j+8)));
     //System.out.println(func.getDecimal(Wholetext.substring(j,j+x)));
     //System.out.println((char)(func.getDecimal(Wholetext.substring(j,j+8))));
     //System.out.println((char)(func.getDecimal(Wholetext.substring(j,j+x)))+Wholetext.substring(j,j+x));
     encrypted+=((char)(func.getDecimal(Wholetext.substring(j,j+x))));
     //System.err.println(encrypted);
 
   //System.err.println(Wholetext.length());
 }
//System.out.println("abc");
//System.out.println(encrypted);
//System.out.println("ency");
return (encrypted);
    //decr.removeShuffle(encrypted,x,Wholetext,dev,keyarray);
    

}


public String substitute(String str,String key){
    int max=0;
    for(int i=0;i<str.length();i++){
        if((int)str.charAt(i)>max){
            max=(int)str.charAt(i);
        }
    }
    System.out.println("max"+max);
    
    int keys = Integer.parseInt(key);
    //System.out.println(keys);
    int shift = 256-max;
    shiftval=shift;
    System.out.println(shiftval);
    int ascii;
    String newStr = "";
    for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        //System.out.println(cha);
        ascii = (char)cha;
        //System.out.println(ascii);
        ascii = ascii+shiftval;
        newStr += (char)ascii;
        
        
    }
   
    return newStr;
        }
public String getKey(){
    System.out.println(counter);
    System.out.println(counter1);
    //System.out.println("key"+key);
 keyFinal = key+Integer.toString(counter)+Integer.toString(counter1);
 return keyFinal;
}
}
    

