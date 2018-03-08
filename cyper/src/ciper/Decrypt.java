
package ciper;

import java.util.ArrayList;


public class Decrypt {
Functions func = new Functions();

public String removeShuffle(String text,int x,int dev,String key){
ArrayList<String> keyArray = new ArrayList<>();
for(int j=0;j<key.length();j++){
    keyArray.add(key.substring(j,j+1));
}
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
String realStr = bin.substring(0,bin.length()-encrypt.counter1);
for(int j=0;j<realStr.length();j+=dev){
        ar.add(realStr.substring(j,j+dev));
        }
//System.out.println(ar);
ArrayList<String> removeShuffle = new ArrayList<>();
for(int i=0;i<ar.size();i++){
    String element = ar.get(i);
    String afterremove="";
    for(int j=0;j<element.length();j++){
        afterremove+=element.substring((keyArray.indexOf(j+1)),keyArray.indexOf(j+1)+1);
    }
    removeShuffle.add(afterremove);
    
}
//System.out.println(removeShuffle);
String removeshuf = "";
for(int k=0;k<removeShuffle.size();k++){
    removeshuf+=removeShuffle.get(k);
}
String finastr =removeshuf.substring(0, removeshuf.length()-encrypt.counter);
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
    
}
    
    
    
    
    

