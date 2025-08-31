import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        String userid = (String) session.getAttribute("userid");

        String oldPass = request.getParameter("oldPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");

        if(!newPass.equals(confirmPass)) {
            out.println("<h3>New password and Confirm password do not match.</h3>");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/talentnext","root","password");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
            ps.setString(1, userid);
            ps.setString(2, oldPass);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                PreparedStatement ps2 = con.prepareStatement("UPDATE users SET password=? WHERE userid=?");
                ps2.setString(1, newPass);
                ps2.setString(2, userid);
                ps2.executeUpdate();
                out.println("<h3>Password Changed Successfully!</h3>");
            } else {
                out.println("<h3>Old password is incorrect.</h3>");
            }
        } catch(Exception e) {
            e.printStackTrace(out);
        }
    }
}
