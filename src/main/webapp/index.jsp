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
.background {
	background-image: url("index.jpg");
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

	<div class="w3-container">
		<h3 class="w3-half">
			Hello, <span class="raleway"><c:out value="${owner_name}" /></span>!
		</h3>
	</div>

	<br>
	<!-- Dog Details -->
	<div class="w3-margin w3-padding w3-center" style="width: 50%">
		<!-- Dogs Details represented in table -->
		<table class="w3-table table w3-hoverable">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Breed</th>
					<th>Colour</th>
					<th>Activity</th>
					<th>Maintenance</th>
				</tr>
			</thead>
			<c:forEach items="${dogDetails}" var="dogObj">
				<tr>
					<td><c:out value="${dogObj.name}" /></td>
					<td><c:out value="${dogObj.age}" /></td>
					<td><c:out value="${dogObj.breed}" /></td>
					<td><c:out value="${dogObj.colour}" /></td>
					<td><c:out value="${dogObj.activity}" /></td>
					<td><c:out value="${dogObj.maintenance}" /></td>
				</tr>
			</c:forEach>
		</table>

	<!-- UPDATE/DELETE dog -->
		<div class="w3-margin">
			<form method="post" action="SelectedDog">
		        <label for="selectDog">Select dog to update/delete:</label>
			        <select name="name" id="selectDog" style="width: 200px;" >
			            <c:forEach items="${dogDetails}" var="dogObj">
			                <option value="${dogObj.name}">${dogObj.name}</option>
			            </c:forEach>
			        </select>
			        <div class="w3-panel">
			        	<input type="submit" name="userChoice" value="Update" class="menuType w3-margin" style="width: 40%"/>
			        	<input type="submit" name="userChoice" value="Delete" class="menuType w3-margin" style="width: 40%"/>
			        </div>
	    	</form>
   		</div>
	</div>

	<div class="w3-container">
		<h3 class="w3-half">MENU:</h3>
	</div>

	<div class="w3-bar-block">
		<!-- INSERT dog -->
		<div class="w3-bar-item">
			<form method="post" action="add.jsp">
				<input type="submit" value="Add New Dog" class="menuType" />
			</form>
		</div>

		<!-- GET ALL DOGS -->
		<div class="w3-bar-item">
			<form method="post" action="AllDogsServlet">
				<input type="submit" value="See Other Dogs" class="menuType" />
			</form>
		</div>
	</div>

	<!-- LOGOUT and CLOSE SESSION -->
	<div class="w3-container">
		<div class="w3-quarter">
			<form method="post" action="LogoutServlet">
				<input type="submit" value="LOGOUT" class="menuType" />
			</form>
		</div>
	</div>

<!-- Footer, FIX SO IT DOESNT COVER PAGE CONTENT -->
<footer>
	<p>Natalia Palej&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student No: A00279259<br>
	Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a></p>
</footer>
</body>
</html>