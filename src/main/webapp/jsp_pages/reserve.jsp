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
	
<!-- script that will take in the current date local time and set it as the min value for the dateTime input. -->
<script>
/**
 * script that holds the function for seeting up the min dat for the Calendar id input.
 */
function getMinDateTime() {
	var minAttribute = document.querySelector("input") //from MDN, grab the element
	var today = new Date();
	//added an offset to control the minimum and if statements to check the 'end' of month, date and year
	var month = (today.getMonth() + 1);
	var day = today.getDate();
	//switch-case for month
	switch (month) {
		case 0:
			month = '0' + (today.getMonth() + 1)
			break;
		case 1:
			month = '0' + (today.getMonth() + 1)
			break;
		case 2:
			month = '0' + (today.getMonth() + 1)
			break;
		case 3:
			month = '0' + (today.getMonth() + 1)
			break;
		case 4:
			month = '0' + (today.getMonth() + 1)
			break;
		case 5:
			month = '0' + (today.getMonth() + 1)
			break;
		case 6:
			month = '0' + (today.getMonth() + 1)
			break;
		case 7:
			month = '0' + (today.getMonth() + 1)
			break;
		case 8:
			month = '0' + (today.getMonth() + 1)
			break;
		case 9:
			month = '0' + (today.getMonth() + 1)
			break;
	}

	switch (day) {
		case 0:
			month = '0' + (today.getDate());
			break;
		case 1:
			month = '0' + (today.getDate());
			break;
		case 2:
			month = '0' + (today.getDate());
			break;
		case 3:
			month = '0' + (today.getDate());
			break;
		case 4:
			month = '0' + (today.getDate());
			break;
		case 5:
			month = '0' + (today.getDate());
			break;
		case 6:
			month = '0' + (today.getDate());
			break;
		case 7:
			month = '0' + (today.getDate());
			break;
		case 8:
			month = '0' + (today.getDate());
			break;
		case 9:
			month = '0' + (today.getDate());
			break;
	}

	//sqitch-case for day


	var date = today.getFullYear() +'-'+ month +'-'+ day; //because the months start from 0 and min fails if the current is past min
	var time = "00:00";
	var minDateTime = date + "T" + time;
	//needs to be formatted as such yyyy:mm:dd for the attribute to work.
	console.log(minDateTime); //the input element name for check_in and check_out is "calendar"
	return document.getElementById("calendar").setAttribute("min", minDateTime); //the input element name for check_in and check_out is "calendar"
	

}

</script>	
<meta charset="UTF-8">
<title>Reservation</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12" style="background-color: #01004C;">
				<h1 style="color: aliceblue; text-align: center;">HOTEL BOOKER</h1>
			</div>
		</div>

		<div class="">

			<form method="POST" action="reserve"> <!-- action...from the servlet that is handling the requests -->
				<div class="form-group">
					<div class="checkinTime">
						<input type ="datetime-local" id="calendar" class="form-control" name="checkInTime" onclick="getMinDateTime()" max="2099-12-31T00:00"> 
					</div>
	
					<div class="checkOutTime"></div>
	
					<div class="numberOfGuests"></div>
	
					<div class="numberOfRooms"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>