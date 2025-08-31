import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionTrackingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        Integer visitCount = (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);

        out.println("<h2>You have visited this page " + visitCount + " times.</h2>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>Is New Session: " + session.isNew() + "</p>");
        out.println("<p>Creation Time: " + session.getCreationTime() + "</p>");
        out.println("<p>Last Accessed Time: " + session.getLastAccessedTime() + "</p>");
    }
}
