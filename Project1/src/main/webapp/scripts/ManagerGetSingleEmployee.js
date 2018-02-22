
function sendAjaxPost(url, func) {
	console.log("click");
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("status").innerHTML = "";
			func(this);
		} else if (this.readyState != 4) {
			document.getElementById("status").innerHTML = "Loading Information Please wait";
		}
	};
	console.log(location.href.split("?")[1]);
	var new_url = url + "?" + location.href.split("?")[1];
	xhr.open("POST", new_url, true);
	xhr.send();
};

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("information");
		var empId = document.createElement("tr");
		empId.innerHTML ="<td>Employee Id: </td><td>" + res.empId + "</td>";
		var fname = document.createElement("tr");
		fname.innerHTML ="<td>First Name: </td><td>" + res.fname + "</td>";
		var lname = document.createElement("tr");
		lname.innerHTML = "<td>Last Name: </td><td>" + res.lname + "</td>";
		var email = document.createElement("tr");
		email.innerHTML = "<td>Email: </td><td>" + res.email + "</td>";
		var addrs = document.createElement("tr");
		addrs.innerHTML = "<td>Address: </td><td>" + res.addrs + "</td>";
		table.appendChild(fname);
		table.appendChild(lname);
		table.appendChild(email);
		table.appendChild(addrs);
		var reimbursements = document.getElementById("reimbursement");
		var arr = res.arr;
		console.log(arr);
		for (var a in arr) {
			console.log(a);
			var obj = arr[a];
			console.log(obj);
			var newRow = document.createElement("tr");
			var remId = document.createElement("td");
			remId.innerHTML = obj.remId;
			var manId = document.createElement("td");
			manId.innerHTML = obj.manId;
			var status = document.createElement("td");
			status.innerHTML = obj.status;
			var reimbursementVal = document.createElement("td");
			reimbursementVal.innerHTML = obj.reimbursementVal;
			var reimbursementInfo = document.createElement("td");
			reimbursementInfo.innerHTML = "<a href=\" http://localhost:8084/Project1/managerviewreimbursement?val=" + obj.remId + "\" >Click for more information</a>";
			newRow.appendChild(remId);
			newRow.appendChild(manId);
			newRow.appendChild(status);
			newRow.appendChild(reimbursementVal);
			newRow.appendChild(reimbursementInfo);
			reimbursements.appendChild(newRow);
		}
	} else {
		window.location = "http://localhost:8084/Project1/managerlogin";
	}
}

window.onload = function() {
	console.log("hellio");
	sendAjaxPost("http://localhost:8084/Project1/managergetsingleemployee", populateInformation);
}
