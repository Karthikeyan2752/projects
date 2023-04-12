/*
 * hr functionalities
 */
var k=0;
function feed() {
	k=1
	var home2= document.getElementById("home2");
	home2.style.display='none';
	var page = 1;
	var isLoading = false;
	var xhrInit = new XMLHttpRequest();
	var postContainer = document.getElementById('post-container');
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
					html += '</div>';
				}
				postContainer.innerHTML += html;
				page++;
			} else {
				alert('Error fetching jobs');
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

				xhr.open('GET', 'FetchPosts?page=' + page, true);
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.send();
			}
		}
	});
	var home = document.getElementById("home");
	home.style.display='flex';
}

function showAppliedCandidates(jobID){
	
}
function validateForm() {
	var name = document.getElementById("name").value;
	var companyName = document.getElementById("companyName").value;
	var email = document.getElementById("email").value;
	var mobileNumber = document.getElementById("mobileNumber").value;
	var website = document.getElementById("website").value;
	var location = document.getElementById("location").value;

	var contactRegex = /^[0-9]{10}$/;
	if (!contactRegex.test(mobileNumber)) {
		alert("Please enter a valid mobile number");
		return false;
	}

	var nameRegex = /^[a-zA-Z ]+$/;
	if (!nameRegex.test(name)) {
		alert("Please enter a valid name");
		return false;
	}
	
	if (!nameRegex.test(companyName)) {
		alert("Please enter a valid organisation name");
		return false;
	}
	
	if (!nameRegex.test(location)) {
		alert("Please enter a valid location");
		return false;
	}


	var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	if (!emailRegex.test(email)) {
		alert("Please enter a valid email address");
		return false;
	}

    var websiteRegex = /^(http(s)?:\/\/)?(www\.)?[a-zA-Z0-9_-]+\.[a-zA-Z]{2,6}([a-zA-Z0-9_%?=&#]+)?$/;
	if(!websiteRegex.test(website)){
		alert("Please enter a valid website URL");
		return false;
	}
	
	return true;
}
function launch_toast(message) {
    var x = document.getElementById("toast")
    var desc = document.getElementById("desc")
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5000);
    desc.innerHTML=message;
}
function post() {
	k=0;
	
	var home = document.getElementById("home");
	var home2 = document.getElementById("home2");
	home.style.display='none';
	/*var postContainer = document.getElementById("post-container");
	profile.innerHTML='';
	postContainer.innerHTML='';*/
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
                        <input type="number" id="a" name="a" required><br><br>

                        <label for="location"><strong>Location:</strong></label><br>
                        <input type="text" id="location" name="location" required><br><br>

                        <label for="responsibilities"><strong>Responsibilities:</strong></label><br>
                        <textarea id="responsibilities" name="responsibilities" required></textarea><br><br>

                        <label for="requirements"><strong>Requirements:</strong></label><br>
                        <textarea id="requirements" name="requirements" required></textarea><br><br>

                        <label for="description"><strong>Description:</strong></label><br>
                        <textarea id="description" name="description" required></textarea><br><br>

                        <button type="button" onclick="submitForm()">Post</button>
                    
                </div>`;
    home2.style.display='inline-block';
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
                launch_toast("Failed to post job. Please try again.");
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
}



function insights() {
	
}

function automate() {

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
								html += '<button class="btn btn-primary apply-button" onclick="apply(this,\'' + jobs[i].jobID + '\')">Apply</button>';
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
                            <input type="text" id="name" name="name" value="${response.name}"><br><br>

                            <label for="mobileNumber"><strong>Mobile Number:</strong></label><br>
                            <input type="text" id="mobileNumber" name="mobileNumber" value="${response.mobileNumber}"><br><br>

                            <label for="companyName"><strong>Organisation Name:</strong></label><br>
                            <input type="text" id="companyName" name="companyName" value="${response.companyName}"><br><br>

                            <label for="website"><strong>Website URL:</strong></label><br>
                            <input type="text" id="website" name="website" value="${response.website}"><br><br>

                            <label for="email"><strong>Email:</strong></label><br>
                            <input type="text" id="email" name="email" value="${response.email}"><br><br>               

                            <label for="location"><strong>Location:</strong></label><br>
                            <input type="text" id="location" name="location" value="${response.location}"><br><br>

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