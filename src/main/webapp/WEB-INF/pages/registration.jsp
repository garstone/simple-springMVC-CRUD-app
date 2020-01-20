<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Sign up</title>
</head>

<body>
<c:if test="${!empty error}">
    <h4>User with this login exists. Please choose another one</h4>
</c:if>
<form:form method="post" modelAttribute="user">
    <h4>Sign up</h4>
    <form:input type="text" path="login" placeholder="Your login"
                autofocus="true"></form:input>
    <form:input type="text" path="name" placeholder="Your name"
                autofocus="true"></form:input>
    <form:input type="text" path="password" placeholder="Your password"
                autofocus="true"></form:input>
    <button type="submit">Sign up</button>
</form:form>
<p>
    <a href="/">Return to main page</a>
</p>
</body>
</html>
