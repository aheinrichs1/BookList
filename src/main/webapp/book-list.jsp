<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
<link rel = "stylesheet" type = "text/css" href="stylesheet.css">
</head>
<body>
<h1>Welcome to my book list!</h1>
<form method = "post" action = "navigationServlet">
<table>
<tr>
	<th></th>
	<th>Title</th>
	<th>Author</th>
	<th>Category</th>
</tr>
<c:forEach items="${requestScope.allItems}" var="currentitem">
<tr>
   <td><input type="radio" name="id" value="${currentitem.id}" ></td>
   <td>${currentitem.title}</td>
   <td>${currentitem.author}</td>
   <td>${currentitem.category}</td>
   </tr>
</c:forEach>
</table>
<br/>
<input type = "submit" value = "Edit Book" name="doThisToItem">
<input type = "submit" value = "Delete Book" name="doThisToItem">
<br/>
<h4>Add a book:</h4>
Title: <input type = "text" name = "title">
Author: <input type = "text" name = "author">
Category: <input type = "text" name = "category">
<input type = "submit" value = "Add Book" name="doThisToItem">
<h5>All 3 fields must have values in them to add a new book.</h5>
</form>
<br />
<a href = "viewAllListsServlet">View all book lists</a><br />
<a href = "addItemsForListServlet">Create a new list</a>
</body>
</html>