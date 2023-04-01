<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="com.model.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home Page</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
</head>
	<body>
		<header>
		<%String name = (String) session.getAttribute("name"); %>
			<h1>WELCOME <% out.println(name); %></h1>
			<nav>
				<ul>
					<li><a href="LoginView.jsp">Home</a></li>
					<li><a href="About.html">About Us</a></li>
					<li><a href="Report.jsp">Report</a></li>
					<li><a href="FeedBack.jsp">Feedback</a></li>
				</ul>
			</nav>
		</header>
		<main>
			<div>
				<a href="Profile.jsp" >View/Edit Profile</a>
			</div>
			<div>
				<a href="ShowJobs.jsp">Search for Jobs</a>
			</div>
			<div>
				<a href="CallLetters.jsp">Call Letters</a>
			</div>
			<div>
				<a href="AppliedJobs.jsp">View Applied Jobs</a>
			</div>
			<div>
				<a href="UserLogout.jsp">Logout</a>
		</div>
	</main>

	<footer>
		<p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
	</footer>
</body>	
			