import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class PrimeServlet extends HttpServlet {

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int num = Integer.parseInt(request.getParameter("number"));
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                primes
