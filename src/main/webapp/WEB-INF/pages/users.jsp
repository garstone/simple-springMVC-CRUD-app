<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users</title>
</head>
<body>
<table border="2">
    <tr>
        <td>ID</td>
        <td>Login</td>
        <td>Name</td>
        <td>Password</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${userList}" var = "user">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>
                <form action="/users/edit/${user.id}" method="get">
                    <input type="submit" value="Edit" style="float:left">
                </form>
                <form action="/users/delete/${user.id}" method="get">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
</body>
</html>


