<%@ page import="java.util.*" %>
<html>
<head>
    <title>Prime Numbers</title>
</head>
<body>
    <h2>Prime Numbers</h2>
    <table border="1">
        <tr><th>Prime Numbers</th></tr>
        <%
            ArrayList<Integer> primes = (ArrayList<Integer>) request.getAttribute("primes");
            for(Integer p : primes) {
        %>
            <tr><td><%= p %></td></tr>
        <%
            }
        %>
    </table>
</body>
</html>
