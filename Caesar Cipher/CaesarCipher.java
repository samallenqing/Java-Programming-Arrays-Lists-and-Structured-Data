
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public String encrypt (String input, int key){
       StringBuilder sb = new StringBuilder(input);
       String order = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String order2 = order.toLowerCase();
       String NewOrder = order.substring(key);
       NewOrder = NewOrder + order.substring(0, key);
       String NewOrder2 = NewOrder.toLowerCase();
       for ( int i = 0; i < sb.length(); i ++){
           char currChar = sb.charAt(i);
           char NewChar = 'a';
           int idx = 0;
           if(order.indexOf(currChar) != -1){
               idx = order.indexOf(currChar);
               NewChar = NewOrder.charAt(idx);
               sb.setCharAt(i,NewChar);
            }
           if(order2.indexOf(currChar) != -1){
              idx = order2.indexOf(currChar);
              NewChar = NewOrder2.charAt(idx);
              sb.setCharAt(i,NewChar);
           }
            
        }
       return sb.toString();
    }
    
    public String encryptTwoKeys (String input, int key1, int key2){
       String order = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String order2 = order.toLowerCase();
       String code1 = order.substring(key1);
       code1 = code1 + order.substring(0,key1);
       String code11 = code1.toLowerCase();
       String code2 = order.substring(key2);
       code2 = code2 + order.substring(0,key2);
       String code22 = code2.toLowerCase();
       StringBuilder sb = new StringBuilder (input);
       for (int i = 0; i < sb.length(); i++){
           char currChar = sb.charAt(i);
           char NewChar = 'a';
           int idx = 0;
            if (i % 2 == 0){
                if (order.indexOf(currChar) != -1){
                    idx = order.indexOf(currChar);
                    NewChar = code1.charAt(idx);
                    sb.setCharAt(i,NewChar);
                }
                if(order2.indexOf(currChar) != -1){
                    idx = order2.indexOf(currChar);
                    NewChar = code11.charAt(idx);
                    sb.setCharAt(i,NewChar);
                }
            }
            if( i % 2 == 1){
                if (order.indexOf(currChar) !=-1){
                   idx = order.indexOf(currChar);
                   NewChar = code2.charAt(idx);
                   sb.setCharAt(i,NewChar);
                }
                if (order2.indexOf(currChar) !=-1){
                   idx = order2.indexOf(currChar);
                   NewChar = code22.charAt(idx);
                   sb.setCharAt(i,NewChar);
                }
                
            }
        }
       return sb.toString();
    }
    
    public void testCaesar(){
        FileResource f = new FileResource();
        String message = f.asString();
        String encrypted = encrypt(message, 15);
        System.out.println("key is " + 15 + "\n" + encrypted);
    }
    
    public void testEncryptTwoKeys(){
        FileResource f = new FileResource();
        String message = f.asString();
        String encrypted = encryptTwoKeys(message, 1, 15);
        System.out.println(encrypted);
    }
}
