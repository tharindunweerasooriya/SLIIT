<%@page import="com.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
	<body> 
		<div class="container"><div class="row"><div class="col-6"> 
		<h1>Register</h1>
		<form id="formItem" name="formItem">
 		First Name :
 		<input id="first_name" name="first_name" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Last Name : 
 		<input id="last_name" name="last_name" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Email : 
 		<input id="em" name="em" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>User Name : 
 		<input id="usern" name="usern" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Password : 
 		<input id="pass" name="pass" type="text" 
 		class="form-control form-control-sm">
 		<br>
 		
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave" 
 name="hidItemIDSave" value="">
</form>
<br>
<p class="text"><a href="Log.jsp">Sing in</a></p>
<br>

<br>
<div id="divItemsGrid">
 
</div>
</div> </div> </div> 
</body>
</html>