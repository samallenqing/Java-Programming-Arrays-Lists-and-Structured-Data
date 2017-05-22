
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class CharactersInPlay {
    private ArrayList<String> character;
    private ArrayList<Integer> count;
    
    public CharactersInPlay(){
        character = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person){
        int index = character.indexOf(person);
        if(index != -1){
            int c =  count.get(index);
            count.set(index, c+1);
        }else{
           character.add(person);
           count.add(1);
        }
    }
    
    public void findAllCharacters(){
       FileResource f = new FileResource();
       for(String line : f.lines()){
          int index = line.indexOf(".");
          if (index != -1) {
                int nonblank = 0;
                while (nonblank < index) {
                    if (!line.substring(nonblank, nonblank+1).equals(" ")){
                         break;
                    }
                    else {
                        nonblank = nonblank + 1;
                    }
                }
                String person = line.substring(nonblank, index);
                update(person);
          }
        }
    }
    
    private void charactersWithNumParts(int num1, int num2) {
        for (int k = 0; k < character.size(); k++) {
            if (count.get(k)>=num1 && count.get(k) <= num2) 
                System.out.println(character.get(k) + ": "+ count.get(k)+ "\t");
        }
    }
    
    private int findIndexOfMax() {
        int current = count.get(0);
        int index = 0;
        for (int k = 0; k < count.size(); k++) {
            int newone = count.get(k);
            if (newone > current) {
                current = newone;
                index = k;
            }
            
        }
        return index;
    }
    
    public void testfindAllCharacters() {
        findAllCharacters();
        charactersWithNumParts(10, 15);
        int biggest = findIndexOfMax();
        System.out.println("The word with highest frequency is: "+character.get(biggest)+" with "+count.get(biggest));
    }
}
