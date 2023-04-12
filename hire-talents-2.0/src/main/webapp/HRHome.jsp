<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.model.JobNotification"%>
<%@ page import="com.repository.DB"%>
<%@ page import="com.model.User"%>
<%@ page import="com.model.HR"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR HOME PAGE</title>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="jobs.css">
<script src="HRFunctions.js"></script>
</head>
<body id="body" onload="feed()">
	<div id="header">
		<header>
			<%
			String companyName = (String) session.getAttribute("companyName");
			String about = (String) session.getAttribute("about");
			int postedJobs = (Integer) session.getAttribute("postedJobs");
			int hiredCandidates = (Integer) session.getAttribute("hiredCandidates");
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
					<li><button class="nav-button" onclick="automate()">Automate Hiring</button></li>
					<li><button class="nav-button" onclick="post()">Post Job</button></li>
					<li><button class="nav-button" onclick="insights()">Insights</button></li>
				</ul>
			</nav>
		</header>
		<br>
	</div>

	<main id="main">
		<div id = "home">
		<div id="profile">
			<div class="profile-details">
				<i class="fa-sharp fa-regular fa-buildings"></i>
				<h3><%=companyName%></h3>
				<p><%=about%></p>
				<br>
				<p>
					<strong>Posted Jobs:</strong>
					<%=postedJobs%></p>
				<p>
					<strong>Hired candidates:</strong>
					<%=hiredCandidates%></p>
				<button class="btn btn-primary edit-profile-button"
					onclick="editInfo()">Edit Info</button>
				<button class="btn btn-primary edit-profile-button"
					onclick="window.location.href='UserLogout.jsp'">Logout</button>
			</div>
		</div>
		<div id="post-container"></div>
		</div>
		<div id="home2" style="display: 'none'"></div>
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
	<div id="toast"><div id="img"></div><div id="desc"></div></div>	
</body>
</html>
