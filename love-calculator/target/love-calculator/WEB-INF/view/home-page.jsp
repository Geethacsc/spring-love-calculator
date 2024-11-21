<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Praise the Lord</title>
</head>
<body>

	<h1 align="center">LOVE CALCULATOR</h1>
	<h3><a href="sign-in">Regsiter</a></h3>
	<hr />
	<form:form action="process-homepage" method="get" modelAttribute="userInfo">
	<!-- modelAttribute ="userInfo" binds data from the dto. i.e here the default value is fetched fromdto class -->
	<div align="center">
	<p>
	<label for="un">User Name :</label>
	<!-- path - binds the data from dto using modelAttribute attribute in mvc form tag -->
	<form:input id="un" path="userName"/>
	</p>
	<p>
	<label for="cn">Friend Name : </label>
	<form:input id="cn" path="crushName"/>
	</p>
	<input type="submit" value="submit">
	</div>
	</form:form>
</body>
</html>