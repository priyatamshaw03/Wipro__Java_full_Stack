import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the response type
        response.setContentType("text/html");

        // Get the writer
        PrintWriter out = response.getWriter();

        // Output to browser
        out.println("<html><body>");
        out.println("<h1>My First Servlet program</h1>");
        out.println("</body></html>");
    }
}
