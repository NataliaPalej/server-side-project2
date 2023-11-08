<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Allerta+Stencil">
<link rel="stylesheet" type="text/css" href="style.css">

<script>
function goBack() {
    window.location.href = "index.jsp";
}
</script>

<title>Natalia Palej A00279259</title>
</head>

<body>
<h1 class="w3-allerta">My Dog Details</h1>
<br>

<!-- *Add Name from Cookies* -->
<h3>Hello, </h3>
<br>

<h3>Other Dogs</h3>

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
			<th>Owner</th>
		</tr>
		<c:forEach items="${dogsList}" var="dogObj">
		<tr>
			<td class=""><c:out value="${dogObj.name}" /></td>
			<td class=""><c:out value="${dogObj.age}" /></td>
			<td class=""><c:out value="${dogObj.breed}" /></td>
			<td class=""><c:out value="${dogObj.colour}" /></td>
			<td class=""><c:out value="${dogObj.activity}" /></td>
			<td class=""><c:out value="${dogObj.maintenance}" /></td>
			<td class=""><c:out value="${dogObj.owner}" /></td>
		</tr>
		</c:forEach>
	</table>
	
	<div class="button-container">
		<button onclick="goBack()" class="button w3-margin">BACK</button>
	</div>
	
</div>
		
<!-- Footer, *change background* -->
<footer class="w3-padding-small">
	<p>Natalia Palej<br>
	Student No: A00279259</p>
	<p>Email: <a href="mailto:A00279259@student.tus.ie">A00279259@student.tus.ie</a><br>
	Software Design with Artificial Intelligence for Cloud Computing</p>
</footer>

</body>
</html>