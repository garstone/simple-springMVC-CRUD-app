<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<c:if test="${!empty error}">
    <h4>User with the login exists. Please choose another login</h4>
</c:if>
<c:if test="${empty error}">
    <h4>Please edit your name and password</h4>
</c:if>
<c:if test="${!empty signup}">
    <form action="/users/add" method="post">
        <input type="text" name = "login" value="${user.login}">
        <input type="text" name="name" value="${user.name}" placeholder=${user.name}>
        <input type="text" name="password" value="${user.password}" placeholder=${user.password}>
        <input type="submit" value="Edit profile">
    </form>
</c:if>
<c:if test="${empty signup}">
    <form action="/users/edit" method="post">
        <input type="hidden" name = "id" value="${user.id}">
        <input type="hidden" name = "login" value="${user.login}">
        <input type="hidden" name = "roles" value="${user.roles}">
        <input type="text" name="name" value="${user.name}" placeholder=${user.name}>
        <input type="text" name="password" value="${user.password}" placeholder=${user.password}>
        <input type="submit" value="Edit profile">
    </form>
</c:if>
</body>
</html>
