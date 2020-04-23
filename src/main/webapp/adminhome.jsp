<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ELearning - Admin Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<%
String username =(String) session.getAttribute("adminusername");
if(username==null)
{
	response.sendRedirect("/admin/");
}
%>
<div class="header1">
<h1 style="text-align: center"> Welcome<span style="color: yellow;"> <%=username.toUpperCase() %></span></h1> 

<ul>

<li ><a href="/admin/viewusers">view users</a></li>
<li ><a href="/admin/acceptuserregisteration">accept user registeration</a></li>
<li ><a href="/admin/deleteusers">delete user account</a></li>
<li ><a href="/admin/searchbyusername">search by username</a></li>
<li><a href="/admin/adminLogout">logout</a></li>
</ul>

</div>
<div align="center">
<table border="2">
<!-- <tr>
<th>Username</th>
<th>First name</th>
<th>Last name</th>
<th> Mobile</th>
<th> email</th></tr> -->
<c:forEach items="${usersList}" var="userr">
<tr>
<td>${userr.username}</td>
<td>${userr.firstname}</td>
<td>${userr.lastname}</td>
<td>${userr.email}</td>
<td>${userr.mobile}</td>
</tr>
</c:forEach>
</table>
<div align="center">

<table border="1">
<tr>
<th>Username</th>
<th>First name</th>
<th>Last name</th>
<th> Mobile</th>
<th> email</th>
<th> status</th>
<th>Delete</th>

</tr>
<c:forEach items="${userList}" var="user">

   <tr>
   <td>${user.username}</td>
   <td>${user.firstname}</td>
   <td>${user.lastname}</td>
   <td>${user.mobile}</td>
   <td>${user.email}</td>
   </td>
   <td>${user.status}</td>
   <td><a href="activate?id=${user.username}"><button>Activate</button></a></td>
   <td><a href="deactivate?id=${user.username}"><button>Deactivate</button></a></td>
  <%--  <td><a href="delete?id=${user.username}"><button>Delete</button></a></td> --%>
   
   
   </tr>
</c:forEach>
<c:forEach items="${userdelList}" var="user">
   <tr>
   <td>${user.username}</td>
   <td>${user.firstname}</td>
   <td>${user.lastname}</td>
   <td>${user.mobile}</td>
   <td>${user.email}</td>
   </td>
   <td>${user.status}</td>
   
   <td><a href="delete?id=${user.username}"><button>Delete</button></a></td>
   
   
   </tr>
</c:forEach>

</table>

</div>
</body>
</html>