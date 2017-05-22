
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    public void simpleTests(){
    CaesarCipherTwo c = new CaesarCipherTwo(12,2);
    FileResource f = new FileResource();
    String s = f.asString();
    String m = c.encrypt(s);
    System.out.println("The encrypted message is:\n"+m);
    String d = c.decrypt(m);
    System.out.println("The decrypted message is:\n"+d);
    String t = breakCaesarCipher(m);
    System.out.println("The decrypted message with new method is:\n"+t);
   }
   
   public String halfOfString(String message, int start){
          String hs = new String();
          for(int i= start; i < message.length(); i += 2){
              hs = hs + message.charAt(i);
            }
          return hs;
   }
   
   public int [] countLetters(String s){
          int [] counter = new int [26];
          String order = "abcdefghijklmnopqrstuvwxyz";
          s = s.toLowerCase();
          for(int i=0; i < s.length(); i++){
             int index = order.indexOf(s.charAt(i));
             if(index != -1){
                 counter[index] += 1;
                }
          }
          return counter;
      }
      
   public int maxIndex(int [] counter){
          int tag = 0;
          int index = 0;
          for(int i = 0; i < counter.length; i++){
              if( tag < counter[i] ){
                  index = i; 
                  tag = counter[i];
                }
            }
            return index;
   }
   
   public int getKey(String input){
      int [] counter = countLetters(input);
      int index = maxIndex(counter);
      int key = 0;
      if(index <= 4){
             key = 4 - index;
            }
      if(index > 4){
             key = index - 4;
             key = 26 - key;
      } 
      return key;
    }
    
   public String breakCaesarCipher(String input){
       String h1 = halfOfString(input, 0);
       String h2 = halfOfString(input, 1);
       int key1 = getKey(h1);
       int key2 = getKey(h2);
       System.out.println("key1 and key2 are:\n" + key1 + key2);
       CaesarCipherTwo cct = new CaesarCipherTwo(key1, key2);
       String m = cct.encrypt(input);
       return m;
    }
   
        
}
