<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.cculp2.tomcattodo.Todo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container text-center">
    <h1>Todo List</h1>
    <form action="/DeleteTodoServlet" method="post">
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Details</th>
        <th scope="col">Finished</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="todo" items="${todoList}">
<tr>
    <th scope="row">${todo.title}</th>
    <td>${todo.details}</td>
    <td><button type="submit" name="delete" value="${todo.id}" class="btn btn-primary">Finished!</button></td>
</tr>
</c:forEach>
    </tbody>
</table>
    </form>
    <a href="/AddTodo" class="btn btn-info" role="button">Add Todo</a>
</div>
</body>
</html>
