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
	window.location.href = "IndexServlet";
}
</script>

<style>
	.background{
		background-image: url("indexAllDogs.jpg");
  		background-repeat: no-repeat;
  		background-attachment: fixed;
  		background-size: cover;
		align-items: center;
		height: 15vh;
		margin: 0;
		}
</style>

</head>

<body class="background">
<h1 class="w3-allerta">All Dogs</h1>
<br>

<h4><span class="raleway"><c:out value="${owner_name}" /></span>, here's list of all dogs registered in the app:</h4>
<br>

<!-- Dogs Details represented in table -->
<div class="w3-container w3-center">
	<table class="w3-table table w3-hoverable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Breed</th>
				<th>Colour</th>
				<th>Activity</th>
				<th>Maintenance</th>
				<th>Owner</th>
			</tr>
		</thead>
			<c:forEach items="${allDogs}" var="dogObj">
			<tr class="">
				<td><c:out value="${dogObj.name}" /></td>
				<td><c:out value="${dogObj.age}" /></td>
				<td><c:out value="${dogObj.breed}" /></td>
				<td><c:out value="${dogObj.colour}" /></td>
				<td><c:out value="${dogObj.activity}" /></td>
				<td><c:out value="${dogObj.maintenance}" /></td>
				<td><c:out value="${dogObj.owner_name}" /></td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="goBack()" class="button w3-margin w3-left">BACK</button>
</div>
		
<footer class="w3-padding-small">
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>

</body>
</html>