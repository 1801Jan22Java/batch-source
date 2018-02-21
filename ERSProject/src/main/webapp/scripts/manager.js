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
        
      //  if(res.manager === "true"){
       // 	console.log("Is Manager!!");
     //   	document.getElementById("manageButton").style.display = "inline-block";
      //  }
        
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
    var empTable = document.getElementById("empTable");
    //id title date status
    for(var i = 0; i < res.requests.length; i++){
    	
    	//console.log(res.requests[i].title);
    	
        var row = (res.requests[i].status == 0 ? openTable : closedTable).insertRow(res.requests[i].status == 0 ? openTable.children.length : closedTable.children.length);
    	var cell1 = row.insertCell(0);
    	var cell2 = row.insertCell(1);
    	var cell3 = row.insertCell(2);
    	var cell4 = row.insertCell(3);
    	var cell5 = row.insertCell(4);
    	var cell6 = row.insertCell(5);
    	
    	if(res.requests[i].status != 0){
	    	var cell7 = row.insertCell(6);
	    	cell7.innerText = res.requests[i].manager;
    	}
    	
    	var cell8 = row.insertCell(res.requests[i].status != 0 ? 7: 6 );
    	
    	cell1.innerText = res.requests[i].id;
    	cell2.innerText = res.requests[i].email;
    	cell2.className = "idRow";
    	cell3.innerText = res.requests[i].title;
    	cell4.innerText = res.requests[i].amount + " " + res.requests[i].symbol;
    	cell5.innerText = res.requests[i].date;
    	cell6.innerText = res.requests[i].status == 0 ? "Pending" : res.requests[i].status == 1 ? "Approved" : "Denied";
    	
    	cell8.innerHTML = "<div class=\"btn-group\">"+
                                        "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">View</button>"+
                                        (res.requests[i].status != 0 ? "" :(
                                        "<button type=\"button\" class=\"btn btn-success\" id=\"approveButton" + res.requests[i].id + "\">Approve</button>"+
                                        "<button type=\"button\" class=\"btn btn-danger\" id=\"denyButton" + res.requests[i].id + "\">Deny</button>"))+
                                    "</div>";
    	if( res.requests[i].status == 0){
	    	document.getElementById("approveButton"+res.requests[i].id).onclick = function(j) { return function() { onApproveClick(j); }; }(res.requests[i].id);
	    	document.getElementById("denyButton"+res.requests[i].id).onclick = function(j) { return function() { onDenyClick(j); }; }(res.requests[i].id);
	    	
    	}

    }
    
    function onApproveClick(id){
    	console.log(document.getElementById("approveButton"+id).parentNode.parentNode.parentNode);
    	var closedTable = document.getElementById("requestTableClosed");
    	
    	//newRow.appen
    	closedTable.appendChild(document.getElementById("approveButton"+id).parentNode.parentNode.parentNode);
    	document.getElementById("approveButton"+id).parentNode.removeChild(document.getElementById("approveButton"+id));
    	document.getElementById("denyButton"+id).parentNode.removeChild(document.getElementById("denyButton"+id));
    	
    	sendAjaxGet("http://localhost:8080/ERSProject/requestMod?id=" + id + "&type=1");
    }
    
    function onDenyClick(id){
    	console.log(document.getElementById("denyButton"+id).parentNode.parentNode.parentNode);
    	var closedTable = document.getElementById("requestTableClosed");
    	
    	//newRow.appen
    	closedTable.appendChild(document.getElementById("denyButton"+id).parentNode.parentNode.parentNode);
    	document.getElementById("approveButton"+id).parentNode.removeChild(document.getElementById("approveButton"+id));
    	document.getElementById("denyButton"+id).parentNode.removeChild(document.getElementById("denyButton"+id));
    	
    	sendAjaxGet("http://localhost:8080/ERSProject/requestMod?id=" + id + "&type=2");
    }
    
    for(var i = 0; i < res.employees.length; i++){
    	var row = empTable.insertRow(empTable.children.length);
    	
    	var cell1 = row.insertCell(0);
    	var cell2 = row.insertCell(1);
    	var cell3 = row.insertCell(2);
    	
    	cell1.innerText = res.employees[i].id;
    	cell2.innerText = res.employees[i].email;
    	cell3.innerHTML = "<button type=\"button\" class=\"btn btn-primary\" id=\"searchEmpButton" + res.employees[i].id + "\">Search</button>";
    
    	document.getElementById("searchEmpButton"+res.employees[i].id).onclick = function(j) { return function() { onSearchClick(j); }; }(res.employees[i].email);
    }
    
    document.getElementById("findAll").onclick = function(j) { return function() { onSearchClick(j); }; }("");
    
    function onSearchClick(email){
    	console.log("search for id: " + email);
    	
    	var rows = document.getElementsByClassName("idRow");
    	
    	for(var i = 0; i < rows.length; i++){
    		if(email == ""){
        		console.log("showing all");
        		rows[i].parentNode.style.visibility = "visible";
    		}
    		else{
	    		if(rows[i].innerText != email){
	    			rows[i].parentNode.style.visibility = "collapse";
	    		}
	    		else{
	    			console.log("showing else");
	    			rows[i].parentNode.style.visibility = "visible";
	    		}
    		}
    	}
    	
    	
    	
    }
}

window.onload = function () {
	sendAjaxGet("http://localhost:8080/ERSProject/session", populateUser);
    sendAjaxGet("http://localhost:8080/ERSProject/managerRequests", populateRequests);
}