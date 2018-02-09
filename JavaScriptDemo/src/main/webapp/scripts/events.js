/**
 * 
 */
window.onload = function() {
	document.getElementById("divWithText").addEventListener("mousemove", trackCursor, false);
	// Don't need to pass in event object, but best practices to do so
	function trackCursor(event) {
		document.getElementById("mouseX").innerHtml = event.clientX;
		document.getElementById("mouseY").innerHtml = event.clientY;
	}
	
	var myEventHandler = function(event) {
		console.log("target: " + event.target.is + " and this: " + this.id);
		console.log(event.timeStamp);
	}
	
	var displayDivs = document.getElementsByClassName("displayDiv");
	for (var i = 0; i < displayDivs.length; i++) {
		displayDiv[i].addEventListener("click", myEventHandler);
	}
	
	function stopPropAndRoll(event) {
		event.stopPropagation();
	}
	document.getElementById("div5").addEventListener("click", stopPropAndRoll);
	
}