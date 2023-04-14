/*
 * hr functionalities
 */
var k=0;
function feed() {
	k=1
	var insight = document.getElementById("insight");
	insight.style.display='none';
	var candidatesContainer= document.getElementById("candidates-container");
	candidatesContainer.style.display='none';
	var profile  = document.getElementById("profile");
	profile.style.display='inline-block';
	var home2= document.getElementById("home2");
	var postContainer = document.getElementById('post-container');
	postContainer.style.display='inline-block';
	home2.style.display='none';
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();

	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE && k==1) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
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
					html += '<button class="btn btn-primary apply-button" onclick="showAppliedCandidates(\'' + jobs[i].jobID + '\')">Start Hiring</button>';
					html += '<button class="btn btn-primary apply-button" onclick="sendCallLetterModal2(\'' + jobs[i].jobID + '\')">Automate Hiring</button>';
					html += '<button class="btn btn-primary apply-button" onclick="deactivate(\'' + jobs[i].jobID + '\')">Stop Accepting Applications</button>';
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				launch_toast('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'FetchPosts?page=' + page, true);
	xhrInit.setRequestHeader('Content-Type', 'application/json');
	xhrInit.send();
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {

		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {

			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE && k==1) {
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
							html += '<button class="btn btn-primary apply-button" onclick="showAppliedCandidates(\'' + jobs[i].jobID + '\')">Start Hiring</button>';
							html += '<button class="btn btn-primary apply-button" onclick="sendCallLetterModal2(\'' + jobs[i].jobID + '\')">Automate Hiring</button>';
							html += '<button class="btn btn-primary apply-button" onclick="deactivate(\'' + jobs[i].jobID + '\')">Stop Accepting Applications</button>';
							html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							launch_toast('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhr.open('GET', 'FetchPosts?page=' + page, true);
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.send();
			}
		}
	});
	var home = document.getElementById("home");
	home.style.display='flex';
}

function automate(jobID){
	k=2;
	debugger;
	var insight = document.getElementById("insight");
	insight.style.display='none';
	var candidatesContainer = document.getElementById("candidates-container");
	candidatesContainer.style.display='inline-block';
	var profile  = document.getElementById("profile");
	profile.style.display='none';
	var page = 1;
	var isLoading = false;
	var postContainer = document.getElementById('post-container');
	postContainer.style.display='none';
	var candidatesContainer = document.getElementById("candidates-container");
	candidatesContainer.innerHTML='';
	window.addEventListener('scroll', function() {

		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {

			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE && k==2) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var candidates = response.candidates;
							var candidatesContainer = document.getElementById('candidates-container');
							var html = '';
							if(page==1&&candidates.length==0){
								html += `<div class="post">
											<h2>No candidates matched</h2>
										 </div>`;
								candidatesContainer.innerHTML += html;	
								k=0;
								return;	 
							}
							
							for (var i = 0; i < candidates.length; i++) {

								html += `<div class="post">
											<h2>${candidates[i].name}</h2>
											<p>${candidates[i].about}</p>
											<p class="skills"><i class="fas fa-tasks"></i>Skills: ${candidates[i].skills}</p>					
											<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ${candidates[i].location}</p>
											<p><strong>Experience:</strong> ${candidates[i].experience}</p>
											<p><strong>Email:</strong> ${candidates[i].email}</p>
											<p><strong>Contact Number:</strong> ${candidates[i].mobileNumber}</p>
											<div id="callLetter-details"></div>											
										</div>`;

							}
							
							candidatesContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							launch_toast('Error fetching candidates');
							isLoading = false;
						}
					}
				}
				var venue = document.getElementById("venue").value;
				var time = document.getElementById("time").value;
				var date = document.getElementById("date").value;
				
				xhr.open('GET', 'AutomateHiring?jobID='+jobID+'&time='+time+'&date='+date+'&venue='+venue,  true);
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.send();
			}
		}
	});
	var home = document.getElementById("home");
	home.style.display='flex';
	//postContainer.style.display='inline-block';
}

