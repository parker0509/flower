package board.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = "root1234";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Database connection successful!");
        } catch (SQLException e) {
            System.out.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}
