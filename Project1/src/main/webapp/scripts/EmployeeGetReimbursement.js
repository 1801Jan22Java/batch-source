

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	
	var status = document.getElementsByTagName("table")[0].id;
	console.log(status);
	var new_url = url + "?val=" + status;
	xhr.onreadystatechange = function() {
		console.log("readyState: " + xhr.readyState);
		console.log("status: " + xhr.status);
		if (this.readyState == 4 && this.status == 200) {
			
			document.getElementById("status").innerHTML = "";
			func(this,status);
		} else {
			console.log("james is poop");
			document.getElementById("status").innerHTML = "Fetching results. Please be patient";
		}
	};
	xhr.open("GET", new_url, true);
	xhr.send();
};

function populateInformation(xhr,status) {
	console.log("hello from populate");
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		console.log(res);
		var table = document.getElementById(status);
		console.log(res.length);
		if (res.length) {
			for(var r in res) { 
				var obj = res[r];
				console.log(obj);
				var newRow = document.createElement("tr");
				var fname = document.createElement("td");
				fname.innerHTML = obj.fname;
				var lname = document.createElement("td");
				lname.innerHTML = obj.lname;
				var empId = document.createElement("td");
				empId.innerHTML = obj.empId;
				var status = document.createElement("td");
				status.innerHTML = obj.status;
				var value = document.createElement("td");
				value.innerHTML = obj.reimbursementVal;
				newRow.appendChild(fname);
				newRow.appendChild(lname);
				newRow.appendChild(empId);
				newRow.appendChild(status);
				newRow.appendChild(value);
				table.appendChild(newRow);
			}
		} else {
			document.getElementById("status").innerHTML = "No reimbursements to show";
		}
		
	} else {
		window.location = "http://localhost:8084/Project1/employeelogin";
	}
}

window.onload = function() {
	console.log("hello in view pending");
	sendAjaxGet("http://localhost:8084/Project1/employeegetreimbursement", populateInformation);
}