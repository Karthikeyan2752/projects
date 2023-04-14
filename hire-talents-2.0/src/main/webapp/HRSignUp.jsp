<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR Sign Up Page</title>
<link rel="stylesheet" href="styl.css">
</head>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="HRFunctions.js"></script>
<body>
	<header>
		<h1>HIRE TALENTS</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="About.html">About Us</a></li>
				<li><a href="Report.jsp">Report</a></li>
				<li><a href="Feedback.jsp">Feedback</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h2>HR Sign Up</h2>
		<form action="HRSignUpServlet" method="post"
			onsubmit="return validateFormSignUp()">
			<label for="name"><strong>Name:</strong></label> <input type="text" id="name"
				name="name" required><br>
			<br> <label for="email"><strong>Email:</strong></label> <input type="text"
				id="email" name="email" required><br>
			<br> <label for="password"><strong>Password:</strong></label> <input
				type="password" id="password" name="password" required><br>
				password must include :<ul> 
		    <li>A upper case letter</li>
		    <li>A lower case letter</li>
		    <li>A special character letter</li>
		    <li>A number</li></ul>
			<br> <label for="repassword"><strong>Re-enter Password:</strong></label> <input
				type="password" id="repassword" name="repassword" required><br>
			<br> <label for="contact"><strong>Contact Number:</strong></label> <input
				type="text" id="contact" name="contact" required><br>
			<br> <label for="companyName"><strong>Company Name:</strong></label> <input
				type="text" id="companyName" name="companyName" required><br>
			<br>
			<center><button type="submit">Sign Up</button></center>
		</form>

	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
