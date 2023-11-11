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

<style>
	.background{
		background-image: url("delete.jpg");
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
<h1 class="w3-allerta">Deleted Dog</h1>
<h4 class="w3-margin">
	<span class="raleway"><c:out value="${owner_name}" /></span>, 
	it's sad to see your dog 
	<span class="raleway"><c:out value="${sessionScope.selectedDogName}" /></span> gone...</h4>

<form method = "post" action="IndexServlet">
	<input type="submit" value="BACK" class="w3-left inputSubmit"/>
</form>
		
<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>