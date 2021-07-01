<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
<!-- script that will take in the current date local time and set it as the min value for the dateTime input. 
	will need to figure out why script source attribute will not let me call my functions from a separate file...-->
<script>
/**
 * script that holds the function for seeting up the min dat for the Calendar id input.
 */
function getMinDateTime(attribute) {
	var element = document.querySelector("input") //from MDN, grab the element
	var today = new Date();
	//added an offset to control the minimum and if statements to check the 'end' of month, date and year
	var month = (today.getMonth() + 1);
	var day = today.getDate();
	//switch-case for month
	switch (month) {
		case 1:
			month = "0" + (today.getMonth() + 1)
			break;
		case 2:
			month = "0" + (today.getMonth() + 1)
			break;
		case 3:
			month = "0" + (today.getMonth() + 1)
			break;
		case 4:
			month = "0" + (today.getMonth() + 1)
			break;
		case 5:
			month = "0" + (today.getMonth() + 1)
			break;
		case 6:
			month = "0" + (today.getMonth() + 1)
			break;
		case 7:
			month = "0" + (today.getMonth() + 1)
			break;
		case 8:
			month = "0" + (today.getMonth() + 1)
			break;
		case 9:
			month = "0" + (today.getMonth() + 1)
			break;
	}
	//switch-case for day
	switch (day) {
		case 1:
			day = "-0" + today.getDate();
			break;
		case 2:
			day = "-0" + today.getDate();
			break;
		case 3:
			day = "-0" + today.getDate();
			break;
		case 4:
			day = "-0" + today.getDate();
			break;
		case 5:
			day = "0" + today.getDate();
			break;
		case 6:
			day = "-0" + today.getDate();
			break;
		case 7:
			day = "-0" + today.getDate();
			break;
		case 8:
			day = "-0" + today.getDate();
			break;
		case 9:
			day = "-0" + today.getDate();
			break;
	}
	var date = today.getFullYear() +"-"+ month + day; //because the months start from 0 and min fails if the current is past min
	var time = "00:00";
	var minDateTime = date + "T" + time;
	if(attribute ==="checkInTime"){
		return document.getElementById("calendar").setAttribute("min", minDateTime); //the input element name for check_in and check_out is "calendar"
	}else if (attribute === "checkOutTime"){
		return document.getElementById("calendar2").setAttribute("min", minDateTime); //the input element name for check_in and check_out is "calendar"

	}
}

</script>	
<meta charset="UTF-8">
<link rel="jspStylesheet" href="style_sheets/jspStyles.css">
<title>Reservation</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" style="background-color: #01004C;">
				<h1 style="color: aliceblue; text-align: center;">HOTEL BOOKER</h1>
			</div>
		</div>

		<div class="col-lg-4">

			<form method="POST" action="reserve"> <!-- action...from the servlet that is handling the requests -->
				<div class="form-group row">
					<label for="calendar"class= "col-sm-3 col-form-label" style="font-weight: bold;">Reserve Check-In Date and Time</label>
					<div class="checkinTime col-lg-9">
						<input type ="datetime-local" id="calendar" class="form-control" name="checkInTime" onclick="getMinDateTime(name)" max="2099-12-31T00:00"> 
					</div>
					<br>
					
					<!-- need to know why this is not setting the min date... -->
					<label for="calenda2r"class= "col-sm-3 col-form-label" style="font-weight: bold;">Reserve Check-Out Date and Time</label>
					<div class="checkOutTime col-lg-9">
						<input type ="datetime-local" id="calendar2" class="form-control" name="checkOutTime" onclick="getMinDateTime(name)" max="2099-12-31T00:00"> 	
					</div>
					
					<div class="numberOfGuests"></div>
	
					<div class="numberOfRooms"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>