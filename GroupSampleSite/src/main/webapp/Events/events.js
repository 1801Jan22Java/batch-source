/**
 * 
 */

var catText = '{"Cats":[{"Name":"Garfield","Species":"Lazy","Age":"5 months"}, {"Name":"Sylvester","Species":"Siamese", "Age":"4 months"}, {"Name":"Tom","Species":"Grey Tabby", "Age":"87 years"}]}';

var catObj = JSON.parse(catText);

window.onload = function(){
	console.log(catObj);
}

function showCats() {
	var showCatList = document.getElementById("showCatList");
	var cats = catObj.Cats;
	for (var i = 0; i < catObj.length; i++){
		console.log(Cats[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class", "row");
		newDiv.innerHTML = "Name: " + cats[i].Name + "; Species: " + cats[i].Species + "; Age: " + cats[i].Age;
		
		showCatList.appendChild(newDiv);
	}
}