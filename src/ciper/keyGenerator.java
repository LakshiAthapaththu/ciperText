/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciper;

public class keyGenerator {
Functions func=new Functions();   
public void generateKey(String Alphabet){
    String bin = func.getAscii(Alphabet, 8);
    //System.out.println(bin);
    //int key=(func.getDecimal(bin));
    //int count=0;
    //System.out.println(key);
    //while(key>1000){
       //key=key-1000;
       //count++;
    
    //} 
    
    //System.out.println(Integer.toString(key)+"K"+Integer.toString(count));
    
}

    
}
