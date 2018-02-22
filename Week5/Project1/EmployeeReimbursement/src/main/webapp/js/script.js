let reimbursementPopup = document.getElementById("reimbursementForm");
let editProfilePopup = document.getElementById("editForm");
let editRequestPopup = document.getElementById("editRequestForm");
let cancelBtns = document.getElementsByClassName("cancelBtn");
let managerViewSection = document.getElementById("manager-reimbursements-section");
let employeeViewSection = document.getElementById("employee-reimbursements-section");
let employeesViewSection = document.getElementById("employees-reimbursements-section"); 
let isManager;
let allEmployees;

function cancel(){
	var button = event.target;

	if (button.parentNode.parentNode.style.display != "none")
		fadeOut(button.parentNode.parentNode);
}

function fadeIn(element) {
	element.style.display = "none";
	element.style.display = "block";
	element.classList.remove("fadeOut");
	element.classList.add("fadeIn");
	document.getElementById("request-form").reset();
	document.getElementById("edit-form").reset();
	document.getElementById("edit-request-form").reset();
}
function fadeOut(element) {
	element.classList.remove("fadeIn");
	element.classList.add("fadeOut");

	setTimeout(function() {
		element.style.display = "none";
		document.getElementById("request-form").reset();
		document.getElementById("edit-form").reset();
		document.getElementById("edit-request-form").reset();
	}, 750);
}

function CheckRequiredFieldsEmpty() {
	if(reimbursementPopup.style.display != "none"){
		if (document.getElementById("form-purpose").value != null && document.getElementById("form-amount").value != null && document.getElementById("upload-btn").files.length != 0){
			if (document.getElementById("form-purpose").value != ""  && document.getElementById("form-amount").value > 0){
				fadeOut(parent);
			}
		}
	}
	if(editProfilePopup.style.display != "none"){
		if(document.getElementById("form-username").value != null || document.getElementById("form-password").value != null){
			if(document.getElementById("form-username").value != "" || document.getElementById("form-password").value != ""){
				fadeOut(parent);
			}
		}
	}
	if(editRequestPopup.style.display != "none"){
		if(document.getElementById("form-reimId").value.toFixed(0) > 0 && document.getElementById("form-status").value != null){
			if(document.getElementById("form-status").value.toUpperCase() == "APPROVED" || document.getElementById("form-status").value.toUpperCase() == "DECLINED" ){
				fadeOut(parent);
			}
		}
	}
}

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
}

function profileDetails(json){
	document.getElementById("profile-employee-text").innerHTML = json.employee.firstname+" "+json.employee.lastname;
	document.getElementById("your-table-header").innerHTML = "Your Requests";
	document.getElementById("profile-email-text").innerHTML = json.employee.email;
	if(json.manager === null)
		document.getElementById("profile-manager-text").innerHTML = "Reports to no one.";
	else
		document.getElementById("profile-manager-text").innerHTML = json.manager.firstname+" "+json.manager.lastname;
	if(json.employee != null)
		fillTable(json.employee, "your-reimbursement-table");
}
function reimbursementDetails(xhr) {
	var response = JSON.parse(xhr.responseText);
	allEmployees = response.employees;
	console.log(response);
	//update user profile
	if(response.employee != null && document.getElementById("profile-details") != null)
		profileDetails(response);
	if(response.employees != undefined){
		if(response.employees.length > 0){
			fillEmployeesTable(response, response.current);
			var tbody = document.createElement("tbody");
			for(var i = 0; i < response.employees.length; i++){
				var rows = fillTable(response.employees[i], "employees-reimbursement-table", true)
				for(var j = 0; j < rows.length; j++)
					tbody.appendChild(rows[j]);
			}
			document.getElementById("employees-reimbursement-table").appendChild(tbody);
		}
	}
	if(response.current != null && document.getElementById("home-nav").childElementCount == 2){
		var li = document.createElement("li");
		li.classList.add("nav-item");
		var a = document.createElement("a");
		a.classList.add("nav-link");
		a.href = "#all-emps";
		a.innerHTML = "Employees";
		li.appendChild(a);
		document.getElementById("home-nav").appendChild(li);
		var li2 = document.createElement("li");
		li2.classList.add("nav-item");
		var a2 = document.createElement("a");
		a2.classList.add("nav-link");
		a2.href = "#all-emp-reimbs";
		a2.innerHTML = "All Requests";
		li2.appendChild(a2);
		document.getElementById("home-nav").appendChild(li2);
	}
	
	
	if(employeeViewSection.style.display == "block" && response.queriedEmployee != null)
		fillTable(response.queriedEmployee, "employee-reimbursement-table", true);
}

