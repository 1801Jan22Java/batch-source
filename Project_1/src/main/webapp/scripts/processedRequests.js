/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("Get",url,true);
	
	xhr.send();
};

function toEmpl() {
	sendAjaxGet("http://localhost:8084/Project_1/employee", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function toPendReq() {
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function refresh() {
	sendAjaxGet("http://localhost:8084/Project_1/processedRequests", whenLoad);
}

function logout() {
	sendAjaxGet("http://localhost:8084/Project_1/logout", function(){
		window.location.href = resp.responseUrl;
	});
};

function clearTable() {
	var myNode = document.getElementById("tableBody");
	while (myNode.firstChild) {
	    myNode.removeChild(myNode.firstChild);
	}
}

function whenLoad(resp) {
	if (resp.responseURL != "http://localhost:8084/Project_1/processedRequests" &&
			resp.responseURL != "http://localhost:8084/Project_1/processedRequests?load=true") {
		window.location.href = resp.responseURL;
		
	}
	clearTable();
	var j = JSON.parse(resp.response);
	var t = document.getElementById("tableHead");
	
	var b = document.getElementById("tableBody");
	for (var i = 0; i < j.length; i++) {

		var row = document.createElement("TR");
		var col1 = document.createElement("TH");
		var col2 = document.createElement("TD");
		var col3 = document.createElement("TD");
		var col4 = document.createElement("TD");
		var col5 = document.createElement("TD");
		col1.setAttribute("scope", "row");
		col1.innerText = j[i].id;
		col2.innerText = j[i].reqId;
		col3.innerText = j[i].managerId;
		col4.innerText = j[i].datePro.year + "-" + j[i].datePro.monthValue
				+ "-" + j[i].datePro.dayOfMonth;
		col5.innerText = j[i].status;
		row.appendChild(col1);
		row.appendChild(col2);
		row.appendChild(col3);
		row.appendChild(col4);
		row.appendChild(col5);
		b.appendChild(row);
	}
};

window.onload = function(){
	sendAjaxGet("http://localhost:8084/Project_1/processedRequests?load=true", whenLoad);
	document.getElementById("home").addEventListener("click", toEmpl);
	document.getElementById("pReq").addEventListener("click", toPendReq);
	document.getElementById("proReq").addEventListener("click", refresh);
	document.getElementById("logOut").addEventListener("click", logout);
}