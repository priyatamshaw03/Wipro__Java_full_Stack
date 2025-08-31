import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidationServlet extends HttpServlet {
    private final String[] existingUsernames = {"user1", "user2"};
    private final String[] existingEmails = {"user1@example.com", "user2@example.com"};

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        if (username != null) {
            boolean exists = false;
            for (String u : existingUsernames) {
                if (u.equals(username)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                out.println("Username already exists!");
            } else {
                out.println("Username is available.");
            }
        }

        if (email != null) {
            boolean exists = false;
            for (String e : existingEmails) {
                if (e.equals(email)) {
                    exists = true;
                    break;
                }
            }
            if (exists) {
                out.println("Email already exists!");
            } else {
                out.println("Email is available.");
            }
        }
    }
}