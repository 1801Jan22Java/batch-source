document.getElementById("request").addEventListener("click", function(){
    document.getElementById("upForm").setAttribute("style", "display: none");
    document.getElementById("requestForm").setAttribute("style", "display: inline");
});

document.getElementById("update").addEventListener("click", function(){
    document.getElementById("requestForm").setAttribute("style", "display: none");
    document.getElementById("upForm").setAttribute("style", "display: inline");
});

document.getElementById("view").addEventListener("click", function() {
	document.getElementById("requestForm").setAttribute("style", "display: none");
    document.getElementById("upForm").setAttribute("style", "display: none");
	sendAjaxGet("http://localhost:8080/RMS/viewInfo", populateViewResults);
});

document.getElementById("pending").addEventListener("click", function() {
	document.getElementById("requestForm").setAttribute("style", "display: none");
    document.getElementById("upForm").setAttribute("style", "display: none");
	sendAjaxGet("http://localhost:8080/RMS/getPending", populateGetRequestResults);
});

document.getElementById("resolved").addEventListener("click", function() {
	document.getElementById("requestForm").setAttribute("style", "display: none");
    document.getElementById("upForm").setAttribute("style", "display: none");
	sendAjaxGet("http://localhost:8080/RMS/getResolved", populateGetRequestResults);
});

document.getElementById("empRequest").addEventListener("click", function() {
	sendAjaxPost("http://localhost:8080/RMS/manager", populateGetRequestResults, document.getElementById("empID").value)
});


function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.withCredentials = true;
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	xhr.open("GET",url,true);
	xhr.send();
};

function sendAjaxPost(url, func, data) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.withCredentials = true;
	xhr.onreadystatechange = function(){
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	xhr.open("POST",url,true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	var string = "empID="+data;
	xhr.send(string);
};

function populateViewResults(xhr) {
	if (xhr.responseText) {
		document.getElementById("resultsTable").innerHTML  = '<tr><th>Employee ID</th><th>Username</th>'
			+'<th>Password</th><th>Name</th><th>Email</th><th>Manager Status</th></tr>';
		var res = JSON.parse(xhr.responseText);
		for (var i = 0; i < res.length; i++) {
			var row = document.createElement('tr');
			row.innerHTML = '<td>'+res[i].employeeID+'</td><td>'+res[i].username+'</td><td>'+res[i].password
				+'</td><td>'+res[i].fName+' '+res[i].lName+'</td><td>'+res[i].email+'</td><td>'+res[i].isManager+'</td>';
			document.getElementById("resultsTable").appendChild(row);
		}
		document.getElementById("results").setAttribute("style", "display: inline");
	}
};

function populateGetRequestResults(xhr) {
	if (xhr.responseText) {
		document.getElementById("resultsTable").innerHTML  = '<tr><th>Request ID</th><th>Employee ID</th>'
			+'<th>Amount</th><th>Description</th><th>File Name</th><th>Timestamp</th><th>Status</th><th>Manager ID</th></tr>';
		var res = JSON.parse(xhr.responseText);
		for (var i = 0; i < res.length; i++) {
			var row = document.createElement('tr');
			row.innerHTML = '<td>'+res[i].requestID+'</td><td>'+res[i].employeeID+'</td><td>'+res[i].amount+'</td><td>'
				+res[i].description+'</td><td>'+res[i].filename+'</td><td>'+res[i].timestamp+'</td><td>'+res[i].status+'</td><td>'+res[i].managerID+'</td>';
			document.getElementById("resultsTable").appendChild(row);
		}
		document.getElementById("results").setAttribute("style", "display: inline");
	}
};