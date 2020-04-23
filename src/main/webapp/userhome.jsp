<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning Student Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("username");
if(username==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>

<li ><a href="#">View Profile</a></li>

<li ><a href="/user/searchusers">search users</a></li>
<li ><a href="/user/addusersaddress">add users to addressbook</a></li>
<li><a href="/user/accessuser">access user</a>
<li><a href="/user/addrequest">add request</a>
<li><a href="/user/sendmsg">send msgs to user</a>
<li ><a href="/user/userLogout">LogOut</a></li>
</ul>

</div>
<div align="center">
<table border="2">
<c:forEach items="${usersList}" var="user">
<tr>
<td>${user.username}</td>
<td>${user.firstname}</td>
<td>${user.lastname}</td>
<td>${user.email}</td>
<td>${user.mobile}</td>
<td>

</td></tr>
</c:forEach>



</body>
</html>