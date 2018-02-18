/**
 * 
 */

function sendAjaxGet(url, func) {
	// Step 1: Obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	// Step 2: Define onreadytatechange
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	// Step 3: prepare request
	xhr.open("GET", url, true);
	
	// Step 4: Send request
	xhr.send();
};

function populateUser(xhr) {
	var res = JSON.parse(xhr.responseText);
	if (res.username != "null") {
		document.getElementById("user").innerHTML = "You are logged in as " + res.username;
	} else {
		window.location = "http://localhost:8084/ServletApp/login";
	}
}

window.onload = function() {
	sendAjaxGet("http://localhost:8084/ServletApp/session", populateUser);
}