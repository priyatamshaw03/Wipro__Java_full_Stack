import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/params")
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Request Parameters:</h2>");
        out.println("<table border='1'><tr><th>Parameter Name</th><th>Value(s)</th></tr>");

        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement();
            String[] values = request.getParameterValues(param);

            out.print("<tr><td>" + param + "</td><td>");
            for (int i = 0; i < values.length; i++) {
                out.print(values[i]);
                if (i < values.length - 1) out.print(", ");
            }
            out.println("</td></tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}
