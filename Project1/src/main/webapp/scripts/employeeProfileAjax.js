function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

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
