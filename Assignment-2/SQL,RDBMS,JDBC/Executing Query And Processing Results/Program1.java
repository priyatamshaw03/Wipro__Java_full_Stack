import java.sql.*;

public class Program1 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Register the JDBC driver (optional for modern Java versions)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Open a connection
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Replace with your URL
            String user = "your_username";                     // Replace with your username
            String password = "your_password";                 // Replace with your password

            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful!");

            // 3. Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT empno, ename FROM emp"; // Correct SQL statement
            rs = stmt.executeQuery(sql);

            // 4. Process the result set
            while (rs.next()) {
                // Retrieve by column index (1-based for JDBC)
                int empNo = rs.getInt(1);
                // Retrieve by column name
                String eName = rs.getString("ename");

                // Display the results
                System.out.println("Empno: " + empNo + ", Ename: " + eName);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // 5. Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}