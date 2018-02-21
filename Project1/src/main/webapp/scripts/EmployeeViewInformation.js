/**
 *
 */

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("POST", url, true);
	xhr.send();
};

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("table");
		var fname = document.createElement("tr");
		fname.innerHTML = "First Name: " + res.fname;
		var lname = document.createElement("tr");
		lname.innerHTML = "Last Name: " + res.lname;
		var email = document.createElement("tr");
		email.innerHTML = "Email: " + res.email;
		var addrs = document.createElement("tr");
		addrs.innerHTML = "Address: " + res.address;
		table.appendChild(fname);
		table.appendChild(lname);
		table.appendChild(email);
		table.appendChild(addrs);

	} else {
		window.location = "http://localhost:8084/Project1/employeelogin";
	}
}

window.onload = function() {
	
	sendAjaxPost("http://localhost:8084/Project1/employeeviewinformation", populateInformation);
}
