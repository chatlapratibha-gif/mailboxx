<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user login</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1">
<h1>User Login</h1>
${message}
</div>
<!-- Form  -->
<div align="center">
<div class="forms-data">
<form:form action="/user/userlogin" method="post" modelAttribute="user" style="margin-top:50px;">

<table>
<tr>
<td>User Name :</td>
<td>

<form:input path="username" class="form-control"/>
<br>
 <form:errors path="username" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>Password :</td>
<td><form:password path="password" class="form-control"/>
<br>
<form:errors path="password" cssClass="errors"></form:errors>
</td>
</tr>

<tr>

<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />

</tr>
</table>



</form:form>


New Student<a href="/user/register" style="color:yellow;"> SignUp</a>
</div>

<a href="/">Home</a>
</div>
</body>
</html>