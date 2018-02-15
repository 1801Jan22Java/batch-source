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

function submitCredentials(form){
		newText.innerHTML="Here is some text";
		var testVar = form.username.value;
		var pwvar = form.password.value;
		if(testVar ==="Bob Ross" && pwvar ==="happylittletrees")
		{
					alert("You're on your way!");
					//window.open("main.html");
					window.location.href="main.html";
		}
		else{
		alert("You do not have the membership!");
		}
		
	}
