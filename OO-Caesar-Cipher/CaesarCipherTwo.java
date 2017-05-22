
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    private String Alphabet;
    private String ALPHABET;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private String shiftedAlphabet11;
    private String shiftedAlphabet22;
    private int mainKey1;
    private int mainKey2;
    
    public CaesarCipherTwo(int key1, int key2){
        Alphabet = "abcdefghijklmnopqrstuvwxyz";
        ALPHABET = Alphabet.toUpperCase();
        mainKey1 = 26 - key1;
        mainKey2 = 26 - key2;
        shiftedAlphabet1 = Alphabet.substring(key1, 26) + Alphabet.substring(0, key1);
        shiftedAlphabet11 = ALPHABET.substring(key1, 26) + ALPHABET.substring(0,key1);
        shiftedAlphabet2 = Alphabet.substring(key2, 26) + Alphabet.substring(0, key2);
        shiftedAlphabet22 = ALPHABET.substring(key2, 26) + ALPHABET.substring(0,key2); 
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0; i < sb.length(); i++){
            int index = 0;
            if(i % 2 == 0){
                if(Alphabet.indexOf(sb.charAt(i)) != -1){
                    sb.setCharAt(i, shiftedAlphabet1.charAt(Alphabet.indexOf(sb.charAt(i))));
                }
                if(ALPHABET.indexOf(sb.charAt(i)) != -1){
                    sb.setCharAt(i, shiftedAlphabet11.charAt(ALPHABET.indexOf(sb.charAt(i))));
                }
            }
            if(i % 2 == 1){
                if(Alphabet.indexOf(sb.charAt(i)) != -1){
                    sb.setCharAt(i, shiftedAlphabet2.charAt(Alphabet.indexOf(sb.charAt(i))));
                }
                if(ALPHABET.indexOf(sb.charAt(i)) != -1){
                    sb.setCharAt(i, shiftedAlphabet22.charAt(ALPHABET.indexOf(sb.charAt(i))));
                }
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipherTwo c = new CaesarCipherTwo(mainKey1, mainKey2);
        String m = c.encrypt(input);
        return m;
    }
}
