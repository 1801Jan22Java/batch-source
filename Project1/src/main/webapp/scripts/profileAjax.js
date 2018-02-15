/**
 * 
 */

function sendAjaxGet(url, func) {
	// Step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	// Step 2: define onreadystatechange
	// We want to check the ready state and the status
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

	// Step 3: prepare request
	xhr.open("GET", url, true);
	xhr.send();

}

function displayProfile(xhr){
	var user = JSON.parse(xhr.responseText);
	var position = "";
	if(user.position_id==1){
		position = "Employee";
	} else if(user.position_id==2){
		position = "Manager"
	}
	document.getElementById("username").textContent = user.username;
	document.getElementById("firstname").value = user.firstname;
	document.getElementById("lastname").value = user.lastname;
	document.getElementById("position").textContent = position;
	document.getElementById("password").value = user.password;
}

function simpleLog(xhr) {
	console.log(xhr);
}

window.onload = function() {
	
	sendAjaxGet('getprofile', displayProfile);
}
