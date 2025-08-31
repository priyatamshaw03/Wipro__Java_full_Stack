<%@ page import="com.example.EmployeeBean" %>
<jsp:useBean id="emp" class="com.example.EmployeeBean" scope="request"/>
<jsp:setProperty name="emp" property="*"/>

<html>
<body>
<h2>Employee Information</h2>
Employee Name: <jsp:getProperty name="emp" property="employeeName"/><br/>
Employee ID: <jsp:getProperty name="emp" property="employeeId"/><br/>
</body>
</html>
