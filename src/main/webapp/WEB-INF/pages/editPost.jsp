<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty post.text}">
        <h2>Add new post</h2>
        <title>Add</title>
    </c:if>
    <c:if test="${!empty post.text}">
        <h2>Edit the post</h2>
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty post.text}">
    <c:url value="/posts/add" var="var"/>
</c:if>
<c:if test="${!empty post.text}">
    <c:url value="/posts/edit" var="var"/>
</c:if>
<form action="${var}" method="post">
    <c:if test="${!empty post.text}">
        <input type="hidden" name="id" value="${post.id}">
    </c:if>
    <label for="author">${post.author}</label>
    <input type="text" name="author" id="author">
    <label for="text">${post.text}</label>
    <input type="text" name="text" id="text">
    <c:if test="${empty post.text}">
        <input type="submit" value="Add new post">
    </c:if>
    <c:if test="${!empty post.text}">
        <input type="submit" value="Edit the post">
    </c:if>
</form>
</body>
</html>