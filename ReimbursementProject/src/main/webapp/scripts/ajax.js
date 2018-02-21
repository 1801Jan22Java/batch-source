/**
 * 
 */
function getPendingRequests(xhr) {
	var res = JSON.parse(xhr.response);
	// Find a <table> element with id="myTable":
	console.log(res[0].requestAmount);
	console.log(res[0].requestComment);
	console.log(res[0].requestStatus.requestStatusName)
	console.log(res.length);
	var table = document.getElementById("myTable");

	for (var i = 0; i < res.length; i++) {
		var row = table.insertRow(i + 1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		cell1.innerHTML = "$"+res[i].requestAmount;	// res.requestAmount
		cell2.innerHTML = res[i].requestComment;	// res.
		cell3.innerHTML = res[i].requestStatus.requestStatusName;	
	}
	// Create an empty <tr> element and add it to the 1st position of the table:
/*	var row = table.insertRow(1);

	// Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);

	// Add some text to the new cells:
	cell1.innerHTML = "NEW CELL1";	// res.requestAmount
	cell2.innerHTML = "NEW CELL2";	// res.
	cell3.innerHTML = "1";	*/
};


function sendAjaxGet(url, func) {
	// step 1: obtain xhr
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	// step 2: define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	// step 3: prepare request
	xhr.open("GET", url, true);
	// step 4: send request
	xhr.send();
};

window.onload = function() {
	sendAjaxGet('getpendingrequests', getPendingRequests);
};
 

/*window.onload = function() {
	document.getElementById("pokeButton").addEventListener("click", function() {
				sendAjaxGet('getpendingrequests', getPokemon);
			})
};*/ 