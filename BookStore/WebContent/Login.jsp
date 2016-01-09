<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/login.css" rel="stylesheet" type="text/css" />
<title>Login</title>
</head>
<body>
	<c:import url="header.jsp">
	</c:import>
	
	<div id="container">
		<form id="infoForPurchaser" action="LoginController" method="post">
			<ul>
				<li> <p>Username:</p> <input type = "text" name="username" placeholder="username" required> </li>
				<li> <p>Password:</p> <input type = "password" name="password" placeholder="*********" required> </li>
			</ul>
			<ul>
				<li id="buttonTd"> <input type="submit" name="loginButton" id="loginButton" value="Log In"/> </li>
			</ul>
		
		</form>
	</div>
	
	<c:import url="footer.jsp">
	</c:import>
</body>
</html>