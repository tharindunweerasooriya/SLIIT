<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Researcher Login</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/research.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<h1>Researcher Login</h1>
<form id="formLogin">
 Username: 
 <input id="usern" name="usern" type="text" 
 class="form-control form-control-sm">
 Password: 
 <input id="pass" name="pass" type="password" 
 class="form-control form-control-sm">
 <br>
 <input id="btnLoginR" name="btnLoginR" type="button" value="Login" 
 class="btn btn-primary">
 <br>
 <br>
 <div id="alertError" class="alert alert-danger"></div>
</form>
 </div>
</div>
</div>
</body>
</html>