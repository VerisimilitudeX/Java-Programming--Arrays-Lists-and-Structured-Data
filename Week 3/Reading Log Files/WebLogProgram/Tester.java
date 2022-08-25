import java.util.*;

public class Tester {
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAll();
        System.out.println("\nUnique IP Addresses: " + la.countUniqueIPs());
        la.printAllHigherThanNum(400);
        la.uniqueIPVisitsOnDay("Sep 30");
        la.countUniqueIPsInRange(300,399);
    }
}
