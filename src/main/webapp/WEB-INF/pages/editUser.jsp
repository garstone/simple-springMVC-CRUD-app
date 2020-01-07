<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<h3>Please edit your name and password</h3>
<form action="/users/edit" method="post">
    <input type="hidden" name = "id" value="${user.id}">
    <input type="hidden" name = "login" value="${user.login}">
    <input type="text" name="name" value="${user.name}" placeholder=${user.name}>
    <input type="text" name="password" value="${user.password}" placeholder=${user.password}>
    <input type="submit" value="Edit profile">
</form>
</body>
</html>
