<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/26/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit account</title>
</head>
<body>
<h1>Edit account</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/accounts">Back to customer list</a>
</p>
<form method="post">
  <fieldset>
    <legend>Account information</legend>
    <table>
      <tr>
        <td>Username: </td>
        <td><input type="text" name="username" id="username" value="${requestScope["account"].getUsername()}"></td>
      </tr>
      <tr>
        <td>Password: </td>
        <td><input type="text" name="password" id="password" value="${requestScope["account"].getPassword()}"></td>
      </tr>
      <tr>
        <td>Role: </td>
        <td><input type="text" name="role" id="role" value="${requestScope["account"].getRole()}"></td>
      </tr>
      <tr>
        <td>FullName: </td>
        <td><input type="text" name="fullName" id="fullName" value="${requestScope["account"].getFullName()}"></td>
      </tr>
      <tr>
        <td>Age: </td>
        <td><input type="text" name="age" id="age" value="${requestScope["account"].getAge()}"></td>
      </tr>
      <tr>
        <td>Phone: </td>
        <td><input type="text" name="phone" id="phone" value="${requestScope["account"].getPhone()}"></td>
      </tr>
      <tr>
        <td>Email: </td>
        <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Update Account"></td>
      </tr>
    </table>

  </fieldset>
</form>
</body>
</html>