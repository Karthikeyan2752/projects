<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List"%>
<%@ page import = "com.model.User"%>
<%@ page import = "com.repository.DB"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applied Candidates</title>
<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="jobs.css">
<script src="script.js"></script>
</head>
<body>
  <header>
  <h1>Job Posts</h1>
</header>

<main>
  <div id="posts-container">
    <% 
    int jobID = Integer.parseInt(request.getParameter("jobID"));
   // session.setAttribute("jobID", jobID);
    List<User> candidates = DB.getInstance().getAppliedCandidates(jobID);
    if(candidates.isEmpty()){%>
    	<h2>No candidates applied</h2>
    <%}
    for (User candidate : candidates) { %>
      <div class="post">
        <h2><%= candidate.getName() %></h2>
        <p><strong>Skills:</strong> <%= candidate.getSkills() %></p>
        <p><strong>Qualification:</strong> <%= candidate.getQualification() %></p>
        <p><strong>Experience:</strong> <%= candidate.getExperience() %></p>
        <p><strong>Email:</strong> <%= candidate.getEmail() %></p>
        <p><strong>Mobile Number:</strong> <%= candidate.getMobileNumber() %></p>
        <button class="apply-button" onclick="sendCallLetter(this,<%= candidate.getUserID() %>,<%= jobID %>)">Send Call Letter</button>
        <button class="apply-button" onclick="removeCandidate(this,<%= candidate.getUserID() %>,<%= jobID %>)">Remove</button>
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
