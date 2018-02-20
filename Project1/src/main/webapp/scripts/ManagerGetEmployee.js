/**
 *
 */

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("status").innerHTML = "";
			func(this);
		} else {
			document.getElementById("status").innerHTML = "Fetching results. Please be patient";
		}
	};
	xhr.open("POST", url, true);
	xhr.send();
};

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		if (res.length) {
			var table = document.getElementById("table");
			for (var r in res) {
				var obj = res[r];
				var newRow = document.createElement("tr");
				var fname = document.createElement("td");
				fname.innerHTML = obj.fname;
				var lname = document.createElement("td");
				lname.innerHTML = obj.lname;
				var empId = document.createElement("td");
				empId.innerHTML = obj.empId;
				var email = document.createElement("td");
				email.innerHTML = obj.email;
				var addrs = document.createElement("td");
				addrs.innerHTML = obj.address;
				var user  = document.createElement("td");
				user.innerHTML  = obj.username;
				var pass  = document.createElement("td");
				pass.innerHTML  = obj.password;

				newRow.appendChild(fname);
				newRow.appendChild(lname);
				newRow.appendChild(empId);
				newRow.appendChild(email);
				newRow.appendChild(addrs);
				newRow.appendChild(user);
				newRow.appendChild(pass);
				table.appendChild(newRow);

			}

		} else {
			document.getElementById("status").innerHTML = "No reimbursements to show";
		}

	} else {
		window.location = "http://localhost:8084/Project1/managerlogin";
	}
}

window.onload = function() {
	sendAjaxPost("http://localhost:8084/Project1/managergetemployee", populateInformation);
}
