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
			window.location = "login?action=login";
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
	document.getElementById("json-full-name").innerHTML = response.firstname + " " + response.lastname;
	document.getElementById("json-job-title").innerHTML = response.jobTitle;
	
	var months = ["NULL", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	
	if (response.employees.length > 0) {
		isManager = true;
		document.getElementById("json-employee-open").style.display = "none";
		document.getElementById("json-employee-closed").style.display = "none";
		document.getElementById("json-admin-open").style.display = "none";
		document.getElementById("json-admin-closed").style.display = "none";
		
		// Get all open requests for the open request table
		var total = 0;
		var tb = document.createElement("tbody");
		response.employees.forEach(function(employee) { 
			employee.requests.forEach(function(request) { 
				if (request.currentStatus == "Pending") {
					total++;
					var tr = document.createElement("tr");
					tr.title = request.description;
					var tdDate = document.createElement("td");
					tdDate.innerHTML = "<span class='text-nowrap'>" + months[request.creationDate.monthValue] + " " + request.creationDate.dayOfMonth + ", " + request.creationDate.year + "</span>";
					tr.appendChild(tdDate);
					
					var tdAuthor = document.createElement("td");
					tdAuthor.innerHTML = employee.firstname + " " + employee.lastname;
					tr.appendChild(tdAuthor);
					
					var tdType = document.createElement("td");
					tdType.innerHTML = request.requestType;
					tr.appendChild(tdType);
					
					var tdAmount = document.createElement("td");
					tdAmount.innerHTML = "$" + request.amount.toFixed(2).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					tr.appendChild(tdAmount);
					
					var tdStatus = document.createElement("td");
					tdStatus.innerHTML = request.currentStatus;
					tr.appendChild(tdStatus);
					
					var tdDetails = document.createElement("td");
					tdDetails.innerHTML = "<a href=\"../request?id=" + request.requestId + "\">Details</a>";
					tr.appendChild(tdDetails);
					tb.appendChild(tr);
				}
			});
			
		});
		if (total == 0) {
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.colSpan = "6";
			td.innerHTML = "No Requests Found";
			tr.appendChild(td);
			tb.appendChild(tr);
		}
		document.getElementById("json-admin-open-table").appendChild(tb);
		
		//Get all closed requests for the closed request table
		var total = 0;
		var tb = document.createElement("tbody");
		response.employees.forEach(function(employee) { 
			employee.requests.forEach(function(request) { 
				if (request.currentStatus != "Pending") {
					total++;
					var tr = document.createElement("tr");
					tr.title = request.description;
					var tdDate = document.createElement("td");
					tdDate.innerHTML = "<span class='text-nowrap'>" + months[request.creationDate.monthValue] + " " + request.creationDate.dayOfMonth + ", " + request.creationDate.year + "</span>";
					tr.appendChild(tdDate);
					
					var tdAuthor = document.createElement("td");
					tdAuthor.innerHTML = employee.firstname + " " + employee.lastname;
					tr.appendChild(tdAuthor);
					
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
				}
			});
			
		});
		if (total == 0) {
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.colSpan = "7";
			td.innerHTML = "No Requests Found";
			tr.appendChild(td);
			tb.appendChild(tr);
		}
		document.getElementById("json-admin-closed-table").appendChild(tb);
		// Only show open requests on load
		document.getElementById("json-admin-open").style.display = "block";
	} else {
		isManager = false;
		document.getElementById("json-employee-open").style.display = "none";
		document.getElementById("json-employee-closed").style.display = "none";
		document.getElementById("json-admin-open").style.display = "none";
		document.getElementById("json-admin-closed").style.display = "none";
		
		
		// Get all open requests for the open request table
		var total = 0;
		var tb = document.createElement("tbody");
		response.requests.forEach(function(request) { 
			if (request.currentStatus == "Pending") {
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
				
				var tdDetails = document.createElement("td");
				tdDetails.innerHTML = "<a href=\"../request?id=" + request.requestId + "\">Details</a>";
				tr.appendChild(tdDetails);
				tb.appendChild(tr);
			}
		});
		if (total == 0) {
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.colSpan = "5";
			td.innerHTML = "No Requests Found";
			tr.appendChild(td);
			tb.appendChild(tr);
		}
		document.getElementById("json-employee-open-table").appendChild(tb);
		
		//Get all closed requests for the closed request table
		var total = 0;
		var tb = document.createElement("tbody");
		response.requests.forEach(function(request) { 
			if (request.currentStatus != "Pending") {
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
			}
		});
		if (total == 0) {
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.colSpan = "6";
			td.innerHTML = "No Requests Found";
			tr.appendChild(td);
			tb.appendChild(tr);
		}
		document.getElementById("json-employee-closed-table").appendChild(tb);
		
		// Only show open requests on load
		document.getElementById("json-employee-open").style.display = "block";
	}
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "none";
	document.getElementById("json-nav-links").style.display = "flex";
	document.getElementById("json-body").style.display = "block";
}

function showClosed() {
	document.getElementById("json-employee-open").style.display = "none";
	document.getElementById("json-employee-closed").style.display = "none";
	document.getElementById("json-admin-open").style.display = "none";
	document.getElementById("json-admin-closed").style.display = "none";
	
	document.getElementById("json-body").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	setTimeout(function() {
		document.getElementById("json-loading").style.display = "none";
		document.getElementById("json-body").style.display = "block";
		if (isManager) {
			document.getElementById("json-admin-closed").style.display = "block";
		} else {
			document.getElementById("json-employee-closed").style.display = "block";
		}
	}, 1000);
}

function showOpen() {
	document.getElementById("json-employee-open").style.display = "none";
	document.getElementById("json-employee-closed").style.display = "none";
	document.getElementById("json-admin-open").style.display = "none";
	document.getElementById("json-admin-closed").style.display = "none";
	
	document.getElementById("json-body").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	setTimeout(function() {
		document.getElementById("json-loading").style.display = "none";
		document.getElementById("json-body").style.display = "block";
		if (isManager) {
			document.getElementById("json-admin-open").style.display = "block";
		} else {
			document.getElementById("json-employee-open").style.display = "block";
		}
	}, 1000);
}

window.onload = function () {
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	
	var openLinks = document.getElementsByClassName("view-open-link");
	for (var i = 0; i < openLinks.length; i++) {
		openLinks[i].onclick = function() { showOpen(); };
	}
	var closedLinks = document.getElementsByClassName("view-closed-link");
	for (var i = 0; i < closedLinks.length; i++) {
		closedLinks[i].onclick = function() { showClosed(); };
	}
	
	var action = "";
	var parameters = window.location.search.substring(1).split("&");
	parameters.forEach(function(parameter) { 
		var keyValue = parameter.split("=");
		if (keyValue[0] == "action"){
			action = keyValue[1];
		}
	});
	if (action == "success") {
		document.getElementById("message").innerHTML = "Request Was Added";
	} else if (action == "fail") {
		document.getElementById("message").innerHTML = "Request Was Not Added";
	} else if (action == "not-found") {
		document.getElementById("message").innerHTML = "Page Not Found";
	}
	
	
	sendAjaxGet("../util/requests", getJson);
}