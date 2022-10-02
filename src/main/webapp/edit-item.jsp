<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit a book</title>
<link rel = "stylesheet" type = "text/css" href="stylesheet.css">
</head>
<body>
<h1>Edit a book</h1>
<table>
<tr>
	<th>Editing:</th>
	<th>by</th>
	<th> in category</th>
</tr>
<tr>
	<td>${itemToEdit.title}</td>
	<td>${itemToEdit.author}</td>
	<td>${itemToEdit.category}</td>
</tr>
</table>
<br/>
<form action = "editItemServlet" method="post">
Title: <input type = "text" name = "title">
Author: <input type = "text" name = "author">
Category: <input type = "text" name = "category">
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
<h4>Any field left blank will render no change in that field.</h4>
<a href="viewAllItemsServlet">Return to the list</a>
</body>
</html>