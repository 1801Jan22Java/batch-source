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
		window.location = "../login?action=login";
	}
	if (response.action == "logout") {
		window.location = "../logout?action=login";
	}
	
	var months = ["NULL", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	
	document.getElementById("json-full-name").innerHTML = response.firstname + " " + response.lastname;
	document.getElementById("json-job-title").innerHTML = response.jobTitle;
	
	//Get all closed requests for the closed request table
	var total = 0;
	var tb = document.createElement("tbody");
	response.requests.forEach(function(request) { 
		total++;
		var tr = document.createElement("tr");
		tr.title = request.description;
		var tdDate = document.createElement("td");
		tdDate.innerHTML = "<span class='text-nowrap'>" + months[request.creationDate.monthValue] + " " + request.creationDate.dayOfMonth + ", " + request.creationDate.year + "</span>";
		tr.appendChild(tdDate);
		
		var tdType = document.createElement("td");
		tdType.innerHTML = request.requestType;
		tr.appendChild(tdType);
		
		var tdAmount = document.createElement("td");
		tdAmount.innerHTML = "$" + request.amount.toFixed(2).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");;
		tr.appendChild(tdAmount);

		var tdStatus = document.createElement("td");
		tdStatus.innerHTML = request.currentStatus;
		tr.appendChild(tdStatus);
		
		var tdManager = document.createElement("td");
		if (request.currentManager) {
			tdManager.innerHTML = request.currentManager.firstname + " " + request.currentManager.lastname;
		}
		tr.appendChild(tdManager);
		
		var tdDetails = document.createElement("td");
		tdDetails.innerHTML = "<a href=\"../request?id=" + request.requestId + "\">Details</a>";
		tr.appendChild(tdDetails);
		tb.appendChild(tr);
	});
	if (total == 0) {
		var tr = document.createElement("tr");
		var td = document.createElement("td");
		td.colSpan = "6";
		td.innerHTML = "No Requests Found";
		tr.appendChild(td);
		tb.appendChild(tr);
	}
	document.getElementById("json-requests-closed-table").appendChild(tb);
	
	document.getElementById("firstname").value = response.firstname;
	document.getElementById("firstname").placeholder = response.firstname;
	
	document.getElementById("lastname").value = response.lastname;
	document.getElementById("lastname").placeholder = response.lastname;
	
	document.getElementById("email").value = response.email;
	document.getElementById("email").placeholder = response.email;
	
	document.getElementById("job-title").value = response.jobTitle;
	document.getElementById("job-title").placeholder = response.jobTitle;
	
	document.getElementById("employee-id").value = response.employeeId;
	
	// Second servlet... keep loading screen
	sendAjaxGet("../util/requests", checkManager);
	
}

function checkManager(xhr) {
	var response = JSON.parse(xhr.responseText);
	// If they are a manager, show manager specific links at the bottom of the page
	if (response.employees.length > 0) {
		document.getElementById("json-links").innerHTML = "<a href=\"../requests\" >View All Requests</a> &nbsp; &bull; &nbsp;  <a href=\"../employees\">View All Employees</a>";
	// If they are not a manager, show employee specific links at the bottom of the page
	} else {
		document.getElementById("json-links").innerHTML = "<a href=\"../requests\" >Return To Request List</a>";
	}
	
	// Last servlet... hide loading screen
	// Hide the loading screen and show the nav links and main content
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "none";
	document.getElementById("json-nav-links").style.display = "flex";
	document.getElementById("json-body").style.display = "block";
}



window.onload = function () {
	// Use javascript to hide the static warning about enabling javascript in the user's browser and show the loading screen
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	
	// Obtain the GET parameters of the URL to populate any possible warnings
	var employeeId = 0;
	var action = "";
	var warning = "";
	var parameters = window.location.search.substring(1).split("&");
	parameters.forEach( function(parameter) { 
		var keyValue = parameter.split("=");
		if (keyValue[0] == "id") {
			employeeId = keyValue[1];
		} else if (keyValue[0] == "action"){
			action = keyValue[1];
		} else if (keyValue[0] == "warning"){
			warning = keyValue[1];
		}
	});
	
	if (action == "success") {
		document.getElementById("message").innerHTML = "Information Updated";
	} else if (action == "fail") {
		document.getElementById("message").innerHTML = "No Information Updated";
	}
	if ( (action == "success" || action == "fail") && warning == "bad-email" ) {
		document.getElementById("message").innerHTML = document.getElementById("message").innerHTML + "<br>Email is Not Available";
	} 
	
	var addToQuery = "";
	if (employeeId != 0) {
		addToQuery = "?id=" + employeeId;
	}
	
	// First servlet... keep loading screen
	sendAjaxGet("../util/profile" + addToQuery, getJson);
	
}