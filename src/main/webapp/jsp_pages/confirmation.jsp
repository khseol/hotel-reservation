<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
crossorigin="anonymous">
<meta charset="UTF-8">
<title>Reservation Confirmation</title>
</head>
<body>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" style="background-color: #01004C;">
				<h1 style="color: aliceblue; text-align: center;">HOTEL BOOKER</h1>
			</div>
		</div>
		
		<div class="col-lg-12 rounded" style="border: 2px solid #01004C; border-style: dotted;margin-top: 2%;">
			<h1>Reservation Invoice:</h1> <!-- the name of the attribute set in java invoice servlet: reservationInformation -->
			<button type="button" class="btn btn-outline-info btn-md"id="printInvoice" 
			style="float:right; padding:5px;" onclick ="window.print()">Print</button>	
			<br>
			<h2 class="reservation"name="invoice_number">#<c:out value="${reservationInformation.reservationID}"></c:out></h2>
			<h3 class="userInformation" style="text-decoration: underline;">User Information</h3>
			<table class="table table-borderless">
				<thead>
					<th scope="col"class="col-md-6">Name</th>
					<th scope="col"class="col-md-6">Email</th>
				</thead>
				<tbody>
					<td><c:out value="${reservationInformation.userID.user_name }"></c:out></td>
					<td><c:out value="${reservationInformation.userID.user_email }"></c:out></td>
				</tbody>
			</table>
			<table class="table table-borderless">
				<thead>
					<th scope="col"class="col-md-3">Hotel Name</th>
					<th scope="col"class="col-md-3">Address</th>
					<th scope="col"class="col-md-3">State</th> <!-- the expression to be used for location is ${Location} -->
				</thead>
				<tbody>
					<td><c:out value="${reservationInformation.hotelID.hotelName}"></c:out></td>
					<td><c:out value="${reservationInformation.hotelID.hotelLocationAddress}"></c:out></td>
					<td><c:out value="${Location}"></c:out></td>
				</tbody>
			</table>
			<table class="table table-borderless">
				<thead>
					<th scope="col"class="col-md-3">Number of Guests</th>
					<th scope="col"class="col-md-3">Number of Rooms</th>
					<th scope="col"class="col-md-3">Check-IN/Check-OUT</th>
				</thead>
				<tbody>
					<td><c:out value="${reservationInformation.numberOfGuests }"></c:out></td>
					<td><c:out value="${reservationInformation.numberOfRooms }"></c:out></td>
					<td><c:out value="${CheckIn}"></c:out><br>
							<c:out value="${CheckOut}"></c:out></td>
				</tbody>
			</table>
			<br>
			
			<h3>TOTAL AMOUNT<br>$<c:out value="${pay}"></c:out></h3>
		</div>
	</div>
	
</body>
</html>