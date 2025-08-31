import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uid = request.getParameter("uid");
        String pass = request.getParameter("pass");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String state = request.getParameter("state");
        String contact = request.getParameter("contact");
        String address = request.getParameter("address");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/talentnext","root","password");

            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, uid);
            ps.setString(2, pass);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, state);
            ps.setString(6, contact);
            ps.setString(7, address);

            int i = ps.executeUpdate();
            if(i > 0) {
                out.println("<h3>Registration Successful. Please <a href='login.html'>Login</a></h3>");
            }
        } catch(Exception e) {
            e.printStackTrace(out);
        }
    }
}
