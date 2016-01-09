<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/bookPreview.css" rel="stylesheet" type="text/css" />
<title>Book Store</title>
</head>
<body>
	<c:import url="header.jsp">
	</c:import>
	
	<div id= "container">
		<c:forEach var="book" items="${bookList}">
			<c:if test="${book.id eq bookID}">
				<ul>
					<c:choose>
						<c:when test="${book.pictureURL eq null}">
							<li id = "picture"><img id="bookE" src="picture/book111.png"></li>
						</c:when>
						<c:otherwise>
							<li id = "picture"><img src="${book.pictureURL}"></li>
						</c:otherwise>
					</c:choose>
					<li> <span class="teal">Title:</span> ${book.title} </li>
					<li> <span class="teal">Publication Year:</span> ${book.publicationYear} </li>
					<li> <span class="teal">Author/s:</span> ${book.authors} </li>
					<li> <span class="teal">Publisher:</span> ${book.publisher} </li>
					<li id = "description"> <span class="teal">Description:</span> ${book.description} </li>
					<li id = "genre"> <span class="teal">Genre:</span> ${book.genre}</li>
					<li> <span class="teal">Price:</span> ${book.price} USD</li>
					<c:choose>
						<c:when test="${book.numberInStock > 0}">
							<li id="addToCart"><a href="./AddToCartController?bId=${book.id}"> Add to cart </a></li>
						</c:when>
						<c:otherwise>
							<li id = "ofc"><p> Out of stock! </p></li>
						</c:otherwise>
					</c:choose>
					
				</ul>
			</c:if>
		</c:forEach>
	</div>
	<!-- container -->
	
	
	<c:import url="footer.jsp">
	</c:import>
</body>
</html>