function redirectToAppliedCandidates(jobID) {
	sessionStorage.setItem('jobID', jobID);
	window.location.href = 'AppliedCandidates.jsp';
}
function callLetters(){
	var postContainer = document.getElementById('post-container');
	postContainer.innerHTML =`<div class="post"><h2>Call Letters</h2></div>`;
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
				var jobs = response.jobs;
				var html = '';
				for (var i = 0; i < jobs.length; i++){
					html += '<div class="post">';
					html += '<h2>' + jobs[i].title + '</h2>';
					html += '<p>' + jobs[i].description + '</p>';
					html += '<p class="skills"><i class="fas fa-tasks"></i>Skills: ' + jobs[i].skill + '</p>';
					html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
					html += '<p><strong>Requirements:</strong> ' + jobs[i].requirement + '</p>';
					html += '<p><strong>Responsibilities:</strong> ' + jobs[i].responsibilities + '</p>';
					html += '<p><strong>Work Mode:</strong> ' + jobs[i].type + '</p>';
					html += '<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ' + jobs[i].location + '</p>';
					html += '<p><strong>Experience:</strong> ' + jobs[i].experience + '</p>';
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				alert('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'CallLetters?page=' + page, true);
	//xhrInit.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhrInit.send();
	
	window.addEventListener('scroll', function() {
		
		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {
			
			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var jobs = response.callLetters;
							var html = '';
							for (var i = 0; i < jobs.length; i++) {

								html += '<div class="post">';
								html += '<h2>' + jobs[i].title + '</h2>';
								html += '<p>' + jobs[i].description + '</p>';
								html += '<p class="skills"><i class="fas fa-tasks"></i>Skills: ' + jobs[i].skill + '</p>';
								html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
								html += '<p><strong>Requirements:</strong> ' + jobs[i].requirement + '</p>';
								html += '<p><strong>Responsibilities:</strong> ' + jobs[i].responsibilities + '</p>';
								html += '<p><strong>Work Mode:</strong> ' + jobs[i].type + '</p>';
								html += '<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ' + jobs[i].location + '</p>';
								html += '<p><strong>Experience:</strong> ' + jobs[i].experience + '</p>';
								html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							alert('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhrInit.open('GET', 'CallLetters?page=' + page, true);
				//xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				xhr.send();
			}
		}
	});

}
function search(){
	var designation = document.getElementById("searchText").value;
	var postContainer = document.getElementById('post-container');
	postContainer.innerHTML =`<div class="post"><h2>Jobs based on `+designation+'</h2></div>';
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
				var jobs = response.jobs;
				var html = '';
				for (var i = 0; i < jobs.length; i++){
					html += '<div class="post">';
					html += '<h2>' + jobs[i].title + '</h2>';
					html += '<p>' + jobs[i].description + '</p>';
					html += '<p class="skills"><i class="fas fa-tasks"></i>Skills: ' + jobs[i].skill + '</p>';
					html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
					html += '<p><strong>Requirements:</strong> ' + jobs[i].requirement + '</p>';
					html += '<p><strong>Responsibilities:</strong> ' + jobs[i].responsibilities + '</p>';
					html += '<p><strong>Work Mode:</strong> ' + jobs[i].type + '</p>';
					html += '<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ' + jobs[i].location + '</p>';
					html += '<p><strong>Experience:</strong> ' + jobs[i].experience + '</p>';
					html += '<button class="btn btn-primary apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				alert('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'FetchPostsWithNameServlet?page=' + page+'&title='+designation, true);
	//xhrInit.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhrInit.send();
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {
		
		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {
			
			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var jobs = response.jobs;
							var html = '';
							for (var i = 0; i < jobs.length; i++) {

								html += '<div class="post">';
								html += '<h2>' + jobs[i].title + '</h2>';
								html += '<p>' + jobs[i].description + '</p>';
								html += '<p><strong>Skills:</strong> ' + jobs[i].skill + '</p>';
								html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
								html += '<p><strong>Application end date:</strong> ' + jobs[i].date + '</p>';
								html += '<button class="apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
								html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							alert('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhrInit.open('GET', 'FetchPostsWithNameServlet?page=' + page+'&title='+designation, true);
				//xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				xhr.send();
			}
		}
	});
}

function editProfile() {
    var main = document.getElementById("main");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
            var response = JSON.parse(xhr.responseText);
            var html = `<br><div id = editProfile>
            			<h1 style="text-align:center;">User Profile</h1><br><br>
                        <form action="SaveProfileServlet" method="POST" onsubmit="return validateForm()">
                            <label for="name"><strong>Name:</strong></label><br>
                            <input type="text" id="name" name="name" value="${response.name}"><br><br>

                            <label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
                            <input type="text" id="mobileNumber" name="mobileNumber" value="${response.mobileNumber}"><br><br>

                            <label for="skills"><strong>Skills:</strong></label><br>
                            <input type="text" id="skills" name="skills" value="${response.skills}"><br><br>

                            <label for="qualification"><strong>Qualification:</strong></label><br>
                            <input type="text" id="qualification" name="qualification" value="${response.qualification}"><br><br>

                            <label for="email"><strong>Email:</strong></label><br>
                            <input type="text" id="email" name="email" value="${response.email}"><br><br>

                            <label for="experience"><strong>Experience:</strong></label><br>
                            <input type="number" id="experience" name="experience" value="${response.experience}"><br><br>

                            <label for="location"><strong>Location:</strong></label><br>
                            <input type="text" id="location" name="location" value="${response.location}"><br><br>

                            <label for="about"><strong>About:</strong></label><br>
                            <textarea id="about" name="about">${response.about}</textarea><br><br>

                            <button type="submit">Save</button>
                        </form></div>`;
            main.innerHTML = html;
        }
    };
    xhr.open("GET", "GetUserProfileServlet", true);
    xhr.send();
}

function feed() {
	
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	var postContainer = document.getElementById('post-container');
	postContainer.innerHTML="";
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
				var jobs = response.jobs;
				var html = '';
				for (var i = 0; i < jobs.length; i++){
					html += '<div class="post">';
					html += '<h2>' + jobs[i].title + '</h2>';
					html += '<p>' + jobs[i].description + '</p>';
					html += '<p class="skills"><i class="fas fa-tasks"></i>Skills: ' + jobs[i].skill + '</p>';
					html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
					html += '<p><strong>Requirements:</strong> ' + jobs[i].requirement + '</p>';
					html += '<p><strong>Responsibilities:</strong> ' + jobs[i].responsibilities + '</p>';
					html += '<p><strong>Work Mode:</strong> ' + jobs[i].type + '</p>';
					html += '<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ' + jobs[i].location + '</p>';
					html += '<p><strong>Experience:</strong> ' + jobs[i].experience + '</p>';
					html += '<button class="btn btn-primary apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				alert('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'FetchPostsServlet?page=' + page, true);
	xhrInit.setRequestHeader('Content-Type', 'application/json');
	xhrInit.send();
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {
		
		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {
			
			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var jobs = response.jobs;
							var html = '';
							for (var i = 0; i < jobs.length; i++) {

								html += '<div class="post">';
								html += '<h2>' + jobs[i].title + '</h2>';
								html += '<p>' + jobs[i].description + '</p>';
								html += '<p><strong>Skills:</strong> ' + jobs[i].skill + '</p>';
								html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
								html += '<p><strong>Application end date:</strong> ' + jobs[i].date + '</p>';
								html += '<button class="apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
								html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							alert('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhr.open('GET', 'FetchPostsServlet?page=' + page, true);
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.send();
			}
		}
	});
}

function validateForm() {
  var name = document.getElementById("name").value;
  var email = document.getElementById("email").value;
  var contact = document.getElementById("contact").value;
  var skills = document.getElementById("skills").value;
  var qualification = document.getElementById("qualification").value;
  
  var contactRegex = /^[0-9]{10}$/;
  if(!contactRegex.test(contact)){
	  alert("Please enter a valid mobile number");
	  return false;
  }
  
  var skillRegex = /^[a-zA-Z0-9]+(?:,[a-zA-Z0-9]+)*$/;
  if(!skillRegex.test(skills)){
	  alert("Please enter valid skills");
	  return false;
  }
  
  var qualificationRegex = /^([a-zA-Z]+\.)?[a-zA-Z\s]+$/;
  if(!qualificationRegex.test(qualification)){
	  alert("Please enter a valid qualification");
	  return false;
  }
  
  var nameRegex = /^[a-zA-Z ]+$/;
  if (!nameRegex.test(name)) {
    alert("Please enter a valid name");
    return false;
  }

  
  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(email)) {
    alert("Please enter a valid email address");
    return false;
  }

  return true;
}

