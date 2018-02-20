function postAjax(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function(){
		if(this.readyState == 4){
			func(this);
		}
	};
	
	xhr.open("GET", url, true);
	xhr.send();
	return xhr;
}


function fillRequestTable(xhr){
	let res = JSON.parse(xhr.responseText);
	
	
	var col = [];
	for (let i = 0; i < res.length; i++){
		for(var key in res[i]) {
			if (col.indexOf(key) === -1){
				col.push(key);
			}
		}
	}

	let table = document.createElement("table");
	table.setAttribute("class", "table");
	let thead = document.createElement("thead");
	table.appendChild(thead);
	
	let tr = table.insertRow(0);
	let amountIndex;
	let statusIndex;
	let requestIndex;
	let employeeIndex;
	for(let i = 0; i < col.length; i++){
		let th = document.createElement("th")	//Table header
		switch (col[i]){
		case "requestID":
			th.innerHTML = "Request ID";
			requestIndex = i;
			break;
		case "employeeID":
			th.innerHTML = "Employee ID";
			employeeIndex = i;
			break;
		case "dateSubmitted":
			th.innerHTML = "Date Submitted";
			break;
		case "statusID":
			th.innerHTML = "Status";
			statusIndex = i;
			break;
		case "description":
			th.innerHTML = "Description";
			break;
		case "amount":
			th.innerHTML = "Amount";
			amountIndex = i;
			break;
		}
//		th.innerHTML = col[i];
		tr.appendChild(th);
//		tr.insertCell(i).outerHTML = th.outerHTML;
	}
	/*
	let th = document.createElement("th");
	th.innerHTML = "Approve";
	tr.appendChild(th);
	
	th = document.createElement("th");
	th.innerHTML = "Decline";
	tr.appendChild(th);
	*/
	
	thead.appendChild(tr);
	
	for(let i = 0; i < res.length; i++){
		tr = table.insertRow(-1);
		
		let currReqID;
		let currEmpID;
		for(let j = 0; j < col.length; j++){
			let cell = tr.insertCell(-1);
			if(j === amountIndex){
				cell.innerHTML = "$"+res[i][col[j]];
			}
			else if(j === requestIndex){	//the request ID
				currReqID = res[i][col[j]];
				cell.innerHTML = res[i][col[j]];
			}
			else if(j === statusIndex){	//statusID
				switch(res[i][col[j]]){
				case 1:
					cell.innerHTML = "Pending";
					break;
				case 2:
					cell.innerHTML = "Approved";
					break;
				case 3:
					cell.innerHTML = "Declined";
					break;
				}
			}
			else{
				cell.innerHTML = res[i][col[j]];
			}
		}
	}
	let newTable = document.getElementById("employeeRequestTable");
	newTable.innerHTML = "";
	newTable.appendChild(table);
}

window.onload = function() {
	postAjax('http://localhost:8084/EmployeeReimbursement/viewemployeerequests', fillRequestTable);
};