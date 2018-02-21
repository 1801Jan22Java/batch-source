

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");

	var status = document.getElementsByTagName("table")[0].id;
	var new_url = url + "?val=" + status;
	xhr.onreadystatechange = function() {
		console.log("readyState: " + xhr.readyState);
		console.log("status: " + xhr.status);
		if (this.readyState == 4 && this.status == 200) {

			document.getElementById("status").innerHTML = "";
			func(this,status);
		} else {
			document.getElementById("status").innerHTML = "Fetching results. Please be patient";
		}
	};
	xhr.open("GET", new_url, true);
	xhr.send();
};

function populateInformation(xhr,status) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById(status);
		if (res.length) {
			for(var r in res) {
				var obj = res[r];
				var newRow = document.createElement("tr");
				var remId = document.createElement("td");
				remId.innerHTML = obj.remId;
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
				var reimbursementInfo = document.createElement("td");
				console.log(obj.remId);
				reimbursementInfo.innerHTML = "<a href =\"http://localhost:8084/Project1/employeeviewreimbursement?val=" + obj.remId + "\">Click to view more info</a>";
				console.log(reimbursementInfo.innerHTML);
				newRow.appendChild(remId);
				newRow.appendChild(fname);
				newRow.appendChild(lname);
				newRow.appendChild(empId);
				newRow.appendChild(status);
				newRow.appendChild(value);
				newRow.appendChild(reimbursementInfo);
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
	sendAjaxGet("http://localhost:8084/Project1/employeegetreimbursement", populateInformation);
}
