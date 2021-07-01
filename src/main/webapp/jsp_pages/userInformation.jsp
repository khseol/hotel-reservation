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
			<div class="col-lg-12" style="background-color: #01004C;">
				<h1 style="color: aliceblue; text-align: center;">HOTEL BOOKER</h1>
			</div>
		</div>
		<!-- the first page the user is forwared to will need to fill out basic information:
		name, email, and travel location
		the requests will be handled in a separate servlet that will take in the information and apply it to its
		respective model and table-->

		<div class="row">
			<form method="post" action="userServlet">
				<div class="form-group">

					<div id="forTheUserName">
						<label for="forTheUserName">Full Name</label> <input type="text"
							name="user_name" class="form-control" id="forTheUserName"
							placeholder="Enter full name" style="padding: 15px;"> <small
							id="Specifics" class="text-muted">eg. Jane Doe</small> <br>
					</div>

					<div id="forUserEmail">
						<label for="forUserEmail">Email</label> <input type="email"
							name="user_email" class="form-control"
							placeholder="example@gmail.com" style="padding: 15px;"> <br>
					</div>

					<div id="forUserTravel">
						<label for="forUserTravel">Where are you traveling to?</label> <select
							class="selectpicker form-control" name="user_location">
							<option hidden>Select a state</option>
							<c:forEach var="state" items="${locationData }">
								<option value="${state.location_id }"><c:out
										value="${state.stateName }"></c:out></option>
							</c:forEach>
						</select> <br>
					</div>

					<div id="forSubmitting">
						<input type="submit" class="btn btn-primary"
							value="Choose a hotel">

					</div>

				</div>
			</form>
		</div>

	</div>
</body>
</html>