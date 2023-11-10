<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		background-image: url("background4.jpg");
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
		align-items: center;
		min-height: 400px;
		margin-bottom: 100px;
   		clear: both;
		}
</style>


</head>

<body class="body">
<h1 class="w3-allerta">Register Dog</h1>

<div class="w3-padding w3-left">
	<h4>Dog Details:</h4>
	<form method = "post" action="RegisterServlet" class="w3-container w3-padding form">
		<label>Dog Name: </label> 
		<input type="text" name="name" class="inputText"/>
		<br>
		<label>Age:</label> 
		<input type="text" name="age" class="inputText"/>
		<br>
		<label>Breed:</label> 
		<input type="text" name="breed" class="inputText"/>
		<br>
		<label>Colour:</label> 
		<input type="text" name="colour" class="inputText"/>
		<br>
		<label>Activity Level:</label> 
		<input type="text" name="activity" class="inputText"/>
		<br>
		<label>Maintenance: </label> 
		<input type="text" name="maintenance" class="inputText"/>
		<br>
		<label>Owner Name: </label> 
		<input type="text" name="owner_name" class="inputText"/>
		<br>
		<label>Owner Email: </label> 
		<input type="text" name="owner_email" class="inputText"/>
		<br>
		<label>Owner Password: </label> 
		<input type="text" name="owner_password" class="inputText"/>
		<br>
		<input type="submit" value="Register" class="w3-right inputSubmit"/>
	</form>
</div>

<div class="w3-half w3-margin w3-padding w3-center w3-card">
	<h4>Active Members</h4>
	<!-- Setting session attributes for members count -->
	<c:set var="owners_count" value="${owners_count}" scope="session" />
	<c:set var="dogs_count" value="${dogs_count}" scope="session" />
	<div class="w3-left w3-container w3-cell">
		<img src="iconPerson.png" style="width: 60px; margin-right: 10px;"/>	
	</div>
	<div class="w3-left w3-container w3-cell">
		<p>Owners: <c:out value="${owners_count}"/></p>
	</div>
	
	<!-- Gap between owners and dogs -->
	<div class="w3-left w3-container w3-cell">
	</div>
	
	<div class="w3-left w3-container w3-cell">
		<img src="iconPet.png" style="width: 60px; margin-right: 30px;"/>
	</div>
	<div class="w3-left w3-container w3-cell">
		<p>Dogs: <c:out value="${dogs_count}"/></p>
	</div>
</div>
	
<footer>
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>
</body>
</html>