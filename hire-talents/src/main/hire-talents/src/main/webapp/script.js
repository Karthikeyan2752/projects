/*function apply(button) {
  button.innerHTML = 'Applied';
  button.disabled = true;
}*/

function redirectToAppliedCandidates(jobID) {
  sessionStorage.setItem('jobID', jobID);
  window.location.href = 'AppliedCandidates.jsp';
}

function apply(button, jobId) {
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
	xhr.send('userID=' + encodeURIComponent(userID)+'&jobID=' + encodeURIComponent(jobID));
	//xhr.send('&jobID=' + encodeURIComponent(jobID));
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
  xhr.send('userID=' + encodeURIComponent(userID)+'&jobID=' + encodeURIComponent(jobID));
  
  
}