function apply(button, jobId) {
	console.log(jobId);
	button.innerHTML = 'Applying...';
	button.disabled = true;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				alert('Applied successfully, waiting for HR response');
				button.innerHTML = 'Applied';
				button.disabled = true;
			} else {
				button.innerHTML = 'Apply';
				button.disabled = false;
				alert('Error applying for job');
			}
		}
	};
	xhr.open('POST', 'ApplyJobServlet', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('jobId=' + encodeURIComponent(jobId));
}

function sendCallLetter(button, userID, jobID) {
	button.innerHTML = 'Sending...';
	button.disabled = true;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				alert('Call letter sent!');
				button.innerHTML = 'sent';
				button.disabled = true;
			} else {
				button.innerHTML = 'Send CallLetter';
				button.disabled = false;
				alert('Error sending call letter');
			}
		}
	};
	xhr.open('POST', 'SendCallLetter', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('userID=' + encodeURIComponent(userID) + '&jobID=' + encodeURIComponent(jobID));
	
}

function removeCandidate(button, userID, jobID) {
	button.innerHTML = 'Removing...';
	button.disabled = true;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				alert('removed successfully!');
				button.innerHTML = 'Removed';
				button.disabled = true;
			} else {
				button.innerHTML = 'Remove';
				button.disabled = false;
				alert('Error Removing');
			}
		}
	};
	xhr.open('POST', 'RemoveCandidate', true);
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhr.send('userID=' + encodeURIComponent(userID) + '&jobID=' + encodeURIComponent(jobID));
}

