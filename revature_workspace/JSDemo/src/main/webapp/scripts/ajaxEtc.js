/**
 * 
 */

var toggle = setInterval(function(){
	console.log("called interval");
	setColor();
},1000);


function setColor(){
	console.log("called setColor");
	var x= document.getElementById("toggleDiv");
	x.style.backgroundColor = x.style.backgroundColor == "cyan" ? "#78ab42":"cyan";
}

function getPokemon(xhr){
	var res = JSON.parse(xhr.responseText);
	var html  = "<h4> Chosen pokemon has name: " +res.name + "</h4>";
	document.getElementById("pokeResult").innerHTML = html;
};

function stopColor(){
	clearInterval(toggle);
}



function sendAjaxGet(url,func)
{
	
	//Step 1 - Obtain XHR
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	//Step 2  - Define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readState);
		if(this.readyState == 4 && this.status == 200){
			//func is the callback function.  this is the XHR
			func(this);
		}
	};
	
	//step 3: prepare request
	
	xhr.open("GET",url,true);
	
	//step 4: send request
	
	xhr.send();
}
window.onload = function() {
	document.getElementById("pokeButton").addEventListener("click", function() {
		sendAjaxGet('https://pokeapi.co/api/v2/pokemon/' + document.getElementById('pokeId').value,getPokemon);
	})
}