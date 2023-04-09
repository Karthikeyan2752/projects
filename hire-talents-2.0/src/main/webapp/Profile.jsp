<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>User Profile</title>
	<link rel="stylesheet"  href="styl.css">
</head>
<script>
function validateForm() {
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
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


  return true;
}
</script>
<body>
<header>
  <%String name = (String) session.getAttribute("name"); %>
			<h1><% out.println(name); %></h1>
  <nav>
			<ul>
				<li><a href="UserHomePage.jsp">Home</a></li>
				<li><a href="CallLetters.jsp">Call Letters</a></li>
				<li><a href="AppliedJobs.jsp">AppliedJobs</a></li>
				<li><a href="About.html">About Us</a></li>
				<li><a href="Report.jsp">Report</a></li>
				<li><a href="Feedback.jsp">Feedback</a></li>
				<li><a href="UserLogout.jsp">Logout</a></li>

			</ul>
		</nav>
</header>
<main>
		<h1>User Profile</h1>
		<form action="SaveProfileServlet" method="POST" onsubmit="return validateForm()">
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" value="<%= session.getAttribute("name") %>"><br>

			<label for="mobileNumber">Mobile Number:</label>
			<input type="text" id="mobileNumber" name="mobileNumber" value="<%= session.getAttribute("mobileNumber") %>"><br>

			<label for="skills">Skills:</label>
			<input type="text" id="skills" name="skills" value="<%= session.getAttribute("skills") %>"><br>

			<label for="qualification">Qualification:</label>
			<input type="text" id="qualification" name="qualification" value="<%= session.getAttribute("qualification") %>"><br>

			<label for="email">Email:</label>
			<input type="text" id="email" name="email" value="<%= session.getAttribute("email") %>"><br>

			<label for="experience">Experience:</label>
			<input type="text" id="experience" name="experience" value="<%= session.getAttribute("experience") %>"><br>

			<button type="submit">Save</button>
		</form>
	</main>
</body>
</html>
