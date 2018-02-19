/**
 * 
 */
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

function fillEmployeeTable(xhr){
	res = JSON.parse(xhr.responseText);
	//console.log(xhr.responseText);
	
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
	let passwordIndex;
	for(let i = 0; i < col.length; i++){
		if(col[i] != "password") {
			let th = document.createElement("th")	//Table header
			switch (col[i]){
			case "id":
				th.innerHTML = "Employee ID";
				break;
			case "firstName":
				th.innerHTML = "First Name";
				break;
			case "lastName":
				th.innerHTML = "Last Name";
				break;
			case "email":
				th.innerHTML = "Email";
				break;
			}
//			th.innerHTML = col[i];
			tr.appendChild(th);
//			tr.insertCell(i).outerHTML = th.outerHTML;
		} else {
			passwordIndex = i;
		}
	}
	thead.appendChild(tr);
	
	for(let i = 0; i < res.length; i++){
		tr = table.insertRow(-1);
		for(let j = 0; j < col.length; j++){
			if(j != passwordIndex){
				let cell = tr.insertCell(-1);
				cell.innerHTML = res[i][col[j]];
			}
		}
	}
	
	let newTable = document.getElementById("requestTable");
	newTable.innerHTML = "";
	newTable.appendChild(table);
	
}

window.onload = function() {
		postAjax('http://localhost:8084/EmployeeReimbursement/employeetable', fillEmployeeTable);
}