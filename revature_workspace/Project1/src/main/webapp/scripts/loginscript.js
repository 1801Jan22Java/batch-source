/**
 * 
 */

window.onload = function(){

function login() {
	alert("welcome");
		var button = document.getElementById("submitButton");
		var form = document.getElementsByTagName("form");
		console.log(button);
		var testVar = document.getElementById("username");
		var pwvar = document.getElementById("password");
		console.log(testVar.value);
		console.log(pwvar.value);
		button.onclick = function() {
			if (testVar.value === "test" && pwvar.value === "test") {
				console.log(testVar.value);
				console.log(testVar.innerHTML);
				window.close();
				alert("You're on your way!");
				//window.open("main.html");
				window.open("../views/main.html");
			} else {
				console.log(testVar);
				console.log(pwvar);
				alert("You do not have the membership!");
			}
		
		}
		
};
login();	
}