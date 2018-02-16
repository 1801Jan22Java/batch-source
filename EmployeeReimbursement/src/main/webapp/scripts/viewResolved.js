/**
 * 
 */
function postAjax(url, func){
	let xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject("MicrosoftXMLHTTP");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			func(this);
		}
	};
	
	xhr.open("POST", url, true);
	xhr.send();
	return xhr;
}

window.onload = function(xhr) {
	postAjax('http://localhost:8084/EmployeeReimbursement/viewresolved', function(){
		let table = document.createElement("table");
		let tr = table.insertRow(-1);	//Last position
		
		let res = JSON.parse(xhr.responseText);
		
		for(let i = 0; i < res.length; i++){
			let th = document.createElement("th")	//Table header
			th.innerHTML = col[i];
			tr.appendChild(th);
		}
		
		document.getElementById("empFirstName").innerHTML = res.firstName;
		document.getElementById("empLastName").innerHTML = res.lastName;
		document.getElementById("empEmail").innerHTML = res.email;
		document.getElementById("empID").innerHTML = res.id;
	});
}