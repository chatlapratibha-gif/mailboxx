<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>





<div class="header1">
<h1>User Login</h1>

</div>
<!-- Form  -->
<div align="center">
<div class="forms-data">
<form:form action="/user/userregistration" method="post" modelAttribute="userreg" style="margin-top:50px;margin-left:30px;">

<table>
<tr>
<td>User Name :</td>
<td>

<form:input path="username"  class="form-control"/>
<br>
 <form:errors path="username" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>First Name :</td>
<td>

<form:input path="firstname" class="form-control"/>
<br>
 <form:errors path="firstname" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>Last Name :</td>
<td>

<form:input path="lastname" class="form-control"/>
<br>
 <form:errors path="lastname" cssClass="errors"></form:errors> 
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
<td>Email :</td>
<td>

<form:input path="email" class="form-control"/>
<br>
 <form:errors path="email" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>Mobile :</td>
<td>

<form:input path="mobile" class="form-control"/>
<br>
 <form:errors path="mobile" cssClass="errors"></form:errors> 
</td>
</tr>




<tr>

<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton" />

</tr>
</table>



</form:form>


Existing Student<a href="/user/" style="color:yellow;"> SignIn</a>
</div>

<a href="/">Home</a>
</div>
</body>
</html>