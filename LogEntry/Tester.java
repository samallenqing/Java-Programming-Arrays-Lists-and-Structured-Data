
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAll();
        // complete method
    }
    
    public void testUniqueIP(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        int n = la.countUniqueIPs();
        System.out.println(n);
    }
    
    public void testPrintAllHigherThanNum(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        la.printAllHigherThanNum(400);
    }
    
    public void testUniqueIPVisitsOnDay(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile();
        ArrayList<String> timeIp = new ArrayList<String>();
        String d = "Sep 24";    //Enter format as: “Dec 05” 
        timeIp = la.uniqueIPVisitsOnDay(d);    
        for(String s : timeIp){
            System.out.println(d+"\tThose IPs accessed web:\t"+s);
        }
        System.out.println("The size of ArrayList is:\t"+timeIp.size());
    }
    
    public void testCountUniqueIPsInRange(){
      LogAnalyzer la = new LogAnalyzer();
      la.readFile();
      ArrayList<String> ip = new ArrayList<String>();
      ip = la.countUniqueIPsInRange(200,299);
      for(String s : ip){
         System.out.println(s); 
        }
      System.out.println("The size of ArrayList is:\t"+ip.size());
    }
}
