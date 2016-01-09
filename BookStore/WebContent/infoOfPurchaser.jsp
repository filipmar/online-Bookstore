<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/infoOfPurchaser.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.1/jquery-ui.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css" />
<script src="js/infoOfPurchaser.js"></script>
<title>Book Store</title>
</head>
<body>
	<c:import url="header.jsp">
	</c:import>
	<!-- go back -->
	
	<div id="dialog" title="Info">
  		Success order, ${firstName}. Your order will be send to admin. If everything is ok we will contact you.
	</div>

	<div id= "container">
			<p> Enter the required information below(all field is required!) </p> 
			<form id="infoForPurchaser" action="AddToCartController" method="post">
				<ul>
					<li><input type="text" class="inputLi" name="firstName" id="firstName" placeholder="First Name" required/></li>
					<li><input type="text" class="inputLi" name="lastName" placeholder="Last Name" required/></li>
					<li><input type="text" class="inputLi" name="adress" placeholder="Adress" required/> </li>
					<li><input type="text" class="inputLi" name="zipCode" placeholder="Zip Code" required pattern="[0-9]{5}"/> </li>
					<li><input type="text" class="inputLi" name="city" placeholder="City" required/> <input type="hidden" name="success" id="success" value="success" /> </li>
					<li><input type="text" class="inputLi" name="phoneNumber" placeholder="Phone Number" required pattern="[0-9]{10}"/> <input type="hidden" id="granted" name="granted" value="ordered" /></li>
					<li><input type="text" class="inputLi" name="email" placeholder="you@email.com" required /></li>
					<li id="orderLi"><input name="orderButton" id="orderButton" type="submit" value="Order now!"/><li>
				</ul>
			</form>

	</div>
	<!-- container -->
	<div id="orderDetails">
		<ol>
		<c:set var="totalPrice" value="0" />
			<p>Your books: </p>
			<c:forEach var="book" items="${booksInCart}">
				<c:set var="totalPrice" value="${totalPrice + book.price}" />
				<li id="liTitle"> <a href="./BookPreview?bId=${book.id}" id="reviewA">${book.title}</a> </li> 
			</c:forEach>
		</ol>
			<p id = "tprice">Total price: ${totalPrice} USD</p>
	</div>
	
	<c:import url="footer.jsp">
	</c:import>

</body>
</html>