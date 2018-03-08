/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciper;

/**
 *
 * @author Lakshi Athapaththu
 */
public class Ciper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       encrypt e = new encrypt();
       keyGenerator keygen = new keyGenerator();
       Functions F= new Functions();
       Decrypt D = new Decrypt();
       keyGenerater K = new keyGenerater();
       //e.getAscii("lakshi athapaththu kavmini");
       String text = "lakshi athapaththu avindu dinushan aiya baba";
        //System.out.println(K.generateKey());
        String encry = (e.getEncryoted(text));
        System.out.println(encry);
        String keyelement = e.getKey();
        System.out.println(keyelement);
        System.out.println(D.decryptText(encry,keyelement));
        
        
        
    }
    
}
