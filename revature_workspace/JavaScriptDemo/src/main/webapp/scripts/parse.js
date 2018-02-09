/*

*/

var bearText = '{"bears":[{"name":"hoshi","cave":{"id":3,"name","Madison"}},
{"name":"BearTwo","cave":{"id":4,"name":"Oslo"}}]}';
var bearObj = JSON.parse(bearText);
window.onload= function(){ 
	console.log(bearObj);
}
function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for(var i = 0; i<bears.length;i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttributes("class","displayDiv");
		newDiv.innerHTML="name: " bears[i].name+"; cave: " +bears[i].cave.name;
		bearDiv.appendChild(newDiv);
		}
	}
}
