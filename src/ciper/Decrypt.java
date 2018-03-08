
package ciper;

import java.util.ArrayList;


public class Decrypt {
Functions func = new Functions();
int dev;
String key;
public String decryptText(String test, String key1){
   String removesub =(removeSubstitute(test,key1));
   return(removeShuffle(removesub,key1)); 
}
public String removeShuffle(String text,String key1){
int count1= Integer.parseInt(key1.substring(key1.length()-1,key1.length()));
int count = Integer.parseInt(key1.substring(key1.length()-2,key1.length()-1));
int x=8;
key = key1.substring(0, key1.length()-5);
ArrayList<String> keyArray = new ArrayList<>();
dev = key1.length()-5;
for(int j=0;j<key.length();j++){
    keyArray.add(key.substring(j,j+1));
}
//System.out.println(keyArray);
//y for previous blockc
 String bin = "";
    for(int i=0;i<text.length();i++){
        String binval=Integer.toBinaryString(text.charAt(i));
        if(binval.length()<x){
            binval=func.addZeros(x, binval);
            
        }
        bin+=binval;
        
    }
ArrayList<String> ar = new ArrayList<>();
//System.out.println(bin.length());
String realStr = bin.substring(0,bin.length()-count1);
for(int j=0;j<realStr.length();j+=dev){
        ar.add(realStr.substring(j,j+dev));
        }
ArrayList<String> removeShuffle = new ArrayList<>();
for(int i=0;i<ar.size();i++){
    String element = ar.get(i);
    String afterremove="";
    for(int j=0;j<element.length();j++){

        afterremove+=element.substring(Integer.parseInt(keyArray.get(j))-1,Integer.parseInt(keyArray.get(j)));
    }
    removeShuffle.add(afterremove);
    
}
String removeshuf = "";
for(int k=0;k<removeShuffle.size();k++){
    removeshuf+=removeShuffle.get(k);
}
int num =x-(removeshuf.length()%x) ;
//System.out.println(num);
String finastr = func.addZerosSuffix(num, removeshuf);
String decrypted ="";
for(int j=0;j<finastr.length();j+=x){
    decrypted+=((char)(func.getDecimal(finastr.substring(j,j+x))));
}

return (decrypted);
 }



public String removeSubstitute(String str,String key){
     int keys= Integer.parseInt(key.substring(0, key.length()-5));
     int shift = Integer.parseInt(key.substring(key.length()-5,key.length()-2));
     String removesubstitution = "";
     int ascii;
     for(int i=0;i<str.length();i++){
        char cha = str.charAt(i);
        //System.out.println(cha);
        ascii = (char)cha;
         
        ascii = ascii-shift;
        
        removesubstitution += (char)ascii;
        
        
    }
   
     return removesubstitution;
    
    
}}
    
    
    
    
    

