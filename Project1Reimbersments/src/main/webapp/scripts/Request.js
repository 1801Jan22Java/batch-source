window.onload = function(){
	document.getElementById("submit_btn").addEventListener("click",function () { sendAjaxImage("http://localhost:8084/Project1Reimbersments/RequestDocumentServlet")} );
}
sendAjaxImage = function(url){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	var file = document.getElementById("image").files[0];
	xhr.open("POST", url);
	console.log(file);
	if(file)
	{
		console.log("here");
		xhr.send(file);
	}
	xhr.onreadystatechange = function () {
		console.log(xhr.readyState);
		console.log(xhr.status);
		if(xhr.readyState==4 && xhr.status==200) {
			console.log("completion");
		}
	}
}