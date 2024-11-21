<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Praise the Lord</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	margin-left: 30px;
	text-align: left
}

#signin {
	margin-left: 800px;
}
</style>
</head>
<body>
	<h3>
		<a href="sign-in" id="signin">Sign-in</a>
	</h3>

	<h1 align="center">LOVE CALCULATOR</h1>
	<hr />
	<form:form action="process-homepage" method="get"
		modelAttribute="userInfo">
		<!-- modelAttribute ="userInfo" binds data from the dto. i.e here the default value is fetched fromdto class -->
		<div align="center">
			<table>
				<tr>
					<td><label for="un">Your Name :</label></td>
					<!-- path - binds the data from dto using modelAttribute attribute in mvc form tag -->
					<td><form:input id="un" path="userName" /></td>
					<td><form:errors cssClass="error" path="userName" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><label for="cn">Crush Name : </label></td>
					<td><form:input id="cn" path="crushName" /></td>
					<td><form:errors path="crushName" cssClass="error" /></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td><form:checkbox path="termsAndConditions" /></td>
					<td>I am agreeing that this is for fun</td>
					<td><form:errors path="termsAndConditions" cssClass="error" /></td>
				</tr>
			</table>
			<input type="submit" value="submit">
		</div>
	</form:form>
</body>
</html>