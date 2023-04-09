<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.model.JobNotification" %>
<%@ page import="com.repository.DB" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Post a job</title>
	<link rel="stylesheet" href="styl.css">
	<script>
		function validateForm() {
		  var title = document.getElementById("jobTitle").value;
		  var skills = document.getElementById("skills").value;
		  
		  var skillRegex = /^[a-zA-Z0-9]+(?:,[a-zA-Z0-9]+)*$/;
		  if(!skillRegex.test(skills)){
			  alert("Please enter valid skills");
			  return false;
		  }
		 
		  var nameRegex = /^[a-zA-Z ]+$/;
		  if (!nameRegex.test(title)) {
		    alert("Please enter a valid name");
		    return false;
		  }
	
		  showSuccessMessage();
		  return true;
		}
		 function showSuccessMessage() {
	            alert("Job posted successfully");
	     }
	</script>
</head>
<body>
	<header>
		<h1>Post a job</h1>
		<nav>
			<ul>
				<li><a href="HRHome.jsp">Home</a></li>
				<li><a href="Automate.jsp">Automate recruitment</a></li>
				<li><a href="Insights.jsp">Insights</a></li>
				<li><a href="Logout.jsp">Logout</a></li>
			</ul>
		</nav>
	</header>
	<main>
		<form action="PostJob" method="post" onsubmit="return validateForm()">

	
			<label for="jobTitle">Job Title:</label>
			<input type="text" id="jobTitle" name="jobTitle" required>

			<label for="description">Job Description:</label>
			<textarea id="description" name="description" required></textarea><br><br>

			<label for="applicationEndDate">Application End Date:</label>
			<input type="date" id="applicationEndDate" name="applicationEndDate" required><br><br>

			<label for="skills">Skills Required:</label>
			<input type="text" id="skills" name="skills" required><br><br>

			<label for="numberOfVacancies">Number of Vacancies:</label>
			<input type="number" id="numberOfVacancies" name="numberOfVacancies" required><br><br>
			<button type="submit">Post Job</button>
			<button type="reset">Reset</button>
		</form>
			
	</main>
</body>
</html>
