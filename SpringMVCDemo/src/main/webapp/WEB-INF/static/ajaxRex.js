/**
 * 
 */
function getTRex(xhr){
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>Chosen T-Rex has name: "+res.name+"</h4>";
	document.getElementById("tRexResult").innerHTML = html;
};

function sendAjaxGet(url,func){
	//step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	xhr.onreadystatechange = function(){
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	//step 3: prepare request
	xhr.open("GET",url,true);
	//step 4: send request
	xhr.send();
};

window.onload = function(){
	document.getElementById("tRexButton").addEventListener("click",function(){
		sendAjaxGet('http://localhost:8084/SpringMVCDemo/trex/'+document.getElementById("tRexId").value,getTRex);
	})
};