function redirectToAppliedCandidates(jobID) {
	sessionStorage.setItem('jobID', jobID);
	window.location.href = 'AppliedCandidates.jsp';
}
function callLetters(){
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

				xhrInit.open('GET', 'FetchPostsWithNameServlet?page=' + page+'&title='+designation, true);
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
