
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>(); // complete constructor
     }
        
     public void readFile() {
         FileResource fr = new FileResource();// complete method
         for(String s : fr.lines()){
             LogEntry le = WebLogParser.parseEntry(s);
             records.add(le);
            }
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     public int countUniqueIPs(){
         ArrayList<String> IP = new ArrayList<String>();
         for(LogEntry le : records){
             String uniqueIP = le.getIpAddress();
             if(!IP.contains(uniqueIP)){
                 IP.add(uniqueIP);
                }
         }
         return IP.size();
     }
     
     public void printAllHigherThanNum(int num){
         ArrayList<Integer> code = new ArrayList<Integer>();
       for(LogEntry le : records){
           int statusCode = le.getStatusCode();
           if(statusCode > num && !code.contains(statusCode)){
               code.add(statusCode);
               System.out.println(le);
            }
        }
     }
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){  //“Dec 05” enter format
         ArrayList <String> time = new ArrayList<String>();
       for(LogEntry le : records){
           String date = le.getAccessTime().toString();
           if (date.contains(someday)){
               String ip = le.getIpAddress();
               if(!time.contains(ip)){
               time.add(ip); 
              }
           }
        }
       return time;
     }
     
     public ArrayList<String> countUniqueIPsInRange(int low, int high){
         ArrayList <String> uniqueIp = new ArrayList<String>();
         for(LogEntry le : records){
             int status = le.getStatusCode();
             if( low <= status && status <= high){
                 String ip = le.getIpAddress();
                 if(!uniqueIp.contains(ip)){
                     uniqueIp.add(ip);
                    }
                }
            }
         return uniqueIp;
     }
     
     public HashMap <String, Integer> countVisitsPerIP(){
         HashMap <String, Integer> counts = new HashMap <String, Integer>();
         for(LogEntry le : records){
             String ip = le.getIpAddress();
             if(! counts.containsKey(ip)){
                 counts.put(ip, 1);
                }
             else{
                 counts.put(ip, counts.get(ip) + 1);
                }
            }
         return counts;
     }
     
     public int mostNumberVisitsByIP(HashMap<String, Integer> counts){
         int max = 0;
         for(int n : counts.values()){
             if(max < n){
                 max = n;
                }
            }
         return max;
     }
     
     public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
         ArrayList<String> ip = new ArrayList<String>();
         int max = mostNumberVisitsByIP(counts);
         for(String s : counts.keySet()){
             if(counts.get(s) == max){
                 ip.add(s);
                }
            }
         return ip;
     }
     
     public HashMap <String, ArrayList<String>> iPsForDays(){
         String ip;
         HashMap <String, ArrayList<String>> count = new HashMap<String, ArrayList<String>>();
         ArrayList<String> ipList = new ArrayList<String>();
         for(LogEntry le: records){
             String whole = le.getAccessTime().toString();
             String date = whole.substring(4, 10);
             ip = le.getIpAddress();
             if (!count.containsKey(date)){
                count.put(date, new ArrayList<String>());
             }
             count.get(date).add(ip);
         }
         return count;
     }
     
     public String dayWithMostIPVisits(HashMap <String, ArrayList<String>> count){
         String date = "";
         int maxSize = 0;
         for( String s : count.keySet()){
             int currSize = count.get(s).size();
             if( maxSize < currSize){
                 maxSize = currSize;
                 date = s;
                }
            }
         return date;
     }
     
     public ArrayList<String> iPsWithMostVisitsOnDay(HashMap <String, ArrayList<String>> count
                                                     , String date){
          ArrayList<String> ip = new ArrayList<String>();
          ip = count.get(date);
          HashMap <String, Integer> time = new HashMap <String, Integer>();
          for(String s : ip){
              if(!time.containsKey(s)){
                  time.put(s,1);
                }
              else{
                  time.put(s,time.get(s)+1);
                }
            }
          ip = iPsMostVisits(time);
          return ip;
     }
}
