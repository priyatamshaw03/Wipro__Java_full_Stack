import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String state = request.getParameter("state");

        out.println("<h3>Last 10 Movie Titles for " + state + "</h3>");
        out.println("<ul>");
        
        // This is a placeholder. In a real application, you would fetch from a database.
        if ("AP".equals(state)) {
            out.println("<li>Movie A (AP)</li>");
            out.println("<li>Movie B (AP)</li>");
            out.println("<li>Movie C (AP)</li>");
        } else if ("TS".equals(state)) {
            out.println("<li>Movie X (TS)</li>");
            out.println("<li>Movie Y (TS)</li>");
            out.println("<li>Movie Z (TS)</li>");
        }

        out.println("</ul>");
    }
}