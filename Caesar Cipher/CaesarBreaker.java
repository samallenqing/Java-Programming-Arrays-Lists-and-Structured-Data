
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarBreaker {
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
        
      public String decrypt(FileResource resource){
          CaesarCipher c = new CaesarCipher();
          String xxx = resource.asString();
          String s = resource.asString();
          int [] counter = countLetters(s);
          int index = maxIndex(counter);
          
          int key = 0;
          if (index <= 4 ){
             key = 4 - index; 
            }
            else{
             key = index - 4;  
             key = 26 - key;
            } 
            
          String message = c.encrypt(xxx, key);
          return message;
        }
     
      public void testDecrypt() {
          FileResource f = new FileResource();
          String message = decrypt(f);
          System.out.println("The Original Message is   " + message);
        }
        
      public String halfOfString(String message, int start){
          String hs = new String();
          for(int i= start; i < message.length(); i += 2){
              hs = hs + message.charAt(i);
            }
          return hs;
        }
        
      public int getKey(String s){
          int [] counter = countLetters(s);
          int index = maxIndex(counter);
          System.out.println(index);
          int key = 0;
          if (index <= 4 ){
             key = 4 - index;
            }
           if(index > 4){
             key = index - 4;   
             key = 26 - key;
            }  
          return key;
      }
      
      public String decryptTwoKeys(String encrypted){
          CaesarCipher cc = new CaesarCipher();
          String a = new String();
          String b = new String();
          for(int i = 0; i< encrypted.length(); i += 1){
              if(i % 2 == 0){
                  a = a + encrypted.charAt(i);
                }
              if(i % 2 == 1){
                b = b + encrypted.charAt(i);  
                }
            }
          int key1 = getKey(a);
          int key2 = getKey(b);
          System.out.println("The two key used to decrypt message is key1 =   " + key1+"    key2 =  "+key2);
          String message = cc.encryptTwoKeys(encrypted, key1, key2);
          return message;
        }
      
      public void testDecryptTwoKeys(){
          FileResource f = new FileResource();
          String s = f.asString();
          String message = decryptTwoKeys(s);
          System.out.println("The original message is:  " + message); 
        }
}
