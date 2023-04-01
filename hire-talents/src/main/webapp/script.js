/*function apply(button) {
  button.innerHTML = 'Applied';
  button.disabled = true;
}*/
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

