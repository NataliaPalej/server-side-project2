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
	.background{
		background-image: url("logout.jpg");
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
		align-items: center;
		height: auto;
		margin: 0;
		}
</style>

</head>

<body class="background">

<h1 class="w3-allerta">G O O D B Y E</h1>
<div class="body w3-center">
	<h2>Sad to see you go, <c:out value="${owner_name}" />!</h2>
	<h5>Hope to see you again...</h5>
</div>
	
<footer class="w3-padding-small">
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>

</body>
</html>