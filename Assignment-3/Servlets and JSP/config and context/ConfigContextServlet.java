import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigContextServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Print Servlet Config parameters
        out.println("<h2>Servlet Config Parameters:</h2>");
        Enumeration<String> configParams = config.getInitParameterNames();
        while (configParams.hasMoreElements()) {
            String name = configParams.nextElement();
            String value = config.getInitParameter(name);
            out.println(name + " : " + value + "<br>");
        }

        // Print Servlet Context parameters
        out.println("<h2>Servlet Context Parameters:</h2>");
        ServletContext context = config.getServletContext();
        Enumeration<String> contextParams = context.getInitParameterNames();
        while (contextParams.hasMoreElements()) {
            String name = contextParams.nextElement();
            String value = context.getInitParameter(name);
            out.println(name + " : " + value + "<br>");
        }
    }
}
