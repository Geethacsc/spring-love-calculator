<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hi ${mysession.name} ${userInfo.userName}!</h3>
	<h3>send result to you email</h3>
	<form action="process-email" >
		<table>
			<tr>
				<td>your email id:</td>
				<td><input name="email" /></td>
				<td><input type="submit" value="submit"/></td>
			</tr>
		</table>
	<form>
	<br />
	<a href="home-page">try with somebody else</a>
</body>
</html>