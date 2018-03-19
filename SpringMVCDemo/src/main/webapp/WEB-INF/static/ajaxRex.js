/**
 * 
 */
function getTRex(xhr) {
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>Chosen TRex has name: " + res.name + "</h4>";
	document.getElementById("rexResult").innerHTML = html;
};

function sendAjaxGet(url, func) {
	// Step 1: Obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	// Step 2: Define onreadytatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	// Step 3: prepare request
	xhr.open("GET", url, true);
	
	// Step 4: Send request
	xhr.send();
};

window.onload = function() {
	document.getElementById("tRexButton").addEventListener("click", function() {
		sendAjaxGet('http://localhost:8084/SpringMVCDemo/trex/'+document.getElementById("tRexId").value, getTRex);
	})
};