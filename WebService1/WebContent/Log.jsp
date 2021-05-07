<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/user.js"></script>
</head>
<body> 
		<div class="container"><div class="row"><div class="col-2"> 
		<h1>User Login</h1>
		<form id="formItem" name="formItem">
 		
 		
 		<br>User Name : 
 		<input id="usern" name="usern" type="text" 
 		class="form-control form-control-sm">
 		
 		<br>Password : 
 		<input id="pass" name="pass" type="text" 
 		class="form-control form-control-sm"><br>
 		
 <input id="btnLog" name="btnLog" type="button" value="Login" 
 class="btn btn-primary">
 <input type="hidden" id="userLog" 
 name="userLog" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">


<br>
</div>
</div> </div> </div> 
</body>
</html>