import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            out.println("<h3>No Cookies</h3>");
        } else {
            out.println("<table border='1'><tr><th>Cookie Name</th><th>Cookie Value</th></tr>");
            for (Cookie c : cookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }
            out.println("</table>");
        }
    }
}
