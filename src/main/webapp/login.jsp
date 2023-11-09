<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Natalia Palej A00279259</title>

<style>
	.body{
		background-image: ("background.jpg");
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
		align-items: center;
		height: 90vh;
		margin: 0;
		}
</style>

</head>

<body>
<h1 class="w3-allerta">Dogs Application</h1>

<div class="body">
	<form method = "post" action="LoginServlet" class="w3-container w3-padding">
	<!-- <form method = "post" action="LoginServlet" class="w3-container w3-padding"> -->
		<label>Email: </label> 
		<input type="text" name="email"/>
		<br>
		<label>Password</label> 
		<input type="text" name="password"/>
		<br>
		<input type="submit" value="Login" class="w3-padding-large w3-right w3-hover-purple w3-round-large"/>
	</form>
</div>
	
<footer class="w3-padding-small">
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>
</body>
</html>