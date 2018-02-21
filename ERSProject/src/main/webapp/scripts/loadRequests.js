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

function populateUser(xhr){
    var res = JSON.parse(xhr.responseText);

    if (res.username != "null") {
        document.getElementById("user").innerHTML = res.username;
        console.log("valid user!");
        console.log(res.manager);
        if(res.manager === "true"){
        	console.log("Is Manager!!");
        	document.getElementById("manageButton").style.display = "inline-block";
        }
        
    }
    else {
        //TODO::Send them back to a proper URL
        window.location = "http://localhost:8080/ERSProject/home.html";
        console.log("invalid user!");
    }

}

function populateRequests(xhr){
	console.log(xhr.responseText);
    var res = JSON.parse(xhr.responseText);
    console.log(res);
    var openTable = document.getElementById("requestTableOpen");
    var closedTable = document.getElementById("requestTableClosed");
    //id title date status
    for(var i = 0; i < res.length; i++){
    	var obj = res[i];
    	console.log(res[i].title);
    	
        var row = (res[i].status == 0 ? openTable : closedTable).insertRow(res[i].status == 0 ? openTable.children.length : closedTable.children.length);
    	var cell1 = row.insertCell(0);
    	var cell2 = row.insertCell(1);
    	var cell3 = row.insertCell(2);
    	var cell4 = row.insertCell(3);
    	var cell5 = row.insertCell(4);
    	
    	if(res[i].status != 0){
	    	var cell6 = row.insertCell(5);
	    	cell6.innerText = res[i].manager;
    	}
    	
    	
    	
    	cell1.innerText = res[i].id;
    	cell2.innerText = res[i].title;
    	cell3.innerText = res[i].amount + " " + res[i].symbol;
    	cell4.innerText = res[i].date;
    	cell5.innerText = res[i].status == 0 ? "Pending" : res[i].status == 1 ? "Approved" : "Denied";
    }

}

window.onload = function () {
    //TODO::Proper URL
	sendAjaxGet("http://localhost:8080/ERSProject/session", populateUser);
    sendAjaxGet("http://localhost:8080/ERSProject/requests", populateRequests);
}