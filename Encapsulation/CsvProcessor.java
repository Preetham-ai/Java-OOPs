import java.io.*;
import java.util.*;

public class CsvProcessor {
    public static List<Map<String, String>> readCsv(String filename) throws IOException {
        List<Map<String, String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] headers = br.readLine().split(",");
            String line;
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, String> record = new LinkedHashMap<>();
                for(int i = 0; i < headers.length && i < values.length; i++) {
                    record.put(headers[i].trim(), values[i].trim());
                }
                records.add(record);
            }
        }
        return records;
    }
    
    public static void writeCsv(String filename, List<Map<String, String>> data) throws IOException {
        if(data.isEmpty()) return;
        
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            String[] headers = data.get(0).keySet().toArray(new String[0]);
            pw.println(String.join(",", headers));
            
            for(Map<String, String> row : data) {
                String[] values = new String[headers.length];
                for(int i = 0; i < headers.length; i++) {
                    values[i] = row.get(headers[i]);
                }
                pw.println(String.join(",", values));
            }
        }
    }

    public static void main(String[] args) {
        try {
            // Create sample data
            List<Map<String, String>> data = new ArrayList<>();
            Map<String, String> row1 = new LinkedHashMap<>();
            row1.put("Name", "Alice");
            row1.put("Age", "30");
            row1.put("Occupation", "Engineer");
            data.add(row1);
            
            Map<String, String> row2 = new LinkedHashMap<>();
            row2.put("Name", "Bob");
            row2.put("Age", "25");
            row2.put("Occupation", "Designer");
            data.add(row2);
            
            writeCsv("people.csv", data);
            System.out.println("CSV file created successfully");
            
            List<Map<String, String>> records = readCsv("people.csv");
            System.out.println("\nRecords read from CSV:");
            for(Map<String, String> record : records) {
                System.out.println(record);
            }
        } catch (IOException e) {
            System.err.println("Error processing CSV: " + e.getMessage());
        }
    }
} 
