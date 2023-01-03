<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/26/2022
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Deleting account</title>
</head>
<body>
<h1>Delete account</h1>
<p>
  <a href="/accounts?action=create">Back to account list</a>
</p>
<form method="post">
  <h3>Are you sure?</h3>
  <fieldset>
    <legend>Account information</legend>
    <table>
      <tr>
        <td>Username: </td>
        <td>${requestScope["account"].getUsername()}</td>
      </tr>
      <tr>
        <td>Password: </td>
        <td>${requestScope["account"].getPassword()}</td>
      </tr>
      <tr>
        <td>Role: </td>
        <td>${requestScope["account"].getRole()}</td>
      </tr>
      <tr>
        <td>FullName: </td>
        <td>${requestScope["account"].getFullName()}</td>
      </tr>
      <tr>
        <td>Age: </td>
        <td>${requestScope["account"].getAge()}</td>
      </tr>
      <tr>
        <td>Phone: </td>
        <td>${requestScope["account"].getPhone()}</td>
      </tr>
      <tr>
        <td>Email: </td>
        <td>${requestScope["account"].getEmail()}</td>
      </tr>
      <tr>
        <td><input type="submit" value="Delete account"></td>
        <td><a href="/accounts">Back to account list</a></td>
      </tr>
    </table>
  </fieldset>
  </form>
</body>
</html>