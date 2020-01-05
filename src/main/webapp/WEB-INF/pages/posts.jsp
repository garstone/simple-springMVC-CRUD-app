<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Watch posts</title>
</head>
<body>
<h2> WATCH POSTS </h2>
<table>
    <tr>
        <th>id</th>
        <th>author</th>
        <th>date</th>
        <th>edit</th>
    </tr>
</table>
<c:forEach var="post" items="${postList}">
    <table>
    <tr>
        <td>${post.id}</td>
        <td>${post.author}</td>
        <td>${post.date}</td>
        <td>
            <a href="/edit/${post.id}">Edit</a>
            <a href="/delete/${post.id}">Delete</a>
        </td>
    </tr>
    <tr>${post.text}</tr>
    </table>
</c:forEach>

<h2>Add</h2>
<c:url value="/add" var="add" />
<a href="${add}">Add new post</a>
</body>
</html>