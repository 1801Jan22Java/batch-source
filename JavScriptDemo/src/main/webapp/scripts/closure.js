/**
*
*/
// behavior that will execute when the page loads
Window.onload = function(){
	var count = getCount();
	var AppleCount = getAppleCount();
	var OrangeCount = getOrangeCount();
}
function getCount(noun) {
	var count = 0;
	return function() {
		count +=1;
		console.log(noun+" count is: "+count);
		}
}

function getAppleCount(noun) {
	var count = 0;
	return function() {
		count +=1;
		console.log(noun+" Apple count is: "+Applecount);
		}
}

function getOrangeCount(noun) {
	var count = 0;
	return function() {
		count +=1;
		console.log(noun+" Orange count is: "+ Orangecount);
		}
}