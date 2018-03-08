
package ciper;

public class Functions {

public int getDecimal(String bin){
int decimal = 0;
for(int i=0;i<bin.length();i++){
  decimal+=Integer.parseInt(bin.substring(i,i+1))*(Math.pow(2,bin.length()-1-i));  
}
 return decimal;
}

public String addZeros(int num,String str){
    String binval=str;
    int len=str.length();
    String prefix="";
    for(int i=0;i<num-len;i++){
        prefix+="0";
    }
    //System.out.println(prefix+binval);
return (prefix+binval);

}
public String getAscii(String text,int x) { 
//get whole binary code
   String totStr="";
    for (int i=0;i<text.length();i++){
        
        //System.out.println(text.charAt(i));
        //System.out.println(int(text.charAt(i)));
        String s=(Integer.toBinaryString(text.charAt(i)));
        if(s.length()<x)//change this 8
        {
            s=addZeros(x, s);
        }
       //System.out.println("s is"+" "+s);
       totStr+=s; 
}
return (totStr); 
    
    
}

}