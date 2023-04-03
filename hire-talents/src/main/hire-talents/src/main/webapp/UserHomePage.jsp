<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "com.model.JobNotification" %>
 <%@ page import = "com.repository.DB" %>
 <%@ page import = "java.util.*"  %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Posts</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="jobs.css">
<script src="script.js"></script>
</head>
<body>

<header>
  <%String name = (String) session.getAttribute("name"); %>
			<h1>WELCOME <% out.println(name); %></h1>
  <nav>
			<ul>
				<li><a href="Profile.jsp">View/Edit Profile</a></li>
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
  <div id="posts-container">
    <%-- Iterate over the list of job posts and create a div for each one --%>
    <%
    int userID = (Integer)session.getAttribute("userID");	
    List<JobNotification> jobList = DB.getInstance().getJobsUserNotApplied(userID);
    if(jobList.isEmpty()){%>
       	<h2>No jobs available</h2>
    <%}
    for (JobNotification job : jobList) {
    %>
    <div class="post">
      <h2><%= job.getName() %></h2>
      <p><%= job.getDescription() %></p>
      <p><strong>Skills:</strong> <%= job.getSkills() %></p>
      <p><strong>Number of vacancies:</strong> <%= job.getNumberOfVacancies() %></p>
      <p><strong>Application end date:</strong> <%= job.getApplicationEndDate() %></p>
     <button class="apply-button" onclick="apply(this,<%= job.getID()%>)">Apply</button>
    </div>
    <br>
  
    <% } %>
  </div>
</main>

<footer>
  <p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
</footer>

</body>
</html>
