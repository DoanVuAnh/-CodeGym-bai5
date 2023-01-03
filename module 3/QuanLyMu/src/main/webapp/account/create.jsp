<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/26/2022
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create new account</title>
  <style>
    .message{
      color:green;
    }
  </style>
</head>
<body>
<h1>Create new Account</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/accounts?action=create" >Back to account list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Account information</legend>
    <table>
      <tr>
        <td>Username: </td>
        <td><input type="text" name="username" id="username"></td>
      </tr>
      <tr>
        <td>Password: </td>
        <td><input type="text" name="password" id="password"></td>
      </tr>
      <tr>
        <td>Role: </td>
        <td><input type="text" name="role" id="role"></td>
      </tr>
      <tr>
        <td>FullName: </td>
        <td><input type="text" name="fullName" id="fullName"></td>
      </tr>
      <tr>
        <td>Age: </td>
        <td><input type="number" name="age" id="age"></td>
      </tr>
      <tr>
        <td>Phone: </td>
        <td><input type="text" name="phone" id="phone"></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create Account"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>