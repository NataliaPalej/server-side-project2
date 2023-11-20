<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap" >
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="style.css">
<title>Natalia Palej A00279259</title>

<style>
	.background{
		background-image: url("update.jpg");
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
<h1 class="w3-allerta">Update Your Doggie</h1>

<h4 class="w3-margin"><span class="raleway"><c:out value="${owner_name}" /></span>, 
you can update your dog, <span class="raleway"><c:out value="${selectedDog.name}"/></span>, here.</h4>

<div class="w3-margin">
<label class="label-white">Dog Name: <c:out value='${selectedDog.name}'/></label> 
	<form method = "post" action="UpdateServlet" class="w3-margin">
		<label class="label-white">Age:</label> 
		<input class="w3-input w3-animate-input input" type="text" name="age" 
			   value="<c:out value='${selectedDog.age}'/>" />
		<br>
		<label class="label-white">Breed:</label> 
		<input class="w3-input w3-animate-input input" type="text" name="breed"
			   value="<c:out value='${selectedDog.breed}'/>" />
		<br>
		<label class="label-white">Colour:</label> 
		<input class="w3-input w3-animate-input input" type="text" name="colour"
			   value="<c:out value='${selectedDog.colour}'/>" />
		<br>
		<label class="label-white">Activity Level:</label> 
		<input class="w3-input w3-animate-input input" type="text" name="activity"
			  value="<c:out value='${selectedDog.activity}'/>" />
		<br>
		<label class="label-white">Maintenance: </label> 
		<input class="w3-input w3-animate-input input" type="text" name="maintenance"
			   value="<c:out value='${selectedDog.maintenance}'/>" />
		<br>
		<input type="hidden" name="owner_name" value="<c:out value='${owner_name}'/>" />
		<input type="hidden" name="owner_email" value="<c:out value='${owner_email}'/>" />
		<input type="hidden" name="owner_password" value="<c:out value='${owner_password}'/>" />
		
		<input type="submit" value="Update" class="button w3-left"/>
	</form>
</div>
		
	
<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>