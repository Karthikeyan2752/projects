<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Sign Up Page</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="styl.css">
</head>
<script type="text/javascript" src="script.js"></script>
<script>

</script>

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
		<h2><strong>User Sign Up</strong></h2>
		<form action="UserSignUpServlet" method="post" onsubmit="return validateFormSignUp()">
		    <label for="name"><strong>Name:</strong></label>
		    <input type="text" id="name" name="name" required><br><br>
		    <label for="email"><strong>Email:</strong></label>
		    <input type="email" id="email" name="email" required><br><br>
		    <label for="password"><strong>Password:</strong></label>
		   	password must include :<ul> 
		    <li>A upper case letter</li>
		    <li>A lower case letter</li>
		    <li>A special character letter</li>
		    <li>A number</li></ul>
		    <input type="password" id="password" name="password" required><br><br>
		    <label for="repassword"><strong>Re-enter Password:</strong></label>
		    <input type="password" id="repassword" name="repassword" required><br><br>
		    <label for="contact"><strong>Contact Number:</strong></label>
		    <input type="text" id="contact" name="contact" required><br><br>
		    <label for="skills"><strong>Skills:</strong></label>
		    <input type="text" id="skills" name="skills" placeholder = "enter the skills separated by commas" required><br><br>
		    <label for="qualification"><strong>Highest Qualification:</strong></label>
		    <input type="text" id="qualification" name="qualification" required><br><br>
		    <label for="experience"><strong>Experience:</strong></label>
		    <input type="number" id="experience" name="experience" required><br><br>
		    <label for="location"><strong>Location:</strong></label>
		    <input type="text" id="location" name="location" required><br><br>
		    <label for="about"><strong>Write something about you:</strong></label>
		    <input type="text" id="about" name="about" required><br><br>
		    <center><button style="align-self: center;" type="submit">Sign Up</button></center>
		</form>
	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
