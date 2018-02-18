/**
 * 
 */

function sendAjaxGet(url, func){
	//Step 1: obtain XHR
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//Step 2: Define onreadystatechange and check ready state and status
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			func(xhr);
		}
	};
	
	//Step 3: Prepare request
	xhr.open("GET",url,true);
	//Step 4: Send request
	xhr.send();
};

function populateUser(xhr){
	
	//Check whether there is any response text
	//If no, don't parse it.
	if(xhr.response){
		var res = JSON.parse(xhr.responseText);
		if(res.session.attributes.email == "null"){
			window.location = "/EmployeeReimbursement/login";
		} else if(res.session.attributes.isManager == "false") {
			window.location = "/EmployeeReimbursement/error"
		}
	}
}

//Start up the session
window.onload = function() {
	sendAjaxGet("http://localhost:8084/EmployeeReimbursement/session", populateUser);
}
