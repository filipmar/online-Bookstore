<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/indexBuGenre.css" rel="stylesheet" type="text/css" />
<title>Book Store</title>
</head>
<body>
	<c:import url="header.jsp">
	</c:import>
	
	<div id="container">
		<div id="nav">
			<ul>
				<li><a href="./BookList"> All </a></li>
				<li><a href="./GenreFilter?genre=drama"> Drama </a></li>
				<li><a href="./GenreFilter?genre=horor"> Horor </a></li>
				<li><a href="./GenreFilter?genre=adventure"> Adventure </a></li>
				<li><a href="./GenreFilter?genre=autobiografy"> Autobiografy </a></li>
				<li><a href="./GenreFilter?genre=for kids"> For kids </a></li>
				<li><a href="./GenreFilter?genre=crime"> Crime </a></li>
				<li><a href="./GenreFilter?genre=fiction"> Fiction </a></li>
				<li><a href="./GenreFilter?genre=romance"> Romance </a></li>
				<li><a href="./GenreFilter?genre=poetry"> Poetry </a></li>
				<li><a href="./GenreFilter?genre=it"> IT </a></li>
				<li><a href="./GenreFilter?genre=fantasy"> Fantasy </a></li>
			</ul>
		</div>
		<!-- nav -->
		<div id = "books">
			<c:if test="${fn:length(books) eq 0}">
					<h1 id= "h1books"> There are no books from selected category.</h1>
				</c:if> 
			<c:forEach var="book" items="${books}">
				<div id = "listOfBooks">
					<div id = "picture">
					<c:choose>
						<c:when test="${book.pictureURL eq null}">
							<a href="./BookPreview?bId=${book.id}" ><img id="bookE" src="picture/book111.png"></a>
						</c:when>
						<c:otherwise>
							<a href="./BookPreview?bId=${book.id}" ><img src="${book.pictureURL}"></a>
						</c:otherwise>
					</c:choose>
					</div>
					<!-- picture -->
						<ul id="listOfInfo">	
							<li><span id="teal">Title: </span>${book.title}</li>
							<li><span id="teal">By: </span>${book.authors} (${book.publicationYear})</li>
							<li id="review"><a href="./BookPreview?bId=${book.id}" id="reviewA">Book review</a></li>
						</ul>
					<!-- info -->
				</div>
			</c:forEach>
			
			<div id="pages">
				    <c:if test="${currentPage != 1}">
        				<a href="genre.do?page=${currentPage - 1}"><< Previous</a>
    				</c:if>
            				<c:forEach begin="1" end="${noOfPages}" var="i">
                			<c:choose>
                    			<c:when test="${currentPage eq i}">
                        			${i}
                    			</c:when>
                    		<c:otherwise>
                        		<a href="genre.do?page=${i}">${i}</a>
                    		</c:otherwise>
                			</c:choose>
            				</c:forEach>
    				
    				<c:if test="${currentPage lt noOfPages}">
        				<a href="genre.do?page=${currentPage + 1}">Next >></a>
    				</c:if>
			</div>
			<!-- pages -->
		</div>
		<!-- books -->
		<div id = "cart">
			<img src="picture/cart1.png" >
			<ol>
			<c:set var="totalPrice" value="0" />
				<c:forEach var="book" items="${booksInCart}">
					<c:set var="totalPrice" value="${totalPrice + book.price}" />
					<li> ${book.title} <a href="./DeleteFromCartController?bId=${book.id}" id="deleteX"> x </a></li> 
				</c:forEach>
			</ol>
			<c:choose>
				<c:when test="${booksInCart.size() gt 0}">
					<p id = "tPrice"> Total price: <c:out value="${totalPrice}" /> USD </p>
					<a href="./InfoOfPurchaserController" id ="buyNow"> Buy now! </a>
				</c:when>
				<c:otherwise>
					<p id="cartEmpty"> The cart is empty </p>
				</c:otherwise>
			</c:choose>
		</div>
		<!-- cart -->
	</div>
	<!-- container -->
	
	<c:import url="footer.jsp">
	</c:import>

</body>
</html>