function showAppliedCandidates(jobID){
	k=5;
	var insight = document.getElementById("insight");
	insight.style.display='none';
	var candidatesContainer = document.getElementById("candidates-container");
	candidatesContainer.style.display='inline-block';
	var profile  = document.getElementById("profile");
	profile.style.display='none';
	var page = 1;
	var isLoading = false;
	//var xhrInit = new XMLHttpRequest();
	var postContainer = document.getElementById('post-container');
	postContainer.style.display='none';
	var candidatesContainer = document.getElementById("candidates-container");
	candidatesContainer.innerHTML='';
	/*xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE && k==5) {
			if (xhrInit.status === 200) {
				var response = JSON.parse(xhrInit.responseText);
				var candidates = response.candidates;
				var html = '';
				for (var i = 0; i < candidates.length; i++) {
					html += `<div class="post">
								<h2>${candidates[i].name}</h2>
								<p>${candidates[i].about}</p>
								<p class="skills"><i class="fas fa-tasks"></i>Skills: ${candidates[i].skills}</p>					
								<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ${candidates[i].location}</p>
								<p><strong>Experience:</strong> ${candidates[i].experience}</p>
								<p><strong>Email:</strong> ${candidates[i].email}</p>
								<p><strong>Contact Number:</strong> ${candidates[i].mobileNumber}</p>
								<div id="callLetter-details"></div>
								<button class="btn btn-primary apply-button" onclick="sendCallLetterModal(${candidates[i].userID},${candidates[i].jobID})">Send Call Letter</button>
								<button class="btn btn-primary apply-button" onclick="remove(${candidates[i].userID},${candidates[i].jobID})">Remove</button>
							</div>`;
				}
				candidatesContainer.innerHTML += html;
				page++;
			} else {
				launch_toast('Error fetching candidates');
			}
		}
	}
	xhrInit.open('GET', 'FetchAppliedCandidates?page=' + page+'&jobID='+jobID, true);
	xhrInit.setRequestHeader('Content-Type', 'application/json');
	xhrInit.send();*/
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {

		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {

			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE && k==5) {
						if (xhr.status === 200) {
							var response = JSON.parse(xhr.responseText);
							var candidates = response.candidates;
							var html = '';
							for (var i = 0; i < candidates.length; i++) {

								html += `<div class="post">
											<h2>${candidates[i].name}</h2>
											<p>${candidates[i].about}</p>
											<p class="skills"><i class="fas fa-tasks"></i>Skills: ${candidates[i].skills}</p>					
											<p class="location"><i class="fas fa-map-marker-alt"></i> Location: ${candidates[i].location}</p>
											<p><strong>Experience:</strong> ${candidates[i].experience}</p>
											<p><strong>Email:</strong> ${candidates[i].email}</p>
											<p><strong>Contact Number:</strong> ${candidates[i].mobileNumber}</p>
											<div id="callLetter-details"></div>
											<button class="btn btn-primary apply-button" onclick="sendCallLetterModal(${candidates[i].userID},${candidates[i].jobID})">Send Call Letter</button>
											<button class="btn btn-primary apply-button" onclick="remove(${candidates[i].userID},${candidates[i].jobID})">Remove</button>
										</div>`;

							}
							var candidatesContainer = document.getElementById('candidates-container');
							candidatesContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							launch_toast('Error fetching candidates');
							isLoading = false;
						}
					}
				}

				xhr.open('GET', 'FetchAppliedCandidates?page=' + page+'&jobID='+jobID,  true);
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.send();
			}
		}
	});
	var home = document.getElementById("home");
	home.style.display='flex';
	//postContainer.style.display='inline-block';
}

function launch_toast(message) {
    var x = document.getElementById("toast")
    var desc = document.getElementById("desc")
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5000);
    desc.innerHTML=message;
}

function validatePost() {
    var designation = document.getElementById("designation").value;
    var experience = document.getElementById("experience").value;
    var skills = document.getElementById("skills").value;
    var vacancies = document.getElementById("a").value;
    var location = document.getElementById("location").value;

    var regexLettersAndNumbers = /^[a-zA-Z0-9\s]+$/; // Allows only letters and numbers
    var regexPositiveNumberUnder40 = /^(?:[1-9]|[1-3][0-9]|40)$/; // Allows positive numbers under 40
    var regexAlphanumericWordsSeparatedByComma = /^[a-zA-Z0-9\s,]+$/; // Allows alphanumeric words separated by commas
    var regexPositiveNumber = /^[1-9][0-9]*$/; // Allows positive numbers
    var regexAlphanumeric = /^[a-zA-Z0-9\s]+$/; // Allows alphanumeric characters

    if (!designation.match(regexLettersAndNumbers)) {
        launch_toast("Please enter a valid designation.");
        return false;
    }

    if (!experience.match(regexPositiveNumberUnder40)) {
        launch_toast("Please enter a valid experience (positive number under 40).");
        return false;
    }

    if (!skills.match(regexAlphanumericWordsSeparatedByComma)) {
        launch_toast("Please enter valid skills (alphanumeric words separated by commas).");
        return false;
    }

    if (!vacancies.match(regexPositiveNumber)) {
        launch_toast("Please enter a valid number of vacancies (positive number).");
        return false;
    }

    if (!location.match(regexAlphanumeric)) {
        launch_toast("Please enter a valid location (alphanumeric).");
        return false;
    }

    // If all validations pass, return true
    return true;
}

