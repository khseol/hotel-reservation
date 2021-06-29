<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>User Information</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class = "col-lg-12" style = "background-color: #01004C;">
				<h1 style = "color: aliceblue; text-align: center;">SUITE TOOTH</h1>
			</div>
		</div>
		<!-- the first page the user is forwared to will need to fill out basic information:
		name, email, and travel location
		the requests will be handled in a separate servlet that will take in the information and apply it to its
		respective model and table-->

		<div class="row">
			<form action="POST" action = "user" style="align-items: center;">
				<div class = "form-group">
					<label for= "forTheUserName" >Full Name</label>
					<input type ="text" name="user_name" class="form-control" id = "forTheUserName" placeholder="Enter full name" style="padding: 15px;">
					<small id = "Specifics" class = "text-muted">eg. Jane Doe</small>
					<br>
					
					<label for="forUserEmail">Email</label>
					<input type="email" name="user_email" class="form-control" id= "forUserEmail" placeholder="example@gmail.com" style="padding: 15px;">
					<br>

					<label for="user-travel-location"> Where are you travelling to?</label>
					<select class="form-control form-select" style="padding: 15px;">
						<!--will contain a jstl tags to output a list of the states in ascending order-->

					</select>
					
					<br> <!--creates a line break inbetween elements-->
					<input type="submit", class="btn btn-primary" >
			</form>
		</div>

	</div>
</body>
</html>