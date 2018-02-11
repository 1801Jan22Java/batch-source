window.onload = function(){
	var customerHandler1 = function(event){
		console.log("target: " + event.target.id + " and this : "+ this.id );
		console.log(event.timeStamp);
	}

var customerHandler2 = function(event){
		console.log("target: " + event.target.id + " and this : "+ this.id );
		console.log(event.timeStamp);
	}
	var username=document.getElementById("username");
	var pw =document.getElementById("password");
	var newText = document.getElementById("newText");
	document.getElementById("submitButton").addEventListener("onclick",
	submitCredentials,false);
	
	
}

function submitCredentials(){
	var button=document.getElementById("submitButton");
	var form =document.getElementsByTagName("form");
	console.log(form.childNodes);
	console.log(button);
		newText.innerHTML="Here is some text";
		var testVar = document.getElementById("username");
		var pwvar = document.getElementById("password");
		console.log(testVar.value);
		console.log(pwvar.value);
		button.onclick=function(){
		if(testVar.value ==="test" && pwvar.value ==="test")
		{
			console.log(testVar.value);
			console.log(testVar.innerHTML);
			window.close();
					//alert("You're on your way!");
					//window.open("main.html");
					window.open("main.html");
		}
		else{
			console.log(testVar);
			console.log(pwvar);
		alert("You do not have the membership!");
		}
		}
		
	}
submitCredentials();