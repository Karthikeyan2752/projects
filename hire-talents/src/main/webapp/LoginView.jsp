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
				<li><a href="#">About Us</a></li>
				<li><a href="#">Report</a></li>
				<li><a href="#">Feedback</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h2>Welcome to hire talents!</h2>
		<p>Looking for the perfect job candidate or searching for your
			dream job? We're here to help you every step of the way.</p>
		<form action="UserLoginView.jsp">
			<button type="submit">User Login</button>
		</form>
		<br>
		<form action="HRLoginView.jsp">
			<button type="submit">HR Login</button>
		</form>
	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
