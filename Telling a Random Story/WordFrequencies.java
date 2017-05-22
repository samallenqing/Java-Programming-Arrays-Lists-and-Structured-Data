
/**
 * Write a description of WordFrequencies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class WordFrequencies {
    private ArrayList<Integer> myFreqs;
    private ArrayList<String> myWords;
    
    public WordFrequencies(){
        myFreqs = new ArrayList <Integer>();
        myWords = new ArrayList <String>();
        
    }
    
    public void findUnique(){
       myFreqs.clear();
       myWords.clear();
       FileResource f = new FileResource();
       for(String word : f.words()){
           word = word.toLowerCase();
           int index = myWords.indexOf(word);
           if(index != -1){
               int fre = myFreqs.get(index);
               myFreqs.set(index, fre+1); 
           }else{
              myWords.add(word);
              myFreqs.add(1); 
            }
           
        }
    }
    
    public void tester(){
        findUnique();
        for(int i = 0; i < myWords.size(); i++){
            if(myFreqs.get(i)>240 && myFreqs.get(i)<270 ){
           System.out.println(myWords.get(i)+ ":" + myFreqs.get(i) + "\t"); 
           }
        }
        System.out.println("Unique words number is  "+myWords.size());
        int maxIndex = findIndexOfMax();
        System.out.println("The word that occurs most often and its count are:  "
                            + myWords.get(maxIndex) +"\t"+ myFreqs.get(maxIndex));
    }
    
    public int findIndexOfMax(){
       int count = 0;
       int index = 0;
       for(int i = 0; i< myFreqs.size(); i++){
           if(count < myFreqs.get(i)){
               count = myFreqs.get(i);
               index = i;
            }
        }
        return index;
    }
}
