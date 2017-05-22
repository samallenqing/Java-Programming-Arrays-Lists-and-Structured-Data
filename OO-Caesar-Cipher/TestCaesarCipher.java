
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
     public int [] countLetters(String input){
         String alphabet = "abcdefghijklmnopqrstuvwxyz";
         int [] counter = new int [26];
         input = input.toLowerCase();
         for(int i = 0; i< input.length(); i++){
             int index = 0;
             index = alphabet.indexOf(input.charAt(i));
             if(index != -1){
                 counter[index] +=1;
                }
            }
         return counter;
     }
     
     public int maxIndex(int [] counter){
         int currentIndex = 0;
         int value = 0;
       for(int i = 0; i< counter.length; i++){
           if(value <= counter[i]){
               currentIndex = i;
               value = counter[i];
            }
        }
        return currentIndex;
     }
     
     public void simpleTests(){
        FileResource f = new FileResource();
        String m = f.asString();
        CaesarCipher cc = new CaesarCipher(15);
        String EncryptedMessage = cc.encrypt(m);
        System.out.println("The encrypted message is:\n" + EncryptedMessage);
        String DecryptedMessage = cc.decrypt(EncryptedMessage);
        System.out.println("The decrypted message is:\n"+ DecryptedMessage);
        String s = breakCaesarCipher(EncryptedMessage);
        System.out.println("The decrypted message using breaking method is:\n"+s);
     }
     
     public String breakCaesarCipher(String input){
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
         CaesarCipher cc = new CaesarCipher(key);
         String message = cc.encrypt(input);
         return message;
        }
        
}
