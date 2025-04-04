class DatabaseConnection {
 void connect() {
 System.out.println("Connected to database");
 }
}
class MySQLConnection extends DatabaseConnection {
 void queryMySQL() {
 System.out.println("Executing MySQL query");
 }
}
class PostgreSQLConnection extends DatabaseConnection {
 void queryPostgreSQL() {
 System.out.println("Executing PostgreSQL query");
 }
}
class TestHier2 {
 public static void main(String[] args) {
 MySQLConnection mysql = new MySQLConnection();
 PostgreSQLConnection psql = new PostgreSQLConnection();
 mysql.connect();
 mysql.queryMySQL();
 psql.connect();
 psql.queryPostgreSQL();
 }
}