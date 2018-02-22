/**
 * 
 */

function sendAjaxDelete(url, func, req) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			func(this);
		}

	}

	xhr.open("DELETE", url, true);

	xhr.send(JSON.stringify(req));
};

function sendAjaxPost(url, func, req) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

			func(this);
		}

	}

	xhr.open("POST", url, true);

	xhr.send(JSON.stringify(req));
};

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}

	}

	xhr.open("GET", url, true);

	xhr.send();
};

function toEmpl() {
	sendAjaxGet("http://localhost:8084/Project_1/employee", function(resp) {
		if (resp.responseURL) {
			window.location.href = resp.responseURL;
		}
	});
};

function toProReq() {
	sendAjaxGet("http://localhost:8084/Project_1/processedRequests", function(
			resp) {
		if (resp.responseURL) {
			window.location.href = resp.responseURL;
		}
	});
};

function processRequest() {
	var procRequest = {};
	procRequest.id = document.getElementById("procReqId").value;
	var e = document.getElementById("statusSelect");
	procRequest.status = e.options[e.selectedIndex].text;
	sendAjaxPost("http://localhost:8084/Project_1/processedRequests", function(resp) {
		toProReq();
	}, procRequest);
}

function deleteRequest() {
	var request = {};
	request.id = document.getElementById("deleteId").value;
	sendAjaxDelete("http://localhost:8084/Project_1/pendingRequest", function(){
		myRefresh();
	}, request);
}

function createRequest() {
	var request = {};
	request.amount = document.getElementById("amount").value;
	request.description = document.getElementById("description").value;

	if (request.amount && request.description && request.amount > 0) {
		sendAjaxPost("http://localhost:8084/Project_1/pendingRequest", function() {
			myRefresh();
		}, request);
	}

}

function clearTable() {
	var myNode = document.getElementById("tableBody");
	while (myNode.firstChild) {
	    myNode.removeChild(myNode.firstChild);
	}
}

function whenLoad(resp) {
	clearTable();
	var j = JSON.parse(resp.response);
	var t = document.getElementById("tableHead");
	if (j[0]) {
		if (j[0].id === -1) {
			t.removeChild(document.getElementById("idCol"));
			var e = document.getElementById("procRequest");
			e.removeChild(e.firstElementChild);
		}
	} else {
		t.removeChild(document.getElementById("idCol"));
		var e = document.getElementById("procRequest");
		e.removeChild(e.firstElementChild);
	}
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
		col2.innerText = j[i].emplId;
		col3.innerText = j[i].amount;
		col4.innerText = j[i].dateReq.year + "-" + j[i].dateReq.monthValue
				+ "-" + j[i].dateReq.dayOfMonth;
		col5.innerText = j[i].description;
		row.appendChild(col1);
		if (j[i].id !== -1) {
			row.appendChild(col2);
		}
		row.appendChild(col3);
		row.appendChild(col4);
		row.appendChild(col5);
		b.appendChild(row);
	}
}

function myRefresh() {
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest?load=true",
			whenLoad);
}

window.onload = function() {
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest?load=true",
			whenLoad);
	document.getElementById("home").addEventListener("click", toEmpl);
	document.getElementById("pReq").addEventListener("click", myRefresh);
	document.getElementById("proReq").addEventListener("click", toProReq);
	document.getElementById("createRequest").addEventListener("click",
			createRequest);
	document.getElementById("deleteRequest").addEventListener("click",
			deleteRequest);
	document.getElementById("processRequest").addEventListener("click",
			processRequest);
};