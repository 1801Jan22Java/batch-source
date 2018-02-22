document.getElementById("SearchById").addEventListener("click", function(e) {
	document.getElementById("SearchByIdForm").setAttribute("type", "text");

}, false)

var xhr = new XMLHttpRequest() || new ActieXObject("Microsoft.HttpRequest");

function getAllResolvedRequests() {
	xhr.open("Get", "/First_Project/GetAllResolvedRequestServlet");
	xhr.send();
	xhr.onreadystatechange = ResolvedRequests;
}
;
document.getElementById("SubmitSearchById").addEventListener("click",function(){
	let id = document.getElementById("SearchByIdForm").innerhtml;
	xhr.open("Get", "/First_Project/AllEmployeeInfo");
	xhr.send("Id ="+id);
	xhr.onreadystatechange = SearchbyId;
})

function SearchById() {
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

function ResolvedRequests() {
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
			
			
			
			var table = document.getElementById("All_Resolved");
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
	}else{document.getElementById("All_Resolved").innerHTML = "No Completed Requests"
	}

};