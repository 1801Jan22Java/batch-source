function sendAjaxGet(url, func) {
	// Step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	// Step 2: define onreadystatechange
	// We want to check the ready state and the status
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

	// Step 3: prepare request
	xhr.open("GET", url, true);
	xhr.send();

}

function simpleLog(xhr) {
	console.log(xhr);
}

window.onload = function() {

	document.getElementById("test").addEventListener("click", function() {

		sendAjaxGet('/Project1/test' , simpleLog);

	})
}
