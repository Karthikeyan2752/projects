<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.model.JobNotification" %>
<%@ page import = "com.repository.DB" %>
<%@ page import = "java.util.*"  %>
<!DOCTYPE html>
<html>
<head>
	<title>Call Letters</title>
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
	<h1>Call Letters</h1>
	<%
		int userID = (Integer)session.getAttribute("userID");
		List<JobNotification> jobNotifications = DB.getInstance().getCallLetters(userID);		
		if (jobNotifications != null && !jobNotifications.isEmpty()) {
			for (JobNotification job : jobNotifications) {
	%>
		<div class="call-letter">
			<h2>Call Letter for <%= job.getJobTitle() %></h2>
			<p>Dear Candidate,</p>
			<p>We are pleased to inform you that you have been shortlisted for the position of <%= job.getJobTitle() %>.</p>
			<p>Your interview has been scheduled on <%= job.getApplicationEndDate() %> at our office.</p>
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
