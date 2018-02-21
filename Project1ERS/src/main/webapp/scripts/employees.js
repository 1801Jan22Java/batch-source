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
	document.getElementById("json-full-name").innerHTML = response.firstname + " " + response.lastname;
	document.getElementById("json-job-title").innerHTML = response.jobTitle;
	
	var months = ["NULL", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	
	if (response.employees.length > 0) {
		isManager = true;
		
		// Get all employees for the employee table
		var total = 0;
		var tb = document.createElement("tbody");
		response.employees.forEach(function(employee) { 
			total++;
			var tr = document.createElement("tr");
			var tdDate = document.createElement("td");
			tdDate.innerHTML = months[employee.creationDate.monthValue] + " " + employee.creationDate.dayOfMonth + ", " + employee.creationDate.year;
			tr.appendChild(tdDate);
			
			var tdName = document.createElement("td");
			tdName.innerHTML = employee.firstname + " " + employee.lastname;
			tr.appendChild(tdName);
			
			var tdTitle = document.createElement("td");
			tdTitle.innerHTML = employee.jobTitle;
			tr.appendChild(tdTitle);
			
			var tdEmail = document.createElement("td");
			tdEmail.innerHTML = employee.email;
			tr.appendChild(tdEmail);
			
			var tdManager = document.createElement("td");
			if (employee.reportsTo) {
				tdManager.innerHTML = employee.reportsTo.firstname + " " + employee.reportsTo.lastname;
			} else {
				tdManager.innerHTML = "No One";
			}
			tr.appendChild(tdManager);

			var tdUpdate = document.createElement("td");
			tdUpdate.innerHTML = "<a href=\"../profile?id=" + employee.employeeId + "\">Details</a>";
			tr.appendChild(tdUpdate);
			tb.appendChild(tr);
		});
		if (total == 0) {
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.colSpan = "6";
			td.innerHTML = "No Employees Found";
			tr.appendChild(td);
			tb.appendChild(tr);
		}
		document.getElementById("json-employee-roster-table").appendChild(tb);

		document.getElementById("json-no-script").style.display = "none";
		document.getElementById("json-loading").style.display = "none";
		document.getElementById("json-nav-links").style.display = "flex";
		document.getElementById("json-body").style.display = "block";
		
	} else {
		isManager = false;
		window.location = "../error";
	}
	
}

window.onload = function () {
	document.getElementById("json-no-script").style.display = "none";
	document.getElementById("json-loading").style.display = "block";
	
	
	sendAjaxGet("../util/employees", getJson);
}