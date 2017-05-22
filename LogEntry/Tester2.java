
/**
 * Write a description of Tester2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class Tester2 {
    
    public void testCountVisitsPerIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap<String, Integer> hm = la.countVisitsPerIP();
        System.out.println(hm);
    }
    
    public void testMostNumberVisitsByIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap<String, Integer> hm = la.countVisitsPerIP();
        int max = la.mostNumberVisitsByIP(hm);
        System.out.println("Maximum number of visits to this website by a single IP address is:\t"+max);
    }
    
    public void testIPsMostVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap<String, Integer> hm = la.countVisitsPerIP();
        ArrayList<String> ip = la.iPsMostVisits(hm);
        System.out.println("All IP addresses that all have the maximum number of visits to this website are:\t"
                            + ip);
    }
    
    public void testIPsForDays(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap <String, ArrayList<String>> hm = la.iPsForDays();
        ArrayList<String> ss = new ArrayList<String>();
        for(String s : hm.keySet()){
          ss = hm.get(s);
          System.out.println("IP addresses occurred on day:\t" +s+"\n"+ss);
        }
    }
    
    public void testDayWithMostIPVisits(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap <String, ArrayList<String>> hm = la.iPsForDays();
        String date = la.dayWithMostIPVisits(hm);
        System.out.println("The day that has the most IP address visits is:\t"+date);
    }
    
    public void testIPsWithMostVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        HashMap <String, ArrayList<String>> hm = la.iPsForDays();
        String date = "Sep 29"; // Input date value, format similar to : Sep 30
        ArrayList<String> s = la.iPsWithMostVisitsOnDay(hm, date);
        System.out.println("On "+ date +" those IP had the most accesses:\t"+s);
    }
}
