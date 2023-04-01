<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "com.model.JobNotification" %>
 <%@ page import = "com.repository.DB" %>
 <%@ page import = "java.util.*"  %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APPLIED JOBS</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="jobs.css">
</head>
<body>

<header>
  <h1>Job Posts</h1>
</header>

<main>
  <div id="posts-container">
    <%-- Iterate over the list of job posts and create a div for each one --%>
    <%
    int userID = (Integer)session.getAttribute("userID");	
    List<JobNotification> jobList = DB.getInstance().getAppliedJobs(userID);
    for (JobNotification job : jobList) {
    %>
    <div class="post">
      <h2><%= job.getName() %></h2>
      <p><%= job.getDescription() %></p>
      <p><strong>Skills:</strong> <%= job.getSkills() %></p>
      <p><strong>Number of vacancies:</strong> <%= job.getNumberOfVacancies() %></p>
      <p><strong>Application end date:</strong> <%= job.getApplicationEndDate() %></p>
    </div>
    <%-- End of job post div --%>
    <% } %>
  </div>
</main>

<footer>
  <p>&copy; 2023 Resilient Cyber Solutions. All rights reserved.</p>
</footer>

</body>
</html>
