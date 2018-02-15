/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

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
}

function simpleLog(xhr) {
	console.log(xhr);
}

window.onload = function() {
	
	sendAjaxGet('getprofile', displayProfile);
}
