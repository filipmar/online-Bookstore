<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/addNewBook.css" rel="stylesheet" type="text/css" />
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
				<form action="AddNewUserController" method="post" id="addNewBookForm" enctype="multipart/form-data">
					<label for="username">Username:</label>
					<input name="username" type="text" placeholder="username" required/> ${existUsername}<br/> 
					<label for="firstName">First name:</label>
					<input name="firstName" type="text" placeholder="First name" required/><br/>
					<label for="lastName">Last name:</label>
					<input name="lastName" type="text" placeholder="Last name" required/><br/>
					<label for="password">Password:</label>
					<input name="password" type="password" placeholder="*********" required /><br/>
					<label for="email">E-mail:</label>
					<input name="email" type="text" placeholder="you@mail.com" required/><br/>
					<label for="type">Type:</label>
					<select name="type">
  							<option value= "admin"> Admin </option>
 							<option value="manager">Manager</option>
					</select>
					<input type="submit" value="Add user" id="submitBUtton">
				</form>
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