function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function populateUser(xhr) {
	if (xhr.responseText) {
		/*
		console.log(xhr.responseText);
		var res = JSON.parse(xhr.responseText);
		if (res.username) {
			document.getElementById("user").innerHTML = "you are logged in as "
					+ res.username;
					
		}*/
	} else {
		window.location = "http://localhost:8084/First_Project/login";
	}
}

window.onload = function() {
	sendAjaxGet("http://localhost:8084/First_Project/session", populateUser);
}