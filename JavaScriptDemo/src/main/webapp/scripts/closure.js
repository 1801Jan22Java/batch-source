/**
 * 
 */
//behavior that will execute when the page loads
window.onload = function(){
	counter = getCount();
	appleCounter = getCount("apple");
	orangeCounter = getCount("orange");
}
function getCount(noun) {
	var count = 0;
	return function() {
		count += 1;
		console.log(noun+" count is: "+count);
		return count;
	}
}