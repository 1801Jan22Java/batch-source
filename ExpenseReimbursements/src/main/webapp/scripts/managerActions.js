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

function sendAjaxGetImage(url, func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
	xhr.responseType = 'blob';
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
		if(res.firstName != null){
			document.getElementById("currentUser").innerHTML = "Welcome to the Manager Homepage, " + res.firstName;
		}
	} else {
		window.location = "http://localhost:8084/ExpenseReimbursements/login";
	}
}

function viewAllUsers(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(document.getElementById("allEmps") != null){
			document.getElementById("allEmps").remove();
		}
		document.getElementById("downloadImg").src = "";
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		tab.setAttribute("class", "table table-hover");
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
			row.insertCell(4).innerHTML = "<a href=\"http://localhost:8084/ExpenseReimbursements/employeeInformation/"+res[i].userId+"\">Click for More Information</button>";
		}
	}
}

function viewAllPendingRequests(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(document.getElementById("allEmps") != null){
			document.getElementById("allEmps").remove();
		}
		
		document.getElementById("downloadImg").src = "";
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		tab.setAttribute("class", "table");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>Employee Name</b>";
		headRow.insertCell(1).innerHTML = "<b>Amount Requested</b>";
		headRow.insertCell(2).innerHTML = "<b>Date Submitted</b>";
		headRow.insertCell(3).innerHTML = "<b>Manager Action</b>";
		var url = "http://localhost:8084/ExpenseReimbursements/approveReimbursement/";
		var url2 = "http://localhost:8084/ExpenseReimbursements/declineReimbursement/";
		for(var i = 0; i < res.length; i++){
			var row = header.insertRow(i+1);
			row.setAttribute("id", res[i].reimburseId);
			row.insertCell(0).innerHTML = res[i].employee.firstName + " " + res[i].employee.lastName;
			row.insertCell(1).innerHTML = "$" + res[i].amount;
			row.insertCell(2).innerHTML = res[i].dateSubmitted;
			row.insertCell(3).innerHTML = "<a href="+url+res[i].reimburseId+"><button class=\"btn btn-outline-success\">Approve</button><a href="+url2+res[i].reimburseId+"><button class=\"btn btn-outline-danger\">Decline</button>"
			for(var j = 0; j < row.childNodes.length - 1; j++){
				row.childNodes[j].setAttribute("onclick", "displayImage()");
			}
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
		tab.setAttribute("class", "table");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>Employee Name</b>";
		headRow.insertCell(1).innerHTML = "<b>Amount Requested</b>";
		headRow.insertCell(2).innerHTML = "<b>Date Submitted</b>";
		headRow.insertCell(3).innerHTML = "<b>Status</b>";
		headRow.insertCell(4).innerHTML = "<b>Resolved By</b>";
		
		document.getElementById("downloadImg").src = "";

		for(var i = 0; i < res.length; i++){
			var row = header.insertRow(i+1);
			row.setAttribute("onClick", "displayImage()");
			row.setAttribute("id", res[i].reimburseId);
			row.insertCell(0).innerHTML = res[i].employee.firstName + " " + res[i].employee.lastName;
			row.insertCell(1).innerHTML = "$" + res[i].amount;
			row.insertCell(2).innerHTML = res[i].dateSubmitted;
			row.insertCell(3).innerHTML = res[i].status.statusCode;
			row.insertCell(4).innerHTML = res[i].manager.firstName + " " + res[i].manager.lastName;
		}
	}
}

function displayImage(){
	sendAjaxGetImage("/ExpenseReimbursements/getImage?reimburseId="+ event.target.parentNode.getAttribute("id"), getReimburseImg);
}

function getReimburseImg(xhr){
	 var blob = new Blob([xhr.response], {type: 'image/jpg'});
	    if (blob) {
	        document.getElementById("downloadImg").src = window.URL.createObjectURL(blob);
	    }
}

window.onload = function(){
	sendAjaxGet("http://localhost:8084/ExpenseReimbursements/session", grabUsername);
	document.getElementById("manager").addEventListener('click', function(){
		var selection = document.getElementsByTagName("select")[1].value;
		switch(selection){
		case "allEmployees":
			sendAjaxGet("http://localhost:8084/ExpenseReimbursements/viewAllEmployees", viewAllUsers);
			break;
		case "viewAllPendingRequests":
			sendAjaxGet("http://localhost:8084/ExpenseReimbursements/viewAllPendingRequests", viewAllPendingRequests);
			break;
		case "viewAllResolvedRequests":
			sendAjaxGet("http://localhost:8084/ExpenseReimbursements/viewAllResolvedRequests", viewAllRevolvedRequests);
		default:
			break;
		}
	}, false);
}