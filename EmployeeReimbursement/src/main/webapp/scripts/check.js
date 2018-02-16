/**
 * 
 */

function sendAjaxGet(url, func){
	//Step 1: obtain XHR
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//Step 2: Define onreadystatechange and check ready state and status
	xhr.onreadystatechange = function(){
		console.log(xhr.readyState);
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
	if(xhr.resp){
		var res = JSON.parse(xhr.responseText);
		if(res.session.attributes.email != "null"){
			document.getElementById("user").innerHTML="You are logged in as "+res.email;
		} 
	}else {
		//Redirect if unsuccessful
		window.location = "http://localhost:8084/EmployeeReimbursement/login";
	}
}

//Start up the session
window.onload = function() {
	sendAjaxGet("http://localhost:8084/EmployeeReimbursement/session", populateUser);
}
