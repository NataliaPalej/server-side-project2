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
</head>

<body>
<h1 class="w3-allerta">Register Dog</h1>

<div class="body">
	<form method = "post" action="RegisterServlet" class="w3-container w3-padding">
		<label>Dog Name: </label> 
		<input type="text" name="name"/>
		<br>
		<label>Age:</label> 
		<input type="text" name="age"/>
		<br>
		<label>Breed:</label> 
		<input type="text" name="breed"/>
		<br>
		<label>Colour:</label> 
		<input type="text" name="colour"/>
		<br>
		<label>Activity Level:</label> 
		<input type="text" name="activity"/>
		<br>
		<label>Maintenance: </label> 
		<input type="text" name="maintenance"/>
		<br>
		<label>Owner Name: </label> 
		<input type="text" name="owner_name"/>
		<br>
		<label>Owner Email: </label> 
		<input type="text" name="owner_email"/>
		<br>
		<label>Owner Password: </label> 
		<input type="text" name="owner_password"/>
		<br>
		<input type="submit" value="Register" class="w3-padding-large w3-right w3-hover-purple w3-round-large"/>
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