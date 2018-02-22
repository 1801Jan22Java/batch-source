window.URL = window.URL || window.webkitURL;

function populateInformation(xhr) {
	if (xhr.responseText) {
		var res = JSON.parse(xhr.responseText);
		var table = document.getElementById("table");
		
		var remId = document.createElement("tr");
		remId.innerHTML = "<td>Reimbursement Id: </td><td>" + res.remId + "</td>";
		var status = document.createElement("tr");
		status.innerHTML = "<td>Status: </td><td>" + res.status+ "</td>";
		var manId = document.createElement("tr");
		manId.innerHTML = "<td>Manager Id: </td><td>" + res.manId + "</td>";
		var value = document.createElement("tr");
		value.innerHTML = "<td>Reimbursement Amount: </td><td>" + res.value + "</td>";
		
		table.appendChild(remId);
		table.appendChild(status);
		table.appendChild(manId);
		table.appendChild(value);

	} else {
		window.location = "http://localhost:8084/Project1/managerhomepage";
	}
}

function sendAjaxPost(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	console.log(location.href.split("?")[1]);
	var new_url = url + "?" + location.href.split("?")[1];
	xhr.open("POST", new_url, true);
	xhr.send();
};

function sendAjaxGet(url,status) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("updated to " + status);
			location.reload(true);
		}
	};
	console.log(location.href.split("?")[1]);
	var new_url = url + "?" + location.href.split("?")[1] + "&val=" + status;
	xhr.open("GET", new_url, true);
	xhr.send();
};

function populateImage(xhr) {
	console.log("setting blob")
	var blob = new Blob([xhr.response], {type: 'image/png'});
	console.log(blob);
	if (blob) {
		console.log("que?")
		console.log(document.getElementById("image").src);
		document.getElementById("image").src = window.URL.createObjectURL(blob);
		console.log(document.getElementById("image").src);
	}
}

function sendAjaxImg(url,func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.responseType = 'blob';
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log("blob is bueno")
			func(this);
		}
	};
	var new_url = url + "?" + location.href.split("?")[1]
	xhr.open("GET", new_url, true);
	xhr.send();
}

window.onload = function() {
	console.log(location.href);
	sendAjaxImg("http://localhost:8084/Project1/imagefetcher", populateImage);
	sendAjaxPost("http://localhost:8084/Project1/managerviewreimbursement", populateInformation);
	document.getElementById("approve").addEventListener("click",function() {
		sendAjaxGet("http://localhost:8084/Project1/managerapprovedeny","1");
	});
	document.getElementById("deny").addEventListener("click",function() {
		sendAjaxGet("http://localhost:8084/Project1/managerapprovedeny","2");
	});
}