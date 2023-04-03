<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.model.JobNotification"%> 
<%@ page import = "com.model.HR"%>       
<%@ page import = "com.repository.DB"%>
<%@ page import = "java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HR Home page</title>

<link rel="stylesheet" href="styl.css">
</head>
<body>
<% int HRID = (Integer) session.getAttribute("userID");
  List<JobNotification> jobs = DB.getInstance().getJobs(HRID);
  HR hr = DB.getInstance().getHR(HRID);
  %>
	<header>
  		<h1>Welcome <%= hr.getName() %></h1>
		<nav>
				<ul>
					<li><a href="PostJob.jsp">Post a Job</a></li>
					<li><a href="Automate.jsp">Automate recruitment</a></li>
					<li><a href="Insights.jsp">Insights</a></li>
					<li><a href="UserLogout.jsp">Logout</a></li>
				</ul>
			</nav>

	</header>
	<main>
 	<div id="posts-container">
  <% 
  for (JobNotification job : jobs) { %>
     <div class="post">
     <div align="center">
      <h2><%= job.getName() %></h2></div>
      <p><%= job.getDescription() %></p>
      <p><strong>Skills:</strong> <%= job.getSkills() %></p>
      <p><strong>Number of vacancies:</strong> <%= job.getNumberOfVacancies() %></p>
      <p><strong>Application end date:</strong> <%= job.getApplicationEndDate()%></p>
     <div align="center" > 
     <form action="AppliedCandidates.jsp">
		  <button class="apply-button" type="submit" value="<%= job.getID() %>" name="jobID">View Applied candidates</button>
	  </form>
	  </div>
	  <br>
	  <hr><br>
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
