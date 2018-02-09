/**
*
*/

var bearText = '{"bears":[{"name":"Ferdinand", "cave":{id:3,"name":"Reston"}}, 
				{"name":"Rodger", "cave":{id:3,"name":"Sacramento"}}]}';
				
var bearObj = JSON.parse(bearText);

function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for(var i = 0; i<bears.length; i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class","displayDiv");
		newDiv.innerHTML="name: " +bears[i].name+"; cave: "+bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
}