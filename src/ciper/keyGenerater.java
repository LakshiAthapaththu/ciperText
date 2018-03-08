
package ciper;

import java.util.ArrayList;
import java.util.Arrays;
 import java.util.Random;

public class keyGenerater {

public String generateKey(){
   
Random randomNum = new Random();
Random rand = new Random();
int  n = 5 + randomNum.nextInt(5);
//System.out.println(n);
int num;
String key ="";
ArrayList<Integer> keys = new ArrayList<>();
while(keys.size()<n){
    num = rand.nextInt(n)+1;
    if(keys.contains(num)==false){
        keys.add(num);
    }
}
for(int i = 0; i<keys.size();i++){
    key+=Integer.toString(keys.get(i));
}
    System.out.println(key);
return key;
}

}
