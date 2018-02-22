
	var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");
function findJSONEmployee() {
	xhr.open("Get", "/First_Project/requestTableAddition");
	xhr.send();
	xhr.onreadystatechange = stuffEmployee2;
};

function stuffEmployee2() {
	console.log(xhr.status);
	if (xhr.readyState == 4 && xhr.status == 200) {
		if(JSON.parse(xhr.responseText)){
			obj = JSON.parse(xhr.responseText);
			var j = 0;
			var keys = [];
			var values = [];
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
				
				console.log(keys);
				
				var table = document.getElementById("Table_body");
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
		}else{document.getElementById("Table_body").innerHTML = "No Completed Requests"
		}

};

