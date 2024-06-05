package ShoppingApp;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {
    private static final String LOG_FILE = "ShoppingAppLogs.log"; 
  
    public static void log(String message) {
        Date date = new Date();
        String logMessage = date.toString() + " - " + message;
        
        System.out.println(logMessage);

        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(logMessage);
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
