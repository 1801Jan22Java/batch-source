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

function seeOneReq(xhr){
    if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		if (res) {
            var table = document.getElementById("empReqTableBody");
            
            res.forEach(function(element) {
            	var row = document.createElement("tr");
            	var employee = document.createElement("td");
            	var amount = document.createElement("td");
            	var description = document.createElement("td");
            	var status = document.createElement("td");
            	var reply = document.createElement("td");
            	
            	employee.innerHTML=element.employeeID;
            	row.appendChild(employee);
            	
            	amount.innerHTML=element.amount;
            	row.appendChild(amount);
            	
            	description.innerHTML=element.description;
            	row.appendChild(description);
            	
            	status.innerHTML=element.status;
            	row.appendChild(status);
            	
            	reply.innerHTML=element.reply;
            	row.appendChild(reply);
            	
            	table.appendChild(row);
            });
            
		}
		console.log(table);
	} else {
		window.location = "http://localhost:8080:ProjectNo1/employee_requests.html";
	}
};

window.onload = function () {
	sendAjaxGet("../employee_requests", seeOneReq);
};
