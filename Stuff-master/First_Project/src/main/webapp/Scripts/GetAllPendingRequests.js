

var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");

function getAllPendingRequests() {
	xhr.open("Get", "/First_Project/AllPendingRequestServlet");
	xhr.send();
	xhr.onreadystatechange = PendingRequests;
}
;

function PendingRequests() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		if(JSON.parse(xhr.responseText)){
		obj = JSON.parse(xhr.responseText);
		
		
		console.log(obj);
		//console.log(obj.things.length);
		//console.log(obj.Request_Id);
		//console.log(Object.keys(obj).length + " this is the size");
		var j = 0;
		var keys = [];
		var values = [];
		console.log(obj.things.length);
		for (var x = 0; x < obj.things.length; x++) {
			miniObj = obj.things[x];
			 j = 0;
			
			for (var key in miniObj) {
				if (key != undefined) {
					keys[j] = key;
				}
				//console.log(miniObj[key]);
				if (miniObj[key] != undefined) {
					
					values[j] = miniObj[key];
				}
				j++;
			}
			
			
			
			var table = document.getElementById("All_Pending");
			if (x<= 0) {
				//console.log("got here");
				var headRow = table.insertRow(-1);
				
				for (var i = 0; i <keys.length; i++) {
					var headCell = headRow.insertCell(-1);
					headCell.innerHTML = keys[i];
				}
			}
			// count is the number of things in the object need to set -6

			var headRow = table.insertRow(1);
			for (var i = 0; i < Object.keys(miniObj).length; i++) {
				var headCell = headRow.insertCell(i);
				headCell.innerHTML = values[i];
			}

			
		}
	 }
	}else{document.getElementById("All_Pending").innerHTML = "No Completed Requests"
	}

};