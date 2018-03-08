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
       String text = "i went home with my honeY";
        //System.out.println(K.generateKey());
        //String encry = (e.getEncryoted(text));
        System.out.println(e.getEncryoted(text));
        //String k =(e.getKey());
        //System.out.println(k);
        //System.out.println(D.decryptText(encry,k));
        
        //System.out.println(e.sperate("15324",(F.getAscii(text, 8)) ,5));
        //String a =e.shuffle((e.sperate("15324",(F.getAscii(text, 8)) ,5)),"15324", 8, 5);
        //System.out.println(a);
        //String b = (e.substitute(a, "15324",34));
        //System.out.println(b);
        //String c=(D.removeSubstitute(b,"15324", 34));
        //System.out.println(c);
        //System.out.println(D.removeShuffle(c, 8, 5, "15324"));
        
        
    }
    
}
