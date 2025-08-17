import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program1 {

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // 1. Load the JDBC Driver
            // You may not need this line in modern JDBC, but it's good practice
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Establish the Connection
            // Replace with your actual database details
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "your_username";
            String password = "your_password";

            connection = DriverManager.getConnection(url, user, password);

            // If the connection is successful
            System.out.println("Connection Established Successfully.");

        } catch (ClassNotFoundException e) {
            // Handle if the driver is not found
            System.out.println("JDBC Driver not found.");
            System.out.println("Description of the exception: " + e.getMessage());

        } catch (SQLException e) {
            // Handle database connection errors
            System.out.println("Connection could not be established.");
            System.out.println("Description of the exception: " + e.getMessage());

        } finally {
            // Close the connection in a finally block to ensure it's always closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing the connection: " + e.getMessage());
            }
        }
    }
}