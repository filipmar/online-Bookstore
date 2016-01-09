<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/LoginBookPreview.css" rel="stylesheet" type="text/css" />
<title>${loggedUser.firstName} ${loggedUser.lastName}</title>
</head>
<body>
	<c:import url="header.jsp">
	</c:import>
	
	<c:if test="${loggedUser == null}">
		<c:redirect url="Login.jsp" />
	</c:if>
	
	<div id="container">
		<div id="navigationMenu">
			<ul>
			<li> <a href="LoginBookPreviewViewController"> Books </a> </li>
			<li style="list-style: none; padding-left: 25px;"><a href="AddNewBookController" > -Add new book </a></li>
				<li> <a href="#"> Orders </a> </li>
				<c:if test="${loggedUser.type eq 'admin'}">
					<li> <a href="LoginUsersViewController"> Users </a></li>
					<li style="list-style: none; padding-left: 25px;"><a href="AddNewUserController"> -Add new user </a></li>
				</c:if>
			</ul>
		</div>
		
		<div id="bookList">
				<table id="tableBooks">
					<tr>
						<td style="color: teal; border-bottom: 2px teal dotted"> No. </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> Purchaser </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> Book </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> Status </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> </td>
						<td style="color: teal; border-bottom: 2px teal dotted"></td>
					</tr>
					<c:set var="counter" value="0"/>
					<c:forEach var="order" items="${allOrders}" varStatus="status">
					<c:set var="counter" value="${counter + 1}"/>
					<tr>
						<td> ${counter}. </td>
						<td> ${order.purchaser.firstName}  ${order.purchaser.lastName}</td>
						<td> ${order.book.title}</td>
						<td> (${order.granted})</td>
						<c:choose>
							<c:when test="${order.granted eq 'ordered'}">
								<td id="update"> <a href="SendOrderController?oID=${order.id}&amp;pID=${order.purchaser.id}">Send</a> </td>
								<td id="update"> <a href="CancelOrderedOrderController?oID=${order.id}">Cancel</a> </td>
							</c:when>
							<c:when test="${order.granted eq 'sent'}">
								<td id="update"> <a href="DeliveredOrderController?oID=${order.id}"> Delivered </a> </td>
								<td id="update"> <a href="CancelSentOrderController?oID=${order.id}"> Cancel </a> </td>
							</c:when>
							<c:when test="${order.granted eq 'cancel'}">
								<td id="update" colspan="2"> <a href="SendOrderController?oID=${order.id}&amp;pID=${order.purchaser.id}"> Send actually </a> </td>
							</c:when>
							<c:when test="${order.granted eq 'delivered'}">
								<td id="update" colspan="2"> </td>
							</c:when>
						</c:choose>
					</tr>
					</c:forEach>
					
				</table>
				<table style="margin-top: 25px; margin-left: 10px;">
					<tr>
						<td style="border-bottom: 1px dotted teal;">Total earnings | </td>
						<td style="border-bottom: 1px dotted teal;">Total ordered books | </td>
						<td style="border-bottom: 1px dotted teal;">Total deliveredBooks | </td>
					</tr>
					<tr> 
						<td style="padding-left: 15px;">${totalPrice} $</td>
						<td style="padding-left: 15px;">${totalOrderes}</td>
						<td style="padding-left: 15px;">${totalDeliveredOrders}</td>
					</tr>
				</table>
				
		</div>
		
		<div id = "infoOfUser">
			<ul>
				<li><span class="tealColor">Username:</span> ${loggedUser.username}</li>
				<li><span class="tealColor">First name:</span> ${loggedUser.firstName}</li>
				<li><span class="tealColor">Last name:</span> ${loggedUser.lastName}</li>
				<li><span class="tealColor">E-mail:</span> ${loggedUser.email}</li>
				<li><span class="tealColor">Type:</span> ${loggedUser.type}</li>
				<li> <a href="LogOutController"><<< Logout </a> </li>
		</ul>
	</div>
	</div>
	

	
	<c:import url="footer.jsp">
	</c:import>

</body>
</html>