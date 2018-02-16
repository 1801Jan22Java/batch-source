/**
 * 
 */

function sendAjaxGet(url, func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function grabUsername(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(res.firstname != null){
			document.getElementById("currentUser").innerHTML = "Welcome, " + res.firstname;
		}
	} else {
		window.location = "http://localhost:8084/Reimbursements/login";
	}
}

function viewAllUsers(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(document.getElementById("allEmps") != null){
			document.getElementById("allEmps").remove();
		}
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>First Name</b>";
		headRow.insertCell(1).innerHTML = "<b>Last Name</b>";
		headRow.insertCell(2).innerHTML = "<b>Email</b>";
		headRow.insertCell(3).innerHTML = "<b>Username</b>";
		headRow.insertCell(4).innerHTML = "<b>Reimbursement info</b>";
		for(var i = 0; i < res.length; i++){
			var row = header.insertRow(i+1);
			row.insertCell(0).innerHTML = res[i].firstName;
			row.insertCell(1).innerHTML = res[i].lastName;
			row.insertCell(2).innerHTML = res[i].email;
			row.insertCell(3).innerHTML = res[i].userName;
			row.insertCell(4).innerHTML = "<a href=\"/Reimbursements/login\">Need To Change to actual link" + res[i].userId + "</a>";
		}
	}
}

function viewAllPendingRequests(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(document.getElementById("allEmps") != null){
			document.getElementById("allEmps").remove();
		}
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>Reimbursement ID</b>";
		headRow.insertCell(1).innerHTML = "<b>Employee ID</b>";
		headRow.insertCell(2).innerHTML = "<b>Employee Name</b>";
		headRow.insertCell(3).innerHTML = "<b>Amount Requested</b>";
		headRow.insertCell(4).innerHTML = "<b>Date Submitted</b>";
		headRow.insertCell(5).innerHTML = "<b>Manager Action</b>";
		var url = "http://localhost:8084/Reimbursements/approveReimbursement/";
		var url2 = "http://localhost:8084/Reimbursements/declineReimbursement/";
		for(var i = 0; i < res.length; i++){
			var row = header.insertRow(i+1);
			row.insertCell(0).innerHTML = res[i].reimburseId;
			row.insertCell(1).innerHTML = res[i].employee.userId;
			row.insertCell(2).innerHTML = res[i].employee.firstName + " " + res[i].employee.lastName;
			row.insertCell(3).innerHTML = res[i].amount;
			row.insertCell(4).innerHTML = res[i].dateSubmitted;
			row.insertCell(5).innerHTML = "<a href="+url+res[i].reimburseId+"><button>Approve</button><a href="+url2+res[i].reimburseId+"><button>Decline</button>"
		}
	}
}

function viewAllRevolvedRequests(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(document.getElementById("allEmps") != null){
			document.getElementById("allEmps").remove();
		}
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>Reimbursement ID</b>";
		headRow.insertCell(1).innerHTML = "<b>Employee ID</b>";
		headRow.insertCell(2).innerHTML = "<b>Employee Name</b>";
		headRow.insertCell(3).innerHTML = "<b>Amount Requested</b>";
		headRow.insertCell(4).innerHTML = "<b>Date Submitted</b>";
		headRow.insertCell(5).innerHTML = "<b>Status</b>";
		headRow.insertCell(6).innerHTML = "<b>Resolved By</b>";

		for(var i = 0; i < res.length; i++){
			var row = header.insertRow(i+1);
			row.insertCell(0).innerHTML = res[i].reimburseId;
			row.insertCell(1).innerHTML = res[i].employee.userId;
			row.insertCell(2).innerHTML = res[i].employee.firstName + " " + res[i].employee.lastName;
			row.insertCell(3).innerHTML = res[i].amount;
			row.insertCell(4).innerHTML = res[i].dateSubmitted;
			row.insertCell(5).innerHTML = res[i].status.statusCode;
			row.insertCell(6).innerHTML = res[i].manager.firstName + " " + res[i].manager.lastName;
		}
	}
}

window.onload = function(){
	sendAjaxGet("http://localhost:8084/Reimbursements/session", grabUsername);
	document.getElementById("button").addEventListener('click', function(){
		var selection = document.getElementsByTagName("select")[0].value;
		switch(selection){
		case "allEmployees":
			sendAjaxGet("http://localhost:8084/Reimbursements/viewAllEmployees", viewAllUsers);
			break;
		case "viewAllPendingRequests":
			sendAjaxGet("http://localhost:8084/Reimbursements/viewAllPendingRequests", viewAllPendingRequests);
			break;
		case "viewAllResolvedRequests":
			sendAjaxGet("http://localhost:8084/Reimbursements/viewAllResolvedRequests", viewAllRevolvedRequests);
		default:
			break;
			
		}
	}, false);
}