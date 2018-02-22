/**
 * 
 */

function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this)
		}
	}

	xhr.open("GET", url, true);
	xhr.send();

}

function displayProfile(xhr) {
	var reim = JSON.parse(xhr.responseText);
	var pending = [];
	var resolved = [];

	for (r in reim) {
		if (reim[r].reimburse_status_id == 1) {
			pending.push(reim[r])
		}
		if (reim[r].reimburse_status_id > 1) {
			resolved.push(reim[r])
		}
	}

	// Create 2 tables
	var ptable = document.getElementById("pending");
	for (p in pending) {

		var txta = document.createTextNode(pending[p].amount);
		var tda = document.createElement("td");
		var txtb = document.createTextNode(pending[p].reimburse_id);
		var tdb = document.createElement("td");
		var txtc = document.createTextNode(pending[p].notes);
		var tdc = document.createElement("td");
		var txtd = document.createTextNode("Pending");
		var tdd = document.createElement("td");

		tda.appendChild(txta);
		tdb.appendChild(txtb);
		tdc.appendChild(txtc);
		tdd.appendChild(txtd);
		var tr = document.createElement("tr");
		tr.appendChild(tda);
		tr.appendChild(tdb);
		tr.appendChild(tdc);
		tr.appendChild(tdd);
		ptable.appendChild(tr);
	}
	var rtable = document.getElementById("resolved");
	for (r in resolved) {
		var status;
		if (resolved[r].reimburse_status_id == 2) {
			status = "Rejected";
		} else if (resolved[r].reimburse_status_id == 3) {
			status = "Approved"
		}

		var txta = document.createTextNode(resolved[r].amount);
		var tda = document.createElement("td");
		var txtb = document.createTextNode(resolved[r].reimburse_id);
		var tdb = document.createElement("td");
		var txtc = document.createTextNode(resolved[r].notes);
		var tdc = document.createElement("td");
		var txtd = document.createTextNode(status);
		var tdd = document.createElement("td");

		tda.appendChild(txta);
		tdb.appendChild(txtb);
		tdc.appendChild(txtc);
		tdd.appendChild(txtd);
		var tr = document.createElement("tr");
		tr.appendChild(tda);
		tr.appendChild(tdb);
		tr.appendChild(tdc);
		tr.appendChild(tdd);
		rtable.appendChild(tr);
	}

}

function simpleLog(xhr) {
	console.log(xhr);
}

window.onload = function() {

	sendAjaxGet('requests', displayProfile);
}
