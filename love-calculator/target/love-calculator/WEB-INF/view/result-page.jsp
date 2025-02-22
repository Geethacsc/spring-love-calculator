<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Love Calculator</title>
<!-- data binding using DTO class -->
</head>
<body>
	<h2 align="center">Love Calculator</h2>
	<p>The Love calculator predicts:</p>
	<p>${userInfo.userName} and	${userInfo.crushName} are : Friend</p>
	<br />
	<br />
	<a href="send-email">Send result to email</a>
	<a href="home-page.jsp">try with somebody else</a>
	<a href="user-history">check user history</a>
</body>
</html>