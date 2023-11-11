<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Raleway:wght@200&display=swap" >
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="style.css">
<title>Natalia Palej A00279259</title>

<style>
	.background{
		background-image: url("background3.jpg");
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
<h1 class="w3-allerta">Login Successful</h1>
<c:set var="owner_name" value="${dogDetails[0].owner_name}" scope="session" />
<c:set var="name" value="${dogDetails[0].name}" scope="session" />
<h3>Welcome, <span class="raleway"><c:out value="${owner_name}" /></span>!</h3>

<div class="w3-card w3-margin w3-padding w3-center">
	<p class="w3-sofia">Congratulations!</p>
	<p>You have successfully logged into the Dogs Application. 
	Here, you can manage and view information about your dogs.</p>
	
	<form method = "post" action="IndexServlet">
		<input type="submit" value="GO" class="w3-round-large button w3-margin"/>
	</form>
</div>
		
	
<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>