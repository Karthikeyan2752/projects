<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login Page</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
		<form action="UserLoginS" >
			<label for="email">Email ID:</label>
			<input type="text" id="email" name="email" required ><br><br>
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" required><br><br>
			<button type="submit">Sign In</button>
			<button type="button" onclick="window.location.href='UserSignUp.jsp'">New User</button>
		</form>
		
	</main>
	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
