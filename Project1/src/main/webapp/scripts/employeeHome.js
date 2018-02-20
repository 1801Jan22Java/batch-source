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
	document.getElementById("empName").innerHTML = html;
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
	
	for (var i = 0; i < reimbs.length; i++) {
		var r = reimbs[i];
		var tr = document.createElement("tr");
		var id = document.createElement("td");
        var sts = document.createElement("td");
        var amnt = document.createElement("td");
        var dofc = document.createElement("td");
        var dofad = document.createElement("td");
		id.innerHTML = r.reimbId;
		sts.innerHTML = r.status;
		amnt.innerHTML = "$" + r.amount;
		dofc.innerHTML = r.doc;
		dofad.innerHTML = r.doad;
		tr.appendChild(id);
		tr.appendChild(sts);
		tr.appendChild(amnt);
		tr.appendChild(dofc);
		tr.appendChild(dofad);
		trs.push(tr);
	}
	
	for (var i = 0; i < trs.length; i++) {
        reimbTable.appendChild(trs[i]);
	}
}

var displayAll = function() {
	sendAjaxPost("allRequests.txt", generateRequests);
}

var displayResolved = function() {
	sendAjaxPost("allResolvedRequests.txt", generateRequests);
}

var displayPending = function() {
	sendAjaxPost("allPendingRequests.txt", generateRequests);
}

function filterEvent() {
    var boxes = document.getElementsByTagName("input");

    function boxListener(element, val) {
        element.addEventListener("change", inquire);
        function inquire() {
            if (val === "all") {
            	displayAll();
            } else if (val === "pending") {
            	displayPending();
            } else if (val === "resolved") {
            	displayResolved();
            }
        }
    }

    for (var i = 0; i < boxes.length; i++) {
        var box = boxes[i];
        if (box.hasAttribute("name") && box.getAttribute("name") === "filter") {
            boxListener(box, box.getAttribute("value"));
        }
    }
}

window.onload = function(){
	sendAjaxPost("empInfo.txt", getEmployeeName);
	sendAjaxPost("allRequests.txt", generateRequests);
	filterEvent();
};