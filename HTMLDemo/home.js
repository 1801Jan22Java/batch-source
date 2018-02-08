

var bearText = '{"bears" : [{"name" : "Ferdinand", "cave" : {"id" : 3, "name" : "Reston"}}, {"name" : "Bear2", "cave" : {"id" : 4, "name" : "Sacramento"}}]}'
var bearObj = JSON.parse(bearText);

window.onload = function(){
document.getElementById("button").onclick =  function(){
    var string1 = "username";
    var string2 = "password";

    if(string1 == document.getElementById("username").value && string2 == document.getElementById("password").value){
        document.location.href = "HomePage.html";
    }
};

document.getElementById("myButton").onclick =  function(){
    var div = documnet.getElementById("clickDiv");
    div.setAtttribute("style", "opacity : 1");
};

showBears();

}

function showBears() {
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for (var i = 0; i < bears.length; i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		
		newDiv.innerHTML = "name : " + bears[i].name +"; cave: " + bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
}