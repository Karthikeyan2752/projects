<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>User Registration</title>
</head>
<body>
	<h1>User Registration</h1>
	<form id="registrationForm" method="post" action="register">
		<label for="username">Username:</label> 
		<input type="text" id="username" name="username" required> <br> 
		<label for="email">Email:</label> 
		<input type="email" id="email"name="email" required> <br> 
		<label for="password">Password:</label>
		<input type="password" id="password" name="password" required>
		<br> <input type="submit" value="Register">
	</form>

	<script>
		document
				.getElementById('registrationForm')
				.addEventListener(
						'submit',
						function(event) {
							event.preventDefault();

							var formData = {
								username : document.getElementById('username').value,
								email : document.getElementById('email').value,
								password : document.getElementById('password').value
							};

							var xhr = new XMLHttpRequest();
							xhr.open('POST', 'register', true);
							xhr.setRequestHeader('Content-Type',
									'application/json');
							xhr.onload = function() {
								if (xhr.status >= 200 && xhr.status < 300) {
									console.log('Registration successful');
									window.location.href = "RegistrationSuccess.jsp";
								} else {

									var errorMessage = 'Registration failed with status code '+ xhr.status;
									console.error(errorMessage);

									var errorDiv = document.getElementById('error-message');
									errorDiv.textContent = 'Registration failed. Please try again later.';
									errorDiv.style.color = 'red';
								}
							};

							xhr.onerror = function() {

								console
										.error('Network error occurred. Registration failed.');

								var errorDiv = document
										.getElementById('error-message');
								errorDiv.textContent = 'Network error. Please check your internet connection.';
								errorDiv.style.color = 'red';
							};

							var jsonData = JSON.stringify(formData);

							xhr.send(jsonData);
						});
	</script>
</body>
</html>
