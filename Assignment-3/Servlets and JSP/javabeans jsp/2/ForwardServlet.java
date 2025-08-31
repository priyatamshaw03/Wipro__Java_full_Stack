package com.example;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String op = request.getParameter("operation");
        int value = Integer.parseInt(op);

        RequestDispatcher rd;
        if (value < 10) {
            rd = request.getRequestDispatcher("page1.jsp");
        } else if (value > 10 && value < 99) {
            rd = request.getRequestDispatcher("page2.jsp");
        } else {
            rd = request.getRequestDispatcher("error.jsp");
        }
        rd.forward(request, response);
    }
}
