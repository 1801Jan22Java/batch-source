/**
*
*/
window.onload = function(){
	document.getElementById("divWithText").addEventListener("mousemove", trackCursor, false);
	// don't actually need to pass event object as parameter, but is good practice 
	function trackCursor(event){
		document.getElementById("mouseX").innerHTML= event.clientX;
		document.getElementById("mouseY").innerHTML= event.clientY;
		
		var myEventHandler = function(event){
			console.log("target: "+event.target.id+" and this: " +this.id);
			console.log(event.timestamp);
		}
		
		var displayDivs = document.getElementsByClassName("displayDiv");
		for(var i = 0; i <displayDivs.length;i++){
			displayDivs[i].addEventListener("click", myEventHandler);
		}
		
		function stopPropAndRoll(event){
			event.stopPropagation();
		}
		
		document.getElementByID("div5").addEventListener("click", stopPropAndRoll);
	}
}