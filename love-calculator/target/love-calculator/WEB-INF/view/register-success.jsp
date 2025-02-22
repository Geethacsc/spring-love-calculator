<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<h1 align="center">LOVE CALCULATOR REGISTERATION SUCCESS</h1>
	<hr />
	<form:form modelAttribute="userRegister">
		<div align="center">
			<p><label>Name :</label>${userRegister.name} </p>
			<label>User	Name :</label>${userRegister.userName} 
			<p>
			<label for="pwd">Password:</label>${userRegister.password} 
			</p>
			<p>
				<label>Country :</label>${userRegister.country}
			</p>
			<p> 
			<label>Hobby: </label>
			<c:forEach var="hob" items="${userRegister.hobby}">
				${hob};
			 </c:forEach>
			</p>
			<p>
				<label>Gender	:</label>${userRegister.gender}
			</p>
			<p>
				<label>Age	:</label>${userRegister.age}
			</p>
			<h3>Communication</h3>
			<label>Email	:</label>${userRegister.communicationDto.email}<br/>
			<label>Mobile	:</label>${userRegister.communicationDto.mobile}
		</div>
	</form:form>

</body>
</html>