function post() {
    k = 0;
    
    var insight = document.getElementById("insight");
    insight.style.display = 'none';
    var home = document.getElementById("home");
    var home2 = document.getElementById("home2");
    home.style.display = 'none';
    home2.innerHTML = `<br><div id="create-post">
                    <h1 style="text-align:center;">Write A Post</h1><br><br>
                    
                        <label for="designation"><strong>Designation:</strong></label><br>
                        <input type="text" id="designation" name="designation" required><br><br>

                        <label for="experience"><strong>Experience:</strong></label><br>
                        <input type="number" id="experience" name="experience" min="0" required><br><br>

                        <label for="workType"><strong>Work Type:</strong></label><br>
                        <select id="workType" name="workType" required>
                            <option value="" disabled selected>Select Work Type</option>
                            <option value="Full-time">Full-time</option>
                            <option value="Part-time">Part-time</option>
                            <option value="remote">Remote</option>
                        </select><br><br>

                        <label for="skills"><strong>Skills:</strong></label><br>
                        <input type="text" id="skills" name="skills" required><br><br>

                        <label for="a"><strong>Available Vacancies:</strong></label><br>
                        <input type="number" id="a" name="a" min="0" required><br><br>

                        <label for="location"><strong>Location:</strong></label><br>
                        <input type="text" id="location" name="location" required><br><br>

                        <label for="responsibilities"><strong>Responsibilities:</strong></label><br>
                        <textarea id="responsibilities" name="responsibilities" required></textarea><br><br>

                        <label for="requirements"><strong>Requirements:</strong></label><br>
                        <textarea id="requirements" name="requirements" required></textarea><br><br>

                        <label for="description"><strong>Description:</strong></label><br>
                        <textarea id="description" name="description" required></textarea><br><br>

                        <button type="button" onclick="validateAndSubmitForm()">Post</button>
                    
                </div>`;
    home2.style.display = 'inline-block';
}
function validateAndSubmitForm(){
	if(validatePost()){
		submitForm();
	}else{
		launch_toast('something is wrong in your post, try again!');
	}
}
function submitForm() {
    var designation = document.getElementById("designation").value;
    var experience = document.getElementById("experience").value;
    var workType = document.getElementById("workType").value;
    var skills = document.getElementById("skills").value;
    var a = document.getElementById("a").value;
    var location = document.getElementById("location").value;
    var responsibilities = document.getElementById("responsibilities").value;
    var requirements = document.getElementById("requirements").value;
    var description = document.getElementById("description").value;

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // Success, show toast
                launch_toast(xhr.responseText);
            } else {
                // Failure, show toast
                launch_toast("Failed to post job, try again.");
            }
        }
    };
    xhr.open('POST', 'PostJob', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    var data = "designation=" + encodeURIComponent(designation) +
               "&experience=" + encodeURIComponent(experience) +
               "&workType=" + encodeURIComponent(workType) +
               "&skills=" + encodeURIComponent(skills) +
               "&a=" + encodeURIComponent(a) +
               "&location=" + encodeURIComponent(location) +
               "&responsibilities=" + encodeURIComponent(responsibilities) +
               "&requirements=" + encodeURIComponent(requirements) +
               "&description=" + encodeURIComponent(description);
    xhr.send(data);
    post();
}

