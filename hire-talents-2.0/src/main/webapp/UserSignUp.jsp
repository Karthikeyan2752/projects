<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Sign Up Page</title>
<link rel="stylesheet" href="styl.css">
</head>
<script>
function validateForm() {
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  var repassword = document.getElementById("repassword").value;
  var contact = document.getElementById("contact").value;
  var skills = document.getElementById("skills").value;
  var qualification = document.getElementById("qualification").value;
  
  var contactRegex = /^[0-9]{10}$/;
  if(!contactRegex.test(contact)){
	  alert("Please enter a valid mobile number");
	  return false;
  }
  
  var skillRegex = /^[a-zA-Z0-9]+(?:,[a-zA-Z0-9]+)*$/;
  if(!skillRegex.test(skills)){
	  alert("Please enter valid skills");
	  return false;
  }
  
  var qualificationRegex = /^([a-zA-Z]+\.)?[a-zA-Z\s]+$/;
  if(!qualificationRegex.test(qualification)){
	  alert("Please enter a valid qualification");
	  return false;
  }
  
  var nameRegex = /^[a-zA-Z ]+$/;
  if (!nameRegex.test(name)) {
    alert("Please enter a valid name");
    return false;
  }

  
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    alert("Please enter a valid email address");
    return false;
  }

  
  var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
  if (!passwordRegex.test(password)) {
    alert("Please enter a valid password. Password must contain at least 8 characters, including at least one uppercase letter, one lowercase letter, one digit, and one special character (!@#$%^&*)");
    return false;
  }

  if (password !== repassword) {
    alert("Passwords don't match. Please re-enter password");
    return false;
  }

  return true;
}
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
		<h2>User Sign Up</h2>
		<form action="UserSignUpServlet" method="post" onsubmit="return validateForm()">
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
		    <input type="text" id="skills" name="skills" placeholder = "enter the skills separated by commas" required><br><br>
		    <label for="qualification">Highest Qualification:</label>
		    <input type="text" id="qualification" name="qualification" required><br><br>
		    <label for="experience">Experience:</label>
		    <input type="number" id="experience" name="experience" required><br><br>
		    <label for="location">Location:</label>
		    <input type="text" id="location" name="location" required><br><br>
		    <label for="about">Write something about you:</label>
		    <input type="text" id="about" name="about" required><br><br>
		    <button type="submit">Sign Up</button>
		    <button type="reset">Reset</button>
		</form>
	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
