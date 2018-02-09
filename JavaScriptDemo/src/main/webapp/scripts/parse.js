/**
 * 
 */

var bearText = '{"bears":[{"name":"Ferdinand", "cave": {"id": 3, "name": "reston"}},{"name":"BearTwo", "cave": {"id": 4, "name": "sacremento"}}]}';
var bearObj = JSON.parse(bearText);
window.onload = function(){
	console.log(bearObj);
}

function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	// Get array of bears
	var bears = bearObj.bears;
	
	for(var i = 0; i<bears.length ; i++){
		console.log(bears[i]);
		
		// Create new element
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class", "displayDiv");
		
		// Add text into element
		newDiv.innerHTML="name: "+bears[i].name + " cave: " + bears[i].cave.name;
		
		bearDiv.appendChild(newDiv);
	}
}