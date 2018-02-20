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

function getEmployeeName(xhr) {
	var res = JSON.parse(xhr.responseText);
	var html = res.fname + ' ' + res.lname;
	var html2 = res.job;
	document.getElementById("empName").innerHTML = html;
	document.getElementById("empJob").innerHTML = html2;
}

function generateRequests(xhr) {
	var reimbTable = document.getElementById("reimbTable");
	var head = document.getElementById("head");
	while (reimbTable.firstChild) {
		reimbTable.removeChild(reimbTable.firstChild);
	}
	reimbTable.appendChild(head);
	
	var res = JSON.parse(xhr.responseText);
	var reimbs = res.allReimbs;
	var trs = [];

    function imgListener(element, val) {
        element.addEventListener("click", toggle);
        function toggle() {
            changeImage(val);
        }
    }
	
	for (var i = 0; i < reimbs.length; i++) {
		var r = reimbs[i];
		var tr = document.createElement("tr");
		var rId = document.createElement("td");
        var emplId = document.createElement("td");
        var sts = document.createElement("td");
        var amnt = document.createElement("td");
        var img = document.createElement("td");
        var rmId = document.createElement("td");
        var dofc = document.createElement("td");
        var dofad = document.createElement("td");
        var approve = document.createElement("td");
        var deny = document.createElement("td");
        var judged = r.mgrId == 0;
		rId.innerHTML = r.reimbId;
		emplId.innerHTML = r.empId;
		sts.innerHTML = r.status;
		amnt.innerHTML = "$" + r.amount;
		var imgButton = document.createElement("Input");
		imgButton.type = "button";
		imgButton.value = "view";
		imgListener(imgButton, r.reimbId + ".jpg");
		img.appendChild(imgButton);
		rmId.innerHTML = (judged ? " " : r.mgrId);
		dofc.innerHTML = r.doc;
		dofad.innerHTML = r.doad;
		if (judged) {
			approve.appendChild(makeForm("approve", r.reimbId));
			deny.appendChild(makeForm("deny", r.reimbId));
		} else {
			approve.innerHTML = "";
			deny.innerHTML = "";
		}
		tr.appendChild(rId);
        tr.appendChild(emplId);
		tr.appendChild(sts);
		tr.appendChild(amnt);
        tr.appendChild(img);
        tr.appendChild(rmId);
        tr.appendChild(dofc);
		tr.appendChild(dofad);
        tr.appendChild(approve);
        tr.appendChild(deny);
		trs.push(tr);
	}
	
	for (var i = 0; i < trs.length; i++) {
        reimbTable.appendChild(trs[i]);
	}
}

function changeImage(name) {
    document.getElementById("display").setAttribute("src", name);
}

var makeForm = function(verb, id) {
    var form = document.createElement("form");
    form.action = "approveDeny";
    form.method = "post";
    
    var hiddenField = document.createElement("input");
    hiddenField.type = "hidden";
    hiddenField.name = "verb";
    hiddenField.value = verb;
    form.appendChild(hiddenField);
    
    var idHiddenField = document.createElement("input");
    idHiddenField.type = "hidden";
    idHiddenField.name = "reimbId";
    idHiddenField.value = id;
    form.appendChild(idHiddenField);
    
    var reloadHiddenField = document.createElement("input");
    reloadHiddenField.type = "hidden";
    reloadHiddenField.name = "reload";
    reloadHiddenField.value = "one";
    form.appendChild(reloadHiddenField);
    
    var submitButton = document.createElement("input");
    submitButton.type = "submit";
    submitButton.value = verb;
    form.appendChild(submitButton);
    
    return form;
}

window.onload = function(){
	sendAjaxPost("empInfo.txt", getEmployeeName);
	sendAjaxPost("singleEmployeeRequests.txt", generateRequests);
};