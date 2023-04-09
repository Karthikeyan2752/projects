<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR Sign Up Page</title>
<link rel="stylesheet" href="styl.css">
</head>
	<script>
		function validateForm() {
		  var name = document.getElementById("name").value;
		  var email = document.getElementById("email").value;
		  var password = document.getElementById("password").value;
		  var repassword = document.getElementById("repassword").value;
		  var contact = document.getElementById("contact").value;
		  var companyName = document.getElementById("companyName").value;
		  
		  var contactRegex = /^[0-9]{10}$/;
		  if(!contactRegex.test(contact)){
			  alert("Please enter a valid mobile number");
			  return false;
		  }
		
		  
		  var nameRegex = /^[a-zA-Z ]+$/;
		  if (!nameRegex.test(name)) {
		    alert("Please enter a valid name");
		    return false;
		  }
		  
		  if(!nameRegex.test(companyName)){
			  alert("Please enter a valid company name");
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
		<h2>HR Sign Up</h2>
		<form action="HRSignUpServlet" method="post" onsubmit="return validateForm()">
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
		    <label for="companyName">Company Name:</label>
		    <input type="text" id="companyName" name="companyName"><br><br>
		    <button type="submit">Sign Up</button>
		    <button type="reset">Reset</button>
		</form>

	</main>
	<footer>
		<p>&copy; 2023 Resilience Cyber Solutions. All rights reserved.</p>
	</footer>
</body>
</html>