function sendCallLetterModal2(jobID) {	
	
	var modalHtml = `<div class="modal" tabindex="-1" role="dialog" id="call-letter-modal">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Automate Hiring</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<label for="venue">Venue:</label><br>
									<input type="text" id="venue" name="venue" class="form-control"><br>
									<label for="time">Time:</label><br>
									<input type="time" id="time" name="time" class="form-control"><br>
									<label for="date">Date:</label>
									<input type="date" id="date" name="date" class="form-control">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary" onclick="automate(${jobID})">Automate</button>
								</div>
							</div>
						</div>
					</div>`;
	
	var modalContainer = document.createElement('div');
	modalContainer.innerHTML = modalHtml;
	document.body.appendChild(modalContainer);
	$('#call-letter-modal').modal('show');

}
function sendCallLetterModal(userID, jobID) {	
	
	var modalHtml = `<div class="modal" tabindex="-1" role="dialog" id="call-letter-modal">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title">Send Call Letter</h5>
									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<label for="venue">Venue:</label><br>
									<input type="text" id="venue" name="venue" class="form-control"><br>
									<label for="time">Time:</label><br>
									<input type="time" id="time" name="time" class="form-control"><br>
									<label for="date">Date:</label>
									<input type="date" id="date" name="date" class="form-control">
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary" onclick="sendCallLetter(${userID},${jobID})">Send</button>
								</div>
							</div>
						</div>
					</div>`;
	
	var modalContainer = document.createElement('div');
	modalContainer.innerHTML = modalHtml;
	document.body.appendChild(modalContainer);
	$('#call-letter-modal').modal('show');

}
function sendCallLetter( userID, jobID) {
	
 
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
		launch_toast(xhr.responseText);
        
      } else {
                launch_toast(xhr.responseText);
      }
    }
  };
  var date = document.getElementById("date").value;
  var time = document.getElementById("time").value;
  var venue = document.getElementById("venue").value;
  xhr.open('POST', 'SendCallLetter', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send('venue=' + venue+'&time=' + time+'&date=' + date+'&userID=' + userID+'&jobID=' + jobID);
	
}

function remove( userID, jobID) {
 
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
		launch_toast(xhr.responseText);           
      } else {        
        launch_toast(xhr.responseText);
      }
    }
  };
  xhr.open('POST', 'RemoveCandidate', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send('userID=' + encodeURIComponent(userID)+'&jobID=' + encodeURIComponent(jobID)); 
}


function search(){
	k=2;
	var designation = document.getElementById("searchText").value;
	var postContainer = document.getElementById('post-container');
	postContainer.innerHTML =`<div class="post"><h2>Jobs based on `+designation+'</h2></div>';
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE &&k==2) {
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
					html += '<button class="btn btn-primary apply-button" onclick="showAppliedCandidates(\'' + jobs[i].jobID + '\')">Start Hiring</button>';
					html += '<button class="btn btn-primary apply-button" onclick="sendCallLetterModal2(\'' + jobs[i].jobID + '\')">Automate Hiring</button>';
					html += '<button class="btn btn-primary apply-button" onclick="deactivate(\'' + jobs[i].jobID + '\')">Stop Accepting Applications</button>';

					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				launch_toast('Error fetching jobs');
			}
		}
	}
	xhrInit.open('GET', 'FetchPostsWithName?page=' + page+'&title='+designation, true);
	//xhrInit.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhrInit.send();
	// Attach the scroll listener to fetch more posts
	window.addEventListener('scroll', function() {
		
		if (window.scrollY + window.innerHeight >= document.documentElement.scrollHeight - 100) {
			
			if (!isLoading) {
				isLoading = true;
				var xhr = new XMLHttpRequest();
				xhr.onreadystatechange = function() {
					if (xhr.readyState === XMLHttpRequest.DONE&&k==2) {
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
								html += '<button class="btn btn-primary apply-button" onclick="showAppliedCandidates(\'' + jobs[i].jobID + '\')">Start Hiring</button>';
					 			html += '<button class="btn btn-primary apply-button" onclick="sendCallLetterModal2(\'' + jobs[i].jobID + '\')">Automate Hiring</button>';
								html += '<button class="btn btn-primary apply-button" onclick="deactivate(\'' + jobs[i].jobID + '\')">Stop Accepting Applications</button>';

								html += '</div>';
							}
							var postContainer = document.getElementById('post-container');
							postContainer.innerHTML += html;
							page++;
							isLoading = false;
						} else {
							launch_toast('Error fetching jobs');
							isLoading = false;
						}
					}
				}

				xhrInit.open('GET', 'FetchPostsWithName?page=' + page+'&title='+designation, true);
				//xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
				xhr.send();
			}
		}
	});
}

