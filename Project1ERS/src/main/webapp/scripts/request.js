//As soon as DOM is built
document.getElementById("json-no-script").style.display = "none";
document.getElementById("json-loading").style.display = "block";

//global variable for internal checking
var isManager = false;
var sessionId = 0;
var requestAuthorId = 0;
var currentStatus = "";

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

function checkManager(xhr) {
	var response = JSON.parse(xhr.responseText);
	console.log(response);
	
	if (response.action == "login") {
		window.location = "../login?action=login";
	}
	if (response.action == "logout") {
		window.location = "../logout?action=login";
	}
	if (response.action == "requests") {
		window.location = "../requests";
	}
	if (response.action == "not-found") {
		window.location = "../requests?action=not-found";
	}
	
	sessionId = response.employeeId;
	
	if (response.employees.length > 0) {
		isManager = true;
	} else {
		isManager = false
	}
	
	
	var requestId = -1;
	var action = "";
	var parameters = window.location.search.substring(1).split("&");
	parameters.forEach(function(parameter) { 
		var keyValue = parameter.split("=");
		if (keyValue[0] == "id") {
			requestId = keyValue[1];
		} else if (keyValue[0] == "action"){
			action = keyValue[1];
		}
	});
	if (action == "success") {
		document.getElementById("message").innerHTML = "Information Updated";
	} else if (action == "fail") {
		document.getElementById("message").innerHTML = "No Information Updated";
	}
	
	var addToQuery = "";
	if (requestId > -1) {
		addToQuery = "?id=" + requestId;
	}
	
	// Can only call getJson after the sessionId is known
	sendAjaxGet("../util/request" + addToQuery, getJson);
}

