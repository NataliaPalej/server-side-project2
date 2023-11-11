<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap" >
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="style.css">
<title>Natalia Palej A00279259</title>

<script>
function goBack() {
	window.history.back();
}
</script>

<style>
	.body{
		background-image: url("add.jpg");
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
<h1 class="w3-allerta">Add New Dog</h1>

<h4 class="w3-margin"><span class="raleway"><c:out value="${owner_name}" /></span>, you can add new dog here.</h4>

<div class="w3-container w3-padding">
	<form method = "post" action="addServlet" class="w3-container w3-margin-top form">
		<label class="label">Dog Name: </label> 
		<input type="text" name="name" class="inputText"/>
		<br>
		<label class="label">Age:</label> 
		<input type="text" name="age" class="inputText"/>
		<br>
		<label class="label">Breed:</label> 
		<input type="text" name="breed" class="inputText"/>
		<br>
		<label class="label">Colour:</label> 
		<input type="text" name="colour" class="inputText"/>
		<br>
		<label class="label">Activity Level:</label> 
		<input type="text" name="activity" class="inputText"/>
		<br>
		<label class="label">Maintenance: </label> 
		<input type="text" name="maintenance" class="inputText"/>
		<br>
		<input type="submit" value="Add" class="w3-right inputSubmit"/>
		<button type="button" onclick="goBack()" class="inputSubmit" id="backButton">Back</button>
	</form>
</div>
	
<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>