function editInfo() {
	k=0;
	var home = document.getElementById("home");
	var home2 = document.getElementById("home2");
	home.style.display='none';
	/*var main = document.getElementById("main");
	var profile = document.getElementById("profile");
	var postContainer = document.getElementById("post-container");
	profile.innerHTML='';
	postContainer.innerHTML='';*/
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState ===4) {
			console.log(xhr.responseText);
            var response = JSON.parse(xhr.responseText);
            home2.innerHTML= `<br><div id = editProfile>
            			<h1 style="text-align:center;">Edit Info</h1><br><br>
                        <form action="SaveInfoServlet" method="POST" onsubmit="return validateForm()">
                            <label for="name"><strong>Name:</strong></label><br>
                            <input type="text" id="name" name="name" value="${response.name}" required><br><br>

                            <label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
                            <input type="text" id="mobileNumber" name="mobileNumber" value="${response.mobileNumber}" required><br><br>

                            <label for="companyName"><strong>Organisation Name:</strong></label><br>
                            <input type="text" id="companyName" name="companyName" value="${response.companyName}" required><br><br>

                            <label for="website"><strong>Website URL:</strong></label><br>
                            <input type="text" id="website" name="website" value="${response.website}" required><br><br>               

                            <label for="location"><strong>Location:</strong></label><br>
                            <input type="text" id="location" name="location" value="${response.location}" required><br><br>

                            <label for="about"><strong>About:</strong></label><br>
                            <textarea id="about" name="about">${response.about}</textarea><br><br>

                            <button type="submit">Save</button>
                        </form></div>`;
            home2.style.display='inline-block';
        }
    };
    xhr.open("GET", "GetInfoServlet", true);
    xhr.send();
}

function validateForm() {
	var name = document.getElementById("name").value;
	var companyName = document.getElementById("companyName").value;
	var mobileNumber = document.getElementById("mobileNumber").value;
	var website = document.getElementById("website").value;
	var location = document.getElementById("location").value;

	var contactRegex = /^[0-9]{10}$/;
	if (!contactRegex.test(mobileNumber)) {
		launch_toast("Please enter a valid mobile number");
		return false;
	}

	var nameRegex = /^[a-zA-Z ]+$/;
	if (!nameRegex.test(name)) {
		launch_toast("Please enter a valid name");
		return false;
	}
	
	if (!nameRegex.test(companyName)) {
		launch_toast("Please enter a valid organisation name");
		return false;
	}
	
	if (!nameRegex.test(location)) {
		launch_toast("Please enter a valid location");
		return false;
	}


	var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	if (!emailRegex.test(email)) {
		launch_toast("Please enter a valid email address");
		return false;
	}

    var websiteRegex = /^(http(s)?:\/\/)?(www\.)?[a-zA-Z0-9_-]+\.[a-zA-Z]{2,6}([a-zA-Z0-9_%?=&#]+)?$/;
	if(!websiteRegex.test(website)){
		launch_toast("Please enter a valid website URL");
		return false;
	}
	
	return true;
}
function insights() {
	k=6;
    // Clear the content of the "insight" div
	var candidatesContainer= document.getElementById("candidates-container");
	candidatesContainer.style.display='none';
	var profile  = document.getElementById("profile");
	profile.style.display='none';
	var home  = document.getElementById("home");
	home.style.display='none';
	var home2  = document.getElementById("home2");
	home2.style.display='none';
	var postContainer = document.getElementById('post-container');
	postContainer.style.display='none';
    var insight =document.getElementById("insight");
	
	var xhrInit = new XMLHttpRequest();
	xhrInit.onreadystatechange = function() {
		if (xhrInit.readyState === XMLHttpRequest.DONE ) {
			if (xhrInit.status === 200) {
				var jobs = JSON.parse(xhrInit.responseText);
				var head = jobs.head;
				var insightsHTML = `
					<div class="card text-center">
					  <div class="card-header">
					    <h2>Recruitment Insights</h2>
					  </div>
					  <div class="card-body">
					    <h3> ${head.companyName}</h3>
			        	<p>Total Number of Applied Candidates: ${head.jobsPosted}</p>
			        	<p>Selected Candidates: ${head.selectedCandidates}</p>
					  </div>
					  <div class="card-footer text-muted">
					     <h4>Jobs Posted by You</h4>
					  </div>
					</div>
			        
			        
			       
			        <table id="jobsTable">
			            <thead>
			                <tr>
			                    <th>Role</th>
			                    <th>Skills</th>
			                    <th>Experience</th>
			                    <th>Location</th>
			                    <th>Applied Candidates</th>
			                    <th>Selected Candidates</th>
			                </tr>
			            </thead>
			            <tbody>`;
			                
			                    var table = jobs.table;
			
			                    for (var i = 0; i < table.length; i++) {
			                        var job = table[i];
			                        
			                       insightsHTML+=  `<tr>
			                        <td>${job.role }</td>
			                        <td>${job.skills }</td>
			                        <td>${job.experience }</td>
			                        <td>${ job.location }</td>
			                        <td>${ job.appliedCandidates }</td>
			                        <td>${ job.selectedCandidates }</td>
									</tr>`;
			                        
			                       
			                    }
			                
			         insightsHTML+=  ` </tbody>
			        </table><br>
			        <p>Thank you for using our recruitment management system! You can download this information as an Excel/PDF file for your reference.</p>
			       		    
					<button class="btn" onclick="excelExport()" style="width:100%"><i class="fa fa-download"></i> Download As Excel</button><br>
					<button class="btn" onclick="printTable()" style="width:100%"><i class="fa fa-download"></i> Download As PDF</button>
			        
			       
			    `;
			
			    // Set the generated HTML content to the "insight" div
			    insight.innerHTML = insightsHTML;
			    insight.style.display='inline-block';
			} else {
				launch_toast('Error fetching insights');
			}
		}
	}
	
	xhrInit.open('GET', 'GetInsights', true);
	//xhrInit.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhrInit.send();
    // Create the HTML content for the insights section
    
}

// Import the XLSX library
function excelExport() {
    // Get the table element by its id
    var table = document.getElementById("jobsTable");
    
    // Convert the table to a SheetJS workbook object
    var workbook = XLSX.utils.table_to_book(table);
    
    // Convert the workbook to a binary string
    var excelData = XLSX.write(workbook, { bookType: 'xlsx', type: 'binary' });
    
    // Create a Blob from the binary string
    var blob = new Blob([s2ab(excelData)], { type: "application/octet-stream" });
    
    // Generate a download link element
    var downloadLink = document.createElement("a");
    downloadLink.href = window.URL.createObjectURL(blob);
    downloadLink.download = "insights_by_hiretalents.xlsx"; // Set the desired filename for the Excel file
    
    // Append the download link to the DOM and trigger the download
    document.body.appendChild(downloadLink);
    downloadLink.click();
    document.body.removeChild(downloadLink);
}

// Utility function to convert a string to an ArrayBuffer
function s2ab(s) {
    var buf = new ArrayBuffer(s.length);
    var view = new Uint8Array(buf);
    for (var i = 0; i < s.length; i++) view[i] = s.charCodeAt(i) & 0xFF;
    return buf;
}


function printTable() {
    // Get the table element by its id
    var table = document.getElementById("jobsTable");
    
    // Open a new window with the table content
    var printWindow = window.open('', '_blank');
    printWindow.document.write('<html><head><title>Insights</title></head><body>');
     printWindow.document.write(`<h1>Insights By HireTalents</h1>`); // Add a heading with the specified name
    printWindow.document.write(table.outerHTML);
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    
    // Call the print method on the window
    printWindow.print();
}

function deactivate(jobID){
	var xhr = new XMLHttpRequest();
  	xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (xhr.status == 200) {
		launch_toast(xhr.responseText);           
      } else {        
        launch_toast(xhr.responseText);
      }
    }
  };
  xhr.open('POST', 'DeactivateJob', true);
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.send('jobID=' + encodeURIComponent(jobID)); 
}

