/**
 * 
 */

window.onload = function() {
	document.getElementById("divWithText").addEventListener("mousemove", trackCursor, false);
	//Don't have to pass in event object, but it's the best practice to do so.
	function trackCursor(event) { 
		document.getElementById("mouseX").innerHTML = event.clientX;
		document.getElementById("mouseY").innerHTML = event.clientY;
	}
	
	var myEventHandler = function(event) {
		console.log("target: " + event.target.id + " and this: " + this.id);
		console.log(event.timeStamp);
	}
	
	var displayDivs = document.getElementsByClassName("displayDiv");
	for(var i = 0; i < displayDivs.length; i++){
		displayDivs[i].addEventListener("click", myEventHandler);
	}
	
	//Stops the propagation at div5
	document.getElementById("div5").addEventListener("click", stopPropAndRoll);
	function stopPropAndRoll(event) {
		event.stopPropagation();
	}
}