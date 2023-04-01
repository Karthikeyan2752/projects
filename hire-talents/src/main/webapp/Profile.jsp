<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>User Profile</title>
	<link rel="stylesheet" type="text/css" href="profile.css">
</head>
<body>
	<div class="profile" align="center">
		<h1>User Profile</h1>
		<form action="SaveProfileServlet" method="POST">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" value="<%= session.getAttribute("name") %>"><br>

			<label for="mobileNumber">Mobile Number:</label>
			<input type="text" id="mobileNumber" name="mobileNumber" value="<%= session.getAttribute("mobileNumber") %>"><br>

			<label for="skills">Skills:</label>
			<input type="text" id="skills" name="skills" value="<%= session.getAttribute("skills") %>"><br>

			<label for="qualification">Qualification:</label>
			<input type="text" id="qualification" name="qualification" value="<%= session.getAttribute("qualification") %>"><br>

			<label for="email">Email:</label>
			<input type="text" id="email" name="email" value="<%= session.getAttribute("email") %>"><br>

			<label for="experience">Experience:</label>
			<input type="text" id="experience" name="experience" value="<%= session.getAttribute("experience") %>"><br>

			<input type="submit" value="Save">
		</form>
	</div>
</body>
</html>
