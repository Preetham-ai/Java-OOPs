import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.regex.*;

public class LogAnalyzer {
    private static final Pattern LOG_PATTERN = Pattern.compile(
        "\\[(.*?)\\] \\[(.*?)\\] (.*)");
    private static final DateTimeFormatter DATE_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void analyzeLogFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = reader.readLine()) != null) {
                Matcher matcher = LOG_PATTERN.matcher(line);
                if(matcher.matches()) {
                    LocalDateTime timestamp = LocalDateTime.parse(matcher.group(1), DATE_FORMAT);
                    String level = matcher.group(2);
                    String message = matcher.group(3);
                    
                    System.out.printf("[%s] %s: %s%n",
                        timestamp.format(DateTimeFormatter.ISO_LOCAL_TIME),
                        level,
                        message);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("app.log")) {
            writer.println("[2023-11-15 08:30:45] [INFO] Application started");
            writer.println("[2023-11-15 08:31:20] [WARNING] Low memory detected");
            writer.println("[2023-11-15 08:32:10] [ERROR] Failed to connect to database");
        } catch (FileNotFoundException e) {
            System.err.println("Could not create log file: " + e.getMessage());
            return;
        }
        
        try {
            System.out.println("Analyzing log file:");
            analyzeLogFile("app.log");
        } catch (IOException e) {
            System.err.println("Error analyzing log: " + e.getMessage());
        }
    }
}

