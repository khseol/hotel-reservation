<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" style="background-color: #01004C;">
				<h1 style="color: aliceblue; text-align: center;">HOTEL BOOKER</h1>
			</div>
		</div>
		
		
		<div class= "row"> <!-- this is the part that will display the hotels available to the user. -->
		
			<form method="GET" action = "selectHotel" >
				<div class="form group">
					<table class="table table-hover">
						<thead>
							<th scope="col">Hotel</th>
						</thead>
					</table>
				</div>
			</form>	
		</div> <!-- closing tag for the second row class div element. -->
		
	</div> <!-- ending tag for the div element that has container fluid -->
</body>
</html>