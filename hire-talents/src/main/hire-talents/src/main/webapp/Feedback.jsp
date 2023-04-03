<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Feedback page</title>
<link rel="stylesheet" href="styl.css">
</head>
<body>
	<header>
		<h1>Our success depends on your feedback</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="About.html">About Us</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<h2>Give your feedback</h2>
		<form action="FeedbackServlet" method="post">
			<label for="feedback">Type your valuable feedback:</label>
			<textarea id="feedback" name="feedback"></textarea><br><br>
			<button type="submit">Submit</button>
		</form>
			
	</main>
	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
