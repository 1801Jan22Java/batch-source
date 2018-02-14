function sendAjaxGet(url, func) {
	// Step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	// Step 2: define onreadystatechange
	// We want to check the ready state and the status
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

	// Step 3: prepare request
	xhr.open("GET", url, true);
	xhr.send();

}

function populateUser(xhr) {
	var res = JSON.parse(xhr.responseText);
	if (res.username != "null") {
		document.getElementById("user").innerHTML = "you are logged in as "
				+ res.username;
	} else {
		window.location = "http://localhost:8088/ServletLoginApp/login";
	}
}

window.onload = function{
	sendAjaxGet("http://localhost:8088/ServletLoginApp/session", populateUser )
}