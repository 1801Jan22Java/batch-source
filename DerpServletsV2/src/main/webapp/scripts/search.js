/**
 * 
 */

function sendAjaxGet(url, func) {
	// step 1: obtain XHR
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	// step 2: define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}

	}
	// step 3: prepare request

	xhr.open("GET", url, true);

	// step 4: send request

	xhr.send();

};

window.onload = function(){
	document.getElementById("button").addEventListener("click", getPages);
};