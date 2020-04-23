<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MailBox</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
<div class="header1">
<h1> AdminLogin</h1>
</div>
<!-- Form  -->
<div align="center">
<div class="forms-data">
<form:form action="/admin/adminlogin" method="post" modelAttribute="admin" style="margin-top:50px;">

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


</div>

<a href="/">Home</a>
</div>
</body>
</html>