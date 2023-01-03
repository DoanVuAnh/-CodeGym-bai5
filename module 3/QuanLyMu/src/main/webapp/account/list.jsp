<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/26/2022
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account List</title>
</head>
<body>
<h1>Accounts</h1>
<p>
    <a href="/accounts?action=create">Create new account</a>
</p>
<table border="1">
    <tr>
        <td>Username</td>
        <td>Password</td>
        <td>Rode</td>
        <td>FullName</td>
        <td>Age</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["accounts"]}' var="account">
        <tr>
            <td><a href="/accounts?action=view&id=${account.getId()}">${account.getUsername()}</a></td>
            <td>${account.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/accounts?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/accounts?action=delete&id=${customer.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>