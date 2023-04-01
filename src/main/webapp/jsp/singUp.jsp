<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Bazis
  Date: 13.03.2023
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1 style="color: ${color}">Registration Page</h1>
<h2>Enter your data</h2>
<form action="/signUp" method="post">
    <label for="firstName">Enter your first name</label>
    <input id="firstName" name="firstName" placeholder="Your first name">
    <br>
    <label for="lastName">Enter your first name</label>
    <input id="lastName" name="lastName" placeholder="Your last name">
    <br>
    <label for="email">Enter your email</label>
    <input type="email" id="email" name="email" placeholder="Your email">
    <br>
    <label for="password">Enter your password</label>
    <input id="password" name="password" placeholder="Your password">
    <br>
    <input type="submit" value="Register">
</form>
</body>
</html>