function validateFormSignUp() {
		  var name = document.getElementById("name").value;
		  var email = document.getElementById("email").value;
		  var password = document.getElementById("password").value;
		  var repassword = document.getElementById("repassword").value;
		  var contact = document.getElementById("contact").value;
		  var companyName = document.getElementById("companyName").value;
		  
		  var contactRegex = /^[0-9]{10}$/;
		  if(!contactRegex.test(contact)){
			  alert("Please enter a valid mobile number");
			  return false;
		  }
		
		  
		  var nameRegex = /^[a-zA-Z ]+$/;
		  if (!nameRegex.test(name)) {
		    alert("Please enter a valid name");
		    return false;
		  }
		  
		  if(!nameRegex.test(companyName)){
			  alert("Please enter a valid company name");
			  return false;
		  }
		
		  
		  var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		  if (!emailRegex.test(email)) {
		    alert("Please enter a valid email address");
		    return false;
		  }
		
		  
		  var passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;
		  if (!passwordRegex.test(password)) {
		    alert("Please enter a valid password. Password must contain at least 8 characters, including at least one uppercase letter, one lowercase letter, one digit, and one special character (!@#$%^&*)");
		    return false;
		  }
		
		  if (password !== repassword) {
		    alert("Passwords don't match. Please re-enter password");
		    return false;
		  }
		
		  return true;
		}
