/**
 * 
 */

window.URL = window.URL || window.webkitURL;

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

function grabEmpDetails(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		document.querySelector("[name='fullName']").innerHTML = res.employee.firstName + " " + res.employee.lastName;
		document.querySelector("[name='firstName']").innerHTML = res.employee.firstName;
		document.querySelector("[name='lastName']").innerHTML = res.employee.lastName;
		document.querySelector("[name='username']").innerHTML = res.employee.userName;
		document.querySelector("[name='email']").innerHTML = res.employee.email;
		var tab = document.createElement("table");
		tab.setAttribute("id", "allEmps");
		tab.setAttribute("class","table");
		document.getElementById("tables").append(tab);
		var table = document.getElementById("allEmps");
		var header = table.createTHead();
		var headRow = header.insertRow(0);
		headRow.insertCell(0).innerHTML = "<b>Amount Requested</b>";
		headRow.insertCell(1).innerHTML = "<b>Date Submitted</b>";
		headRow.insertCell(2).innerHTML = "<b>Status</b>";
		headRow.insertCell(3).innerHTML = "<b>Resolved By</b>";
		var url = "/ExpenseReimbursements/getImage/";
		for(var i = 0; i < res.resolved.length; i++){
			var row = header.insertRow(i+1);
			url += res.resolved[i].reimburseId;
			row.setAttribute("onClick", "displayImage()");
			row.setAttribute("id", res.resolved[i].reimburseId);
			row.insertCell(0).innerHTML = res.resolved[i].amount;
			row.insertCell(1).innerHTML = res.resolved[i].dateSubmitted;
			row.insertCell(2).innerHTML = res.resolved[i].status.statusCode;
			row.insertCell(3).innerHTML = res.resolved[i].manager.firstName + " " + res.resolved[i].manager.lastName;
		}
		for(var i = 0; i < res.pending.length; i++){
			var row = header.insertRow();
			row.setAttribute("onClick", "displayImage()");
			row.insertCell(0).innerHTML = res.pending[i].amount;
			row.insertCell(1).innerHTML = res.pending[i].dateSubmitted;
			row.insertCell(2).innerHTML = res.pending[i].status.statusCode;
		}
	} else {
		window.location = "http://localhost:8084/ExpenseReimbursements/login";
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
	var paths = location.pathname.split('/');
	sendAjaxGet("http://localhost:8084/ExpenseReimbursements/employeeDetails/"+paths[3], grabEmpDetails);
}