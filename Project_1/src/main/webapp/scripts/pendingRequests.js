/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("Get",url,true);
	
	xhr.send();
};

function toEmpl() {
	sendAjaxGet("http://localhost:8084/Project_1/employee", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function toProReq() {
	sendAjaxGet("http://localhost:8084/Project_1/processedRequests", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function refresh() {
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest", whenLoad);
}

function whenLoad(resp) {
	
};

window.onload = function(){
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest?load=true", whenLoad);
	document.getElementById("home").addEventListener("click", toEmpl);
	document.getElementById("pReq").addEventListener("click", refresh)
	document.getElementById("proReq").addEventListener("click", toProReq)
}