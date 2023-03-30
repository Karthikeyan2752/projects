<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<link rel="stylesheet" href="styl.css">
</head>
<body>
	<header>
		<h1>HIRE TALENTS</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="#">About Us</a></li>
				<li><a href="#">Report</a></li>
				<li><a href="#">Feedback</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h2>User Login</h2>
		<form action="UserLoginS" method = "post">
			<label for="userid">User ID:</label>
			<input type="text" id="userid" name="userid"><br><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password"><br><br>
			<button type="submit">Sign In</button>
			<button type="button" onclick="window.location.href='UserSignUp.jsp'">New User</button>
		</form>
	</main>
	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
