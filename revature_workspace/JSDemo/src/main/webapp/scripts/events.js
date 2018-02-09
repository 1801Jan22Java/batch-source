/**
 * 
 */

window.onload = function() {
	document.getElementById("divWithText").addEventListener("mousemove",trackCursor,false);
	//Don't actually need to pass in event object but it is best practices
	function trackCursor(event)
	{
		document.getElementById("mouseX").innerHTML=event.clientX;
		document.getElementById("mouseY").innerHTML=event.clientY;
	}
	
	var myEventHandlers = function(event){
		console.log("target: " + event.target.id + " and this : "+ this.id );
		console.log(event.timeStamp);
	}
	
	var displayDivs = document.getElementsByClassName("displayDiv");
	for (var i = 0; i < displayDivs.length; i++)
	{
		displayDivs[i].addEventListener("click",myEventHandlers);

	}

	function stopPropAndRoll(event)
	{
		event.stopPropagation();
	};
	document.getElementById("div5").addEventListener("click",stopPropAndRoll);
}