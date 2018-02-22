function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function seeOneInfo(xhr){
    if (xhr.responseText) {
		var emps = JSON.parse(xhr.responseText);
		console.log(emps);
		var table = document.getElementById("empReqTableBody");
		if(emps){
			emps.forEach(function(res) {            
	            	var row = document.createElement("tr");
	            	var request = document.createElement("td");
	            	var employee = document.createElement("td");
	            	var amount = document.createElement("td");
	            	var description = document.createElement("td");
	            	var status = document.createElement("td");
	            	var reply = document.createElement("td");
	            	
	            	request.innerHTML=res.requestID;
	            	row.appendChild(request);
	            	
	            	employee.innerHTML=res.employeeID;
	            	row.appendChild(employee);
	            	
	            	amount.innerHTML=res.amount;
	            	row.appendChild(amount);
	            	
	            	description.innerHTML=res.description;
	            	row.appendChild(description);
	            	
	            	status.innerHTML=res.status;
	            	row.appendChild(status);
	            	
	            	if(res.reply){
		            	reply.innerHTML=res.reply;
		            	row.appendChild(reply);
	            	} else {
	            		reply.innerHTML="Not Resolved";
	            		row.appendChild(reply);
	            	}
	            	
	            	table.appendChild(row);
	            table.appendChild(row);
			});
		}
	} else {
		window.location = "http://localhost:8080:ProjectNo1/manager_requests.html";
	}
};

window.onload = function () {
	sendAjaxGet("../manager_requests", seeOneInfo);
};/**
 * 
 */