import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/talentnext","root","password");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE userid=? AND password=?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("userid", uname);
                response.sendRedirect("home.jsp");
            } else {
                out.println("<h3>Invalid Credentials. Please try again.</h3>");
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
        } catch(Exception e) {
            e.printStackTrace(out);
        }
    }
}
