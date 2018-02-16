/**
 * 
 */

function sendAjaxGet(url, func){
	var xhr=new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange=function(){
		if(this.readyState == 4 && this.stuats==200){
			func(this);
		} 
	};
	xhr.open("GET",url,true);
	xhr.send();
};

function populateUser(xhr){
	var res= JSON.parse(xhr.responseText);
	if(xhr.responseText){
	if(res.username){
		document.getElementById("user").innerHTML="you are logged in as "+res.username;
	}
	}
	else{
		window.location = "http://localhost:8084/Project1/login"
	}
};

window.onload =function(){
	sendAjaxGet("http://localhost:8084/Project1/session",populateUser);
};
