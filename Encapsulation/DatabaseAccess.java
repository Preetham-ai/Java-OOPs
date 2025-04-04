     import java.sql.*;

public class DatabaseAccess {
    public static void queryDatabase(String url, String user, String password) {
        String query = "SELECT * FROM products WHERE price > 100";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while(rs.next()) {
                System.out.printf("ID: %d, Name: %s, Price: %.2f%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getDouble("price"));
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "username";
        String password = "password";
        
        queryDatabase(url, user, password);
    }
}
