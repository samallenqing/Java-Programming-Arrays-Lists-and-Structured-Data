
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    private String ALPHABET;
    private String shiftedALPHABET;
    
    public CaesarCipher(int key){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        ALPHABET = alphabet.toUpperCase();
        shiftedAlphabet = alphabet.substring(key,26) + alphabet.substring(0,key);
        shiftedALPHABET = ALPHABET.substring(key,26) + ALPHABET.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input){
        StringBuilder sb = new StringBuilder(input);
        for(int i = 0 ; i < sb.length(); i++){
            char currentChar = sb.charAt(i);
            int index = 0;
            char newChar = 'a';
            if(alphabet.indexOf(currentChar) != -1){
                index = alphabet.indexOf(currentChar);
                newChar = shiftedAlphabet.charAt(index);
                sb.setCharAt(i,newChar);
            }
            if(ALPHABET.indexOf(currentChar) != -1){
               index = ALPHABET.indexOf(currentChar);
               newChar = shiftedALPHABET.charAt(index);
               sb.setCharAt(i,newChar);
            }
        }
        return sb.toString();
    }
    
    public String decrypt(String input){
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        String s = cc.encrypt(input);
        return s;
    }
}
    
