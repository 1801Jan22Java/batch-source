/**
 * 
 */
/*var bearText = '{"bears":[{"name":"Ferdinand", "cave": {"id": 3, "name": "Reston"}},
							{"name":"BearTwo", "cave": {"id": 4, "name": "Sacremento"}}]}';*/
var bearObj = JSON.parse(bearText);
body.onload = function(){
	console.log(bearObj);
}

function showBears(){
	//Before anything
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for (var i = 0; i < bears.length; i++){
		console.log(bears[i]);
		//Want to create a new div for each
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class","displayDiv");
		newDiv.innerHTML="name: "+bears[i].name+"; cave: "+bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
}