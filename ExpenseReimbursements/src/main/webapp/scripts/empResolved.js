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


function viewEmployeeResolved(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("pendingRequests");
		for(var i = 0; i < res.length; i++){
			var row = table.insertRow(i+1);
			row.insertCell(0).innerHTML = "$" + res[i].amount;
			row.insertCell(1).innerHTML = res[i].dateSubmitted;
			row.insertCell(2).innerHTML = res[i].manager.firstName + " " + res[i].manager.lastName;
			row.insertCell(3).innerHTML = res[i].status.statusCode;
		}
	}
}

window.onload = function(){
	sendAjaxGet("http://localhost:8084/ExpenseReimbursements/viewEmpResolved", viewEmployeeResolved);
}