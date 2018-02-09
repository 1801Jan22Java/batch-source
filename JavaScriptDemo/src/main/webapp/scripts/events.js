/**
 * 
 */
window.onload = function(){
	document.getElementById("divWithText").addEventListener("mousemove", trackCursor);
	// We don't have to pass in event object, but it's best practice to do so
	function trackCursor(event){
		document.getElementById("mouseX").innerHTML=event.clientX;
		document.getElementById("mouseY").innerHTML=event.clientY;
		
	}
	
	var myEventHandler = function(event) {
		console.log("target: "+ event.target.id+" and this: "+ this.id);
		// milliseconds since page loaded
		console.log(event.timeStamp);
	}
	
	var displayDiv = document.getElementsByClassName("displayDiv");
	for(var i=0; i< displayDiv.length; i++){
		displayDiv[i].addEventListener("click",myEventHandler);
	}
	
	function stopPropAndRoll(event){
		event.stopPropagation();
	}
	document.getElementById("div5").addEventListener("click", stopPropAndRoll);	
	
	

}