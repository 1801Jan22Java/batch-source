/**
 * 
 */
//Specifies behavior that will execute as soon as the page loads.
body.onload = function() {
	counter = getCount();
	appleCounter = getCount("Apple");
	orangeCounter = getCount("Orange");
}
function getCount(noun) {
	var count = 0;
	return function() {
		count += 1;
		console.log(noun+" count is: "+count);
		return count;
	};
}