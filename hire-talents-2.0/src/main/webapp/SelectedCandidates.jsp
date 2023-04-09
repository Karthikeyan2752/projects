<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "com.model.User"%>
<%@ page import = "com.hrcontrols.HRControlViewModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selected Candidates</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="styl.css">
<script src="script.js"></script>
</head>
<body>
  <header>
  <h1>Selected Candidates</h1>
  <nav>
				<ul>
					<li><a href="PostJob.jsp">Post a Job</a></li>
					<li><a href="HRHome.jsp">Home</a></li>
					<li><a href="Insights.jsp">Insights</a></li>
					<li><a href="UserLogout.jsp">Logout</a></li>
				</ul>
			</nav>
</header>

<main>
  <div id="posts-container">
    <% 
    int jobID = Integer.parseInt(request.getParameter("jobID"));
    List<User> candidates = new HRControlViewModel().automateRecruitment(jobID);
    if(candidates.isEmpty()){%>
    	<h2>No candidates matched</h2>
   <%}
    for (User candidate : candidates) { %>
      <div class="post">
        <h2><%= candidate.getName() %></h2>
        <p><strong>Skills:</strong> <%= candidate.getSkills() %></p>
        <p><strong>Qualification:</strong> <%= candidate.getQualification() %></p>
        <p><strong>Experience:</strong> <%= candidate.getExperience() %></p>
        <p><strong>Email:</strong> <%= candidate.getEmail() %></p>
        <p><strong>Mobile Number:</strong> <%= candidate.getMobileNumber() %></p>
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
