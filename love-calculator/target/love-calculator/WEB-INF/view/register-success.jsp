<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>-->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
	<h1 align="center">LOVE CALCULATOR REGISTER</h1>
	<hr />
	<form:form modelAttribute="userRegister">
		<div align="center">
			<label>Name :</label>${userRegister.name} <br /> 
			<label>User	Name :</label>${userRegister.userName} 
			<br /> 
			<label for="pwd">Password:</label>${userRegister.password} 
			<br /> 
			<label>Country :</label>${userRegister.country}
			<br /> 
			<label>Hobby</label>
			<c:forEach var="hob" items=${userRegister.hobby}>
				${hob}
			 </c:forEach>
			
			<br/>
			<label>Gender	:</label>${userRegister.gender}
		</div>
	</form:form>

</body>
</html>