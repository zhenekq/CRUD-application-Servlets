<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19.05.2021
  Time: 0:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CRUD APPLICATION</h1>
<h2>Current users: </h2>
<c:forEach var="user" items="${requestScope.users}">
    <ul>
        <li>Name: <c:out value="${user.name}"/></li>

        <li>Age: <c:out value="${user.age}"/></li>
    </ul>
    <hr/>

</c:forEach>
<h2>Add new user</h2>
<form method="post">
    <input type="text" name="name" placeholder="Enter your username"><br><br>
    <input type="number" name="age" placeholder="Enter your age"><br><br>
    <input type="submit" value="Submit" name="submit"><br>
</form>
</body>
</html>
