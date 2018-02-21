function sendAjaxGet(url, func){
	//Step 1: obtain XHR
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//Step 2: Define onreadystatechange and check ready state and status
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			func(xhr);
		}
	};
	
	//Step 3: Prepare request
	xhr.open("GET",url,true);
	//Step 4: Send request
	xhr.send();
};

function sayHi(xhr){
	if(xhr.response){
		document.getElementById("displayHello").innerHTML = "<p>"+xhr.responseText+"</p>";
	}
}

	document.getElementById("sayHi").addEventListener('click', function(){
		sendAjaxGet("helloworld", sayHi);
	});