function sendAjaxGet(url, callback){
	//make xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	//define statechange
	xhr.onreadystatechange = function(){
		//console.log(this.readyState);
		
		if(this.readyState == 4 && this.status == 200){
			callback(this);
		}
		
	};
	
	//prep
	xhr.open("GET", url, true);
	
	//send
	xhr.send();
}

function populateWallets(xhr){
	console.log(xhr.responseText);
    var res = JSON.parse(xhr.responseText);
    console.log(res);
    var options = document.getElementById("wals");
    
    if(res.length > 0){
    	document.getElementById("addWalletsDiv").style.visibility="collapse";
    	document.getElementById("requestForm").style.visibility="visible";
	    for(var i = 0; i < res.length; i++){
	    	console.log(res[i].name); 
	    	
	    	var newOption = document.createElement('option');
	    	newOption.value = res[i].address;
	    	newOption.text = "" + res[i].name + ": " + res[i].address + " - (" + res[i].balance + ")";
	    	newOption.name = res[i].name;
	    	options.add(newOption);
	    	
	    }
    }
    else{
    	document.getElementById("requestForm").style.visibility="collapse";
    	document.getElementById("addWalletsDiv").style.visibility="visible";
    }
}

function populateUser(xhr){
    var res = JSON.parse(xhr.responseText);

    if (res.username != "null") {
        document.getElementById("user").innerHTML = res.username;
        console.log("valid user!");
        console.log(res.manager);
        if(res.manager === "true"){
        	console.log("Is Manager!!");
        }
        
    }
    else {
        //TODO::Send them back to a proper URL
        window.location = "http://localhost:8080/ERSProject/home.html";
        console.log("invalid user!");
    }

}

window.onload = function () {
    //TODO::Proper URL
	sendAjaxGet("http://localhost:8080/ERSProject/session", populateUser);
    sendAjaxGet("http://localhost:8080/ERSProject/wallet", populateWallets);
}