function fillTable(json, element, isManager){
	//update table requests
	if(isManager)
		document.getElementById("queriedEmployee").innerHTML = json.firstname+ " "+ json.lastname+"'s Reimbursements"
	var table = document.getElementById(element);
	if(table.childElementCount == 2)
		table.removeChild(table.lastChild);
	var tbody = document.createElement("tbody");
	var rows = [];
	for(var i = 0; i < json.requests.length; i++){
		var row = document.createElement("tr");

		var request = json.requests[i];

		var id = document.createElement("td");
		id.innerHTML = request.id;
		row.appendChild(id);
		var status = document.createElement("td");
		status.innerHTML = request.status;
		row.appendChild(status);
		var purpose = document.createElement("td");
		if(request.purpose != null)
			purpose.innerHTML = request.purpose;
		else
			purpose.innerHTML = "";
		row.appendChild(purpose);
		var notes = document.createElement("td");
		if(request.employeeNotes != null)
			notes.innerHTML = request.employeeNotes;
		else
			notes.innerHTML = "";
		row.appendChild(notes);
		var amount = document.createElement("td");
		amount.innerHTML = "$"+request.amount.toFixed(2);
		row.appendChild(amount);
		var upload = document.createElement("td");
		if(request.upload == null)
			upload.innerHTML = "";
		else
			upload.innerHTML = "<a href=\"data/"+request.upload.filename+"\" target=_blank\">"+request.upload.filename+"</a>";
		row.appendChild(upload);
		var created = document.createElement("td");
		created.innerHTML = request.dateCreated.monthValue+"/"+request.dateCreated.dayOfMonth +"/"+ request.dateCreated.year;
		row.appendChild(created);
		if(isManager){
			var managerId = document.createElement("td");
			if(request.managerId > 0)
				managerId.innerHTML = request.managerId;
			else
				managerId.innerHTML = "";
			row.appendChild(managerId);
			var managerNotes = document.createElement("td");
			if(request.managerNotes != null)
				managerNotes.innerHTML = request.managerNotes;
			else
				managerNotes.innerHTML = "";
			row.appendChild(managerNotes);
		}
		rows[i] = row;
		tbody.appendChild(row);
	}
	if(element == "employees-reimbursement-table")
		return rows;
	else
		document.getElementById(element).appendChild(tbody);
}
function fillEmployeesTable(json, currentUserId){
	var table = document.getElementById("employees-table");
	table.removeChild(table.lastChild);
	isManager = 1;
	if(managerViewSection.style.display == "none"){
		managerViewSection.style.display = "block";
		employeesViewSection.style.display = "block";
	}
	var tbody = document.createElement("tbody");
	for(var i = 0; i < json.employees.length; i++){
		var row = document.createElement("tr");
		var employee = json.employees[i];
		var id = document.createElement("td");
		if(currentUserId == employee.id)
			id.innerHTML = "<p>"+employee.id+"<p>";
		else
			id.innerHTML = "<a href=\"#\" onclick=\"employeeRequests("+employee.id+")\">"+employee.id+"</a>";			
		row.appendChild(id);
		var name = document.createElement("td");
		name.innerHTML = employee.firstname+" "+employee.lastname;
		row.appendChild(name);
		var email = document.createElement("td");
		email.innerHTML = employee.email;
		row.appendChild(email);
		var managerId = document.createElement("td");
		if(employee.managerId > 0)
			managerId.innerHTML = employee.managerId;
		else
			managerId.innerHTML = "N/A";
		row.appendChild(managerId);
		tbody.appendChild(row);
	}
	table.appendChild(tbody);
}

function employeeRequests(param){
	if(employeeViewSection.style.display == "block"){
		document.getElementById("queriedEmployee").innerHTML = "Loading Employee's Reimbursements...";
		document.getElementById("employee-reimbursement-table").removeChild(document.getElementById("employee-reimbursement-table").lastChild);
	}
	sendAjaxGet("initializeTable?employeeId="+param, reimbursementDetails);
	
	if(employeeViewSection.style.display == "none"){
		employeeViewSection.style.display = "block";
		var li = document.createElement("li");
		li.classList.add("nav-item");
		li.setAttribute("id", "special");
		var a = document.createElement("a");
		a.classList.add("nav-link");
		a.href = "#one-emp-reimbs";
		a.innerHTML = "Employee Request";
		li.appendChild(a);
		document.getElementById("home-nav").appendChild(li);
	}
		
}

function fixValues(element){
	document.getElementById("form-amount").value.toFixed(2);
	element.submit();
}
function logout(xhr){
	var response = JSON.parse(xhr.responseText);
}

window.onload = function() {
	if(reimbursementPopup != null)
		reimbursementPopup.style.display = "none";
	if(editProfilePopup != null)
		editProfilePopup.style.display = "none";
	if(editRequestPopup != null)
		editRequestPopup.style.display = "none";
	if(managerViewSection != null)
		managerViewSection.style.display = "none";
	if(employeeViewSection != null)
		employeeViewSection.style.display = "none";
	if(employeesViewSection != null)
		employeesViewSection.style.display = "none";

	if(document.getElementById("reimbursement-request") != null){
		document.getElementById("reimbursement-request").onclick = function() {
			if (reimbursementPopup.style.display == "none")
				fadeIn(reimbursementPopup);
		};
	}

	if(document.getElementById("edit-profile-btn") != null){
		document.getElementById("edit-profile-btn").onclick = function() {
			if (editProfilePopup.style.display == "none")
				fadeIn(editProfilePopup);
		};
	}

	if(document.getElementById("edit-request-btn") != null){
		document.getElementById("edit-request-btn").onclick = function() {
			if (editRequestPopup.style.display == "none")
				fadeIn(editRequestPopup);
		};
	}

	if(cancelBtns != null){
		for(var i = 0; i < cancelBtns.length; i++){
			cancelBtns[i].addEventListener("click", cancel, false);
		}
	}

	if(document.getElementById("request-submitBtn") != null){
		document.getElementById("request-submitBtn").onclick = function() {
			CheckRequiredFieldsEmpty();
		};
	}

	if(document.getElementById("edit-submitBtn") != null){
		document.getElementById("edit-submitBtn").onclick = function() {
			CheckRequiredFieldsEmpty();
		};
	}

	if(document.getElementById("editRequest-submitBtn") != null){
		document.getElementById("editRequest-submitBtn").onclick = function() {
			CheckRequiredFieldsEmpty();
		};
	}
	if(document.getElementById("your-reimbursement-table") != null){
		document.getElementById("your-table-header").innerHTML = "Loading Your Requests...";
		sendAjaxGet("initializeTable", reimbursementDetails);
	}
};