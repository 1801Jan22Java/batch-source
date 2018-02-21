

var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");

function getAllEmployees() {
	xhr.open("Get", "/First_Project/AllEmployeeInfo");
	xhr.send();
	xhr.onreadystatechange = stuffEmployee;
}
;

function stuffEmployee() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		obj = JSON.parse(xhr.responseText);
		console.log(obj);
		console.log(obj.things.length);
		//console.log(obj.Request_Id);
		//console.log(Object.keys(obj).length + " this is the size");
		/*for (var x = 0; x < obj.things.length; x++) {
			var j = 0;
			var keys = [];
			var values = [];
			for (var key in obj.things[x]) {
				//console.log(key);
				if (key != undefined) {
					keys[j] = key;
				}
				if (obj.things[key] != undefined) {
					values[j] = obj.things[key];
				}
				j++;
			}
			console.log(keys);
			var table = document.getElementById("All_Employees");
			table.innerHTML = "";
			if (x = 0) {
				var headRow = table.insertRow(0);
				for (var i = 0; i < Object.keys(obj.things[x]).length; i++) {
					var headCell = headRow.insertCell(i);
					headCell.innerHTML = keys[i];
				}
			}
			// count is the number of things in the object need to set -6

			var headRow = table.insertRow(0);
			for (var i = 0; i < Object.keys(obj.things[x]).length; i++) {
				var headCell = headRow.insertCell(i);
				headCell.innerHTML = values[i];
			}


		}*/
	 }

};