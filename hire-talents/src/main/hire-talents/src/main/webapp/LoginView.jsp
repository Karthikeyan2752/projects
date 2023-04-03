<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HIRE TALENTS</title>
<link rel="stylesheet" href="styl.css">
</head>
<body>
	<header>
		<h1>HIRE TALENTS</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="About.html">About Us</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h2>Welcome to hire talents!</h2>
		<div align="center">
		<p>Searching for your dream job, We're here to help you every step of the way.</p>
		<form action="UserLoginView.jsp">
			<button type="submit">User Login</button>
		</form>
		<br>
		<p>Looking for the perfect job candidate, We're here to help you every step of the way.</p>
		
		<form action="HRLoginView.jsp">
			<button type="submit">HR Login</button>
		</form>
		</div>
	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
