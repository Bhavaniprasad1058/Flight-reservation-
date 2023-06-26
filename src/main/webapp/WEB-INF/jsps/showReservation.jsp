<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Flight Details</h2>
Flight Number:${flight.flightNumber}</br>
Operating Airlines:${flight.operatingAirlines}</br>
Departure City:${flight.departureCity}</br>
Arrival City:${flight.arrivalCity}</br>
Departure Date:${flight.dateOfDeparture}</br>
<h2>Enter Passenger Details</h2>
<form action="completeReservation" method="post">
<pre>
first name<input type="text" name="firstName">
last name<input type="text" name="lastName">
middle name<input type="text" name="middleName">
email<input type="text" name="email">
phone<input type="text" name="phone">
<input type="hidden" name="flightId" value="${flight.id }">
<h2>Enter Payment Details</h2>
Name On The Card<input type="text" name="nameOnTheCard">
Card Number<input type="text" name="cardNumber">
cvv<input type="text" name="cvv">
Expiry Date<input type="text" name="expiryDate">
<input type="submit" value="complete Reservation">
</pre>
</form>

</body>
</html>