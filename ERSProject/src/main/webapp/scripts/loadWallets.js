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
    var table = document.getElementById("walletTable");
    
    for(var i = 0; i < res.length; i++){
    	var obj = res[i];
    	console.log(res[i].name);
    	
    	var row = table.insertRow(i + 1);
    	var cell1 = row.insertCell(0);
    	var cell2 = row.insertCell(1);
    	var cell3 = row.insertCell(2);
    	var cell4 = row.insertCell(3);
    	
    	cell1.innerText = res[i].name;
    	cell2.innerText = res[i].address;
    	cell3.innerText = res[i].type;
    	cell4.innerText = res[i].balance;
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
    sendAjaxGet("http://localhost:8080/ERSProject/wallet", populateWallets);
    sendAjaxGet("http://localhost:8080/ERSProject/session", populateUser);
    
    
}