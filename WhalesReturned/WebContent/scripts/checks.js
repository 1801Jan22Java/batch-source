function sendAjaxGet(url, callback){
	//make xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	//define statechange
	xhr.onreadystatechange = function(){
		console.log(this.readyState);
		
		if(this.readyState == 4 && this.status == 200){
			callback(this);
		}
		
	};
	
	//prep
	xhr.open("GET", url, true);
	
	//send
	xhr.send();
}

function populateUser(xhr){
    var res = JSON.parse(xhr.responseText);

    if (res.username != "null") {
        document.getElementById("user").innerHTML = res.username;
        console.log("valid user!");
    }
    else {
        //TODO::Send them back to a proper URL
        //window.location = "http://localhost:8080/Login/home.html";
        console.log("invalid user!");
    }

}

window.onload = function () {
    //TODO::Proper URL
    //sendAjaxGet("http://localhost:8080/Login/login", populateUser);
}