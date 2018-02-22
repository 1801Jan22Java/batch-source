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
			
			 {
	            var row = document.createElement("tr");
	            res.tableValues.forEach(function(element) {
	            	
	            	var col = document.createElement("td");
	            	col.innerHTML=element;
	            	row.appendChild(col);
	                
	            });
	            table.appendChild(row);
			}});
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