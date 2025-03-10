<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Bean.CustomerBean" %> <!-- Update with your package name -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Signup Dashboard</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
    <h1>Signup Dashboard</h1>

    <!-- Success & Error Messages -->
    <c:if test="${not empty successMessage}">
        <p style="color:green;">${successMessage}</p>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <p style="color:red;">${errorMessage}</p>
    </c:if>

    <h3>Registered Customers</h3>
    <table border="1">
        <tr>
            <th>Customer ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>NIC</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.nic}</td>
                <td>${customer.address}</td>
                <td>
                    <form action="DeleteCustomer" method="post">
                        <input type="hidden" name="customerId" value="${customer.customerId}">
                        <button type="submit" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
