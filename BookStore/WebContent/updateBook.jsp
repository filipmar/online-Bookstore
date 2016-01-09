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
<script type="text/javascript">
function CheckNo(sender){
    if(!isNaN(sender.value)){
        if(sender.value > 2115 )
            sender.value = 2115;
        if(sender.value < 1901 )
            sender.value =1901;
    }else{
          sender.value = 0;
    }
}
</script>
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
				<form action="UpdateBookController" method="post" id="addNewBookForm" enctype="multipart/form-data">
					<input name="id" type="text" value="${book.id }" required style="display: none;"/>
					<label for="title">Title:</label>
					<input name="title" type="text" value="${book.title }" required/>
					<label for="publisher">Publisher:</label>
					<input name="publisher" type="text" value="${book.publisher }" required/>
					<label for="authors">Author/s:</label>
					<input name="authors" type="text" value="${book.authors }" required/><br/>
					<label for="publicationYear">Publication year:</label>
					<input name="publicationYear" type="text" value="${book.publicationYear }" required pattern="[0-9]{4}" onblur="CheckNo(this)" /><br/>
					<label for="numberInStock">Number In Stock:</label>
					<input name="numberInStock" type="text" value="${book.numberInStock }" pattern="[0-9]*" required/><br/>
					<c:choose>
						<c:when test="${book.genre eq 'horror' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="horor">Horor</option>
	  							<option value= "drama"> Drama </option>
	  							<option value="adventure">Adventure</option>
	  							<option value="Autobiografy">Autobiografy</option>
	  							<option value= "forKids"> For kids </option>
	 							<option value="crime">Crime</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'drama' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="adventure">Adventure</option>
	  							<option value="Autobiografy">Autobiografy</option>
	  							<option value= "forKids"> For kids </option>
	 							<option value="crime">Crime</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'adventure' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="Autobiografy">Autobiografy</option>
	  							<option value= "forKids"> For kids </option>
	 							<option value="crime">Crime</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'autobiografy' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value= "forKids"> For kids </option>
	 							<option value="crime">Crime</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'for kids' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	 							<option value="crime">Crime</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'crime' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="fiction">Fiction</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'fiction' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="fiction">Fiction</option>
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="romance">Romance</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'romance' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="romance">Romance</option>
								<option value="fiction">Fiction</option>
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="poetry">Poetry</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'poetry' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="poetry">Poetry</option>
								<option value="romance">Romance</option>
								<option value="fiction">Fiction</option>
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="it">IT</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:when test="${book.genre eq 'IT' }">
							<label for="genre">Genre:</label>
							<select name="genre">
								<option value="it">IT</option>
								<option value="poetry">Poetry</option>
								<option value="romance">Romance</option>
								<option value="fiction">Fiction</option>
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
	  							<option value="fantasy">Fantasy</option>
							</select>
						</c:when>
						<c:otherwise>
						<label for="genre">Genre:</label>
							<select name="genre">
								<option value="fantasy">Fantasy</option>
								<option value="it">IT</option>
								<option value="poetry">Poetry</option>
								<option value="romance">Romance</option>
								<option value="fiction">Fiction</option>
								<option value="crime">Crime</option>
								<option value= "forKids"> For kids </option>
								<option value="Autobiografy">Autobiografy</option>
								<option value="adventure">Adventure</option>
								<option value= "drama"> Drama </option>
								<option value="horor">Horor</option>
							</select>
						</c:otherwise>
					</c:choose>
					<label for="price">Price:</label>
					<input name="price" type="text" value="${book.price}" required /> $<br/>
					<label for="description">Description:</label>
					<textarea rows="5" cols="50" required style="margin-top: 10px;" name="description">${book.description}</textarea><br/>
					<input type="text" name="file" id="uploatButton" value="${book.pictureURL}" style="display: none;"/><br/>
					<input type="submit" value="Update book" id="submitBUtton">
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