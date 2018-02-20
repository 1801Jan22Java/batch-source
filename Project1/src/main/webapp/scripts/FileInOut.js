/**
 *
 */

window.URL = window.URL || window.webkitURL;

function setImage(xhr) {
	var blob = new Blob([xhr.response], {type: 'image/png'});
	if (blob) {
		document.getElementById("output").src = window.URL.createObjectURL(blob);
	}
}


function sendAjaxGet(url,func) {
	// step 1: obtain xhr

	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	xhr.responseType = 'blob';

	xhr.onload = function(e) {
	  if (this.readyState == 4 && this.status == 200) {
	    func(this);
	  }
	};

	//step 3: prepare request
	xhr.open("GET",url,true);
	//step 4: send request
	xhr.send();

}

function sendAjaxPost(url) {
	// step 1: obtain xhr

	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	var file = document.getElementById("image").files[0];
	//step 3: prepare request
	xhr.open("POST",url,true);
	//step 4: send request
	if (file) {
		xhr.send(file);
	}
	else {
		return;
	}
	xhr.onreadystatechange = function() {//Call a function when the state changes.
	    if(xhr.readyState == 4 && xhr.status == 200) {
	        console.log("did the thing????")
	    }
	}
}


window.onload = function() {

	document.getElementById("fromdb").addEventListener("click",function(){
		sendAjaxGet("http://localhost:8084/Project1/insertimage",setImage)
	});

	document.getElementById("submit").addEventListener("click",function(){
		sendAjaxPost("http://localhost:8084/Project1/insertimage")
	});
}
