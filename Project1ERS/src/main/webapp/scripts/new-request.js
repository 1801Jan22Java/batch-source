//As soon as DOM is built
document.getElementById("json-no-script").style.display = "none";
document.getElementById("json-loading").style.display = "block";

// global variable for internal checking
var isManager = false;

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} else if (this.readyState == 4 && this.status == 404) {
			console.log("xhr = 404");
			//window.location = "login?action=login";
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
}

function getJson(xhr) {
	var response = JSON.parse(xhr.responseText);
	console.log(response);
	
	if (response.action == "login") {
		window.location = "../../login?action=login";
	}
	if (response.action == "logout") {
		window.location = "../../logout?action=login";
	}
	
	document.getElementById("json-full-name").innerHTML = response.firstname + " " + response.lastname;
	document.getElementById("json-job-title").innerHTML = response.jobTitle;
	
	document.getElementById("employee-id").value = response.employeeId;
	
	sendAjaxGet("../../util/request-types", getRequestTypes);
	
	
}

function getRequestTypes(xhr) {
	var response = JSON.parse(xhr.responseText);
	console.log(response);
	
	var requestList = document.getElementById("request-type");
	response.forEach(function(requestType) { 
		var requestOption = document.createElement("option");
		requestOption.value = requestType.key;
		requestOption.innerHTML = requestType.value;
		requestList.appendChild(requestOption);
	});
	
	
	sendAjaxGet("../../util/requests", checkManager);
	
}

function checkManager(xhr) {
	var response = JSON.parse(xhr.responseText);
	if (response.employees.length > 0) {
		document.getElementById("json-links").innerHTML = "<a href=\"../../requests\" >View All Requests</a> &nbsp; &bull; &nbsp;  <a href=\"../../employees\">View All Employees</a>";
	} else {
		document.getElementById("json-links").innerHTML = "<a href=\"../../requests\" >View My Requests</a>";
	}
	
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "none";
	document.getElementById("json-nav-links").style.display = "flex";
	document.getElementById("json-body").style.display = "block";
}

window.onload = function () {
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	
	sendAjaxGet("../../util/profile", getJson);
	
}