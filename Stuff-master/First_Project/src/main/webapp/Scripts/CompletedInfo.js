

var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");

function findJSONEmployeeCompleted() {
	xhr.open("Get", "/First_Project/EmployeeCompletedInfo");
	xhr.send();
	xhr.onreadystatechange = stuffEmployee;
};

function stuffEmployee() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		console.log("got it");
		
		
		if(xhr.responseText){
		obj = JSON.parse(xhr.responseText);
		//console.log(obj.Request_Id);
		//console.log(Object.keys(obj).length + " this is the size");
		
		var j = 0;
		var keys = [];
		var values = [];
		for (var key in obj) {
			//console.log(key);
			if (key != undefined) {
				keys[j] = key;
			}
			if (obj[key] != undefined) {
				values[j] = obj[key];
			}
			j++;
		}
		var table = document.getElementById("Completed_Table_body");
		table.innerHTML = "";
		
		var headRow = table.insertRow(0);
		for (var i = 0; i < Object.keys(obj).length; i++) {
			var headCell = headRow.insertCell(i);
			headCell.innerHTML = keys[i];
		}
		// count is the number of things in the object need to set -6
		var count =1;
		while(count<2){
		var headRow = table.insertRow(count);
			for (var i = 0; i < Object.keys(obj).length; i++) {
				var headCell = headRow.insertCell(i);
				headCell.innerHTML = values[i];
			}
			count+=1;
		}

	}
}else{
	document.getElementById("Completed_Table_body").innerHTML="No Completed Requests";
}
	

};


