<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Report page</title>
<link rel="stylesheet" href="styl.css">
</head>
<body>
	<header>
		<h1>We are sorry for the inconvenience!</h1>
		<nav>
			<ul>
				<li><a href="LoginView.jsp">Home</a></li>
				<li><a href="About.html">About Us</a></li>

			</ul>
		</nav>
	</header>
	<main>
		<h2>Report An Issue</h2>
		<form action="ReportServlet" method="post">
			<label for="issue">What type of issue your are facing?</label>
			<input type="text" id="issue" name="issue" required><br><br>
			<label for="description">Eloborate the issue:</label>
			<textarea id="description" name="description" required></textarea><br><br>
			<button type="submit">Report</button>
		</form>
			
	</main>
	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
