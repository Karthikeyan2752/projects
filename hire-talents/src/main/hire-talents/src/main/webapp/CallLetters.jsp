<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.model.JobNotification" %>
<%@ page import = "com.repository.DB" %>
<%@ page import = "java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
	<title>Call Letters</title>
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="styl.css">
	<style type="text/css">
		body {
			font-family: Arial, sans-serif;
			font-size: 14px;
			background-color: #f5f5f5;
			padding: 10px;
		}
		h1 {
			font-size: 24px;
			margin-bottom: 20px;
		}
		.call-letter {
			background-color: #fff;
			border: 1px solid #ddd;
			padding: 20px;
			margin-bottom: 20px;
			box-shadow: 0 2px 4px rgba(0,0,0,0.1);
		}
		.call-letter h2 {
			font-size: 18px;
			margin-bottom: 10px;
		}
		.call-letter p {
			margin-bottom: 5px;
		}
		.call-letter .hr-info {
			margin-top: 20px;
			border-top: 1px solid #ddd;
			padding-top: 10px;
		}
		.call-letter .hr-info h3 {
			font-size: 16px;
			margin-bottom: 5px;
		}
		.call-letter .hr-info p {
			margin-bottom: 5px;
		}
	</style>
</head>
<body>
	<header>
		<%String name = (String) session.getAttribute("name"); %>
			<h1>CallLetters for <% out.println(name); %></h1>
			<nav>
				<ul>
				<li><li><a href="UserHomePage.jsp">Home</a></li>
				<li><a href="Profile.jsp">View/Edit Profile</a></li>
				<li><a href="AppliedJobs.jsp">AppliedJobs</a></li>
				<li><a href="About.html">About Us</a></li>
				<li><a href="Report.jsp">Report</a></li>
				<li><a href="Feedback.jsp">Feedback</a></li>
				<li><a href="UserLogout.jsp">Logout</a></li>
				</ul>
			</nav>
		</header>
	<%
		int userID = (Integer)session.getAttribute("userID");
		List<JobNotification> jobNotifications = DB.getInstance().getCallLetters(userID);
		 
		if (jobNotifications != null && !jobNotifications.isEmpty()) {
			for (JobNotification job : jobNotifications) {
	%>	<main>
		<div class="call-letter">
			<h2>Call Letter for <%= job.getJobTitle() %></h2>
			<p>Dear Candidate,</p>
			<p>We are pleased to inform you that you have been shortlisted for the position of <%= job.getJobTitle() %>.</p>
			<p>Your interview has been scheduled on <%= job.getApplicationEndDate()%> at our office.</p>
			<p>Please bring the following documents for verification:</p>
			<ul>
				<li>Resume/CV</li>
				<li>Photo ID</li>
				<li>Educational Certificates</li>
				<li>Work Experience Certificates</li>
			</ul>
			<div class="hr-info">
				<h3>HR Contact Information</h3>
				<p>Name: <%= job.getHr().getName() %></p>
				<p>Company: <%= job.getHr().getCompanyName() %></p>
				<p>Mobile: <%= job.getHr().getMobileNumber() %></p>
				<p>Email: <%= job.getHr().getEmail() %></p>
			</div>
		</div>
		</main>
	<%
			}
		} else {
	%>
		<p>No call letters available.</p>
	<%
		}
	%>
</body>
</html>
