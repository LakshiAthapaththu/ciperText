
package ciper;

import java.util.ArrayList;


public class Decrypt {
Functions func = new Functions();
int dev;
String key;
//public String decryptText(String test, String key1){
    //return(removeShuffle(removeSubstitute(test, key1),key1));
//}
public String removeShuffle(String text,String key1){
int count1= Integer.parseInt(key1.substring(key1.length()-1,key1.length()));
int count = Integer.parseInt(key1.substring(key1.length()-2,key1.length()-1));
int x=8;
key = key1.substring(0, key1.length()-2);
ArrayList<String> keyArray = new ArrayList<>();
//key = key1;
dev = key1.length()-2;
//System.out.println("length is"+dev);
for(int j=0;j<key.length();j++){
    keyArray.add(key.substring(j,j+1));
}
System.out.println(keyArray);
//y for previous blockc
 String bin = "";
    for(int i=0;i<text.length();i++){
        //System.out.println((int)text.charAt(i));
        //System.out.println(text.charAt(i)+" "+Integer.toBinaryString(text.charAt(i)));
        String binval=Integer.toBinaryString(text.charAt(i));
        if(binval.length()<x){
            binval=func.addZeros(x, binval);
            
        }
        bin+=binval;
        
    }
ArrayList<String> ar = new ArrayList<>();
//int remainder = bin.length()%dev;
System.out.println(bin.length());
String realStr = bin.substring(0,bin.length()-count1);
for(int j=0;j<realStr.length();j+=dev){
        ar.add(realStr.substring(j,j+dev));
        }
//System.out.println(ar);
ArrayList<String> removeShuffle = new ArrayList<>();
for(int i=0;i<ar.size();i++){
    String element = ar.get(i);
    String afterremove="";
    for(int j=0;j<element.length();j++){

        afterremove+=element.substring(Integer.parseInt(keyArray.get(j))-1,Integer.parseInt(keyArray.get(j)));
    }
    //System.out.println(afterremove);
    removeShuffle.add(afterremove);
    
}
System.out.println(removeShuffle);
String removeshuf = "";
for(int k=0;k<removeShuffle.size();k++){
    removeshuf+=removeShuffle.get(k);
}
int num =x-(removeshuf.length()%x) ;
System.out.println(num);
String finastr = func.addZerosSuffix(num, removeshuf);
System.out.println(finastr.length());
String decrypted ="";
for(int j=0;j<finastr.length();j+=x){
    decrypted+=((char)(func.getDecimal(finastr.substring(j,j+x))));
}

System.out.println("decrypted :"+" "+decrypted);
return (decrypted);
 }

//if(realStr.length()%dev==0){
    //System.out.println("true 5n bede");
//}
  //System.out.println(bin);
//if(wholetext.equals(bin)){
    //System.out.println("true");
    
    
//} 

//ArrayList<String> subStrings = new ArrayList<>();
//for(int j=0;j<bin.length();j+=5){
        //subStrings.add(bin.substring(j,j+5));

    //System.out.println(subStrings);
 
//System.out.println(subStrings);
    

public String removeSubstitute(String str,String key,int shift){
     int keys= Integer.parseInt(key.substring(0, key.length()-2));
    //System.err.println("start");
     
     String removesubstitution = "";
     int ascii;
     for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        //System.out.println(cha);
        ascii = (char)cha;
         //System.out.println(ascii);
        
        ascii = ascii-shift;
        //if(ascii<0){
            //ascii = ascii + shift;
        //}
        removesubstitution += (char)ascii;
        
        
    }
    //System.out.println(removesubstitution);
     return removesubstitution;
    
    
}}
    
    
    
    
    

