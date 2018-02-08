/*
*
*/
//specifies behavior that will execute as soon as the page loads.
window.onload= function(){
	var count = getCount();
}
function count(noun){
	var count = 0;
	return function() {
		count +=1;
		console.log(noun + " count is: "+ count);
		return count;
	}
}