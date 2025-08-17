import java.sql.*;

public class Program2 {
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

            // 3. Execute the modified query
            stmt = conn.createStatement();
            // The modified SQL statement as per the problem description
            String sql = "SELECT ename, job, sal, comm FROM emp WHERE sal > 1000 AND sal < 2000";
            rs = stmt.executeQuery(sql);

            // 4. Process the result set
            while (rs.next()) {
                // Retrieve and display the specified columns by name
                String eName = rs.getString("ename");
                String job = rs.getString("job");
                double sal = rs.getDouble("sal");
                // comm might be a nullable column, so getDouble is a safe choice
                Object comm = rs.getObject("comm");

                System.out.println("Ename: " + eName + ", Job: " + job + ", Sal: " + sal + ", Comm: " + comm);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle other errors
            e.printStackTrace();
        } finally {
            // 5. Close resources in a finally block to ensure cleanup
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