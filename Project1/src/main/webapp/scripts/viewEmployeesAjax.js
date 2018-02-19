/**
 * get 4 requirements out of the way with inner html
 */

function sendAjaxGet(url, func,event) {
	var xhr = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this,event)
		}
	}

	xhr.open("GET", url, true);
	xhr.send();

}



function displayUsers(xhr) {
	var users = JSON.parse(xhr.responseText);
	for(u in users){
		document.getElementById("outputDiv").innerHTML+= `<button id="`+users[u].user_id+`" class="btn border text-left btn-primary col-sm-12" role = "button"
		onclick="sendAjax(event);" type="button">Username: `+users[u].username+` First: `+users[u].firstname+` Last: `+users[u].lastname+` </button>`;
		
	}

}

function sendAjax(event) {
	sendAjaxGet('allrequests', display,event);
	
}
function display(xhr,event) {
	var all = JSON.parse(xhr.responseText);
	var reim=[];
	for(a in all){
		if(all[a].user_id==event.target.id){
			reim.push(all[a]);
		}
	}
	
	var dtable = document.getElementById("dtable");
	dtable.innerHTML = `
	<tr>
	<th>
	Amount
	</th>
		<th>
		ID
		</th>
		<th>
		Status
		</th>
		<th>
		Resolved By
		</th>
	</tr>`;
	
	for (r in reim) {
		
		var status;
		if (reim[r].reimburse_status_id == "2") {
			status = "Rejected";
		} else if (reim[r].reimburse_status_id == "3") {
			status = "Approved"
		} else if (reim[r].reimburse_status_id == "1") {
			status = "Pending"
		}
		var txta = document.createTextNode(reim[r].amount);
		var tda = document.createElement("td");
		var txtb = document.createTextNode(reim[r].reimburse_id);
		var tdb = document.createElement("td");
		var txtc = document.createTextNode(status);
		var tdc = document.createElement("td");
		var txtd = document.createTextNode(reim[r].resolved_by);
		var tdd = document.createElement("td");

		tda.appendChild(txta);
		tdb.appendChild(txtb);
		tdc.appendChild(txtc);
		tdd.appendChild(txtd)
		var tr = document.createElement("tr");
		// Set ID to r1, r2, etc.
		tr.setAttribute("id", reim[r].reimburse_id+"r");
		
		// Give an onclick event to show images
		tr.setAttribute("onclick", "showImage(event);");
		
		tr.appendChild(tda);
		tr.appendChild(tdb);
		tr.appendChild(tdc);
		tr.appendChild(tdd);
		dtable.appendChild(tr);
	}
}

function showImage(event){
	var row = event.target.parentElement;
	
	// Get the request id from the string
	var raw_id = row.id;
	var int_id = raw_id.replace("r","");
	

	var xhttp = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	//
	// Handle image
	//
	var xhttp = new XMLHttpRequest() || new AciveXObject("Microsoft.HTTPRequest");

	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {

		
		var urlCreator = window.URL || window.webkitURL;
		var imageUrl = urlCreator.createObjectURL(this.response);
		
		document.getElementById("photodiv").src = imageUrl;


	}
}

	xhttp.open("POST", "getimages", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.responseType="blob";
	xhttp.send("request_id="+int_id); 
}

function displayImages(xhr){
	var image = JSON.parse(xhr);
	console.log(image)
}

window.onload = function() {
	sendAjaxGet('allemployees', displayUsers);
}
