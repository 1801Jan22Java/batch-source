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

	for (r in reim) {
		if (reim[r].reimburse_status_id == 1) {
			pending.push(reim[r])
		}

	}

	// Create 2 tables
	var ptable = document.getElementById("pending");
	for (p in pending) {

		var txta = document.createTextNode(pending[p].amount);
		var tda = document.createElement("td");
		
		var txtb = document.createTextNode(pending[p].reimburse_id);
		var tdb = document.createElement("td");
		
		var txtc = document.createTextNode(pending[p].user_id);
		var tdc = document.createElement("td");
		
		var txtd = document.createTextNode("Pending");
		var tdd = document.createElement("td");

		tda.appendChild(txta);
		tdb.appendChild(txtb);
		tdc.appendChild(txtc);
		tdd.appendChild(txtd);
		
		var tr = document.createElement("tr");
		tr.setAttribute("onclick", "select(event)");
		
		tr.appendChild(tda);
		tr.appendChild(tdb);
		tr.appendChild(tdc);
		tr.appendChild(tdd);
		ptable.appendChild(tr);
	}

}

function select(event) {
	var child = event.target.parentElement;
	var parent = child.parentElement;
	var children = parent.childNodes;
	
	for (var c = 2; c < children.length; c++) {
		children[c].className = "darken";
	}
	child.className = "lighten"
}

function simpleLog(xhr) {
	console.log(xhr);
}

function getDataId() {
	var row = document.getElementsByClassName('lighten');
	document.getElementById('ninja').value=row[0].childNodes[1].textContent;
}

document.getElementsByTagName('table')[0].onclick = getDataId;

window.onload = function() {

	sendAjaxGet('allrequests', displayProfile);
}
