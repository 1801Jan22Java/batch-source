/**
 * 
 */

window.onload = function() {

	getApproval();
	var inputOut = document.getElementsByTagName("input");
	console.log(inputOut);
	console.log(inputOut.length);
	var length = inputOut.length;
	for (var i = 0; i < length; i++) {
		console.log(inputOut[i]);
		console.log(inputOut[i].value);
		console.log(inputOut[i].value.checked);
	}
}

function getApproval() {
	document.getElementById("subbutton").onclick = function() {
		var inputOut = document.getElementsByTagName("input");
		console.log(inputOut);
		console.log(inputOut.length);
		var length = inputOut.length;
		for (var i = 0; i < length; i++) {
			console.log(inputOut[i].value);
			console.log(inputOut[i].checked);
			

		}
	}
}


/*
 * function sendAjaxGet(url, func){ var xhr=new XMLHttpRequest() || new
 * ActiveXObject("Microsoft.HTTPRequest"); xhr.onreadystatechange=function(){
 * if(this.readyState == 4 && this.status==200){ func(this); } };
 * xhr.open("GET",url,true); xhr.send(); };
 * 
 * function getApproval(xhr){ var res= JSON.parse(xhr.responseText);
 * if(xhr.responseText){ if(res.username){
 * document.getElementById("user").innerHTML="you are logged in as
 * "+res.username; } } else{ window.location =
 * "http://localhost:8084/Project1/login" } };
 * 
 * window.onload =function(){
 * sendAjaxGet("http://localhost:8084/Project1/session",populateUser); };
 */