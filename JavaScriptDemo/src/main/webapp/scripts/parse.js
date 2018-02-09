/**
 * 
 */
var bearText = '{"bears":[{"name":"Ferdinand","cave":{"id":3,"name":"Reston"}},'+
	'{"name":"BearTwo","cave":{"id":4,"name":"Sacramento"}}]}';
var bearObj = JSON.parse(bearText);
window.onload = function(){
	console.log(bearObj);
}
function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for (var i = 0; i<bears.length; i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class","displayDiv");
		newDiv.innerHTML="name: "+bears[i].name+"; cave: "+bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
}