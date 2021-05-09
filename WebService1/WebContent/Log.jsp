<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/log.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<h1>Login</h1>
<form id="formLogin">
 Username: 
 <input id="usern" name="usern" type="text" 
 class="form-control form-control-sm">
 Password: 
 <input id="pass" name="pass" type="password" 
 class="form-control form-control-sm">
 <br>
 <input id="btnLogin" name="btnLogin" type="button" value="Login" 
 class="btn btn-primary">
 <br>
 <br>
 <div id="alertError" class="alert alert-danger"></div>
</form>
<p class="text"><a href="Register.jsp">Sing up</a></p>
 </div>
</div>
</div>
</body>
</html>