
/**
 * Write a description of Week1Assignment21 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLengths{
    public int[] countWordLengths(FileResource resource, int[] counts){
      for(String w : resource.words()){
          int leng = 0;
          for(int i = 0; i < w.length(); i ++){
              if(Character.isLetter(w.charAt(i)) || w.charAt(i) == '-'){
                  leng +=1;
                }
            }
          if ( leng != 0 && leng <= counts.length){
              counts[leng-1] += 1;
            }
          else{
              System.out.println("Word's Length Larger Than Array Capacity");  
            }
        }
      return counts;
    }
    
    public void testcountWordLengths(){
        FileResource f = new FileResource();
        int [] k = new int [100];
        k = countWordLengths(f, k);
        int maxLength = indexOfMax(k);
        for( int i = 0; i < k.length; i++){
            if(k[i] != 0){
               System.out.println(k[i] + "  Words' Length are "+ (i+1));
            }
        }
        System.out.println("The most common words' length is    " + maxLength);
    }
    
    public int indexOfMax(int [] values){
        int max = 0;
        int tag = 0;
        for(int i = 0; i < values.length; i++){
           if( tag <= values[i] && values[i] != 0){
               max = i + 1;
               tag = values[i];
            }
        }
        return max;
    }
}
    
   