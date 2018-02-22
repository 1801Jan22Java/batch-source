/**
 * 
 */
function getAllEmployees(xhr) {
	var res = JSON.parse(xhr.response);
	
	var table = document.getElementById("myTable");
	for (var i = 0; i < res.length; i++) {
		var row = table.insertRow(i + 1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		var cell6 = row.insertCell(5);
		var cell7 = row.insertCell(6);
		cell1.innerHTML = res[i].email;	
		cell2.innerHTML = res[i].firstName;	
		cell3.innerHTML = res[i].lastName;
		cell4.innerHTML = res[i].address;
		cell5.innerHTML = res[i].city;
		cell6.innerHTML = res[i].state;
		cell7.innerHTML = res[i].phoneNumber;
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
	sendAjaxGet('getallemployees', getAllEmployees);
};