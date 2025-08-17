import java.sql.*;
import java.util.ArrayList;

// UserBean.java
class UserBean {
    private String userID;
    private String password;
    private String name;
    private int incorrectAttempts;
    private int lockStatus;
    private String userType;

    // Getters and Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getIncorrectAttempts() { return incorrectAttempts; }
    public void setIncorrectAttempts(int incorrectAttempts) { this.incorrectAttempts = incorrectAttempts; }

    public int getLockStatus() { return lockStatus; }
    public void setLockStatus(int lockStatus) { this.lockStatus = lockStatus; }

    public String getUserType() { return userType; }
    public void setUserType(String userType) { this.userType = userType; }

    @Override
    public String toString() {
        return "UserBean{" +
                "userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", incorrectAttempts=" + incorrectAttempts +
                ", lockStatus=" + lockStatus +
                ", userType='" + userType + '\'' +
                '}';
    }
}

// DBUtil.java
class DBUtil {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "system";  // your MySQL username
        String pass = "kaust1825"; // your MySQL password

        return DriverManager.getConnection(url, user, pass);
    }
}

// UserDAO.java
class UserDAO {

    // Scenario 1
    public String getUserType(String userID) {
        String query = "SELECT UserType FROM Users WHERE UserID=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getString("UserType");
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // Scenario 2
    public String getIncorrectAttempts(String userID) {
        String query = "SELECT IncorrectAttempts FROM Users WHERE UserID=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int attempts = rs.getInt("IncorrectAttempts");
                if (attempts == 0) return "No Incorrect Attempt";
                else if (attempts == 1) return "One Time";
                else return "Incorrect Attempt Exceeded";
            }
        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }

    // Scenario 3
    public String changeUserType(String userID) {
        String query = "UPDATE Users SET UserType='Admin' WHERE UserID=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userID);
            int rows = ps.executeUpdate();
            return (rows == 1) ? "Update Success" : "Update Failed";
        } catch (Exception e) { e.printStackTrace(); }
        return "Update Failed";
    }

    // Scenario 4
    public int getLockStatus() {
        String query = "SELECT COUNT(*) AS cnt FROM Users WHERE LockStatus=0";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) return rs.getInt("cnt");
        } catch (Exception e) { e.printStackTrace(); }
        return 0;
    }

    // Scenario 5
    public String changeName(String id, String name) {
        String query = "UPDATE Users SET Name=? WHERE UserID=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, id);
            return (ps.executeUpdate() > 0) ? "Success" : "Failed";
        } catch (Exception e) { e.printStackTrace(); }
        return "Failed";
    }

    // Scenario 6
    public String changePassword(String password) {
        String query = "UPDATE Users SET Password=? WHERE UserType='Admin'";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, password);
            return (ps.executeUpdate() > 0) ? "Changed" : "0";
        } catch (Exception e) { e.printStackTrace(); }
        return "0";
    }

    // Scenario 7
    public String addUser_1(UserBean bean) {
        String query = "INSERT INTO Users VALUES (?,?,?,?,?,?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, bean.getUserID());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getIncorrectAttempts());
            ps.setInt(5, bean.getLockStatus());
            ps.setString(6, bean.getUserType());
            return (ps.executeUpdate() > 0) ? "Success" : "Fail";
        } catch (Exception e) { e.printStackTrace(); }
        return "Fail";
    }

    // Scenario 8
    public String addUser_2(UserBean bean) {
        if (bean.getLockStatus() != 0) return "Fail";
        return addUser_1(bean);
    }

    // Scenario 9
    public ArrayList<UserBean> getUsers(String userType) {
        ArrayList<UserBean> list = new ArrayList<>();
        String query = "SELECT * FROM Users WHERE UserType=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, userType);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean bean = new UserBean();
                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));
                list.add(bean);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // Scenario 10
    public ArrayList<UserBean> storeAllRecords() {
        ArrayList<UserBean> list = new ArrayList<>();
        String query = "SELECT * FROM Users";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                UserBean bean = new UserBean();
                bean.setUserID(rs.getString("UserID"));
                bean.setPassword(rs.getString("Password"));
                bean.setName(rs.getString("Name"));
                bean.setIncorrectAttempts(rs.getInt("IncorrectAttempts"));
                bean.setLockStatus(rs.getInt("LockStatus"));
                bean.setUserType(rs.getString("UserType"));
                list.add(bean);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    // Scenario 11
    public String[] getNames() {
        ArrayList<String> names = new ArrayList<>();
        String query = "SELECT Name FROM Users";
        try (Connection con = DBUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) names.add(rs.getString("Name"));
        } catch (Exception e) { e.printStackTrace(); }
        return names.toArray(new String[0]);
    }
}

// MainApp.java
public class MainApp {
    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        // Example: Testing Scenario 1
        System.out.println("UserType: " + dao.getUserType("AB1001"));

        // Scenario 2
        System.out.println(dao.getIncorrectAttempts("AB1001"));

        // Scenario 3
        System.out.println(dao.changeUserType("RS1003"));

        // Scenario 4
        System.out.println("LockStatus count: " + dao.getLockStatus());

        // Scenario 5
        System.out.println(dao.changeName("TA1002", "Prasath Kumar"));

        // Scenario 6
        System.out.println(dao.changePassword("newPass123"));

        // Scenario 7
        UserBean bean = new UserBean();
        bean.setUserID("NEW001");
        bean.setPassword("pass123");
        bean.setName("New User");
        bean.setIncorrectAttempts(0);
        bean.setLockStatus(0);
        bean.setUserType("Employee");
        System.out.println(dao.addUser_1(bean));

        // Scenario 8
        System.out.println(dao.addUser_2(bean));

        // Scenario 9
        dao.getUsers("Employee").forEach(System.out::println);

        // Scenario 10
        dao.storeAllRecords().forEach(System.out::println);

        // Scenario 11
        for (String name : dao.getNames()) System.out.println(name);
    }
}
