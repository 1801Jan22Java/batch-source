/**
 * 
 */
// Specific behavior for this requested JSON object
function getPokemon(xhr){
	// Save the parsed returned JSON object
	var res = JSON.parse(xhr.responseText);
	// Choose the name from the returned JSON object
	var html = "<h4>Chosen pokemon has name: " + res.name + "</h4>";
	// Display the result in the format I chose
	document.getElementById("pokeResult").innerHTML = html;
}

// func = Callback function
function sendAjaxGet(url, func){
	// Step 1 = Create XMLHttpRequest Object
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	// Step 2 = Integrate Anticipated Response = Define onreadystatechange
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200){
			// Send this XHR Object to the function that was passed in as an argument (ie. getPokemon())
			func(this);
		}
	};
	// Step 3 = Prepare Request
	xhr.open("GET", url, true);
	// Step 4 = Send Request
	xhr.send();
}
window.onload = function() {
	document.getElementById("pokeButton").addEventListener("click", function() {
		// Match specific URL with specific desired behavior by sending getPokemon
		// Send getPokemon as an object variable = omit "()"
		sendAjaxGet("https://pokeapi.co/api/v2/pokemon/1" + document.getElementById("pokeId").value, getPokemon);
	})
	
}
