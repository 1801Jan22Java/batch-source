/**
 * 
 */

function sendAjaxGet(url, func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}


function userInfo(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("empInfo");
		var row = table.insertRow(1);
		row.insertCell(0).innerHTML = res.firstName;
		row.insertCell(1).innerHTML = res.lastName;
		row.insertCell(2).innerHTML = res.email;
		row.insertCell(3).innerHTML = res.userName;
		row.insertCell(4).innerHTML = res.password;
	}
}

window.onload = function(){
	sendAjaxGet("http://localhost:8084/ExpenseReimbursements/userInfo", userInfo);
}