package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Connection to DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/yourDB", "root", "password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO emp(id, name, designation) VALUES(?,?,?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, designation);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h2>Employee record inserted successfully!</h2>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
