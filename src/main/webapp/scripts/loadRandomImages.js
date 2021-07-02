/**
 * Script that will try and load a random image of a hotel(maybe plus beds) onto the page
 the function will only just return a random image on file and paste it onto the <td> tag, line break after hotel's 
 name.
 */
 function loadHotelPicture(){
	var hotelPicture = new Image();
	hotelPicture.src = '/images/hotelPictures/basicHotelPicture1.jpg';
	return hotelPicture;
}