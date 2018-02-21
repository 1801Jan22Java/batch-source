/**
 * 
 */

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	var name = document.getElementById("userName").value;
	var pass = document.getElementById("userPassword").value;
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("POST",url,true);
	
	xhr.send(JSON.stringify({"username":name,"password":pass}));
};

function doLogin() {
	sendAjaxPost("http://localhost:8084/Project_1/login", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

window.onload = function(){
		document.getElementById("loginButton").addEventListener("click", doLogin);
}