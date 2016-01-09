<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/LoginUsersView.css" rel="stylesheet" type="text/css" />
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
				<li> <a href="LoginOrdersViewController"> Orders </a> </li>
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
						<td style="color: teal; border-bottom: 2px teal dotted"> Name (type, status) </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> </td>
						<td style="color: teal; border-bottom: 2px teal dotted"> </td>
					</tr>
					<c:set var="counter" value="0"/>
					<c:forEach var="user" items="${allUsers}">
					<c:set var="counter" value="${counter + 1}"/>
					<c:choose>
					<c:when test="${user.status eq 'active'}">
					<tr>
						<td> ${counter}. </td>
						<td> ${user.firstName} ${user.lastName} (${user.type}, ${user.status})</td>
						<td id="update"> <a href="UpdateUserController?userUsername=${user.username}"> Update </a> </td>
						<td id="delete"> <a href="DeleteUserController?userUsername=${user.username}"> Delete </a> </td>
						
					</tr>
					</c:when>
					<c:otherwise>
					<tr>
						<td> ${counter}. </td>
						<td style="color: gray"> ${user.firstName} ${user.lastName} (${user.type}, ${user.status})</td>
						<td></td>
						<td id="revive"> <a href="ReviveUserController?userUsername=${user.username}"> Revive </a> </td>
					</tr>
					</c:otherwise>
					</c:choose>
					</c:forEach>
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