function appliedJobs(){
	var postContainer = document.getElementById('post-container');
	postContainer.innerHTML =`<div class="post"><h2>Applied Jobs</h2></div>`;
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
				var jobs = response.jobs;
				var html = '';
				for (var i = 0; i < jobs.length; i++){
					html += '<div class="post">';
					html += '<h2>' + jobs[i].title + '</h2>';
					html += '<p>' + jobs[i].description + '</p>';
					html += '<p class="skills"><i class="fas fa-tasks"></i><strong> Skills:</strong>  ' + jobs[i].skill + '</p>';
					html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
					html += '<p><strong>Requirements:</strong> ' + jobs[i].requirement + '</p>';
					html += '<p><strong>Responsibilities:</strong> ' + jobs[i].responsibilities + '</p>';
					html += '<p><strong>Work Mode:</strong> ' + jobs[i].type + '</p>';
					html += '<p class="location"><i class="fas fa-map-marker-alt"></i><strong> Location:</strong> ' + jobs[i].location + '</p>';
					html += '<p><strong>Experience:</strong> ' + jobs[i].experience + '</p>';
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				alert('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'AppliedJobs?page=' + page, true);
	//xhrInit.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhrInit.send();
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {
		
		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {
			
			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var jobs = response.jobs;
							var html = '';
							for (var i = 0; i < jobs.length; i++) {

								html += '<div class="post">';
								html += '<h2>' + jobs[i].title + '</h2>';
								html += '<p>' + jobs[i].description + '</p>';
								html += '<p><strong>Skills:</strong> ' + jobs[i].skill + '</p>';
								html += '<p><strong>Number of vacancies:</strong> ' + jobs[i].noOfVacancies + '</p>';
								html += '<p><strong>Application end date:</strong> ' + jobs[i].date + '</p>';
								html += '<button class="apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
								html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							alert('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhrInit.open('GET', 'AppliedJobs?page=' + page, true);
				//xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				xhr.send();
			}
		}
	});
}
