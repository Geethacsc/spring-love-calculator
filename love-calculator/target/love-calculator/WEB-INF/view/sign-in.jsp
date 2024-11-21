<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
</head>
<body>
<h1 align="center">LOVE CALCULATOR REGISTER</h1>
<hr/>
	<form:form action="success-register" modelAttribute="userRegister">
		<div align="center">
			<p>
				<label for="nm">Name :</label>
				<form:input id="nm" path="name" />
			</p>
			<p>
				<label for="un">User Name :</label>
				<form:input id="un" path="userName" />
			</p>
			<p>
				<label for="pwd">Password	:</label>
				<form:password id="pwd" path="password" />
			</p>
			<p>
			<label for="cty">Country	:</label>
			<form:select it="cty" path="country">
			<form:option value="" label="Select"/>
			<form:option value="IND" label="India"/>
			<form:option value="US" label="US"/>	
			<form:option value="AUS" label="Australia"/>
			<form:option value="CAN" label="Canada"/>
			<form:option value="S-KOR" label="South Korea"/>
			</form:select>	
			</p>
			<p>
			<label for="hby">Hobby</label>
			<form:checkbox path="hobby" value="reading"/>reading
			<form:checkbox path="hobby" value="coding"/>coding
			<form:checkbox path="hobby" value="dreaming"/>dreaming
			</p>
			<p>
				<label for="gdr">Gender	:</label>
				<form:radiobutton path="gender" value="Male" />
				Male
				<form:radiobutton path="gender" value="Female" />
				Female
			</p>
			<p>
				<input type="submit" value="Register" />
		</div>
	</form:form>

</body>
</html>