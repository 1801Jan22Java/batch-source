/**
 * 
 */

var toggle = setInterval(function(){
	console.log("called interval");
	setColor();
},500);

function setColor(){
	var x = document.getElementById("toggleDiv");
	
	//what emily gave us
	//x.style.backgroundColor = x.style.backgroundColor == "cyan" ? "#78ab42" : "cyan";
	
	//real random
	var letters = "0123456789ABCDEF";
	var color = "#";
	for (var i = 0; i < 6; i++) {
	  color += letters[Math.floor(Math.random() * 16)];
	}
	x.style.backgroundColor = color;
};
function getPokemon(xhr) {
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>Chosen pokemon has name: " + res.name +"</h4>";
	document.getElementById("pokeResult").innerHTML = html;
};

function stopColor() {
	clearInterval(toggle);
};

function sendAjaxGet(url, func) {
	//step 1: obtain XHR
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	//step 2: define onreadystatechange
	xhr.onreadystatechange = function(){
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
		
	}
	//step 3: prepare request
	
	xhr.open("GET",url,true);
	
	//step 4: send request
	
	xhr.send();
	
};

window.onload = function(){
	document.getElementById("pokeButton").addEventListener("click", function(){
		sendAjaxGet('https://pokeapi.co/api/v2/pokemon/'+document.getElementById("pokeId").value+'/', getPokemon);
	});
};