

function sendAjaxGet(url, func){
	var xhr=new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange=function(){
		if(this.readyState == 4 && this.status==200){
			func(this);
		} 
	};
	xhr.open("GET",url,true);
	xhr.send();
};

function populateUser(xhr){
	var res= JSON.parse(xhr.responseText);
	if(xhr.responseText){
	if(res.username){
		console.log(res.username);
		console.log(res.password);
		//document.getElementById("username").innerHTML="you are logged in as "+res.username;
	//	document.getElementById("password").innerHTML="you are logged in as "+res.password;
	}
	}
	else{
		window.location = "http://localhost:8080/Project1/login"
	}
};

window.onload =function(){
	sendAjaxGet("http://localhost:8080/Project1/session",populateUser);
	
};
