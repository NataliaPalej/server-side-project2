<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="style.css">
<title>Natalia Palej A00279259</title>

<style>
	.background{
		background-image: url("login.jpg");
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
		align-items: center;
		height: 90vh;
		margin: 0;
		}
</style>

</head>

<body class="background">
<h1 class="w3-allerta">Dogs Application</h1>

	<div class="w3-half w3-card w3-margin w3-padding">
		<h3>Log In:</h3>
		<form method = "post" action="LoginServlet">
			<label class="label">Email: </label> 
			<input type="text" name="owner_email" class="inputText"/>
			<br>
			<label class="label">Password</label> 
			<input type="text" name="password" class="inputText"/>
			<br>
			<input type="submit" value="Login" class="w3-right inputSubmit"/>
		</form>
	</div>
	
	<div class="w3-half w3-card w3-margin card">
		<h3>Not a Member Yet?</h3>
		<form method = "post" action="RegisterUser">
			<input type="submit" value="Register" class="w3-right inputSubmit"/>
		</form>
	</div>

<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>