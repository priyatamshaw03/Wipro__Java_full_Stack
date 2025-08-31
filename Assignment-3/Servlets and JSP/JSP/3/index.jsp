<%@ page import="java.math.BigInteger" %>
<html>
<head>
    <title>Factorial Table</title>
</head>
<body>
    <h2>Numbers and their Factorials</h2>
    <table border="1">
        <tr>
            <th>Number</th>
            <th>Factorial</th>
        </tr>
        <%
            for(int i=1; i<=10; i++) {
                BigInteger fact = BigInteger.ONE;
                for(int j=1; j<=i; j++) {
                    fact = fact.multiply(BigInteger.valueOf(j));
                }
        %>
        <tr>
            <td><%= i %></td>
            <td><%= fact %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
