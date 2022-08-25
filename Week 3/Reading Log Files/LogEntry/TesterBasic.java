import java.util.*;

public class TesterBasic{
    public void testLogEntry() {
        LogEntryBasic le = new LogEntryBasic("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntryBasic le2 = new LogEntryBasic("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        // complete method
    }
}
