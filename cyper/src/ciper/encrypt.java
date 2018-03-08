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
 


public ArrayList sperate(String key,String bin,Integer dev){
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
    //System.out.println(subStrings);
    return (subStrings);
 }

public String shuffle(ArrayList substrings,String key,int x,int dev){
    ArrayList<Integer> keyarray = new ArrayList<>();
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
        String shuffleString ="";
        for(int k=0;k<substr.length();k++){
           
            shuffleString+=substr.substring((keyarray.indexOf(k+1)),keyarray.indexOf(k+1)+1);
            }
        afterSuffle.add(shuffleString);
        Wholetext+=shuffleString;
        
    }
 //System.out.println(afterSuffle);   
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
    System.err.println(encrypted);
//System.out.println("ency");
return (encrypted);
    //decr.removeShuffle(encrypted,x,Wholetext,dev,keyarray);
    

}


public String substitute(String str,String key,int y){
    int keys = Integer.parseInt(key);
    //System.out.println(keys);
    int shift = keys%y;
    //System.out.println(shift);
    int ascii;
    String newStr = "";
    for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        //System.out.println(cha);
        ascii = (char)cha;
        //System.out.println(ascii);
        ascii = ascii+shift;
        if(ascii>y){
            ascii = ascii - y;
            //System.out.println(ascii);
        }
        newStr += (char)ascii;
        
        
    }
    //System.out.println(newStr);
    return newStr;
        
        
           
    }
public String removeSubstitute(String str,String key,int y){
    //System.err.println("start");
     int keys = Integer.parseInt(key);
     int shift = keys%y;
     String removesubstitution = "";
     int ascii;
     for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        //System.out.println(cha);
        ascii = (char)cha;
         //System.out.println(ascii);
        
        ascii = ascii+y-shift;
        //if(ascii<0){
            //ascii = ascii + shift;
        //}
        removesubstitution += (char)ascii;
        
        
    }
    //System.out.println(removesubstitution);
     return removesubstitution;
    
    
}
}
    

