window.onload = function(){
	var qs = getQueryStrings();
	var myParam = qs["requestId"]; 
	console.log(myParam);
	document.getElementById("submit_btn").addEventListener("click",function () { sendAjaxImage("http://localhost:8084/Project1Reimbersments/RequestDocumentServlet?requestId="+myParam)} );
}
function getQueryStrings() { 
	  var assoc  = {};
	  var decode = function (s) { return decodeURIComponent(s.replace(/\+/g, " ")); };
	  var queryString = location.search.substring(1); 
	  var keyValues = queryString.split('&'); 

	  for(var i in keyValues) { 
	    var key = keyValues[i].split('=');
	    if (key.length > 1) {
	      assoc[decode(key[0])] = decode(key[1]);
	    }
	  } 

	  return assoc; 
	} 
sendAjaxImage = function(url){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	var file = document.getElementById("image").files[0];
	//var reqId = document.getElementById("requestId").value;
	xhr.open("POST", url);
	console.log(file);
	if(file){
		console.log("here");
		xhr.send(file);
		//xhr.send(reqId);
	}
	xhr.onreadystatechange = function () {
		console.log(xhr.readyState);
		console.log(xhr.status);
		if(xhr.readyState==4 && xhr.status==200) {
			console.log("completion");
		}
	}
	
}