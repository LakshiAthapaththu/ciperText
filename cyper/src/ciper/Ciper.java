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
       //e.getAscii("lakshi athapaththu kavmini");
       String text = "Youbaby ni moec 93825093 djsdhj #%#$%";
       //System.out.println("original:"+" "+text);
       //e.shuffle(e.sperate("3", F.getAscii(text,8),5),"45312",8,5);
       //e.substitute(text, "45312");
       //keygen.generateKey("abcdefg");
       //System.out.println("abc");
       //e.substitute(text, "");
       String afterSubs = e.substitute(text,"12543",127);
       System.out.println(afterSubs);
       System.out.println(F.getAscii(afterSubs,8));
       //System.err.println("abc");
       String after_shuf = e.shuffle(e.sperate("12543",F.getAscii(afterSubs,8),5),"12543",8,5);
       //System.out.println("after_shuf");
       System.out.println(after_shuf);
       //String remove = D.removeShuffle(after_shuf,8,5,"12543");
       //System.out.println(remove);
       //System.out.println(e.removeSubstitute(afterSubs,"12543",127));
       
    }
    
}
