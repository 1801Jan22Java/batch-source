/**
 * 
 */

function sendAjaxDelete(url, func, empl) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("DELETE",url,true);
	
	xhr.send(JSON.stringify(empl));
};

function sendAjaxPut(url, func, empl) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("PUT",url,true);
	
	xhr.send(JSON.stringify(empl));
};

function sendAjaxPost(url, func, empl) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		} 
		
	}
	
	xhr.open("POST",url,true);
	
	xhr.send(JSON.stringify(empl));
};

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

function deleteUser() {
	var empl = {};
	empl.id = document.getElementById("deleteId").value;
	
	if (empl.id) {
		sendAjaxDelete("http://localhost:8084/Project_1/employee", function(){
			myRefresh();
		}, empl);
	} 
}

function updateUser() {
	var empl = {};
	empl.firstName = document.getElementById("updateFirst").value;
	empl.lastName = document.getElementById("updateLast").value;
	empl.password = document.getElementById("updatePassword").value;
	if (!empl.firstName) {
		empl.firstName = document.getElementById("FirstName").innerText;
	}
	if (!empl.lastName) {
		empl.lastName = document.getElementById("LastName").innerText;
	}
	if (!empl.password) {
		empl.password = "";
	}
	sendAjaxPut("http://localhost:8084/Project_1/employee", function(resp){
		myRefresh()
	}, empl);
}

function createUser() {
	var empl = {};
	empl.firstName = document.getElementById("emplFirstName").value;
	empl.lastName = document.getElementById("emplLastName").value;
	empl.userName = document.getElementById("emplUsername").value;
	empl.password = document.getElementById("emplPassword").value;
	empl.email = document.getElementById("emplEmail").value;
	
	if (empl.firstName && empl.lastName && empl.userName && empl.password && empl.email) {
		sendAjaxPost("http://localhost:8084/Project_1/employee", function(resp){
			myRefresh()
		}, empl);
	} else {
		
		document.getElementById("formReq").innerText = "Please fill out all entries."
	}
};

function toPendReq() {
	sendAjaxGet("http://localhost:8084/Project_1/pendingRequest", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function toProReq() {
	sendAjaxGet("http://localhost:8084/Project_1/processedRequests", function(resp){
		if (resp.responseURL) {
            window.location.href = resp.responseURL;
        }
	});
};

function myRefresh() {
	sendAjaxGet("http://localhost:8084/Project_1/employee?load=true", whenLoad);
}

function clearTable() {
	var myNode = document.getElementById("tableBody");
	while (myNode.firstChild) {
	    myNode.removeChild(myNode.firstChild);
	}
}

function whenLoad(resp) {
	clearTable();
	var j =  JSON.parse(resp.response);
	var empl;
	if (j.length) {
		var t = document.getElementById("tableBody")
		for (var i = 0; i < j.length; i++) {
			if (j[i].id == -1){
				empl = j[i];
			} else {
				var row = document.createElement("TR");
				var col1 = document.createElement("TH");
				var col2 = document.createElement("TD");
				var col3 = document.createElement("TD");
				var col4 = document.createElement("TD");
				col1.setAttribute("scope", "row");
				col1.innerText = j[i].id;
				col2.innerText = j[i].firstName + " " + j[i].lastName;
				col3.innerText = j[i].userName;
				col4.innerText = j[i].email;
				row.appendChild(col1);
				row.appendChild(col2);
				row.appendChild(col3);
				row.appendChild(col4);
				t.appendChild(row);
			}
		}
	}else {
		empl = j;
		document.getElementsByTagName("body")[0].removeChild(document.getElementById("tableContainer"));
	}

	document.getElementById("FirstName").innerText = empl.firstName;
	document.getElementById("LastName").innerText = empl.lastName;
	document.getElementById("username").innerText = empl.userName;
	document.getElementById("email").innerText = empl.email;
	document.getElementById("pos").innerText = empl.title;

	
};

window.onload = function(){
	sendAjaxGet("http://localhost:8084/Project_1/employee?load=true", whenLoad);
	document.getElementById("home").addEventListener("click", myRefresh);
	document.getElementById("pReq").addEventListener("click", toPendReq);
	document.getElementById("proReq").addEventListener("click", toProReq);
	document.getElementById("createUser").addEventListener("click", createUser);
	document.getElementById("updateUser").addEventListener("click", updateUser);
	document.getElementById("deleteUser").addEventListener("click", deleteUser);
	
}