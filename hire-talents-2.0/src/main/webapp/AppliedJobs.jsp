<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.JobNotification"%>
<%@ page import="com.repository.DB"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APPLIED JOBS</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="jobs.css">
</head>
<body>
	<div id="header">
	  <header>
	  <%String name =(String) session.getAttribute("name");
	  	String about = (String) session.getAttribute("about");
	  	int appliedJobs = (Integer) session.getAttribute("appliedJobs");
	  	int selectedJobs = (Integer) session.getAttribute("selectedJobs");
	  	%>
	    <h1>Hire Talents</h1>
	    <nav>
	      <ul>
	      	 <li>
	          <div class="search-bar" >
	            <input id="searchText" class="search-input" type="text" placeholder="Search for jobs">
	            <i onclick="searchInAppliedJobs()" class="search-icon fas fa-search"></i>
	          </div>
	        </li>
	        <li><button class="nav-button" onclick="feed()">Home</button></li>
	        <li><button class="nav-button" onclick="showCallLetters()">Call Letters</button></li>
	      </ul>
	    </nav>
	  </header>
	</div>

	<main id ="main">
		  <div id="profile">
	  <div class="profile-details">
	    <i class="fas fa-user-circle profile-icon"></i>
	    <h3><%= name %></h3>
	    <p><%=about %></p>
	    <br>
	    <p><strong>Applied Jobs:</strong> <%=appliedJobs %></p>
	    <p><strong>Selected Jobs:</strong> <%=selectedJobs %></p>
	    <button class="btn btn-primary edit-profile-button">Edit Profile</button>
	    <button class="btn btn-primary edit-profile-button" onclick="window.location.href='UserLogout.jsp'">   Logout   </button>
	  </div>
	</div>
		<div id="post-container"></div>
	</main>
	
	<footer>
	  <p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	  
	  	<p><a href='About.html'>About Us</a>
	   <a href='Report.jsp'>Report</a>
	   <a href='Feedback.jsp'>Feedback</a></p>
	   
	</footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
