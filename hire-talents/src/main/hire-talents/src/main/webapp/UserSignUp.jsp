<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Sign Up Page</title>
<link rel="stylesheet" href="styl.css">
</head>
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
		<h2>User Sign Up</h2>
		<form action="UserSignUpServlet" method="post">
		    <label for="name">Name:</label>
		    <input type="text" id="name" name="name" required><br><br>
		    <label for="email">Email:</label>
		    <input type="email" id="email" name="email" required><br><br>
		    <label for="password">Password:</label>
		    <input type="password" id="password" name="password" required><br><br>
		    <label for="repassword">Re-enter Password:</label>
		    <input type="password" id="repassword" name="repassword" required><br><br>
		    <label for="contact">Contact Number:</label>
		    <input type="text" id="contact" name="contact" required><br><br>
		    <label for="skills">Skills:</label>
		    <input type="text" id="skills" name="skills" placeholder = "enter the skills separated by commas"><br><br>
		    <label for="qualification">Qualification:</label>
		    <input type="text" id="qualification" name="qualification"><br><br>
		    <label for="experience">Experience:</label>
		    <input type="number" id="experience" name="experience"><br><br>
		    <button type="submit">Sign Up</button>
		    <button type="reset">Reset</button>
		</form>

	</main>
	<% if(request.getParameter("error") != null) { %>
			<script>
				alert("Re-entered password doesn't match!, Try Again");
			</script>
		<% } %>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
