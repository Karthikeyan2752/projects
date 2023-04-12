<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR Login Page</title>
<link rel="stylesheet" href="styl.css">
</head>
<body>
	<header>
	<div class="logo"></div>
		<h1>HIRE TALENTS</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="About.html">About Us</a></li>

			</ul>
		</nav>
	</header>
	<main>
		<h2>User Login</h2>
		<form action="HRLoginS" method="post">
			<label for="email">Email ID:</label>
			<input type="text" id="email" name="email" ><br><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password"><br><br>
			<button type="submit">Sign In</button>
			<button type="button" onclick="window.location.href='HRSignUp.jsp'">New User</button>
		</form>
		
	</main>
	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
