/**
 * 
 */
function sendAjaxPost(url,func){
	//step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	xhr.onreadystatechange = function(){
		// console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	//step 3: prepare request
	xhr.open("POST",url,true);
	//step 4: send request
	xhr.send();
};

var makeForm = function(id) {
    var form = document.createElement("form");
    form.action = "viewEmployee";
    form.method = "post";
    var hiddenField = document.createElement("input");
    hiddenField.type = "hidden";
    hiddenField.name = "empId";
    hiddenField.value = id;
    form.appendChild(hiddenField);
    var submitButton = document.createElement("input");
    submitButton.type = "submit";
    submitButton.value = "View employee";
    form.appendChild(submitButton);
    return form;
}

function generateEmployees(xhr) {
	var employeeTable = document.getElementById("employeeTable");
	
	var res = JSON.parse(xhr.responseText);
	var emps = res.allEmps;
	var trs = [];
	
	for (var i = 0; i < emps.length; i++) {
		var e = emps[i];
		var tr = document.createElement("tr");
        var emplId = document.createElement("td");
        var emplName = document.createElement("td");
        var emplJob = document.createElement("td");
        var viewEmpl = document.createElement("td");
        emplId.innerHTML = e.empId;
        emplName.innerHTML = e.fname + ' ' + e.lname;
        emplJob.innerHTML = e.job;
        viewEmpl.appendChild(makeForm(e.empId));
        tr.appendChild(emplId);
        tr.appendChild(emplName);
        tr.appendChild(emplJob);
        tr.appendChild(viewEmpl);
		trs.push(tr);
	}
	
	for (var i = 0; i < trs.length; i++) {
        employeeTable.appendChild(trs[i]);
	}
}

window.onload = function(){
	sendAjaxPost("allEmployees.txt", generateEmployees);
};