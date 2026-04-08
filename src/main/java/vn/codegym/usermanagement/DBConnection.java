package vn.codegym.usermanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String jdbcURL = "jdbc:mysql://localhost:3306/user_management";
    public static final String jdbcUsername = "root";
    public static final String jdbcPassword = "123456";
    private static Connection conn;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(conn == null || conn.isClosed()){
                conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                if (conn != null) {
                    System.out.println("Connected to database");
                }
            }
            return conn;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

