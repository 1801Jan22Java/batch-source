function getAjax(url, func){
	let xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("MicrosoftXMLHTTP");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			func(this);
		}
	};
	
	xhr.open("GET", url, true);
	xhr.send();
	return xhr;
}

window.onload = function(xhr) {
	getAjax('http://localhost:8084/EmployeeReimbursement/viewpending', function(){
		var res = JSON.parse(xhr.responseText);
		document.getElementById("empFirstName").innerHTML = res.firstName;
		document.getElementById("empLastName").innerHTML = res.lastName;
		document.getElementById("empEmail").innerHTML = res.email;
		document.getElementById("empID").innerHTML = res.id;
	});
}