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
		
			<form method="POST" action = "selectHotel" >
				<div class="form group">
					<table class="table table-hover">
						<thead style = "text-align:center ">
							<th scope="col" >Hotel</th>
							<th scope="col">Hotel Address</th>
							<th scope ="col">Hotel Price</th>
							<th></th> <!-- blank header to place a submit button -->
						</thead>
						
						<tbody><!-- Dynamically generate hotel -->
							<c:forEach var="hotel" items="${listOfHotels }">
								<tr>
									<td><c:out value="${hotel.hotelName}"></c:out></td> <!-- prints out the name of the hotel...maybe add a cute picture with it -->
									
									<td><c:out value="${hotel.hotelLocationAddress}"></c:out></td> <!-- prints out the address of the hotel given by the state the user picked -->
									
									<td><c:out value="${hotel.hotelSaleRate}"></c:out></td> <!-- shows the price of the hotel..because the  --> 
									
									<td><button name="selectedHotel" type="submit" class="btn btn-primary" value="${hotel.hotelID}">BOOK!</button> </td> <!-- will be a 'book' button that will book the hotel by saving the hotel's id-value -->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>	
		</div> <!-- closing tag for the second row class div element. -->
		
	</div> <!-- ending tag for the div element that has container fluid -->
</body>
</html>