/**
 * 
 */
function getThisEmployeesRequests(xhr) {
	var res = JSON.parse(xhr.response);
	
	var table = document.getElementById("myTable");
	for (var i = 0; i < res.length; i++) {
		var row = table.insertRow(i + 1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		cell1.innerHTML = "$"+res[i].requestAmount;	
		cell2.innerHTML = res[i].requestComment;	
		cell3.innerHTML = res[i].requestStatus.requestStatusName;	
	}
};


function sendAjaxGet(url, func) {
	// step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	// step 2: define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	// step 3: prepare request
	xhr.open("GET", url, true);
	// step 4: send request
	xhr.send();
};

window.onload = function() {
	sendAjaxGet('getthisemployeesrequests', getThisEmployeesRequests);
};