function getJson(xhr) {
	var response = JSON.parse(xhr.responseText);
	console.log(response);
	if (response.action == "login") {
		window.location = "../login?action=login";
	}
	if (response.action == "logout") {
		window.location = "../logout?action=login";
	}
	if (response.action == "requests") {
		window.location = "../requests";
	}
	if (response.action == "not-found") {
		window.location = "../requests?action=not-found";
	}
	
	
	var months = ["NULL", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	
	requestAuthorId = response.employeeId;
	currentStatus = response.requests[0].currentStatus;
	document.getElementById("json-full-name").innerHTML = response.firstname + " " + response.lastname;
	document.getElementById("json-job-title").innerHTML = response.jobTitle;
	
	document.getElementById("json-date").innerHTML = months[response.requests[0].creationDate.monthValue] + " " + response.requests[0].creationDate.dayOfMonth + ", " + response.requests[0].creationDate.year
	document.getElementById("json-type").innerHTML = response.requests[0].requestType;
	document.getElementById("json-amount").innerHTML = "$" + response.requests[0].amount.toFixed(2).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
	if ( (response.requests[0].currentStatus == "Approved" || response.requests[0].currentStatus == "Denied") && response.requests[0].currentManager ) {
		document.getElementById("json-status").innerHTML = response.requests[0].currentStatus + " by " + response.requests[0].currentManager.firstname + " " + response.requests[0].currentManager.lastname;
	} else {
		document.getElementById("json-status").innerHTML = response.requests[0].currentStatus;
	}
	document.getElementById("json-description").innerHTML = "\"" + response.requests[0].description + "\"";
	
	// Uses global variable initialized by checkManager
	if (isManager) {
		document.getElementById("json-links").innerHTML = "<a href=\"../requests\" >View All Requests</a> &nbsp; &bull; &nbsp;  <a href=\"../employees\">View All Employees</a> &nbsp; &bull; &nbsp;  <a href=\"../profile?id=" + response.employeeId + "\">View " + response.firstname + "'s Requests</a>";
	} else {
		document.getElementById("json-links").innerHTML = "<a href=\"../requests\" >View My Requests</a>";
	}
	
	// Uses global variable initialized by checkManager
	if (response.requests[0].currentStatus == "Cancelled") {
		if (response.employeeId == sessionId) {
			document.getElementById("json-update-form").style.display = "block";
		} else {
			document.getElementById("json-update-form").style.display = "none";
		}
	} else if (response.requests[0].currentStatus == "Approved" || response.requests[0].currentStatus == "Denied") {
		if (isManager) {
			document.getElementById("json-update-form").style.display = "block";
		} else {
			document.getElementById("json-update-form").style.display = "none";
		}
	}
	
	// Get all events for the request
	var total = 0;
	var tb = document.createElement("tbody");
	response.requests[0].events.forEach(function(event) { 
		total++;
		var tr = document.createElement("tr");
		var tdDate = document.createElement("td");
		tdDate.innerHTML = months[event.creationDate.monthValue] + " " + event.creationDate.dayOfMonth + ", " + event.creationDate.year;
		tr.appendChild(tdDate);
		
		var tdAuthor = document.createElement("td");
		tdAuthor.innerHTML = event.eventAuthor.firstname + " " + event.eventAuthor.lastname;
		tr.appendChild(tdAuthor);
		
		var tdStatus = document.createElement("td");
		tdStatus.innerHTML = event.requestStatus;
		tr.appendChild(tdStatus);
		
		var tdMessage = document.createElement("td");
		tdMessage.innerHTML = "\"" + event.message + "\"";
		tr.appendChild(tdMessage);
		tb.appendChild(tr);
	});
	if (total == 0) {
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.colSpan = "4";
		td.innerHTML = "No Updates Found";
		tr.appendChild(td);
		tb.appendChild(tr);
	}
	document.getElementById("json-history-table").appendChild(tb);
	
	// Get all uploads for the request
	var total = 0;
	var tb = document.createElement("tbody");
	response.requests[0].uploads.forEach(function(upload) { 
		total++;
		var tr = document.createElement("tr");
		var tdDate = document.createElement("td");
		tdDate.innerHTML = months[upload.creationDate.monthValue] + " " + upload.creationDate.dayOfMonth + ", " + upload.creationDate.year;
		tr.appendChild(tdDate);
		
		var tdAuthor = document.createElement("td");
		tdAuthor.innerHTML = upload.uploadAuthor.firstname + " " + upload.uploadAuthor.lastname;
		tr.appendChild(tdAuthor);
		
		var tdFilename = document.createElement("td");
		tdFilename.innerHTML = "<a href=\"http://localhost:8088/uploads/" + upload.filename + "\" target=\"_blank\" >" + upload.displayName + "</a>";
		tr.appendChild(tdFilename);
		tb.appendChild(tr);
	});
	if (total == 0) {
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.colSpan = "3";
		td.innerHTML = "No Files Found";
		tr.appendChild(td);
		tb.appendChild(tr);
	}
	document.getElementById("json-file-table").appendChild(tb);
	
	document.getElementById("request-id").value = response.requests[0].requestId;
	
	
	// Can only call getRequestStatuses after the requestAuthorId is known
	sendAjaxGet("../util/request-statuses", getRequestStatuses)
	
}

function getRequestStatuses(xhr) {
	var response = JSON.parse(xhr.responseText);
	console.log(response);
	
	// Uses global variables initialized by checkManager
	var statusList = document.getElementById("request-status");
	response.forEach(function(requestStatus) { 
		// Only the request author is allowed to see the cancel option if it is not already cancelled or approved or denied
		// Only a manager who is not the author can see the approve and deny options if it is not already approved or denied or cancelled
		// Only the request author is allowed to see the reopen option if it is cancelled
		// Only a manager who is not the author is allowed to see the reopen option if it is approved or denied
		// Pending is only available to a request that is already pending 
		if ( (requestStatus.value == "Cancelled" && requestAuthorId == sessionId && currentStatus != "Approved" && currentStatus != "Denied" && currentStatus != "Cancelled")
		  || ( (requestStatus.value == "Approved" || requestStatus.value == "Denied") && isManager && requestAuthorId != sessionId && currentStatus != "Approved" && currentStatus != "Denied" && currentStatus != "Cancelled")
		  || (requestStatus.value == "Reopened" && requestAuthorId == sessionId && currentStatus == "Cancelled")
		  || (requestStatus.value == "Reopened" && isManager && requestAuthorId != sessionId && (currentStatus == "Approved" || currentStatus == "Denied") )
		  || (requestStatus.value == "Pending" && currentStatus == "Pending")
		) {
			var statusOption = document.createElement("option");
			statusOption.value = requestStatus.key;
			statusOption.innerHTML = requestStatus.value;
			statusList.appendChild(statusOption);
		}
	});
	
	statusList.onchange = function() { updateSubmitButton(this); };
	
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "none";
	document.getElementById("json-nav-links").style.display = "flex";
	document.getElementById("json-body").style.display = "block";
}

function updateSubmitButton(list) {
	var newButtonDisplay = "Update";
	switch(list.options[list.selectedIndex].childNodes[0].textContent) {
	case "Approved":
		newButtonDisplay = "Approve";
		break;
	case "Denied":
		newButtonDisplay = "Deny";
		break;
	case "Cancelled":
		newButtonDisplay = "Cancel";
		break;
	case "Reopened":
		newButtonDisplay = "Reopen";
		break;
	}
	document.getElementById("json-submit-button").textContent = newButtonDisplay + " Request";
}

window.onload = function () {
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	
	sendAjaxGet("../util/requests", checkManager);
}