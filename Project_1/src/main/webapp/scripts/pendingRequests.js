/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		console.log(this);
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

function whenLoad(resp) {
	var j = JSON.parse(resp.response);
	var t = document.getElementById("tableBody")
	if ( j[0].id === -1) {
		t.removeChild(document.getElementById("idCol"));
	}
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
		col4.innerText = j[i].dateReq.year + "-" + j[i].dateReq.monthValue + "-" + j[i].dateReq.dayOfMonth;
		col5.innerText = j[i].description;
		row.appendChild(col1); 
		if ( j[i].id !== -1) {
			row.appendChild(col2);
		}
		row.appendChild(col3);
		row.appendChild(col4);
		row.appendChild(col5);
		t.appendChild(row);
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
};