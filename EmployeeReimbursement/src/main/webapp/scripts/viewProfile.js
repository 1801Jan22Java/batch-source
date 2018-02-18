function postAjax(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			func(xhr);
		}
	};
	
	xhr.open("GET", url, true);
	xhr.send();
	return xhr;
}

function fillView(xhr){
	let res = JSON.parse(xhr.responseText);
	document.getElementById("empFirstName").innerHTML = res.firstName;
	document.getElementById("empLastName").innerHTML = res.lastName;
	document.getElementById("empEmail").innerHTML = res.email;
	document.getElementById("empID").innerHTML = res.id;
}


window.onload = function(xhr) {
	postAjax('http://localhost:8084/EmployeeReimbursement/viewprofile', fillView);
}