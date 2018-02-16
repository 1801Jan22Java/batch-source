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

function grabUsername(xhr){
	if(xhr.responseText){
		var res = JSON.parse(xhr.responseText);
		if(res.firstname != null){
			document.getElementById("currentUser").innerHTML = "Welcome, " + res.firstname;
		}
	} else {
		window.location = "http://localhost:8084/Reimbursements/login";
	}
}

window.onload = function(){
	sendAjaxGet("http://localhost:8084/Reimbursements/session", grabUsername);
}