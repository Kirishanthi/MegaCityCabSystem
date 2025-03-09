<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Signup</title>
</head>
<body>
    <h1>Signup</h1>
    <form action="Signup" method="post">
        Name: <input type="text" name="name" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        Address: <input type="text" name="address" required><br><br>
        NIC: <input type="text" name="nic" required><br><br>
        Phone Number: <input type="text" name="phoneNumber" required><br><br>
        <input type="submit" value="Sign Up">
    </form>
    <p>Already have an account? <a href="login.jsp">Login</a></p>
</body>
</html>
