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

<script>
function goBack() {
	window.location.href = "IndexServlet";
}
</script>

<style>
	.body{
		background-image: url("add2.jpg");
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

<h4 class="w3-margin">Hello, <c:out value="${owner_name}" />. You can add new dog here.</h4>

<div class="w3-container w3-padding">
	<form method = "post" action="addServlet" class="w3-container w3-margin-top form">
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
		<input type="submit" value="Add" class="w3-right inputSubmit"/>
		<button onclick="goBack()" class="inputSubmit">Back</button>
	</form>
</div>
	
<footer>
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>
</body>
</html>