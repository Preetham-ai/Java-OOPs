import java.io.*;
import java.util.Properties;
	
public class ConfigManager {
    private Properties properties;
    private String configFile;
    
    public ConfigManager(String filename) {
        this.configFile = filename;
        this.properties = new Properties();
        loadConfig();
    }
    
    private void loadConfig() {
        try (InputStream input = new FileInputStream(configFile)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error loading config: " + e.getMessage());
        }
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        saveConfig();
    }
    
    private void saveConfig() {
        try (OutputStream output = new FileOutputStream(configFile)) {
            properties.store(output, "Updated configuration");
        } catch (IOException e) {
            System.err.println("Error saving config: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ConfigManager config = new ConfigManager("config.properties");
        
        
        config.setProperty("database.url", "jdbc:mysql://localhost:3306/mydb");
        config.setProperty("database.user", "admin");
        
               System.out.println("Database URL: " + config.getProperty("database.url"));
        System.out.println("Database User: " + config.getProperty("database.user"));
    }
}
