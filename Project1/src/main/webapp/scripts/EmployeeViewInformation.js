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
	console.log(url);
	xhr.open("POST", url, true);
	xhr.send();
};

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("table");
		var fname = document.createElement("tr");
		fname.innerHTML = "<td>First Name: </td><td>" + res.fname + "</td>";
		var lname = document.createElement("tr");
		lname.innerHTML = "<td>Last Name: </td><td>" + res.lname + "</td>";
		var email = document.createElement("tr");
		email.innerHTML = "<td>Email: </td><td>" + res.email + "</td>";
		var addrs = document.createElement("tr");
		if (res.address) {
			addrs.innerHTML = "<td>Address: </td><td>" + res.address + "</td>";
		} else {
			addrs.innerHTML = "<td>Address: </td><td> N/A </td>";
		}
		table.appendChild(fname);
		table.appendChild(lname);
		table.appendChild(email);
		table.appendChild(addrs);

	} else {
		window.location = "http://localhost:8084/Project1/employeelogin";
	}
}

window.onload = function() {
	sendAjaxPost("http://localhost:8084/Project1/employeeviewinfo", populateInformation);
}
