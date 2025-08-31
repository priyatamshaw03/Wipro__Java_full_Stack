<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%
    HttpSession session = request.getSession(false);
    String userid = (String) session.getAttribute("userid");
    if(userid == null){
        response.sendRedirect("login.html");
    }
%>
<html>
<body>
    <h2>Home Page</h2>
    <h3>Welcome to <%=userid%> <a href="changepassword.jsp">Change Password</a></h3>
</body>
</html>
