<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!--We user Spring MVC Form tag(<form:form/>)to bind the data in the JSP 
	We can bind the data in the server without using Spring MVC Form Tag. 
	We user Spring MVC Form tag to bind the default data from dto on page load, displaying errors by simply mentioning <form:errors/>
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign in</title>
<style type="text/css">
.error {
	color: red;
	margin-left: 30px;
}
</style>
</head>
<body>
	<h1 align="center">LOVE CALCULATOR REGISTER</h1>
	<hr />
	<form:form action="success-register" modelAttribute="userRegister">
		<div align="center">
			<table>
				<tr>
					<td><label for="nm">Name :</label></td>
					<td><input name="name" id="nm" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<!--<form:input id="nm" path="name" />-->
				<tr>
					<td><label for="un">User Name :</label></td>
					<td><form:input id="un" path="userName" /></td>
					<td><form:errors path="userName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="pwd">Password :</label></td>
					<td><form:password id="pwd" path="password" /></td>
				</tr>
				<tr>
					<td><label for="cty">Country :</label></td>
					<td><form:select it="cty" path="country">
							<form:option value="" label="Select" />
							<form:option value="IND" label="India" />
							<form:option value="US" label="US" />
							<form:option value="AUS" label="Australia" />
							<form:option value="CAN" label="Canada" />
							<form:option value="S-KOR" label="South Korea" />
						</form:select></td>
				</tr>
				<tr>
					<td><label for="hby">Hobby</label></td>
					<td><form:checkbox path="hobby" value="reading" /> reading</td>
					<td><form:checkbox path="hobby" value="coding" /> coding</td>
					<td><form:checkbox path="hobby" value="dreaming" /> dreaming</td>
				</tr>
				<tr>
					<td><label for="gdr">Gender :</label></td>
					<td><form:radiobutton path="gender" value="Male" /> Male</td>
					<td><form:radiobutton path="gender" value="Female" /> Female</td>
				</tr>
				<tr>
					<td><label for="age">Age :</label></td>
					<td><form:input path="age" id="age" /></td>
					<td><form:errors path="age" cssClass="error" /></td>
				</tr>
				<br/>
				<tr>
					<th><h3>Communication</h3></th>
				</tr>
				<tr>
					<td><label for="eml">Email</label></td>
					<td><form:input id="eml" path="communicationDto.email" /></td>
					<td><form:errors path="communicationDto.email"
							cssClass="error" /></td>
				</tr>
				<tr>
					<td><label for="mobile">Mobile</label></td>
					<td><form:input path="communicationDto.mobile" id="mobile" /></td>
					<td><form:errors path="communicationDto" cssClass="error" /></td>
				</tr>
			</table>
			<br /> <input type="submit" value="Register" />
		</div>
	</form:form>

</body>
</html>

<!--We user Spring MVC Form tag to bind the data in the JSP 
	We can bind the data in the server without using Spring MVC Form Tag. 
	We user Spring MVC Form tag to bind the default data from dto on page load, displaying errors by simply mentioning <form:errors/>
 -->