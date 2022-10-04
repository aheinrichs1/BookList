<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reader List</title>
<link rel = "stylesheet" type = "text/css" href="stylesheet.css">
</head>
<body>
<form method="post" action="listnavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
	<td><input type="radio" name="id" value="${currentlist.id}"></td>
	<td><h2>${currentlist.listName}</h2></td>
</tr>
	
<tr>
	<td colspan="3">Date Modified: ${currentlist.dateModified}</td>
</tr>

<tr>
	<td colspan="3">Reader: ${currentlist.reader.readerName}</td>
</tr>
<c:forEach var="listVal" items="${currentlist.listOfItems}">
<tr><td></td>
<td colspan="3">
${listVal.title}, ${listVal.author}, ${listVal.category}
</td>
</tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToList">
<input type="submit" value="delete" name="doThisToList">
<input type="submit" value="add" name="doThisToList">

</form>
<a href="addItemsForListServlet">Create a new list</a><br />
<a href="index.html">Insert a new item</a>
</body>
</html>