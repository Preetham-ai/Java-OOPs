import java.io.*;

public class FileProcessor {
    public static void processFile(String filename) {
        try {
            String content = readFileContents(filename);
            System.out.println("File content:\n" + content);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Security restriction: " + e.getMessage());
        }
    }
    
    private static String readFileContents(String filename) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename)));
    }

    public static void main(String[] args) {
        processFile("test.txt");
        
        processFile("nonexistent.txt");
    }
}

