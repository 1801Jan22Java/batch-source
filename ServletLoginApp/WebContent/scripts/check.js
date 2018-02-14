/**
 * Check whether user is there using AJAX
 */

function sendAjaxGet(url, func){
	//Step 1: obtain XHR
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//Step 2: Define onreadystatechange and check ready state and status
	xhr.onreadystatechange = function(){
		console.log(this.readyState);
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	
	//Step 3: Prepare request
	xhr.open("GET",url,true);
	//Step 4: Send request
	xhr.send();
};

function populateUser(xhr){
	var res = JSON.parse(xhr.responseText);
	if(res.username != "null"){
		document.getElementById("user").innerHTML="You are logged in as "+res.username;
	} else {
		//Redirect if unsuccessful
		window.location = "http://localhost:8084/ServletLoginApp/login";
	}
}


window.onload = function() {
	sendAjaxGet("http://localhost:8084/ServletLoginApp/session", populateUser);
}

