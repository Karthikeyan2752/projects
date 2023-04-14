<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.JobNotification"%>
<%@ page import="com.repository.DB"%>
<%@ page import="com.model.User"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Posts</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="jobs.css">
<script src="script.js"></script>
</head>
<body id="body" onload="feed()">
	<div id="header">
		<header>
			<%
			String name = (String) session.getAttribute("name");
			String about = (String) session.getAttribute("about");
			int appliedJobs = (Integer) session.getAttribute("appliedJobs");
			int selectedJobs = (Integer) session.getAttribute("selectedJobs");
			%>
			<h1>Hire Talents</h1>
			<nav>
				<ul>
					<li>
						<div class="search-bar">
							<input id="searchText" class="search-input" type="text"
								placeholder="Search for jobs"> <i onclick="search()"
								class="search-icon fas fa-search"></i>
						</div>
					</li>
					<li><button class="nav-button" onclick="feed()">Home</button></li>
					<li><button class="nav-button" onclick="callLetters()">Call
							Letters</button></li>
					<li><button class="nav-button" onclick="appliedJobs()">Applied
							Jobs</button></li>
				</ul>
			</nav>
		</header>
		<br>
	</div>

	<main id="main">
		<div id="home">
			<div id="profile">
				<div class="profile-details">
					<i class="fas fa-user-circle profile-icon"></i>
					<h3><%=name%></h3>
					<p><%=about%></p>
					<br>
					<p>
						<strong>Applied Jobs:</strong>
						<%=appliedJobs%></p>
					<p>
						<strong>Selected Jobs:</strong>
						<%=selectedJobs%></p>
					<button class="btn btn-primary edit-profile-button"
						onclick="editProfile()">Edit Profile</button>
					<button class="btn btn-primary edit-profile-button"
						onclick="window.location.href='UserLogout.jsp'">Logout</button>
				</div>
			</div>
			<div id="post-container"></div>
			<div id="call-letter"></div>
		</div>
		<div id="home2" style="display:'none';"></div>
	</main>
	
	<br><br>
	<footer style="text-align: center;">
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>

		<p>
			<a href='About.html'>About Us</a> <a href='Report.jsp'>Report</a> <a
				href='Feedback.jsp'>Feedback</a>
		</p>

	</footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
