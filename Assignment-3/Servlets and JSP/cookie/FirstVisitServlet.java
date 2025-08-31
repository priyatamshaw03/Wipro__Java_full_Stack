import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstVisitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        boolean isNewVisitor = true;

        // Check if cookie exists
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visited")) {
                    isNewVisitor = false;
                }
            }
        }

        if (isNewVisitor) {
            out.println("<h2>Welcome, you are visiting for the first time!</h2>");
            Cookie visitCookie = new Cookie("visited", "yes");
            visitCookie.setMaxAge(60 * 60 * 24); // valid for 1 day
            response.addCookie(visitCookie);
        } else {
            out.println("<h2>Welcome Back!</h2>");
        }
    }
}
