/**
 * 
 */
function getEmployeeInfo(xhr) {
	var res = JSON.parse(xhr.response);
	var table = document.getElementById("myTable");

	table.rows[1].cells[1].innerHTML = res.address;
	table.rows[2].cells[1].innerHTML = res.city;
	table.rows[3].cells[1].innerHTML = res.state;
	table.rows[4].cells[1].innerHTML = res.phoneNumber;
	
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
	sendAjaxGet('getemployeeinfo', getEmployeeInfo);
};