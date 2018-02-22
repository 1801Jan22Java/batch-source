window.URL = window.URL || window.webkitURL;

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("table");
		
		var remId = document.createElement("tr");
		remId.innerHTML = "<td>Reimbursement Id: </td><td>" + res.remId + "</td>";
		var status = document.createElement("tr");
		status.innerHTML = "<td>Status: </td><td>" + res.status + "</td>";
		var manId = document.createElement("tr");
		manId.innerHTML = "<td>Manager Id: </td><td>" + res.manId + "</td>";
		var value = document.createElement("tr");
		value.innerHTML = "<td>Reimbursement Amount: </td><td>" + res.value + "</td>";
		
		table.appendChild(remId);
		table.appendChild(status);
		table.appendChild(manId);
		table.appendChild(value);

	} else {
		window.location = "http://localhost:8084/Project1/employeehomepage";
	}
}

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	console.log(location.href.split("?")[1]);
	var new_url = url + "?" + location.href.split("?")[1];
	xhr.open("POST", new_url, true);
	xhr.send();
};

function sendAjaxGet(url,status) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("updated to " + status);
			location.reload(true);
		}
	};
	console.log(location.href.split("?")[1]);
	var new_url = url + "?" + location.href.split("?")[1] + "&val=" + status;
	xhr.open("GET", new_url, true);
	xhr.send();
};

function populateImage(xhr) {
	var blob = new Blob([xhr.response], {type: 'image/png'});
	if (blob) {
		document.getElementById("image").src = window.URL.createObjectURL(blob);
	}
}

function sendAjaxImg(url,func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.responseType = 'blob';
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("doing function");
			func(this);
		}
	};
	
	var new_url = url + "?" + location.href.split("?")[1];
	console.log(new_url);
	xhr.open("GET", new_url, true);
	xhr.send();
}

window.onload = function() {
	console.log(location.href);
	sendAjaxImg("http://localhost:8084/Project1/imagefetcher", populateImage);
	sendAjaxPost("http://localhost:8084/Project1/employeeviewreimbursement", populateInformation);

}