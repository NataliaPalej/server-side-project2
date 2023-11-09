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
		background-image: url("background5.jpg");
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
<h1 class="w3-allerta">My Dog Details</h1>
<br>

<!-- Setting session attributes -->
<c:set var="name" value="${userDogsList[0].name}" scope="session" />
<c:set var="age" value="${userDogsList[0].age}" scope="session" />
<c:set var="breed" value="${userDogsList[0].breed}" scope="session" />
<c:set var="color" value="${userDogsList[0].colour}" scope="session" />
<c:set var="activity" value="${userDogsList[0].activity}" scope="session" />
<c:set var="maintenance" value="${userDogsList[0].maintenance}" scope="session" />

<div class="w3-container">
	<c:set var="owner_name" value="${userDogsList[0].owner_name}" scope="session" />
	<h3 class="w3-half">Hello, <c:out value="${owner_name}" /> </h3>
</div>

<br>
<!-- Dog Card -->
<div class="w3-card-4 w3-margin w3-padding w3-center" style="width:50%">
	<!-- Dogs Image -->
	<img src="" alt="dog" style="width:100%">
	<!-- Dogs Details represented in table -->
	<div class="w3-container w3-center">
		<table class="w3-table">
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Breed</th>
				<th>Colour</th>
				<th>Activity</th>
				<th>Maintenance</th>
			</tr>
			<c:forEach items="${dogDetails}" var="dogObj">
			<tr >
				<td><c:out value="${dogObj.name}" /></td>
				<td><c:out value="${dogObj.age}" /></td>
				<td><c:out value="${dogObj.breed}" /></td>
				<td><c:out value="${dogObj.colour}" /></td>
				<td><c:out value="${dogObj.activity}" /></td>
				<td><c:out value="${dogObj.maintenance}" /></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>

<br>
<br>

<div class="w3-container">
		<h3 class="w3-half">MENU:</h3>
</div>

<div class="w3-bar-block">
	<!-- ADD NEW DOGS -->
	<div class="w3-bar-item">
		<form method="post" action="add.jsp">
			<input type="submit" value="Add New Dog" class="menuType"/>
		</form>
	</div>
	
	<!-- UPDATE dog -->
	<div class="w3-bar-item">
		<form method="post" action="update.jsp">
			<input type="submit" value="Update Dog" class="menuType"/>
		</form>
	</div>
		
	<!-- DELETE dog -->
	<div class="w3-bar-item">
		<form method="post" action="delete.jsp">
			<input type="submit" value="Delete Dog" class="menuType"/>
		</form>
	</div>
		
	<!-- GET ALL DOGS -->
	<div class="w3-bar-item">
		<form method="post" action="AllDogsServlet">
			<input type="submit" value="See Other Dogs" class="menuType"/>
		</form>
	</div>
</div>
	
<!-- LOGOUT and CLOSE SESSION -->
<div class="w3-container">
	<div class="w3-quarter">
		<form method="post" action="logoutServlet">
			<input type="submit" value="LOGOUT" class="menuType"/>
		</form>
	</div>
</div>
		
<!-- Footer, FIX SO IT DOESNT COVER PAGE CONTENT -->
<footer class="w3-padding-small">
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>

</body>
</html>